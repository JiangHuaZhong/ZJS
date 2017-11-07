package com.jianghua.bos.web.action.base;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;

import com.jianghua.bos.domain.base.Courier;
import com.jianghua.bos.domain.base.Standard;
import com.jianghua.bos.service.base.CourierService;
import com.jianghua.bos.web.action.common.BaseAction;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**  
 * ClassName:CourierAction <br/>  
 * Function:  <br/>  
 * Date:     Nov 1, 2017 9:35:03 AM <br/>       
 */
@Namespace("/")
@ParentPackage("struts-default")
@Controller
@Scope("prototype")
public class CourierAction extends BaseAction<Courier>{

	private static final long serialVersionUID = -5325935108057247463L;

	
	@Override
	public Courier getModel() {
		  
		return model;
	}
	
	
	private String ids;
	
	public void setIds(String ids) {
		this.ids = ids;
	}

	@Autowired
	private CourierService courierService;
	
	/**
	 * 
	 * save: 添加快递员
	 *  
	 * @return
	 */
	@Action(value = "courierAction_save",
			results = {@Result(type="redirect",name="success",location="/pages/base/courier.html")})
	public String save(){
		model.setDeltag('0');
		courierService.save(model);
		
		return SUCCESS;
		
	}
	
	/**
	 * 分页查询快递员信息
	 * pageQuery:. <br/>  
	 *  
	 * @return
	 * @throws IOException
	 */
	@Action("courierAction_pageQuery")
	public String pageQuery() throws IOException{
		
		//获取工号
		final String courierNum = model.getCourierNum();
		//获取收派标准
		final Standard standard = model.getStandard();
		//获取所属单位
		final String company = model.getCompany();
		//获取类型
		final String type = model.getType();
		//构造查询条件
		Specification<Courier> specification = new Specification<Courier>() {

			/**
	         * 用于构建where语句
	         * 
	         * @param root : 通常指实体类
	         * @param query : 查询对象
	         * @param cb : 构造查询条件的对象
	         * @return 组合查询条件
	         */
			@Override
			public Predicate toPredicate(Root<Courier> root,
					CriteriaQuery<?> query, CriteriaBuilder cb) {
				//这个集合用来装载多个查询条件
				List<Predicate> list = new ArrayList<Predicate>();
				//如果快递员编号不为空,构造等值查询
				if(StringUtils.isNotEmpty(courierNum)){
					Predicate p1 = cb.equal(root.get("courierNum").as(String.class), courierNum);
					list.add(p1);
				}
				//如果所属单位不为空,构造等值查询
				if (StringUtils.isNotEmpty(company)) {
					Predicate p2 = cb.equal(root.get("company").as(String.class), company);
					list.add(p2);
				}
				//如果类型不为空,构造等值查询
				if (StringUtils.isNotEmpty(type)) {
					Predicate p3 = cb.equal(root.get("type").as(String.class), type);
					list.add(p3);
				}
				//如果收派标准不为空,构造等值查询
				if (standard != null && StringUtils.isNotEmpty(standard.getName())) {
					//根据收派标准的名字进行级联查询
					Join<Object,Object> join = root.join("standard");
					Predicate p4 = cb.equal(join.get("name").as(String.class),standard.getName());
					list.add(p4);
				}
				//如果集合size为空,返回null
				if(list.size() == 0){
					return null;
				}
				//把集合转化成数组
				Predicate[] array = new Predicate[list.size()]; 
				list.toArray(array);
				//构造查询条件
				return cb.and(array);
			}
		};
		
		Pageable pageable = new PageRequest(page-1, rows);
		Page<Courier> page = courierService.pageQuery(specification,pageable);
		
		page2json(page, new String[] {"fixedAreas"});
			
		return NONE;
	}
	
	/**
	 * 批量删除快递员
	 * batchDel:. <br/>  
	 *  
	 * @return
	 */
	@Action(value="courierAction_batchDel",
			results={@Result(name="success",type="redirect",location="/pages/base/courier.html")})
	public String batchDel(){
		courierService.batchDel(ids);
		return SUCCESS;
	}
	
	/**
	 * 
	 * findAll:查询出所以的快递员
	 *  
	 * @return
	 * @throws IOException 
	 */
	@Action("courierAction_findAll")
	public String findAll() throws IOException{
		
		List<Courier> list = courierService.findByDeltagIsNotZreo();
		List2json(list, new String[] {"standard","fixedAreas"});
		
		return NONE;
	}
	
}
  
