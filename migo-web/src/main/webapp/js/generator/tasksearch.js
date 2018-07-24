$(function () {
    $("#jqGrid").jqGrid({
        url: '../tasksearch/list',
        datatype: "json",
        colModel: [			
			{ label: 'searchId', name: 'searchId', index: 'search_id', width: 50, key: true },
			{ label: '流量入口', name: 'flowType', index: 'flow_type', width: 80 }, 			
			{ label: '关键字', name: 'keyWord', index: 'key_word', width: 80 }, 			
			{ label: '数量', name: 'number', index: 'number', width: 80 }, 			
			{ label: '备注', name: 'remark', index: 'remark', width: 80 }, 			
			{ label: '任务ID', name: 'taskId', index: 'task_id', width: 80 }			
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		taskSearch: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.taskSearch = {};
		},
		update: function (event) {
			var searchId = getSelectedRow();
			if(searchId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(searchId)
		},
		saveOrUpdate: function (event) {
			var url = vm.taskSearch.searchId == null ? "../tasksearch/save" : "../tasksearch/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.taskSearch),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var searchIds = getSelectedRows();
			if(searchIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../tasksearch/delete",
				    data: JSON.stringify(searchIds),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(searchId){
			$.get("../tasksearch/info/"+searchId, function(r){
                vm.taskSearch = r.taskSearch;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});