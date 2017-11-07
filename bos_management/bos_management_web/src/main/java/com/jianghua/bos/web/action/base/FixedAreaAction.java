package com.jianghua.bos.web.action.base;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.xml.resolver.apps.resolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import com.jianghua.bos.domain.base.Courier;
import com.jianghua.bos.domain.base.Customer;
import com.jianghua.bos.domain.base.FixedArea;
import com.jianghua.bos.service.base.FixedAreaSrevice;
import com.jianghua.bos.web.action.common.BaseAction;
import com.sun.xml.bind.v2.TODO;

/**  
 * ClassName:FixedAreaAction <br/>  
 * Function:  <br/>  
 * Date:     Nov 4, 2017 5:08:17 PM <br/>       
 */
@Namespace("/")
@ParentPackage("struts-default")
@Controller
@Scope("prototype")
public class FixedAreaAction extends BaseAction<FixedArea>{

	@Override
	public FixedArea getModel() {
		  
		return model;
	}
	
	@Autowired
	private FixedAreaSrevice fixedAreaSrevice;
	
	/**
	 * 快递员id
	 */
	private Long courerIds;
	/**
	 * 上班时间id
	 */
	private Long takeTimeId;
	/**
	 * 分区id
	 */
	private Long subAreaId;
	
	
	public void setCourerIds(Long courerIds) {
		this.courerIds = courerIds;
	}
	public void setTakeTimeId(Long takeTimeId) {
		this.takeTimeId = takeTimeId;
	}
	public void setSubAreaId(Long subAreaId) {
		this.subAreaId = subAreaId;
	}
	/**
	 * 保存分区
	 * save:. <br/>  
	 *  
	 * @return
	 */
	@Action(value="fixedAreaAction_save",
			results={@Result(name="success",type="redirect",location="/pages/base/fixed_area.html")})
	public String save(){
		
		fixedAreaSrevice.save(model);
		
		return SUCCESS;
	}
	/**
	 * 分页查询分区信息
	 * pageQuery:分页查询分区信息
	 *  
	 * @return
	 * @throws IOException 
	 */
	@Action("fixedAreaAction_pageQuery")
	public String pageQuery() throws IOException{
		Pageable pageable = new PageRequest(page -1, rows);
		Page<FixedArea> page = fixedAreaSrevice.pageQuery(pageable);
		page2json(page,new String[]{"couriers","subareas"});
		return NONE;
	}
	//未关联金客户
	@Action("fixedAreaAction_chaXunMeiYouGuanLian")
	public String chaXunMeiYouGuanLian() throws IOException{
		
		List<Customer> list = (List<Customer>) WebClient
				.create("http://localhost:8088/crm/service/customerService/chaXunMeiYouGuanLian")
				.getCollection(Customer.class);
		List2json(list, null);
		
		return NONE;
	}
	//已关联客户
	@Action("fixedAreaAction_chaXunGuanLian")
	public String chaXunGuanLian() throws IOException{
		
		List<Customer> list = (List<Customer>) WebClient
				.create("http://localhost:8088/crm/service/customerService/chaXunGuanLian")
				.query("fixedAreaId", model.getId())
				.getCollection(Customer.class);
		List2json(list, null);
		
		return NONE;
	}
	
	private List<Long> customerIds = new ArrayList<Long>();
	public void setCustomerIds(List<Long> customerIds) {
		this.customerIds = customerIds;
	}
 	
	//关联客户
	@Action(value = "fixedAreaAction_assignCustomers2FixedArea", results = {
			@Result(name = "success", type = "redirect", location = "/pages/base/fixed_area.html") })
	public String assignCustomers2FixedArea() {
		
		//根据定区id去crm系统关联需要关联的客户
		WebClient
				.create("http://localhost:8088/crm/service/customerService/assignCustomers2FixedArea")
				.query("fixedAreaId", model.getId())
				.query("customerIds", customerIds).put(null);
		
		return SUCCESS;
	}
	
	/**
	 * 
	 * associationCourierToFixedArea:定区关联快递员
	 *  
	 * @return
	 */
	@Action(value = "fixedAreaAction_associationCourierToFixedArea",results = {
			@Result(name = "success", type = "redirect", location = "/pages/base/fixed_area.html") })
	public String associationCourierToFixedArea() {
		fixedAreaSrevice.associationCourierToFixedArea(model,courerIds,takeTimeId);
		
		return SUCCESS;
	}
	
	/**
	 * 关联分区
	 * associationSubAreaToFixedArea:. <br/>  
	 *  
	 * @return
	 */
	@Action(value = "fixedAreaAction_associationSubAreaToFixedArea",results = {
			@Result(name = "success", type = "redirect", location = "/pages/base/fixed_area.html") })
	public String associationSubAreaToFixedArea() {
		fixedAreaSrevice.associationSubAreaToFixedArea(model,subAreaId);
		
		return SUCCESS;
	}
	
}
  
