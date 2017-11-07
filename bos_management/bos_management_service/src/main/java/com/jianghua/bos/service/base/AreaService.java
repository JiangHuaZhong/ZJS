package com.jianghua.bos.service.base;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jianghua.bos.domain.base.Area;

/**  
 * ClassName:AreaService <br/>  
 * Function:  <br/>  
 * Date:     Nov 2, 2017 10:10:55 PM <br/>       
 */
public interface AreaService {

	void save(List<Area> list);

	Page<Area> pageQuery(Pageable pageable);

	List<Area> findAll();

	List<Area> findByQ(String q);

}
  
