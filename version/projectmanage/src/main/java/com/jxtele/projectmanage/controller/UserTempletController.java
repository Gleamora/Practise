package com.jxtele.projectmanage.controller;

import com.jxtele.projectmanage.annotation.Permission;
import com.jxtele.projectmanage.controller.base.BaseController;
import com.jxtele.projectmanage.entity.PermissionType;
import com.jxtele.projectmanage.entity.UserTemplet;
import com.jxtele.projectmanage.service.IProjectService;
import com.jxtele.projectmanage.service.IUserTempletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value="/usertemplet")
public class UserTempletController extends BaseController {

    private final static String qxurl = "usertemplet/list";

    @Autowired
    private IUserTempletService userTempletService;

    @Autowired
    private IProjectService projectService;


    @RequestMapping(value="/add",method=RequestMethod.POST)
    @ResponseBody
    @Permission(url = qxurl,type = PermissionType.ADD)
    public Object add(){
        return userTempletService.insert(this.getParameterMap(),this.getLoginUserId());
    }

    /**
     * 删除项目团队
     * @return
     */
    @RequestMapping(value="/del/{id}",method=RequestMethod.GET)
    @ResponseBody
    @Permission(url = qxurl,type = PermissionType.DEL)
    public Object del(@PathVariable("id") Integer id){
        return userTempletService.deleteByPrimaryKey(id);
    }

    /**
     * 更改项目团队
     * @return
     */
    @RequestMapping(value="/edit",method= RequestMethod.POST)
    @ResponseBody
    @Permission(url = qxurl,type = PermissionType.EDIT)
    public Object edit(@ModelAttribute UserTemplet record){
        return userTempletService.updateByPrimaryKeySelective(record);
    }

    @RequestMapping(value="/getAllproject",method=RequestMethod.GET)
    @ResponseBody
    @Permission(url = qxurl,type = PermissionType.QUERY)
    public Object getAllproject(){
        return projectService.findAllProject();
    }

    @RequestMapping(value="/getProjectByUser",method=RequestMethod.GET)
    @ResponseBody
    @Permission(url = qxurl,type = PermissionType.QUERY)
    public Object getProjectByUser(){
        return userTempletService.getProjectByUser(this.getParameterMap(),this.getLoginUserId(),this.getSession());
    }

    @RequestMapping(value="/getAllprojectByTeam",method=RequestMethod.GET)
    @ResponseBody
    @Permission(url = qxurl,type = PermissionType.QUERY)
    public Object getAllprojectByTeam(){
        return projectService.findProjectByTeamBuild(this.getLoginUserId());
    }

    @RequestMapping(value="/usertempletList",method=RequestMethod.GET)
    @ResponseBody
    @Permission(url = qxurl,type = PermissionType.QUERY)
    public Object usertempletList(){
        return userTempletService.selectByUserId(this.getLoginUserId());
    }

}
