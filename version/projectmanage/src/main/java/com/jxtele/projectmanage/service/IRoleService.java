package com.jxtele.projectmanage.service;


import com.jxtele.projectmanage.util.ParameterMap;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Component
public interface IRoleService {
	public List<ParameterMap> list();
	public Map<String,Object> getMenu(ParameterMap pm);
	public Map<String,Object> edit(ParameterMap pm); 
	public Map<String,Object> add(ParameterMap pm, HttpSession session);
	public Map<String,Object> del(String roleId);
	public Map<String, Object> editusercontrol(ParameterMap pm);
}
