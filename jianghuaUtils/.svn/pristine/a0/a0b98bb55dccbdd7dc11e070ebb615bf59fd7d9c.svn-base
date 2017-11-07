package com.jianghua.test;

import java.util.Collection;

import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.Test;

import com.jianghua.bos.domain.Customer;

/**  
 * ClassName:MyfindAllTest <br/>  
 * Function:  <br/>  
 * Date:     Nov 5, 2017 12:51:36 PM <br/>       
 */
public class MyfindAllTest {

	@Test
	public void test1(){
		
		Collection<? extends Customer> list = WebClient.create("http://localhost:8088/crm/service/customerService/customer").
		accept(MediaType.APPLICATION_JSON).getCollection(Customer.class);
		for (Customer customer : list) {
			System.out.println(customer);
		}
		
	}
}
  
