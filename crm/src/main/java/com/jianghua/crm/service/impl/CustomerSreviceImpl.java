package com.jianghua.crm.service.impl;

import java.util.List;

import org.apache.commons.lang.ObjectUtils.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jianghua.crm.dao.CustomerRepository;
import com.jianghua.crm.domain.Customer;
import com.jianghua.crm.service.CustomerSrevice;

/**  
 * ClassName:CustomerSreviceImpl <br/>  
 * Function:  <br/>  
 * Date:     Nov 5, 2017 10:51:16 AM <br/>       
 */
@Service
@Transactional
public class CustomerSreviceImpl implements CustomerSrevice {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> findAll() {

		return customerRepository.findAll();
	}

	@Override
	public List<Customer> chaXunMeiYouGuanLian() {
		  
		return customerRepository.findByFixedAreaIdIsNull();
	}

	@Override
	public List<Customer> chaXunGuanLian(String fixedAreaId) {
		  
		return customerRepository.findByFixedAreaId(fixedAreaId);
	}

	@Override
	public void assignCustomers2FixedArea(String fixedAreaId,
			List<Long> customerIds) {
		  
		//根据id先解绑这个客户所有的已经绑定的定区
		customerRepository.findByIdSetNull(fixedAreaId);
		
		if (customerIds != null && customerIds.size() > 0) {
			for (Long id : customerIds) {
				//再设置绑定定区
				customerRepository.updateById2FixedArea(fixedAreaId, id);
			}
			
		}
		
		
	}

	@Override
	public void regist(Customer model) {
		  
		customerRepository.save(model);
		
	}

}
  
