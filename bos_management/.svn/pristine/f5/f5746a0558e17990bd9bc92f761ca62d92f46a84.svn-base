package com.jianghua.bos.service.base;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.jianghua.bos.domain.base.Courier;

/**  
 * ClassName:CourierService <br/>  
 * Function:  <br/>  
 * Date:     Nov 1, 2017 9:52:34 AM <br/>       
 */
public interface CourierService {

	/**
	 * 
	 * save:保存快递员
	 *  
	 * @param courier
	 */
	void save(Courier courier);

	/**
	 * 
	 * pageQuery:分页查询快递员信息 
	 *  
	 * @param specification
	 * @param pageable 按条件查询
	 * @return
	 */
	Page<Courier> pageQuery(Specification<Courier> specification, Pageable pageable);

	/**
	 * 
	 * batchDel: 批量作废快递员 
	 *  
	 * @param ids
	 */
	void batchDel(String ids);

	/**
	 * 
	 * findAll:查询没有作废的快递员  
	 *  
	 * @return
	 */
	List<Courier> findByDeltagIsNotZreo();

}
  
