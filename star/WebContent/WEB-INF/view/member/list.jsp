<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/customer/member/list.js"></script>
<div class="page-header">
	<%-- <shiro:hasPermission name="user:add">
	<button id="btnAdd" type="button" onclick="addModel('/user/addUI.html')" class="btn btn-primary btn-sm">
	  	<i class="fa fa-user-plus"></i>&nbsp;添加
	</button>
	</shiro:hasPermission>
	<shiro:hasPermission name="user:edit">
	<button id="btnEdit" type="button" onclick="editModel('/user/editUI.html')" class="btn btn-success btn-sm">
		 <i class="fa fa-pencil-square-o"></i>&nbsp;编辑
	</button>
	</shiro:hasPermission>
	<shiro:hasPermission name="user:deleteBatch ">
	<button id="btnDel" type="button" onclick="delModel('/user/deleteBatch.html', customSearch)" class="btn btn-danger btn-sm">
		<i class="fa fa-trash-o"></i>&nbsp;删除
	</button>
	</shiro:hasPermission>
	<shiro:hasPermission name="user:resetPassword">
	<button id="btnDel" type="button" onclick="resetPWDModel()" class="btn btn-warning btn-sm">
		<i class="fa fa-unlock-alt"></i>&nbsp;重置密码
	</button>
	</shiro:hasPermission> --%>
</div>
<h4 class="widget-title lighter" >会员总数:${memberTotal}&nbsp;&nbsp;&nbsp;已绑定银行卡会员总数:${bindTotal} </h4>
<hr>
<div class="input-group">
             会员账号&nbsp;<input id="mAccountName" type="text" >&nbsp;&nbsp;&nbsp;
             银行卡号&nbsp;<input id="bcNo" type="text" >&nbsp;&nbsp;&nbsp;
             会员等级&nbsp;<input id="mLevel" type="text" >&nbsp;&nbsp;&nbsp;
             姓名&nbsp;<input id="mName" type="text" ><br>
             邮箱&nbsp;<input id="mEmail" type="text" >&nbsp;&nbsp;&nbsp;
             手机号码&nbsp;<input id="mPhone" type="text" >&nbsp;&nbsp;&nbsp;
             注册时间&nbsp;<input id="starDate" type="text" >&nbsp;~&nbsp;<input id="endDate" type="text" >

     <span class="input-group-btn">
         <button id="btnSearch" class="btn btn-primary btn-sm" type="button"> <i class="fa fa-search"></i> 搜索</button>
     </span>
</div>
<div class="row" style="margin-top:5px;">
	<div class="col-xs-12 widget-container-col ui-sortable"
		style="min-height: 127px;">
		<!-- #section:custom/widget-box.options.transparent -->
		<div class="widget-box transparent ui-sortable-handle"
			style="opacity: 1; z-index: 0;">
			<div class="widget-header">
				<h4 class="widget-title lighter">会员列表</h4>
				<div class="widget-toolbar no-border">
					<a href="#" data-action="fullscreen" class="orange2"> 
						<i class="ace-icon fa fa-arrows-alt"></i>
					</a> 
					<a href="#" data-action="collapse" class="green"> 
						<i class="ace-icon fa fa-chevron-up"></i>
					</a>
				</div>
			</div>

			<div class="widget-body" style="display: block;">
				<div class="widget-main padding-6 no-padding-left no-padding-right">
					<input id="pageNum" type="hidden" value="${page.pageNum }">
					<input id="pageSize" type="hidden" value="${page.pageSize }">
					<input id="orderByColumn" type="hidden" value="${page.orderByColumn }">
					<input id="orderByType" type="hidden" value="${page.orderByType }">
					<div id="dtGridContainer" class="dt-grid-container"></div>
					<div id="dtGridToolBarContainer" class="dt-grid-toolbar-container"></div>
				</div>
			</div>
		</div>
	</div>
	
	
</div>


