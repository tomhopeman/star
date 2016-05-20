<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/customer/bankCard/list.js"></script>
<div class="page-header">

</div>

<h4 class="widget-title lighter" >绑定银行卡数量:${totalBankCard}       绑定银行卡的会员数量:${totalBingdingMember}</h4>
<div class="input-group">
	 <input id="bc_id" type="text"  placeholder="银行卡编号">
     <input id="bc_no" type="text"  placeholder="银行卡号">
     <input id="bc_name" type="text"  placeholder="银行卡姓名">
     <input id="m_id" type="text"  placeholder="会员编号">
     <input id="m_accountName" type="text"  placeholder="会员账号">
     <input id="m_name" type="text"  placeholder="会员名称">
     <input id="m_phone" type="text"  placeholder="手机号">
     <select id="bc_status" >
     	<option value="">全部</option>
     	<option value="1">正常</option>
     	<option value="0">冻结</option>
     </select>
     <input id="bindtimeStart" type="date"  placeholder="开始时间">
     <input id="bindtimeEnd" type="date"  placeholder="结束时间">
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
				<h4 class="widget-title lighter">签到记录列表</h4>
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


