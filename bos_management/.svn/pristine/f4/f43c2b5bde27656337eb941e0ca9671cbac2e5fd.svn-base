package com.jianghua.bos.web.action.base;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import com.jianghua.bos.domain.base.SubArea;
import com.jianghua.bos.service.base.SubareaService;
import com.jianghua.bos.web.action.common.BaseAction;

/**  
 * ClassName:SubareaAction <br/>  
 * Function:  <br/>  
 * Date:     Nov 3, 2017 9:28:05 PM <br/>       
 */
@Namespace("/")
@ParentPackage("struts-default")
@Controller
@Scope("prototype")
public class SubareaAction extends BaseAction<SubArea> {

	@Override
	public SubArea getModel() {
		  
		return model;
	}
	
	@Autowired
	private SubareaService subareaService;
	
	/**
	 * 
	 * save:添加保存分区
	 *  
	 * @return
	 */
	@Action(value="subareaAction_save",
			results={@Result(name="success",type="redirect",location="/pages/base/sub_area.html")})
	public String save(){
		
		subareaService.save(model);
		
		return SUCCESS;
	}
	
	/**
	 * 
	 * pageQuery:分页查询分区 
	 *  
	 * @return
	 * @throws IOException
	 */
	@Action("subareaAction_pageQuery")
	public String pageQuery() throws IOException{
		
		Pageable pageable = new PageRequest(page -1, rows);
		Page<SubArea> page = subareaService.pageQuery(pageable);
		page2json(page, new String[]{"subareas","fixedArea"});
		
		return NONE;
	}
	
	/**
	 * 
	 * findAll:查询所有的分区
	 *  
	 * @return
	 * @throws IOException
	 */
	@Action("subareaAction_findAll")
	public String findAll() throws IOException{
		System.out.println("进来查询分区!");
		
		List<SubArea> list = subareaService.findAll();
		List2json(list,new String[]{"subareas","fixedArea"});
		
		return NONE;
	}
	
}
