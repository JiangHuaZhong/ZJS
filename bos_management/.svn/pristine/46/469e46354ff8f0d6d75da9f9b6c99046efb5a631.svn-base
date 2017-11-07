package com.jianghua.bos.web.action.base;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
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

import com.jianghua.bos.domain.base.Standard;
import com.jianghua.bos.service.base.StandardService;
import com.jianghua.bos.web.action.common.BaseAction;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * ClassName:StandardAction <br/>
 * Function: <br/>
 * Date: Oct 31, 2017 7:12:49 PM <br/>
 */

@Namespace("/")
@ParentPackage("struts-default")
@Controller
@Scope("prototype")
public class StandardAction extends BaseAction<Standard> {

	private static final long serialVersionUID = 852059441347172809L;


	@Override
	public Standard getModel() {
		
		return model;
	}

	@Autowired
	private StandardService standardService;

	@Action(value = "standardAction_save", results = {
			@Result(name = "success", location = "/pages/base/standard.html", type = "redirect") })
	public String save() {

		standardService.save(model);

		return SUCCESS;
	}

	@Action("standardAction_pageQuery")
	public String pageQuery() throws IOException {

		// PageRequest中的page属性是从0开始的
		// EasyUI传递过来的page属性是从1开始的
		Pageable pageable = new PageRequest(page - 1, rows);
		Page<Standard> page = standardService.pageQuery(pageable);
		
		page2json(page, null);

		
		return NONE;
	}

	@Action("standardAction_findAll")
	public String findAll() throws IOException {

		List<Standard> list = standardService.findAll();
		String json = JSONArray.fromObject(list).toString();
		HttpServletResponse response = ServletActionContext.getResponse();
		// 设置字符和类型
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().write(json);

		return NONE;
	}

}
