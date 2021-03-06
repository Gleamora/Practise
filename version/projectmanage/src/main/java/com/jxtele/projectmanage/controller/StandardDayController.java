package com.jxtele.projectmanage.controller;

import com.jxtele.projectmanage.annotation.Permission;
import com.jxtele.projectmanage.controller.base.BaseController;
import com.jxtele.projectmanage.entity.PermissionType;
import com.jxtele.projectmanage.entity.ResponseModel;
import com.jxtele.projectmanage.entity.StandardDay;
import com.jxtele.projectmanage.service.IStandardApplyService;
import com.jxtele.projectmanage.service.IStandardDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/standardday")
public class StandardDayController extends BaseController {

    private static final String qxurl = "standardday/list";

    @Autowired
    private IStandardDayService standardDayService;
    @Autowired
    private IStandardApplyService standardApplyService;
    /**
     * 某个项目的工日信息
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value="/plist/{projId}/{id}",method = RequestMethod.GET)
    @Permission(url = qxurl,type = PermissionType.QUERY)
    public ModelAndView list(@PathVariable("projId")Integer projId,@PathVariable("id")Integer id, ModelMap model){
        model.addAttribute("standardappys",standardApplyService.findStandardDayId(id));
        model.addAttribute("projId",projId);
        model.addAttribute("dayid",id);
        return new ModelAndView("page/standardapply/list",model);
    }

    /**
     * 工日列表
     * @param model
     * @return
     */
    @RequestMapping(value="/list",method=RequestMethod.GET)
    @Permission(url = qxurl,type = PermissionType.QUERY)
    public ModelAndView list(Model model){
        model.addAttribute("standarddayLists", standardDayService.findStandardDayByProjId(this.getProjid()));
        return new ModelAndView("page/standardday/list");
    }
    /*添加资金信息*/
    @RequestMapping(value="/add" ,method = RequestMethod.POST)
    @ResponseBody
    @Permission(url = qxurl,type = PermissionType.ADD)
    public Object add(@ModelAttribute StandardDay record){
        return standardDayService.insert(record);
    }

    /*删除资金信息*/
    @RequestMapping(value = "/del/{id}",method = RequestMethod.GET)
    @ResponseBody
    @Permission(url = qxurl,type = PermissionType.DEL)
    public Object del(@PathVariable Integer id){
        return  standardDayService.deleteByPrimaryKey(id);
    }

    /**
     * 更改资金信息
     * @return
     */
    @RequestMapping(value="/edit",method=RequestMethod.POST)
    @ResponseBody
    @Permission(url = qxurl,type = PermissionType.EDIT)
    public Object edit(@ModelAttribute StandardDay record){
        return standardDayService.updateByPrimaryKeySelective(record);
    }

    /**
     * 按类型筛选
     * @param type
     * @return
     */
    @RequestMapping(value = "/listbytype/{type}",method = RequestMethod.GET)
    @ResponseBody
    @Permission(url = qxurl,type = PermissionType.QUERY)
    public Object listbytype(@PathVariable String type){
        return ResponseModel.getModel("添加成功", "success", standardDayService.findStandardDayByProjIdAndType(this.getProjid(),type));
    }
}
