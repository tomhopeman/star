<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<%@include file="/common/common.jspf"%>
<link rel="stylesheet"
	href="${ctx }/resources/js/select2/select2.min.css" />
<script type="text/javascript"
	src="${ctx }/resources/js/select2/select2.min.js"></script>
<script type="text/javascript"
	src="${ctx }/resources/js/select2/zh-CN.js"></script>
<style>
.iconShow
{
	padding-left: 10px; 
	padding-top: 3px;
}
.source-icon
{
	 width:95%;
	 float:left;
}
@media screen and (max-width: 450px) {
	.source-icon
	{
		 width:60%;
	}
}
@media screen and (max-width: 767px) {
	.source-icon
	{
		 width:80%;
	}
}
@media screen and (max-width: 1100px) {
	.source-icon
	{
		 width:90%;
	}
}
</style>

<div class="page-header">
	<h1>
		<c:if test="${empty gTypeEntity}">
		新增比赛类型
		</c:if>
		<c:if test="${!empty gTypeEntity}">
		编辑比赛类型
		<input type="hidden" name="id" id="id" value="${gTypeEntity.id }">
		</c:if>
	</h1>
</div>
<div class="form-group">
			      <label class="control-label col-sm-1 no-padding-right">比赛类型名称</label>
			      <div class="col-sm-10">
			      <div class="clearfix">
			         <input class="form-control" value="${gTypeEntity.gtName}" name="gtName" id="gtName" type="text" placeholder="比赛类型名称..."/>
		      	</div>
		      	</div>
		    </div>
<div class="center">
    <c:if test="${empty gTypeEntity}">
		<button id="btnAdd" type="button" onclick="addTypeHandel()" class="btn btn-success btn-sm"><i class="fa fa-user-plus"></i>&nbsp;保存
	    </button>
    </c:if>
	<c:if test="${!empty gTypeEntity}">
		<button id="btnAdd" type="button" onclick="editTypeHandel()" class="btn btn-success btn-sm"><i class="fa fa-user-plus"></i>&nbsp;保存
	    </button>
	</c:if>
	
	<button id="btn" type="button" onclick="closeWindow()" class="btn btn-info btn-sm">
		<i class="fa fa-undo"></i>&nbsp;关闭
	</button>
</div>
<script type="text/javascript">
function closeWindow() {
    var index = parent.layer.getFrameIndex(window.name);
    parent.layer.close(index);
}
function addTypeHandel() {
	var gtName = $("#gtName").val();
	if(gtName == '') {
		layer.msg('比赛类型名称不能为空！', {
            icon : 2
        });
	} else {
		$.ajax({
	        type : "POST",
	        url : sys.rootPath + '/gtype/add.html',
	        data : {
	            "gtName" : gtName
	        },
	        dataType : "json",
	        beforeSend : function()
	        {
	            index = layer.load();
	        },
	        success : function(resultdata) {
	            layer.close(index);
	            if (resultdata.success) {
	                layer.msg(resultdata.message,{icon:1});
	                parent.customSearch();
	                closeWindow();
	            } else {
	                layer.msg(resultdata.message, {
	                    icon : 5
	                });
	            }
	        },
	        error : function(errorMsg) {
	            layer.close(index);
	            layer.msg('服务器未响应,请稍后再试', {
	                icon : 2
	            });
	        }
	    });
	}
}
function editTypeHandel() {
	var gtName = $("#gtName").val();
	var gtId = $("#id").val();
	if(gtName == '') {
		layer.msg('比赛类型名称不能为空！', {
            icon : 2
        });
	} else {
		$.ajax({
	        type : "POST",
	        url : sys.rootPath + '/gtype/edit.html',
	        data : {
	            "gtName" : gtName,
	            "id" : gtId
	        },
	        dataType : "json",
	        beforeSend : function()
	        {
	            index = layer.load();
	        },
	        success : function(resultdata) {
	            layer.close(index);
	            if (resultdata.success) {
	                layer.msg(resultdata.message,{icon:1});
	                parent.customSearch();
	                closeWindow();
	            } else {
	                layer.msg(resultdata.message, {
	                    icon : 5
	                });
	            }
	        },
	        error : function(errorMsg) {
	            layer.close(index);
	            layer.msg('服务器未响应,请稍后再试', {
	                icon : 2
	            });
	        }
	    });
	}
}
</script>