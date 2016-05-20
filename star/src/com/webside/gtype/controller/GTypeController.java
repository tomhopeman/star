package com.webside.gtype.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.webside.exception.AjaxException;
import com.webside.gtype.model.GTypeEntity;
import com.webside.gtype.service.GTypeService;
import com.webside.member.model.MemberEntity;
import com.webside.resource.model.ResourceEntity;
import com.webside.role.model.RoleEntity;
import com.webside.user.model.UserEntity;
import com.webside.util.Common;
import com.webside.util.EndecryptUtils;
import com.webside.util.PageUtil;
import com.webside.util.Pager;

@Controller
@Scope("prototype")
@RequestMapping("/gtype/")
public class GTypeController {
	
	@Autowired
	private GTypeService gTypeService;
	
	@RequestMapping("listUI.html")
	public String listUI(Model model, HttpServletRequest request) {
		try
		{
			PageUtil page = new PageUtil();
			if(request.getParameterMap().containsKey("page")){
				page.setPageNum(Integer.valueOf(request.getParameter("page")));
				page.setPageSize(Integer.valueOf(request.getParameter("rows")));
				page.setOrderByColumn(request.getParameter("sidx"));
				page.setOrderByType(request.getParameter("sord"));
			}
			model.addAttribute("page", page);
			return Common.BACKGROUND_PATH + "/gtype/list";
		}catch(Exception e)
		{
			throw new AjaxException(e);
		}
	}
	
	
	/**
	 * ajax分页动态加载模式
	 * @param dtGridPager Pager对象
	 * @throws Exception
	 */
	@RequestMapping(value = "/list.html", method = RequestMethod.POST)
	@ResponseBody
	public Object list(String dtGridPager) throws Exception{
		Map<String, Object> parameters = null;
		// 映射Pager对象
		Pager pager = JSON.parseObject(dtGridPager, Pager.class);
		parameters = pager.getParameters();
		// 设置分页，page里面包含了分页信息
		Page<Object> page = PageHelper.startPage(pager.getNowPage(),pager.getPageSize(), "gt_id DESC");
		List<GTypeEntity> list = gTypeService.queryListByPage(parameters);
		parameters.clear();
		parameters.put("isSuccess", Boolean.TRUE);
		parameters.put("nowPage", pager.getNowPage());
		parameters.put("pageSize", pager.getPageSize());
		parameters.put("pageCount", page.getPages());
		parameters.put("recordCount", page.getTotal());
		parameters.put("startRecord", page.getStartRow());
		//列表展示数据
		parameters.put("exhibitDatas", list);
		return parameters;
	}
	
	@RequestMapping("changeShowStatus.html")
	@ResponseBody
	public Object changeShowStatus(GTypeEntity gTypeEntity){
		Map<String, Object> result = new HashMap<String, Object>();
		try
		{
			GTypeEntity gType = gTypeService.findById(gTypeEntity.getId());
			String message = "比赛类型";
			if(gType.getGtStatus() == 1)
			{
				gTypeEntity.setGtStatus(2);
				message += "隐藏";
			} else if(gType.getGtStatus() == 2){
				gTypeEntity.setGtStatus(1);
				message += "显示";
			}
			
			int cnt = gTypeService.updateGType(gTypeEntity);
			if(cnt > 0)
			{
				result.put("success", true);
				result.put("data", null);
				result.put("message", message + "成功");
			} else {
				result.put("success", false);
				result.put("data", null);
				result.put("message", message + "失败");
			}
		} catch(Exception e) {
			throw new AjaxException(e);
		}
		return result;
	}
	
	@RequestMapping("delete.html")
	@ResponseBody
	public Object delete(GTypeEntity gTypeEntity){
		Map<String, Object> result = new HashMap<String, Object>();
		try
		{
			gTypeEntity.setGtStatus(0);
			int cnt = gTypeService.updateGType(gTypeEntity);
			if(cnt > 0)
			{
				result.put("success", true);
				result.put("data", null);
				result.put("message", "比赛类型删除成功");
			} else {
				result.put("success", false);
				result.put("data", null);
				result.put("message", "比赛类型删除失败");
			}
		} catch(Exception e) {
			throw new AjaxException(e);
		}
		return result;
	}
	
	@RequestMapping("addType.html")
	public String addType() {
		return Common.BACKGROUND_PATH + "/gtype/addType";
	}
	
	@RequestMapping("add.html")
	@ResponseBody
	public Object add(GTypeEntity gTypeEntity)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		try
		{
			int result = gTypeService.insert(gTypeEntity);
			if(result > 0)
			{
				map.put("success", Boolean.TRUE);
				map.put("data", null);
				map.put("message", "添加成功");
			}else
			{
				map.put("success", Boolean.FALSE);
				map.put("data", null);
				map.put("message", "添加失败");
			}
		}catch(Exception e)
		{
			throw new AjaxException(e);
		}
		return map;
	}
	
	@RequestMapping("editType.html")
	public String editType(Model model, HttpServletRequest request, Long id) {
		try
		{
			GTypeEntity gTypeEntity = gTypeService.findById(id);
			
			model.addAttribute("gTypeEntity", gTypeEntity);
			return Common.BACKGROUND_PATH + "/gtype/addType";
		}catch(Exception e)
		{
			throw new AjaxException(e);
		}
	}
	
	@RequestMapping("edit.html")
	@ResponseBody
	public Object edit(GTypeEntity gTypeEntity)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		try
		{
			
			int result = gTypeService.updateGType(gTypeEntity);
			if(result > 0)
			{
				map.put("success", Boolean.TRUE);
				map.put("data", null);
				map.put("message", "修改成功");
			}else
			{
				map.put("success", Boolean.FALSE);
				map.put("data", null);
				map.put("message", "修改失败");
			}
		}catch(Exception e)
		{
			throw new AjaxException(e);
		}
		return map;
	}
}
