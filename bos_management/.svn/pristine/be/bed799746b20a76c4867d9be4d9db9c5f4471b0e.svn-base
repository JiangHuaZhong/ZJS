package com.jianghua.bos.service.base.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jianghua.bos.dao.base.TakeTimeRepository;
import com.jianghua.bos.domain.base.TakeTime;
import com.jianghua.bos.service.base.TakeTimeService;

/**  
 * ClassName:TakeTimeServiceImpl <br/>  
 * Function:  <br/>  
 * Date:     Nov 6, 2017 8:35:25 PM <br/>       
 */
@Service
@Transactional
public class TakeTimeServiceImpl implements TakeTimeService {

	@Autowired
	private TakeTimeRepository takeTimeRepository;
	
	@Override
	public List<TakeTime> findAll() {

		return takeTimeRepository.findAll();
	}

}
  
