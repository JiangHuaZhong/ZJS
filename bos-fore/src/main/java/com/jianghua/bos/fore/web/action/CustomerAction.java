package com.jianghua.bos.fore.web.action;

import java.util.Random;

import javax.print.DocFlavor.READER;
import javax.swing.JSlider;
import javax.swing.plaf.basic.BasicSliderUI;
import javax.swing.plaf.basic.BasicSliderUI.ActionScroller;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jianghua.bos.domain.Customer;
import com.jianghua.bos.utils.SmsUtils;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**  
 * ClassName:CustomerAction <br/>  
 * Function:  <br/>  
 * Date:     Nov 7, 2017 3:07:44 PM <br/>       
 */
@Namespace("/")
@ParentPackage("struts-default")
@Controller
@Scope("prototype")
public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{

	private Customer model = new Customer();
	
	@Override
	public Customer getModel() {
		  
		return model;
	}

	
	/**
	 * 
	 * sendSMS:发送验证码
	 *  
	 * @return
	 */
	@Action("customerAction_sendSMS")
	public String sendSMS(){

		String code = RandomStringUtils.randomNumeric(4);
		System.out.println(code);
		
		String msg = "尊敬的客户你好，您本次获取的验证码为："+code;
		ServletActionContext.getRequest().getSession().setAttribute(model.getTelephone(), code);
		
		SmsUtils.sendSmsByWebService(model.getTelephone(),msg);
		
		return NONE;
	}

	private String checkcode;
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
	
	/**
	 * 
	 * regist:用户注册
	 *  
	 * @return
	 */
	@Action(value = "customerAction_regist", results = {
			@Result(name = "success", type = "redirect", location = "/signup-success.html"),
			@Result(name = "error", type = "redirect", location = "/signup-fail.html") })
	public String regist(){
		
		//判断验证码是否一致
		String serverCode = (String) ServletActionContext.getRequest().getSession().getAttribute(model.getTelephone());
		
		if (StringUtils.isNotEmpty(checkcode)
				&& StringUtils.isNotEmpty(serverCode)
				&& serverCode.equals(serverCode)) {

			WebClient
					.create("http://localhost:8088/crm/service/customerService/regist")
					.type(MediaType.APPLICATION_JSON).post(model);
			
			return SUCCESS;
			
		}

		return ERROR;
	}
	
	
}
  
