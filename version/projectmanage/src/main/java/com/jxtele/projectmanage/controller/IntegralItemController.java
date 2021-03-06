package com.jxtele.projectmanage.controller;

import com.jxtele.projectmanage.annotation.Permission;
import com.jxtele.projectmanage.controller.base.BaseController;
import com.jxtele.projectmanage.entity.IntegralItem;
import com.jxtele.projectmanage.entity.PermissionType;
import com.jxtele.projectmanage.entity.ResponseModel;
import com.jxtele.projectmanage.service.IIntegralItemService;
import com.jxtele.projectmanage.service.impl.AttachmentFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping(value = "/integralitem")
public class IntegralItemController extends BaseController {
    private static final String qxurl = "integralitem/list";

    @Autowired
    private IIntegralItemService integralItemService;
    @Autowired
    private AttachmentFileService attachmentFileService;
    @Value("${upload.root.folder}")
    public String locatFolder;

    @RequestMapping(value="/list/{integralId}/{projectId}",method = RequestMethod.GET)
    @Permission(url = qxurl,type = PermissionType.QUERY)
    public ModelAndView list(@PathVariable("integralId")Integer integralId, @PathVariable("projectId")Integer projectId,ModelMap model){
        model.addAttribute("integrals",integralItemService.findIntegralByIntegralId(integralId));
        model.addAttribute("projectId",projectId);
        model.addAttribute("integralId",integralId);
        return new ModelAndView("page/integralitem/list",model);
    }

    /*删除资金信息*/
    @RequestMapping(value = "/del/{id}",method = RequestMethod.GET)
    @ResponseBody
    @Permission(url = qxurl,type = PermissionType.DEL)
    public Object del(@PathVariable Integer id){
        return  integralItemService.deleteByPrimaryKey(id);
    }

    /**
     * 更改资金信息
     * @return
     */
    @RequestMapping(value="/edit",method=RequestMethod.POST)
    @ResponseBody
    @Permission(url = qxurl,type = PermissionType.EDIT)
    public Object edit(@ModelAttribute IntegralItem record,@RequestParam(value = "file",required = false) MultipartFile file){
        return integralItemService.updateByPrimaryKeySelective(record,file,locatFolder);
    }

    /**
     * 上传附件
     * @param file
     * @param record
     * @return
     */
    @RequestMapping(value="/add" ,method = RequestMethod.POST)
    @ResponseBody
    @Permission(url = qxurl,type = PermissionType.ADD)
    public Object add(@ModelAttribute IntegralItem record, @RequestParam(value = "file",required = false) MultipartFile file, Model model){
        Map<String, Object> add = integralItemService.insert(record,  file , locatFolder);
        return add;
    }
    @RequestMapping(value="/getAllfile/{id}",method=RequestMethod.GET)
    @Permission(url = qxurl,type = PermissionType.QUERY)
    @ResponseBody
    public Object getAllfile(@PathVariable Integer id){
        return ResponseModel.getModel("ok", "success", attachmentFileService.findAttachmentFileByRefId(id, IntegralItem.module));
    }

}
