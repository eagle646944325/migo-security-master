$(function () {
    $("#jqGrid").jqGrid({
        url: '../usermessage/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '用户ID', name: 'userId', index: 'user_id', width: 80 }, 			
			{ label: '昵称', name: 'nickName', index: 'nick_name', width: 80 }, 			
			{ label: '头像', name: 'nickImage', index: 'nick_image', width: 80 }, 			
			{ label: '用户类型', name: 'userType', index: 'user_type', width: 80 }, 			
			{ label: '用户状态', name: 'userStatus', index: 'user_status', width: 80 }, 			
			{ label: '用户审核状态', name: 'auditStatus', index: 'audit_status', width: 80 }, 			
			{ label: '角色ID', name: 'level', index: 'level', width: 80 }, 			
			{ label: '姓名', name: 'userName', index: 'user_name', width: 80 }, 			
			{ label: '身份证号', name: 'cardNum', index: 'card_num', width: 80 }			
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
		userMessage: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.userMessage = {};
		},
		update: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
			var url = vm.userMessage.id == null ? "../usermessage/save" : "../usermessage/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.userMessage),
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
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../usermessage/delete",
				    data: JSON.stringify(ids),
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
		getInfo: function(id){
			$.get("../usermessage/info/"+id, function(r){
                vm.userMessage = r.userMessage;
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