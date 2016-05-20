var dtGridColumns = [{
    id : 'id',
    title : '竞猜记录编号',
    type : 'number',
    columnClass : 'text-center',
    hideType : 'xs',
    headerStyle : 'background:#00a2ca;color:white;'
}, {
    id : 'gpName',
    title : '比赛名称',
    type : 'string',
    columnClass : 'text-center',
    headerStyle : 'background:#00a2ca;color:white;',
    resolution : function(value, record, column, grid, dataNo, columnNo) {
    	return record.guessProject.gpName;
    }
}, {
    id : 'gpGameStar',
    title : '开赛时间',
    type : 'string',
    columnClass : 'text-center',
    headerStyle : 'background:#00a2ca;color:white;',
    resolution : function(value, record, column, grid, dataNo, columnNo) {
    	return record.guessProject.gpGameStar;
    }
}, {
    id : 'gpGameResult',
    title : '比赛结果',
    type : 'string',
    columnClass : 'text-center',
    headerStyle : 'background:#00a2ca;color:white;',
    resolution : function(value, record, column, grid, dataNo, columnNo) {
    	if(record.guessProject.gpStatus == 2) {
    		return record.guessProject.gpTeamAName 
    		     + " " 
    		     + record.guessProjectInfo.gpGoalA
    		     + " : "
    		     + record.guessProjectInfo.gpGoalB
    		     + " "
    		     + record.guessProject.gpTeamBName;
    	} else {
    		return '';
    	}
    	
    }
}, {
    id : 'mgResult',
    title : '竞猜记录',
    type : 'string',
    columnClass : 'text-center',
    headerStyle : 'background:#00a2ca;color:white;',
    resolution : function(value, record, column, grid, dataNo, columnNo) {
    	if(value == 1) {
    		return "猜对";
    	} else if(value == 2){
    		return "猜错";
    	}
    	
    }
}, {
    id : 'mAccountName',
    title : '会员账号',
    type : 'string',
    columnClass : 'text-center',
    headerStyle : 'background:#00a2ca;color:white;',
    resolution : function(value, record, column, grid, dataNo, columnNo) {
    	return record.member.mAccountName;
    }
}, {
    id : 'mgBiPledge',
    title : '押金金额',
    type : 'string',
    columnClass : 'text-center',
    headerStyle : 'background:#00a2ca;color:white;'
}, {
    id : 'mgBiAward',
    title : '奖金金额',
    type : 'string',
    columnClass : 'text-center',
    headerStyle : 'background:#00a2ca;color:white;'
}, {
    id : 'mgBiMan',
    title : '管理费',
    type : 'string',
    columnClass : 'text-center',
    headerStyle : 'background:#00a2ca;color:white;'
}];

//动态设置jqGrid的rowNum
var pageSize = $("#pageSize").val();
pageSize = pageSize == 0 || pageSize == "" ? sys.pageNum : pageSize;

var dtGridOption = {
    lang : 'zh-cn',
    ajaxLoad : true,
    check : false,
    loadURL : sys.rootPath + '/mguess/list.html',
    columns : dtGridColumns,
    gridContainer : 'dtGridContainer',
    toolbarContainer : 'dtGridToolBarContainer',
    tools : '',
    pageSize : pageSize,
    pageSizeLimit : [10, 20, 30],
    onGridComplete :function(grid){
    	var pledgeTotalByCondition=grid.params['pledgeTotalByCondition'];
    	var awardTotalByCondition=grid.params['awardTotalByCondition'];
    	var manTotalByCondition=grid.params['manTotalByCondition'];
    	$("#totalMessage").text("该列表下押金总额:" + pledgeTotalByCondition 
    			              + "  奖金总计:" + awardTotalByCondition 
    			              + "  管理费总计:" + manTotalByCondition);
    }

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
    grid.parameters['id'] = $("#id").val();
    grid.parameters['gpId'] = $("#gpId").val();
    grid.parameters['gpName'] = $("#gpName").val();
    grid.parameters['starGameDate'] = $("#starGameDate").val();
    grid.parameters['endGameDate'] = $("#endGameDate").val();
    grid.parameters['mgResult'] = $("#mgResult").val();
    grid.parameters['starGuessDate'] = $("#starGuessDate").val();
    grid.parameters['endGuessDate'] = $("#endGuessDate").val();
    grid.parameters['mId'] = $("#mId").val();
    grid.parameters['mAccountName'] = $("#mAccountName").val();
    grid.refresh(true);
}


