package com.jianghua.bos.web.action.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import com.jianghua.bos.domain.base.Area;
import com.jianghua.bos.service.base.AreaService;
import com.jianghua.bos.utils.PinYin4jUtils;
import com.jianghua.bos.web.action.common.BaseAction;


/**  
 * ClassName:AreaAction <br/>  
 * Function:  <br/>  
 * Date:     Nov 2, 2017 8:50:24 PM <br/>       
 */
@Namespace("/")
@ParentPackage("struts-default")
@Controller
@Scope("prototype")
public class AreaAction extends BaseAction<Area>{

	
	private String q;
	
	public void setQ(String q) {
		this.q = q;
	}
	
	private File file;
	public void setFile(File file) {
		this.file = file;
	}
	
	@Autowired
	private AreaService areaService;
	
	
	//导入文件
	@Action(value="areaAction_importXLS",
			results={@Result(name="success",type="redirect",location="/pages/base/area.html")})
	public String importXLS() throws Exception{
		//加载文件
		HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(file));
		//获取东一个工作簿的数据
		HSSFSheet sheet = workbook.getSheetAt(0);
		
		// 用来存储区域数据
        // 如果一条条的插入数据库,性能太低,所以将数据存入集合,一次性存储
		List<Area> list = new ArrayList<Area>();
		
		//遍历工作簿的每一行
		for (Row row : sheet) {
			//第一行不需要
			if(row.getRowNum() == 0){
				continue;
			}
			//获取每一列省份,城市,城区,邮编
			String province = row.getCell(1).getStringCellValue();
			String city = row.getCell(2).getStringCellValue();
			String district = row.getCell(3).getStringCellValue();
			String postcode = row.getCell(4).getStringCellValue();
			
			//处理把汉字变成拼音,首字母拼接,需要把最后一位省,市,区去掉
			province = province.substring(0,province.length()-1);
			city = city.substring(0,city.length()-1);
			district = district.substring(0,district.length()-1);
			
			String citycode = PinYin4jUtils.hanziToPinyin(city, "").toUpperCase();
			String[] headByString = PinYin4jUtils.getHeadByString(province+city+district,true);
			
			String shortcode = StringUtils.join(headByString);
			
			Area area = new Area(province,city,district,postcode,citycode,shortcode);
			list.add(area);
		}
		
		areaService.save(list);
		
		workbook.close();
		return SUCCESS;
	}
	
	@Action("areaAction_pageQuery")
	public String pageQuery() throws IOException{
		
		Pageable pageable = new PageRequest(page-1, rows);
		Page<Area> page = areaService.pageQuery(pageable);
		
		page2json(page, new String[]{"subareas"});
		
		
		return NONE;
	}
	
	@Action("areaAction_findAll")
	public String findAll() throws IOException{
		List<Area> list;
		if(StringUtils.isEmpty(q)){
			list = areaService.findAll();
		}else {
			list = areaService.findByQ(q);
		}
		
		List2json(list, new String[]{"subareas"});
		
		
		return NONE;
	}
	
	
	
}
  
