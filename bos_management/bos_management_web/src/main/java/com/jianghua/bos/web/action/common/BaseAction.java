package com.jianghua.bos.web.action.common;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.data.domain.Page;

import com.jianghua.bos.domain.base.Area;
import com.jianghua.bos.domain.base.Standard;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**  
 * ClassName:BaseAction <br/>  
 * Function:  <br/>  
 * Date:     Nov 3, 2017 12:38:51 PM <br/>       
 */
public class BaseAction<T> extends ActionSupport implements ModelDriven<T>{

	public BaseAction(){
		
		//获取子类的字节码,如:获得了AreaAction的字节码
		Class<? extends BaseAction> childClass = this.getClass();
		
		//获取父类的类型,获取到了BaseAction<Area>
		Type genericSuperclass = childClass.getGenericSuperclass();
		//进行类型转换
		ParameterizedType parameterizedType = (ParameterizedType)genericSuperclass;
		//获取类型上声明的泛型组成的数组
		Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
		//获取数组中的第一个泛型
		Class realClass = (Class) actualTypeArguments[0];
		try {
			model = (T)realClass.newInstance();
		} catch (Exception e) {
			e.printStackTrace();  
		}
				
	}
	
	protected T model;
	
	@Override
	public T getModel() {
		return model;
	}

	// 自己封装页面传过来的当前页面和一页显示多少行
	// page和rows用别人的框架,必须这样命名
	public int page;
	public int rows;
	
	
	public void setPage(int page) {
		this.page = page;
	}


	public void setRows(int rows) {
		this.rows = rows;
	}
	
	public void page2json(Page<T> page , String[] excludes) throws IOException{
		
		
		// 要把数据转化为json格式
		// 当前页显示的数据
		List<T> rows = page.getContent();
		// 数据总条数
		long total = page.getTotalElements();
		// 自己手动封装符合EasyUI要求的数据
		Map<String, Object> map = new HashMap<String, Object>();
		// 封装数据条数
		map.put("total", total);
		// 当前页显示的数据
		map.put("rows", rows);
		// 把对象转化成json数据
		// JSONObject
		// 把list集合对象转化成json数据
		// JSONArray
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(excludes);
		// 转化数据为json
		String json = JSONObject.fromObject(map,jsonConfig).toString();
		// 获取输出流
		HttpServletResponse response = ServletActionContext.getResponse();
		// 设置字符和类型
		response.setContentType("application/json;charset=UTF-8");
		// 写出数据
		response.getWriter().write(json);
		
	}
	
	/**
	 * 
	 * list2json:. <br/>  
	 *  
	 * @param excludes 忽略的字段
	 * @throws IOException
	 */
	public void List2json(List list, String[] excludes) throws IOException{
		
		JsonConfig jsonConfig = new JsonConfig();
		
		jsonConfig.setExcludes(excludes);
		String json = JSONArray.fromObject(list,jsonConfig).toString();
		System.out.println(json);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().write(json);
		
	}
	
}
  
