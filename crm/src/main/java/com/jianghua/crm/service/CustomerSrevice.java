package com.jianghua.crm.service;

import java.util.List;

import javax.jws.WebService;
import javax.print.attribute.standard.Media;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.jianghua.crm.domain.Customer;

/**  
 * ClassName:CustomerSrevice <br/>  
 * Function:  <br/>  
 * Date:     Nov 5, 2017 10:44:50 AM <br/>       
 */
public interface CustomerSrevice {
	
	
	@GET // 获取
	@Path("/customer") // 指定访问路劲
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON }) // 返回给客户端的数据格式
	List<Customer> findAll();
	
	/**
	 * 
	 * chaXunMeiYouGuanLian:查询没有关联定区的客户 
	 *  
	 * @return
	 */
	@GET
	@Path("/chaXunMeiYouGuanLian")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	List<Customer> chaXunMeiYouGuanLian();
	
	/**
	 * 
	 * chaXunGuanLian:查询已经关联定区的客户
	 *  
	 * @param fixedAreaId
	 * @return
	 */
	@GET
	@Path("/chaXunGuanLian")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	List<Customer> chaXunGuanLian(@QueryParam("fixedAreaId")String fixedAreaId);
	
	/**
	 * 
	 * assignCustomers2FixedArea:关联定区客户
	 *  
	 * @param fixedAreaId
	 * @param customerIds
	 */
	@PUT
	@Path("/assignCustomers2FixedArea")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void assignCustomers2FixedArea(@QueryParam("fixedAreaId")String fixedAreaId,@QueryParam("customerIds")List<Long> customerIds);
	
	
	@POST
	@Path("/regist")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void regist(Customer model);
	
}
  
