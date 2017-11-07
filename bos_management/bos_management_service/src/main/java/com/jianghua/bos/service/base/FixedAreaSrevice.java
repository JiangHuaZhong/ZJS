package com.jianghua.bos.service.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jianghua.bos.domain.base.FixedArea;

/**  
 * ClassName:FixedAreaSrevice <br/>  
 * Function:  <br/>  
 * Date:     Nov 4, 2017 5:14:44 PM <br/>       
 */
public interface FixedAreaSrevice {

	/**
	 * 
	 * save:定区保存
	 *  
	 * @param model
	 */
	void save(FixedArea model);

	/**
	 * 
	 * pageQuery:定区分页查询
	 *  
	 * @param pageable
	 * @return
	 */
	Page<FixedArea> pageQuery(Pageable pageable);

	/**
	 * 
	 * associationCourierToFixedArea:关联快递员
	 *  
	 * @param model 定区
	 * @param courerIds 快递员id
	 * @param takeTimeId 收派时间id
	 */
	void associationCourierToFixedArea(FixedArea model, Long courerIds,
			Long takeTimeId);

	/**
	 * 
	 * associationSubAreaToFixedArea:关联分区
	 *  
	 * @param model 定区
	 * @param subAreaId 分区id
	 */
	void associationSubAreaToFixedArea(FixedArea model, Long subAreaId);

}
  
