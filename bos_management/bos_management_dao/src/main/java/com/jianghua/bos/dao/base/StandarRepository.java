package com.jianghua.bos.dao.base;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.jianghua.bos.domain.base.Standard;

/**  
 * ClassName:StandarRepository <br/>  
 * Function:  <br/>  
 * Date:     Oct 31, 2017 10:57:20 AM <br/>       
 */
public interface StandarRepository extends JpaRepository<Standard, Long>{

	List<Standard> findByName(String name);
	
	@Query("from Standard where name = ?")
	List<Standard> findByNamexxx(String name);
	
	//多条件查询
	Standard findByNameAndMaxLength(String name,Integer maxLength);
	
	//自定义多条件查询
	@Query("from Standard where name = ? and maxLength = ?")
	Standard findByNameAndMaxLengthxxx(String name,Integer maxLength);
	//自定义多条件查询
	@Query("from Standard where name = ?2 and maxLength = ?1")
	Standard findByMaxLengthAndNamexxx(Integer maxLength,String name);
	
	//模糊查询
	Standard findByNameLike(String name);
	
	@Modifying //代表操作的是更新的操作
	@Transactional //开启事务注解
	@Query("delete from Standard where name = ?")
	void deleteByName(String name);
	
	@Modifying
	@Transactional
	@Query("update Standard set maxLength =? where name = ?")
	void updateByName(Integer maxLength ,String name);
	
}
  
