package com.jianghua.bos.dao.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jianghua.bos.dao.base.StandarRepository;
import com.jianghua.bos.domain.base.Standard;

/**  
 * ClassName:StandarRepositoryTest <br/>  
 * Function:  <br/>  
 * Date:     Oct 31, 2017 10:37:02 AM <br/>       
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class StandarRepositoryTest {
	
	@Autowired
	private StandarRepository standarRepository;
	
	@Test
	public void save(){
		
		Standard standard = new Standard();
		standard.setMaxLength(300);
		standarRepository.save(standard);
		
	}
	@Test
	public void update(){
		
		Standard standard = standarRepository.findOne(4L);
		standard.setName("赵六");
		standarRepository.save(standard);
		
	}
	@Test
	public void delete(){
		
		standarRepository.delete(1L);
		
	}
	@Test
	public void findAll(){
		
		List<Standard> standards = standarRepository.findAll();
		for (Standard standard : standards) {
			
			System.out.println(standard);
		}
		
	}
	@Test
	public void finBy(){
		
		List<Standard> list = standarRepository.findByName("张三");
		for (Standard standard : list) {
			System.out.println(standard);
		}
		
	}
	@Test
	public void finByNamexxx(){
		
		List<Standard> list = standarRepository.findByNamexxx("李四");
		for (Standard standard : list) {
			System.out.println(standard);
		}
		
	}
	@Test
	public void finByNameAndMaxLength(){
		
		Standard standard = standarRepository.findByNameAndMaxLength("张三",50);
		System.out.println(standard);
		
	}
	@Test
	public void finByNameAndMaxLengthxxx(){
		
		Standard standard = standarRepository.findByNameAndMaxLengthxxx("张三",50);
		System.out.println(standard);
		
	}
	@Test
	public void finByMaxLengthAndNamexxx(){
		
		Standard standard = standarRepository.findByMaxLengthAndNamexxx(50,"张三");
		System.out.println(standard);
		
	}
	@Test
	public void finByNameLike(){
		
		Standard standard = standarRepository.findByNameLike("%三%");
		System.out.println(standard);
	}
	@Test
	public void deleteByName(){
			
		standarRepository.deleteByName("张三");
	}
	@Test
	public void updateByName(){
		
		standarRepository.updateByName(500, "李四");
	}
}
  
