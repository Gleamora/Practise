package com.jxtele.projectmanage.controller;

import com.jxtele.projectmanage.annotation.Permission;
import com.jxtele.projectmanage.controller.base.BaseController;
import com.jxtele.projectmanage.entity.AlterSchedule;
import com.jxtele.projectmanage.entity.Const;
import com.jxtele.projectmanage.entity.PermissionType;
import com.jxtele.projectmanage.entity.ProjectSchedule;
import com.jxtele.projectmanage.service.IAlterScheduleService;
import com.jxtele.projectmanage.service.IProjectScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
@RequestMapping(value = "/projectschedule")
public class ProjectScheduleController extends BaseController {

    private final static String qxurl = "projectschedule/list";

    @Autowired
    private IProjectScheduleService projectSchedulService;

    @Autowired
    private IAlterScheduleService alterScheduleService;

    @RequestMapping(value="/list/{id}",method = RequestMethod.GET)
    @Permission(url = qxurl,type = PermissionType.QUERY)
    public ModelAndView list(@PathVariable Integer id,ModelMap model){
        model.addAttribute("projectschedules",projectSchedulService.findProjectScheduleByProjId(id));
        model.addAttribute("projectId",this.getProjid());
        return new ModelAndView("page/projectschedule/list",model);
    }


    @RequestMapping(value="/findproject/{id}",method = RequestMethod.GET)
    @ResponseBody
    @Permission(url = qxurl,type = PermissionType.QUERY)
    public Object findproject(@PathVariable("id")Integer id){
      return projectSchedulService.findProjectScheduleByProjId(id).get(0);
    }

    /*添加进度信息*/
    @RequestMapping(value="/add" ,method = RequestMethod.POST)
    @ResponseBody
    @Permission(url = qxurl,type = PermissionType.ADD)
    public Object add(@ModelAttribute ProjectSchedule record){
        record.setProjectId(this.getProjid());
        return projectSchedulService.insert(record);
    }

    /*删除进度信息*/
    @RequestMapping(value = "/del/{id}",method = RequestMethod.GET)
    @ResponseBody
    @Permission(url = qxurl,type = PermissionType.DEL)
    public Object del(@PathVariable Integer id){
        return  projectSchedulService.deleteByPrimaryKey(id);
    }

    /**
     * 更改进度信息
     * @return
     */
    @RequestMapping(value="/edit",method=RequestMethod.POST)
    @ResponseBody
    @Permission(url = qxurl,type = PermissionType.EDIT)
    public Object edit(@ModelAttribute ProjectSchedule record){
        return projectSchedulService.updateByPrimaryKeySelective(record);
    }

    @RequestMapping(value="/secchange",method=RequestMethod.POST)
    @ResponseBody
    @Permission(url = qxurl,type = PermissionType.EDIT)
    public Object secchange(@ModelAttribute ProjectSchedule record){
        AlterSchedule alterSchedule = alterScheduleService.selectByPrimaryKey(record.getSecid());
        ProjectSchedule _record = projectSchedulService.selectByPrimaryKey(record.getId());
        alterSchedule.setProjectId(_record.getProjectId());
        alterSchedule.setLasttotaldays(_record.getTotaldays());
        alterSchedule.setLastenddate(_record.getEnddate());
        alterSchedule.setLaststartdate(_record.getStartdate());
        alterSchedule.setLastfinaldate(_record.getFinaldate());
        alterSchedule.setLastinitialdate(_record.getInitialdate());
        alterSchedule.setCtScheduleid(alterSchedule.getId());
        alterSchedule.setLastwarrantyClaim(_record.getWarrantyClaim());
        alterSchedule.setAlterdate(new Date());
        alterSchedule.setAlertsec(0);
        /*alterSchedule.setAltertime(alterScheduleService.findAlterScheduleByProjId(alterSchedule.getProjectId()).size());*/
        alterScheduleService.updateByPrimaryKeySelective(alterSchedule,null,null);
        return projectSchedulService.updateByPrimaryKeySelective(record);
    }



}
