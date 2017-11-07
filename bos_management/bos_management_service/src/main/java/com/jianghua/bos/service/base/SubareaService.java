package com.jianghua.bos.service.base;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jianghua.bos.domain.base.SubArea;

/**  
 * ClassName:SubareaService <br/>  
 * Function:  <br/>  
 * Date:     Nov 3, 2017 9:39:30 PM <br/>       
 */
public interface SubareaService {

	void save(SubArea model);

	Page<SubArea> pageQuery(Pageable pageable);

	List<SubArea> findAll();


}
  
