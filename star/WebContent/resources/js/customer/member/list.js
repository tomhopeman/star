var dtGridColumns = [{
    id : 'id',
    title : '会员编号',
    type : 'number',
    columnClass : 'text-center',
    hideType : 'xs',
    headerStyle : 'background:#00a2ca;color:white;'
}, {
    id : 'mAccountName',
    title : '会员账号',
    type : 'string',
    columnClass : 'text-center',
    headerStyle : 'background:#00a2ca;color:white;'
}, {
    id : 'mName',
    title : '会员姓名',
    type : 'string',
    columnClass : 'text-center',
    headerStyle : 'background:#00a2ca;color:white;'
}, {
    id : 'mLevel',
    title : '会员等级',
    type : 'string',
    columnClass : 'text-center',
    headerStyle : 'background:#00a2ca;color:white;',
    resolution : function(value, record, column, grid, dataNo, columnNo) {
    	if(record.memberInfo.mLevel == null) {
    		return "0";
    	} else {
    		return record.memberInfo.mLevel
    	}
    }
}, {
    id : 'mEmpValue',
    title : '经验值',
    type : 'string',
    columnClass : 'text-center',
    headerStyle : 'background:#00a2ca;color:white;',
    resolution : function(value, record, column, grid, dataNo, columnNo) {
    	if(record.memberInfo.mEmpValue == null) {
    		return "0";
    	} else {
    		return record.memberInfo.mEmpValue
    	}
    }
}, {
    id : 'biUsable',
    title : '可用余额（米币）',
    type : 'string',
    columnClass : 'text-center',
    headerStyle : 'background:#00a2ca;color:white;',
    resolution : function(value, record, column, grid, dataNo, columnNo) {
    	if(record.memberInfo.biUsable == null) {
    		return "0";
    	} else {
    		return record.memberInfo.biUsable
    	}
    }
}, {
    id : 'biWaitCash',
    title : '待提现（米币）',
    type : 'string',
    columnClass : 'text-center',
    headerStyle : 'background:#00a2ca;color:white;',
    resolution : function(value, record, column, grid, dataNo, columnNo) {
    	if(record.memberInfo.biWaitCash == null) {
    		return "0";
    	} else {
    		return record.memberInfo.biWaitCash
    	}
    }
}, {
    id : 'mBcBind',
    title : '绑定银行卡状态',
    type : 'string',
    columnClass : 'text-center',
    headerStyle : 'background:#00a2ca;color:white;',
    resolution : function(value, record, column, grid, dataNo, columnNo) {
    	if(record.mBcBind == 1) {
    		return '<span class="label label-sm label-success arrowed arrowed-righ">已绑定</span>';
    	} else {
    		return '<span class="label label-sm label-success arrowed arrowed-righ">未绑定</span>';
    	}
    }
}, {
    id : 'mEmail',
    title : '会员邮箱',
    type : 'string',
    columnClass : 'text-center',
    headerStyle : 'background:#00a2ca;color:white;'
}, {
    id : 'mPhone',
    title : '手机号码',
    type : 'string',
    columnClass : 'text-center',
    headerStyle : 'background:#00a2ca;color:white;'
}, {
    id : 'mRegTime',
    title : '注册时间',
    type : 'string',
    columnClass : 'text-center',
    headerStyle : 'background:#00a2ca;color:white;'
}, {
	id : 'handle',
    title : '操作',
    type : 'string',
    columnClass : 'text-center',
    headerStyle : 'background:#00a2ca;color:white;',
    resolution : function(value, record, column, grid, dataNo, columnNo) {
    	var oper = "";
    	if(record.mStatus == 1) {
    		oper = "<a href='javascript:void(0)' onclick='changeStatus(" + record.id + ")'>冻结</a>"
    	} else if(record.mStatus == 2) {
    		oper = "<a href='javascript:void(0)' onclick='changeStatus(" + record.id + ")'>解冻</a>"
    	}
    	oper += "  " + "<a href='javascript:void(0)' onclick='resetPWDModel(" + record.id + ")'>重置密码</a>"
    	return oper;
    }
}];

//动态设置jqGrid的rowNum
var pageSize = $("#pageSize").val();
pageSize = pageSize == 0 || pageSize == "" ? sys.pageNum : pageSize;

var dtGridOption = {
    lang : 'zh-cn',
    ajaxLoad : true,
    check : false,
    loadURL : sys.rootPath + '/member/list.html',
    columns : dtGridColumns,
    gridContainer : 'dtGridContainer',
    toolbarContainer : 'dtGridToolBarContainer',
    tools : '',
    pageSize : pageSize,
    pageSizeLimit : [10, 20, 30]
};

var grid = $.fn.DtGrid.init(dtGridOption);
$(function() {
    if(null != $("#orderByColumn").val() && '' != $("#orderByColumn").val())
    {
        grid.sortParameter.columnId = $("#orderByColumn").val();
        grid.sortParameter.sortType = $("#orderByType").val();
    }
    grid.load();
    $("#btnSearch").click(customSearch);
    //注册回车键事件
    document.onkeypress = function(e){
    var ev = document.all ? window.event : e;
        if(ev.keyCode==13) {
            customSearch();
        }
    };
});

/**
 * 自定义查询
 * 这里不传入分页信息，防止删除记录后重新计算的页码比当前页码小而导致计算异常
 */
function customSearch() {
    grid.parameters = new Object();
    grid.parameters['mAccountName'] = $("#mAccountName").val();
    grid.parameters['mLevel'] = $("#mLevel").val();
    grid.parameters['mName'] = $("#mName").val();
    grid.parameters['mEmail'] = $("#mEmail").val();
    grid.parameters['mPhone'] = $("#mPhone").val();
    grid.parameters['starDate'] = $("#starDate").val();
    grid.parameters['endDate'] = $("#endDate").val();
    grid.parameters['bcNo'] = $("#bcNo").val();
    grid.refresh(true);
}

function changeStatus(id) {
	var index;
    $.ajax({
        type : "POST",
        url : sys.rootPath + '/member/changeFreeStatus.html',
        data : {
            "id" : id
        },
        dataType : "json",
        beforeSend : function()
        {
            index = layer.load();
        },
        success : function(resultdata) {
            layer.close(index);
            if (resultdata.success) {
                layer.msg(resultdata.message, {
                    icon : 1
                });
                customSearch();
            } else {
                layer.msg(resultdata.message, {
                    icon : 5
                });
            }
        },
        error : function(data, errorMsg) {
            layer.close(index);
            layer.msg(data.responseText, {icon : 2});
        }
    });
}

function resetPWDModel(id) {
        var index;
        $.ajax({
            type : "POST",
            url : sys.rootPath + '/member/resetPassword.html',
            data : {
                "id" : id
            },
            dataType : "json",
            beforeSend : function()
            {
                index = layer.load();
            },
            success : function(resultdata) {
                layer.close(index);
                if (resultdata.success) {
                    layer.msg(resultdata.message, {
                        icon : 1
                    });
                } else {
                    layer.msg(resultdata.message, {
                        icon : 5
                    });
                }
            },
            error : function(data, errorMsg) {
                layer.close(index);
                layer.msg(data.responseText, {icon : 2});
            }
        });
}

