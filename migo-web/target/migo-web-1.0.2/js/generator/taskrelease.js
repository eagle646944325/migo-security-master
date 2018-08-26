$(function () {
    $("#jqGrid").jqGrid({
        url: '../taskrelease/list',
        datatype: "json",
        colModel: [			
			{ label: 'releaseId', name: 'releaseId', index: 'release_id', width: 50, key: true },
			{ label: '发布时间', name: 'releaseTime', index: 'release_time', width: 80 }, 			
			{ label: '发布数量', name: 'releaseNum', index: 'release_num', width: 80 }, 			
			{ label: '开始时间', name: 'startTime', index: 'start_time', width: 80 }, 			
			{ label: '结束时间', name: 'endTime', index: 'end_time', width: 80 }, 			
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
		taskRelease: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.taskRelease = {};
		},
		update: function (event) {
			var releaseId = getSelectedRow();
			if(releaseId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(releaseId)
		},
		saveOrUpdate: function (event) {
			var url = vm.taskRelease.releaseId == null ? "../taskrelease/save" : "../taskrelease/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.taskRelease),
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
			var releaseIds = getSelectedRows();
			if(releaseIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../taskrelease/delete",
				    data: JSON.stringify(releaseIds),
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
		getInfo: function(releaseId){
			$.get("../taskrelease/info/"+releaseId, function(r){
                vm.taskRelease = r.taskRelease;
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