package com.jianghua.bos.web.action.base;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jianghua.bos.domain.base.TakeTime;
import com.jianghua.bos.service.base.TakeTimeService;
import com.jianghua.bos.web.action.common.BaseAction;

/**  
 * ClassName:TakeTimeAction <br/>  
 * Function:  <br/>  
 * Date:     Nov 6, 2017 8:31:01 PM <br/>       
 */
@Namespace("/")
@ParentPackage("struts-default")
@Controller
@Scope("prototype")
public class TakeTimeAction extends BaseAction<TakeTime>{

	@Override
	public TakeTime getModel() {
		  
		return super.model;
	}
	
	@Autowired
	private TakeTimeService takeTimeService;
	
	@Action("takeTimeAction_findAll")
	public String findAll() throws IOException{
		
		List<TakeTime> list = takeTimeService.findAll();
		List2json(list, null);
		return NONE;
	}
	
	
}
  
