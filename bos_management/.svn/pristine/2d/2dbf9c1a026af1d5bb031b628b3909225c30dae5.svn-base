package com.jianghua.bos.service.base.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jianghua.bos.dao.base.CourierRepository;
import com.jianghua.bos.domain.base.Courier;
import com.jianghua.bos.service.base.CourierService;

/**  
 * ClassName:CourierServiceImpl <br/>  
 * Function:  <br/>  
 * Date:     Nov 1, 2017 9:53:33 AM <br/>       
 */
@Service
@Transactional
public class CourierServiceImpl implements CourierService {
	
	@Autowired
	private CourierRepository courierRepository;
	
	@Override
	public void save(Courier courier) {
		courierRepository.save(courier);
	}

	@Override
	public Page<Courier> pageQuery(Specification<Courier> specification,Pageable pageable) {
		return courierRepository.findAll(specification,pageable);
	}

	@Override
	public void batchDel(String ids) {
		  
		String[] strings = ids.split(",");
		System.out.println(strings);
		if (StringUtils.isNotEmpty(ids)) {
			
			for (String string : strings) {
				courierRepository.updateById((long)Integer.parseInt(string));
			}
		}
		
	}

	@Override
	public List<Courier> findByDeltagIsNotZreo() {
		  
		return courierRepository.findByDeltagIsNotZreo();
	}

}
  
