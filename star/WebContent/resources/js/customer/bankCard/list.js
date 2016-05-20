var dtGridColumns = [{
    id : 'id',
    title : '编号',
    type : 'number',
    columnClass : 'text-center',
    hideType : 'xs',
    headerStyle : 'background:#00a2ca;color:white;'
}, {
    id : 'bcNo',
    title : '银行卡号',
    type : 'number',
    columnClass : 'text-center',
    headerStyle : 'background:#00a2ca;color:white;'
}, {
    id : 'bcName',
    title : '银行卡姓名',
    type : 'string',
    columnClass : 'text-center',
    headerStyle : 'background:#00a2ca;color:white;'
}, {
    id : 'bcBank',
    title : '所属银行',
    type : 'string',
    columnClass : 'text-center',
    headerStyle : 'background:#00a2ca;color:white;',
    hideType : 'xs'
}, {
    id : 'mId',
    title : '会员ID',
    type : 'number',
    columnClass : 'text-center',
    headerStyle : 'background:#00a2ca;color:white;'
}, {
    id : 'accountName',
    title : '会员账号',
    type : 'string',
    columnClass : 'text-center',
    headerStyle : 'background:#00a2ca;color:white;'
}, {
    id : 'memName',
    title : '会员名称',
    type : 'string',
    columnClass : 'text-center',
    headerStyle : 'background:#00a2ca;color:white;'
}, {
    id : 'memPhone',
    title : '会员手机号',
    type : 'string',
    columnClass : 'text-center',
    headerStyle : 'background:#00a2ca;color:white;'
}, {
    id : 'bcProvince',
    title : '省',
    type : 'string',
    columnClass : 'text-center',
    headerStyle : 'background:#00a2ca;color:white;'
}, {
    id : 'bcCity',
    title : '市',
    type : 'string',
    columnClass : 'text-center',
    headerStyle : 'background:#00a2ca;color:white;'
},{
    id : 'bcBindtime',
    title : '绑定时间',
    type : 'date',
    format : 'yyyy-MM-dd hh:mm:ss',
    otype : 'string',
    oformat : 'yyyy-MM-dd hh:mm:ss',
    columnClass : 'text-center',
    headerStyle : 'background:#00a2ca;color:white;'
},{
    id : 'bcStatus',
    title : '绑定状态',
    type : 'date',
    columnClass : 'text-center',
    headerStyle : 'background:#00a2ca;color:white;',
    resolution : function(value, record, column, grid, dataNo, columnNo) {
        if (value == 1) {
            return '<span class="label label-sm label-success arrowed arrowed-righ">正常</span>';
        } else {
            return '<span class="label label-sm label-warning arrowed arrowed-righ">已冻结</span>';
        }
    }
}];

//动态设置jqGrid的rowNum
var pageSize = $("#pageSize").val();
pageSize = pageSize == 0 || pageSize == "" ? sys.pageNum : pageSize;

var dtGridOption = {
    lang : 'zh-cn',
    ajaxLoad : true,
    check : true,
    loadURL : sys.rootPath + '/bankCard/list.html',
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
    grid.parameters['bc_id'] = $("#bc_id").val();
    grid.parameters['bc_no'] = $("#bc_no").val();
    grid.parameters['bc_name'] = $("#bc_name").val();
    grid.parameters['m_id'] = $("#m_id").val();
    grid.parameters['m_accountName'] = $("#m_accountName").val();
    grid.parameters['m_name'] = $("#m_name").val();
    grid.parameters['m_phone'] = $("#m_phone").val();
    grid.parameters['bc_status'] = $("#bc_status").val();
    grid.parameters['bindtimeStart'] = $("#bindtimeStart").val();
    grid.parameters['bindtimeEnd'] = $("#bindtimeEnd").val();
    grid.refresh(true);
}


