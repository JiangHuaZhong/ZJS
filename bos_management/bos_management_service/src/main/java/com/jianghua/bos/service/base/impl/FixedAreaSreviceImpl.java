package com.jianghua.bos.service.base.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jianghua.bos.dao.base.CourierRepository;
import com.jianghua.bos.dao.base.FixedAreaRepository;
import com.jianghua.bos.dao.base.SubareaRepository;
import com.jianghua.bos.dao.base.TakeTimeRepository;
import com.jianghua.bos.domain.base.Courier;
import com.jianghua.bos.domain.base.FixedArea;
import com.jianghua.bos.domain.base.SubArea;
import com.jianghua.bos.domain.base.TakeTime;
import com.jianghua.bos.service.base.FixedAreaSrevice;

/**  
 * ClassName:FixedAreaSreviceImpl <br/>  
 * Function:  <br/>  
 * Date:     Nov 4, 2017 5:15:56 PM <br/>       
 */
@Service
@Transactional
public class FixedAreaSreviceImpl implements FixedAreaSrevice {

	@Autowired
	private FixedAreaRepository fixedAreaRepository;
	@Autowired
	private CourierRepository courierRepository;
	@Autowired
	private TakeTimeRepository takeTimeRepository;
	@Autowired
	private SubareaRepository subareaRepository;
	
	@Override
	public void save(FixedArea model) {
		
		fixedAreaRepository.save(model);

	}

	@Override
	public Page<FixedArea> pageQuery(Pageable pageable) {
		  
		return fixedAreaRepository.findAll(pageable);
	}

	@Override
	public void associationCourierToFixedArea(FixedArea model, Long courerIds,
			Long takeTimeId) {
		  
		//获取定区对象
		FixedArea fixedArea = fixedAreaRepository.findOne(model.getId());
		//获取快递员
		Courier courier = courierRepository.findOne(courerIds);
		//获取派送时间
		TakeTime takeTime = takeTimeRepository.findOne(takeTimeId);
		//定区关联快递员
		fixedArea.getCouriers().add(courier);//注意快递员不能添加定区,否则数据库会被重复添加多余的数据
		//快递员添加派送时间
		courier.setTakeTime(takeTime);
		
		
	}

	@Override
	public void associationSubAreaToFixedArea(FixedArea model, Long subAreaId) {
		//获取定区对象
		FixedArea fixedArea = fixedAreaRepository.findOne(model.getId());
		//获取分区对象
		SubArea subArea = subareaRepository.findOne(subAreaId);
		subArea.setFixedArea(fixedArea);
		
	}



}
  
