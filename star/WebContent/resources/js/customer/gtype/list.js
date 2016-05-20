var dtGridColumns = [{
    id : 'id',
    title : '竞猜类型编号',
    type : 'number',
    columnClass : 'text-center',
    hideType : 'xs',
    headerStyle : 'background:#00a2ca;color:white;'
}, {
    id : 'gtName',
    title : '竞猜类型名称',
    type : 'string',
    columnClass : 'text-center',
    headerStyle : 'background:#00a2ca;color:white;',
    resolution : function(value, record, column, grid, dataNo, columnNo) {
    	return value;
    }
}, {
    id : 'gtStatus',
    title : '竞猜类型状态',
    type : 'string',
    columnClass : 'text-center',
    headerStyle : 'background:#00a2ca;color:white;',
    resolution : function(value, record, column, grid, dataNo, columnNo) {
    	if(value == 1){
    		return '<span class="label label-sm label-success arrowed arrowed-righ">显示</span>';
    	} else if(value == 2) {
    		return '<span class="label label-sm label-success arrowed arrowed-righ">隐藏</span>';
    	}
    	
    }
}, {
    id : 'handle',
    title : '操作',
    type : 'string',
    columnClass : 'text-center',
    headerStyle : 'background:#00a2ca;color:white;',
    resolution : function(value, record, column, grid, dataNo, columnNo) {
    	var oper = "";
    	if(record.gtStatus == 1) {
    		oper = "<a href='javascript:void(0)' onclick='changeStatus(" + record.id + ")'>隐藏</a>"
    	} else if(record.gtStatus == 2) {
    		oper = "<a href='javascript:void(0)' onclick='changeStatus(" + record.id + ")'>显示</a>"
    	}
    	oper += "    " + "<a href='javascript:void(0)' onclick='editGameType(" + record.id + ")'>修改</a>"
    	oper += "    " + "<a href='javascript:void(0)' onclick='deleteGameType(" + record.id + ")'>删除</a>"
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
    loadURL : sys.rootPath + '/gtype/list.html',
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
//    $("#btnSearch").click(customSearch);
    //注册回车键事件
//    document.onkeypress = function(e){
//    var ev = document.all ? window.event : e;
//        if(ev.keyCode==13) {
//            customSearch();
//        }
//    };
});

/**
 * 自定义查询
 * 这里不传入分页信息，防止删除记录后重新计算的页码比当前页码小而导致计算异常
 */
function customSearch() {
//    grid.parameters = new Object();
//    grid.parameters['id'] = $("#id").val();
//    grid.parameters['gpId'] = $("#gpId").val();
//    grid.parameters['gpName'] = $("#gpName").val();
//    grid.parameters['starGameDate'] = $("#starGameDate").val();
//    grid.parameters['endGameDate'] = $("#endGameDate").val();
//    grid.parameters['mgResult'] = $("#mgResult").val();
//    grid.parameters['starGuessDate'] = $("#starGuessDate").val();
//    grid.parameters['endGuessDate'] = $("#endGuessDate").val();
//    grid.parameters['mId'] = $("#mId").val();
//    grid.parameters['mAccountName'] = $("#mAccountName").val();
    grid.refresh(true);
}

function changeStatus(id) {
	var index;
    $.ajax({
        type : "POST",
        url : sys.rootPath + '/gtype/changeShowStatus.html',
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

function deleteGameType(id) {
	var index;
    $.ajax({
        type : "POST",
        url : sys.rootPath + '/gtype/delete.html',
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

function addGameType(){
    iconLayer = layer.open({
        type : 2,
        scrollbar: false,
        content : sys.rootPath + '/gtype/addType.html',
        area: ['700px', '200px'],
        maxmin : true,
        shift : 4,
        title : '新增比赛类型'
    });
}

function editGameType(id){
    iconLayer = layer.open({
        type : 2,
        scrollbar: false,
        content : sys.rootPath + '/gtype/editType.html?id=' + id,
        area: ['700px', '200px'],
        maxmin : true,
        shift : 4,
        title : '编辑比赛类型'
    });
}

