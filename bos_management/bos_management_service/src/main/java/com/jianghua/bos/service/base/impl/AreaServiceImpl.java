package com.jianghua.bos.service.base.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jianghua.bos.dao.base.AreaRepository;
import com.jianghua.bos.domain.base.Area;
import com.jianghua.bos.service.base.AreaService;

/**  
 * ClassName:AreaServiceImpl <br/>  
 * Function:  <br/>  
 * Date:     Nov 2, 2017 10:11:55 PM <br/>       
 */
@Service
@Transactional
public class AreaServiceImpl implements AreaService{

	@Autowired
	private AreaRepository areaRepository;
	
	
	@Override
	public void save(List<Area> list) {
		areaRepository.save(list);
		
	}


	@Override
	public Page<Area> pageQuery(Pageable pageable) {
		  
		return areaRepository.findAll(pageable);
	}


	@Override
	public List<Area> findAll() {
		  
		return areaRepository.findAll();
	}


	@Override
	public List<Area> findByQ(String q) {
		//将传进来的转化成大写,因为数据库都是大写
		
		q = q.toUpperCase();
		return areaRepository.findByQ("%"+q+"%");
	}

}
  
