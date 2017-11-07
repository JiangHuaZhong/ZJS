package com.jianghua.bos.service.base.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jianghua.bos.dao.base.SubareaRepository;
import com.jianghua.bos.domain.base.SubArea;
import com.jianghua.bos.service.base.SubareaService;

/**  
 * ClassName:SubareaServiceImpl <br/>  
 * Function:  <br/>  
 * Date:     Nov 3, 2017 9:40:02 PM <br/>       
 */

@Service
@Transactional
public class SubareaServiceImpl implements SubareaService {

	@Autowired
	private SubareaRepository subareaRepository;
	
	@Override
	public void save(SubArea model) {
		  subareaRepository.save(model);
	}

	@Override
	public Page<SubArea> pageQuery(Pageable pageable) {
		  
		return subareaRepository.findAll(pageable);
	}

	@Override
	public List<SubArea> findAll() {
		  
		return subareaRepository.findAll();
	}

}
  
