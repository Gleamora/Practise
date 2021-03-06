package com.jxtele.projectmanage.controller;

import com.jxtele.projectmanage.annotation.Permission;
import com.jxtele.projectmanage.controller.base.BaseController;
import com.jxtele.projectmanage.entity.PermissionType;
import com.jxtele.projectmanage.entity.Procurement;
import com.jxtele.projectmanage.service.IProcurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/procurement")
public class ProcurementController extends BaseController {
    private static final String qxurl = "procurement/list";

    @Autowired
    private IProcurementService procurementService;

    @RequestMapping(value="/list",method = RequestMethod.GET)
    @Permission(url = qxurl,type = PermissionType.QUERY)
    public Object list(ModelMap model){
        model.addAttribute("procurements",procurementService.findProcurementByProjId(this.getProjid()));
        return new ModelAndView("page/procurement/list",model);

    }

    /*添加资金信息*/
    @RequestMapping(value="/add" ,method = RequestMethod.POST)
    @ResponseBody
    @Permission(url = qxurl,type = PermissionType.ADD)
    public Object add(@ModelAttribute Procurement record){
        record.setProjectId(this.getProjid());
        return procurementService.insert(record);
    }

    /*删除资金信息*/
    @RequestMapping(value = "/del/{id}",method = RequestMethod.GET)
    @ResponseBody
    @Permission(url = qxurl,type = PermissionType.DEL)
    public Object del(@PathVariable Integer id){
        return  procurementService.deleteByPrimaryKey(id);
    }

    /**
     * 更改资金信息
     * @return
     */
    @RequestMapping(value="/edit",method=RequestMethod.POST)
    @ResponseBody
    @Permission(url = qxurl,type = PermissionType.EDIT)
    public Object edit(@ModelAttribute Procurement record){
        return procurementService.updateByPrimaryKeySelective(record);
    }
}
