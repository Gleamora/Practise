package com.jxtele.projectmanage.controller;

import com.jxtele.projectmanage.annotation.Permission;
import com.jxtele.projectmanage.controller.base.BaseController;
import com.jxtele.projectmanage.entity.PermissionType;
import com.jxtele.projectmanage.entity.ProcurementItem;
import com.jxtele.projectmanage.service.IProcurementItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/procurementitem")
public class ProcurementItemController extends BaseController {
    private static final String qxurl = "procurementitem/list";

    @Autowired
    private IProcurementItemService procurementItemService;

    @RequestMapping(value="/list/{id}",method = RequestMethod.GET)
    @Permission(url = qxurl,type = PermissionType.QUERY)
    public Object list(@PathVariable Integer id, ModelMap model){
        model.addAttribute("procurementitems",procurementItemService.findProcurementItemByProcurementId(id));
        return new ModelAndView("page/procurementitem/list",model);
    }

    /*添加资金信息*/
    @RequestMapping(value="/add" ,method = RequestMethod.POST)
    @ResponseBody
    @Permission(url = qxurl,type = PermissionType.ADD)
    public Object add(@ModelAttribute ProcurementItem record){
        record.setProjectId(this.getProjid());
        return procurementItemService.insert(record);
    }

    /*删除资金信息*/
    @RequestMapping(value = "/del/{id}",method = RequestMethod.GET)
    @ResponseBody
    @Permission(url = qxurl,type = PermissionType.DEL)
    public Object del(@PathVariable Integer id){
        return  procurementItemService.deleteByPrimaryKey(id);
    }

    /**
     * 更改资金信息
     * @return
     */
    @RequestMapping(value="/edit",method=RequestMethod.POST)
    @ResponseBody
    @Permission(url = qxurl,type = PermissionType.EDIT)
    public Object edit(@ModelAttribute ProcurementItem record){
        return procurementItemService.updateByPrimaryKeySelective(record);
    }
}
