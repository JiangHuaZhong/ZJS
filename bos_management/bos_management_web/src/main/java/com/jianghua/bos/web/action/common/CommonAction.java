package com.jianghua.bos.web.action.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.data.domain.Page;

import com.jianghua.bos.domain.base.Area;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**  
 * ClassName:BaseAction <br/>  
 * Function:  <br/>  
 * Date:     Nov 3, 2017 11:10:30 AM <br/>       
 */
public class CommonAction<T> extends ActionSupport implements ModelDriven<T>{

	
	public T model;
	public Class<T> clazz;
	
	
	
	public CommonAction(Class<T> clazz) {
		this.clazz = clazz;
		try {
			model = clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();  
		}
	}



	@Override
	public T getModel() {
		  
		return model;
	}

	public int page;
	public int rows;
	
	
	public void setPage(int page) {
		this.page = page;
	}


	public void setRows(int rows) {
		this.rows = rows;
	}
	
	public void page2json(Page<Area> page , String[] excludes) throws IOException{
		
		List<Area> rows = page.getContent();
		long total = page.getTotalElements();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", rows);
		
		JsonConfig jsonConfig = new JsonConfig();
		
		jsonConfig.setExcludes(excludes);
		String json = JSONObject.fromObject(map,jsonConfig).toString();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().write(json);
		
	}
}
  
