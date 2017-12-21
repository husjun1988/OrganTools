/**
 * @filename ${name}Controller.java
 * @directory /src/main/java/com/gwxa/${packagename}/${output}/controller
 * @package com.gwxa.${packagename}.${output}
 * @description ${description!'[TODO]'}
 * @author ${author}
 * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
 * @version v0.1
 */
package com.gwxa.${packagename}.${output}.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import com.gwxa.framework.base.BaseController;
import com.gwxa.${packagename}.${output}.pojo.${name};
import com.gwxa.framework.base.IBaseService;
import com.gwxa.${packagename}.${output}.service.I${name}Service;

/**
 * @author ${author}
 * ${description!'[TODO]'}
 */
@Controller
@RequestMapping("/${packagename}/")
public class ${name}Controller extends BaseController<${name}>{

	@Autowired
	private I${name}Service ${name?lower_case}ServiceImpl;//${description!'[TODO]'} 逻辑实现接口

	@Override
	protected IBaseService<${name}> getService() {
		return ${name?lower_case}ServiceImpl;
	}

	@ResponseBody
	@RequestMapping("${name?lower_case}_find")
	public void findByBh() {
		super.findByBh();
	}
	
	@ResponseBody
	@RequestMapping("${name?lower_case}_search")
	public void search() {
		super.search();
	}
	
	@ResponseBody
	@RequestMapping("${name?lower_case}_save")
	public void add(${name} ${name?lower_case}) {
		super.save(${name?lower_case});
	}
	
	@ResponseBody
	@RequestMapping("${name?lower_case}_editsave")
	public void edit(${name} ${name?lower_case}) {
		super.editsave(${name?lower_case});
	}
	
	@ResponseBody
	@RequestMapping("${name?lower_case}_del")
	public void del() {
		super.del();
	}
	
	@RequestMapping("${name?lower_case}_index")
	public ModelAndView index() {
		return super.index();
	}
	
	@RequestMapping("${name?lower_case}_add")
	public ModelAndView add() {
		return super.add();
	}
	
	@RequestMapping("${name?lower_case}_edit")
	public ModelAndView edit() {
		return super.edit();
	}

}
