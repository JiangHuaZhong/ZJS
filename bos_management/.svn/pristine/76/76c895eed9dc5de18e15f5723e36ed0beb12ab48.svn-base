package com.jianghua.bos.service.base.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jianghua.bos.dao.base.StandarRepository;
import com.jianghua.bos.domain.base.Standard;
import com.jianghua.bos.service.base.StandardService;

/**  
 * ClassName:StandardServiceImpl <br/>  
 * Function:  <br/>  
 * Date:     Oct 31, 2017 7:41:23 PM <br/>       
 */
@Service
@Transactional
public class StandardServiceImpl implements StandardService {

	@Autowired
	private StandarRepository standarRepository;
	
	@Override
	public void save(Standard standard) {
		standarRepository.save(standard);
		
	}

	@Override
	public Page<Standard> pageQuery(Pageable pageable) {
		  
		return standarRepository.findAll(pageable);
	}

	@Override
	public List<Standard> findAll() {
		  
		return standarRepository.findAll();
	}

}
  
