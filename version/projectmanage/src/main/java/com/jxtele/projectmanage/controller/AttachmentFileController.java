package com.jxtele.projectmanage.controller;

import com.jxtele.projectmanage.annotation.Permission;
import com.jxtele.projectmanage.controller.base.BaseController;
import com.jxtele.projectmanage.entity.AttachmentFile;
import com.jxtele.projectmanage.entity.PermissionType;
import com.jxtele.projectmanage.service.IAttachmentFileService;
import com.jxtele.projectmanage.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/upload")
public class AttachmentFileController extends BaseController {
    private static final String qxurl = "upload/list";
    @Value("${upload.root.folder}")
    public String locatFolder;

    @Autowired
    private IAttachmentFileService attachmentFileService;

    @RequestMapping(value="/list/{id}",method = RequestMethod.GET)
    @Permission(url = qxurl,type = PermissionType.QUERY)
    public ModelAndView list(@PathVariable("id")Integer id, ModelMap model){
       /* model.addAttribute("communications",communicationService.findCommunicationByProjId(id));
        model.addAttribute("projectId",id);*/
        return new ModelAndView("page/upload/list",model);
    }


    @RequestMapping(value = "/del/{id}",method = RequestMethod.GET)
    @ResponseBody
    @Permission(url = qxurl,type = PermissionType.DEL)
    public Object del(@PathVariable Integer id){
        return  attachmentFileService.deleteByPrimaryKey(id);
    }


    @RequestMapping(value="/edit",method=RequestMethod.POST)
    @ResponseBody
    @Permission(url = qxurl,type = PermissionType.EDIT)
    public Object edit(@ModelAttribute AttachmentFile record){
        return attachmentFileService.updateByPrimaryKeySelective(record);
    }

    @RequestMapping(value = "/fileup", method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file,@ModelAttribute AttachmentFile record){
        return null;
    }
    @RequestMapping(value="/downloadFile")
    public void downloads(HttpServletRequest request, HttpServletResponse response,Integer id) throws Exception {
        AttachmentFile record = attachmentFileService.selectByPrimaryKey(id);
        FileUploadUtil.fileDownload(request,response,record.getAttachmentPath(),record.getAttachmentName());
    }

}
