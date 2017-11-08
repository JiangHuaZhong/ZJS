package com.jianghua.crm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.jianghua.crm.domain.Customer;

/**  
 * ClassName:CustomerRepository <br/>  
 * Function:  <br/>  
 * Date:     Nov 5, 2017 10:54:49 AM <br/>       
 */
public interface CustomerRepository extends JpaRepository<Customer, Long>{

	List<Customer> findByFixedAreaIdIsNull();
	
	List<Customer> findByFixedAreaId(String fixedAreaId);
	
	@Modifying
	@Query("update Customer set fixedAreaId = null where fixedAreaId = ?")
	void findByIdSetNull(String fixedAreaId);
	
	@Modifying
	@Query("update Customer set fixedAreaId = ? where id = ?")
	void updateById2FixedArea(String fixedAreaId,Long id);
	
}
  
