package com.webside.bankCard.controller;

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
import com.webside.bankCard.model.BankCardEntity;
import com.webside.bankCard.service.BankCardService;
import com.webside.base.basecontroller.BaseController;
import com.webside.exception.AjaxException;
import com.webside.util.Common;
import com.webside.util.PageUtil;
import com.webside.util.Pager;

@Controller
@Scope("prototype")
@RequestMapping("/bankCard/")
public class BankCardController extends BaseController
{
    @Autowired
    private BankCardService bankCardService;
    
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
            
          //获取所有绑定银行卡数量
            String totalBankCard=bankCardService.queryTotalBankCard();
            //获取所有绑定银行卡的会员数量
            String totalBingdingMember=bankCardService.queryTotalBingdingMember();
            model.addAttribute("totalBankCard", totalBankCard);
            model.addAttribute("totalBingdingMember", totalBingdingMember);
            
            model.addAttribute("page", page);
            return Common.BACKGROUND_PATH + "/bankCard/list";
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
//        if (parameters.size() < 0) {
//            parameters.put("bc_no", null);
//        }
        // 设置分页，page里面包含了分页信息
        Page<Object> page = PageHelper.startPage(pager.getNowPage(),pager.getPageSize(), "bc_id DESC");
        //获取列表
        List<BankCardEntity> list = bankCardService.queryListByPage(parameters);
        
        parameters.clear();
        parameters.put("isSuccess", Boolean.TRUE);
        parameters.put("nowPage", pager.getNowPage());
        parameters.put("pageSize", pager.getPageSize());
        parameters.put("pageCount", page.getPages());
        parameters.put("recordCount", page.getTotal());
        parameters.put("startRecord", page.getStartRow());
        //列表展示数据
        parameters.put("exhibitDatas", list);
//        parameters.put("totalBankCard", totalBankCard);
//        parameters.put("totalBingdingMember", totalBingdingMember);
        
        return parameters;
    }
}
