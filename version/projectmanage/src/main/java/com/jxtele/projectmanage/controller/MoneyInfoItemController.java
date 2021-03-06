package com.jxtele.projectmanage.controller;

import com.jxtele.projectmanage.annotation.Permission;
import com.jxtele.projectmanage.controller.base.BaseController;
import com.jxtele.projectmanage.entity.MoneyInfoItem;
import com.jxtele.projectmanage.entity.PermissionType;
import com.jxtele.projectmanage.service.IMoneyInfoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/moneyinfoitem")
public class MoneyInfoItemController extends BaseController {

    private static final String qxurl = "moneyinfoitem/list";
    @Autowired
    private IMoneyInfoItemService moneyInfoItemService;

    @RequestMapping(value="/list",method = RequestMethod.GET)
    @Permission(url = qxurl,type = PermissionType.QUERY)
    public ModelAndView list(ModelMap model){
        model.addAttribute("moneyinfoitems",moneyInfoItemService.findMoneyInfoItemByProjid(this.getProjid()));
        model.addAttribute("projectId",this.getProjid());
        return new ModelAndView("page/moneyinfoitem/list",model);
    }

    /*添加资金信息子表*/
    @RequestMapping(value="/add" ,method = RequestMethod.POST)
    @ResponseBody
    @Permission(url = qxurl,type = PermissionType.ADD)
    public Object add(@ModelAttribute MoneyInfoItem record){
        record.setProjectId(this.getProjid());
        return moneyInfoItemService.insert(record);
    }

    /*删除资金信息子表*/
    @RequestMapping(value = "/del/{id}",method = RequestMethod.GET)
    @ResponseBody
    @Permission(url = qxurl,type = PermissionType.DEL)
    public Object del(@PathVariable Integer id){
        return  moneyInfoItemService.deleteByPrimaryKey(id);
    }

    /**
     * 更改资金信息子表
     * @return
     */
    @RequestMapping(value="/edit",method=RequestMethod.POST)
    @ResponseBody
    @Permission(url = qxurl,type = PermissionType.EDIT)
    public Object edit(@ModelAttribute MoneyInfoItem record){
        return moneyInfoItemService.updateByPrimaryKeySelective(record);
    }



}
