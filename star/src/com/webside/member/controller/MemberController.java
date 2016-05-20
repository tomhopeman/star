package com.webside.member.controller;

import java.util.ArrayList;
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
import com.webside.base.basecontroller.BaseController;
import com.webside.exception.AjaxException;
import com.webside.member.model.MemberEntity;
import com.webside.member.service.MemberService;
import com.webside.user.model.UserEntity;
import com.webside.util.Common;
import com.webside.util.EndecryptUtils;
import com.webside.util.PageUtil;
import com.webside.util.Pager;

@Controller
@Scope("prototype")
@RequestMapping("/member/")
public class MemberController extends BaseController {
	
	@Autowired
	private MemberService memberService;
	
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
			model.addAttribute("memberTotal", memberService.queryMemberTotal());
			model.addAttribute("bindTotal", memberService.queryBindTotal());
			return Common.BACKGROUND_PATH + "/member/list";
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
		// 判断是否包含自定义参数
		parameters = pager.getParameters();
//		if (parameters.size() < 0) {
//			parameters.put("userName", null);
//		}
		// 设置分页，page里面包含了分页信息
		Page<Object> page = PageHelper.startPage(pager.getNowPage(),pager.getPageSize(), "m_id DESC");
		List<MemberEntity> list = memberService.queryListByPage(parameters);
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
	
	@RequestMapping("changeFreeStatus.html")
	@ResponseBody
	public Object changeFreeStatus(MemberEntity memberEntity){
		Map<String, Object> result = new HashMap<String, Object>();
		try
		{
			MemberEntity member = memberService.findById(memberEntity.getId());
			String message = "会员账号";
			if(member.getmStatus() == 1)
			{
				memberEntity.setmStatus(2);
				message += "冻结";
			} else if(member.getmStatus() == 2){
				memberEntity.setmStatus(1);
				message += "解冻";
			}
			
			int cnt = memberService.updateMember(memberEntity);
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
	
	@RequestMapping("resetPassword.html")
	@ResponseBody
	public Object resetPassword(MemberEntity memberEntity){
		Map<String, Object> result = new HashMap<String, Object>();
		try
		{
			//生成随机密码
//			String password = RandomUtil.generateString(6);
			String password = "111111";
			
			//加密用户输入的密码，得到密码和加密盐，保存到数据库
			MemberEntity member = EndecryptUtils.md5MemberPassword(memberEntity.getmAccountName(), password, 2);
			//设置添加用户的密码和加密盐
			memberEntity.setmPassword(member.getmPassword());
			memberEntity.setmCredentialsSalt(member.getmCredentialsSalt());
			if(memberEntity.getId() == null) {
				member = null;
				member = memberService.findByName(memberEntity.getmAccountName());
				if(member != null)
				{
					memberEntity.setId(member.getId());
					memberEntity.setmAccountName(member.getmAccountName());
					int cnt = memberService.updateMember(memberEntity);
					if(cnt > 0)
					{
						result.put("success", true);
						result.put("data", null);
						result.put("message", "密码重置成功");
					}else
					{
						result.put("success", false);
						result.put("data", null);
						result.put("message", "密码重置失败");
					}
				}else
				{
					result.put("success", false);
					result.put("data", null);
					result.put("message", "账户不存在");
				}
			}else
			{
				int cnt = memberService.updateMember(memberEntity);
				if(cnt > 0)
				{
					result.put("success", true);
					result.put("data", null);
					result.put("message", "密码重置成功");
				}else
				{
					result.put("success", false);
					result.put("data", null);
					result.put("message", "密码重置失败");
				}
			}
			
		}catch(Exception e)
		{
			throw new AjaxException(e);
		}
		return result;
	}
}
