/**
 * @filename ${name}ServiceImpl.java
 * @directory /src/main/java/com/gwxa/${packagename}/${output}/service/impl
 * @package com.gwxa.${packagename}.${output}.service
 * @description ${description!'[TODO]'}
 * @author ${author}
 * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
 * @version v0.1
 */
package com.gwxa.${packagename}.${output}.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gwxa.framework.util.Paramater;
import com.gwxa.framework.base.BaseMapper;
import com.gwxa.framework.base.BaseServiceImpl;
import com.gwxa.framework.util.WhereSqlUtil;
import com.gwxa.${packagename}.${output}.mapper.${name}Mapper;
import com.gwxa.${packagename}.${output}.pojo.${name};
import com.gwxa.${packagename}.${output}.service.I${name}Service;

/**
 * @author ${author}
 */
@Service
public class ${name}ServiceImpl extends BaseServiceImpl<${name}> implements I${name}Service {
	
	@Autowired
	private ${name}Mapper ${name?lower_case}Mapper;
	
	
	@Override
	public String bulidWhereSql(Paramater para) {
		return new WhereSqlUtil("where bianh >0 ",null, para)
				<#list columns as item>
				.whereLike("${item.name?lower_case}") //${item.comments}
				</#list>
				.getWhereSql();
	}
	
	@Override
	protected BaseMapper<${name}> getDao() {
		return ${name?lower_case}Mapper;
	}

}
