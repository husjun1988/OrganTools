/**
 * @filename ${name}.java
 * @directory /src/com/gwxa/model
 * @package com.gwxa.model
 * @description ${description!'[TODO]'}
 * @author ${author}
 * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
 * @version v1.0
 */
package com.gwxa.model;

import com.gwxa.base.support.AbstractModel;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * @author ${author}
 */
public class ${name} extends AbstractModel{

	private static final long serialVersionUID = 1L;

	private static final String tablename = "${table}";

<#list columns as item>
	<#if item.name?lower_case != "bianh" && item.name?lower_case != "chuangjsj" && item.name?lower_case != "chuangjyh" && item.name?lower_case != "xiugsj" && item.name?lower_case != "xiugyh" && item.name?lower_case != "banbh">
	/** ${item.comments} */
	<#if item.type == "Date">
	@JSONField(format = "yyyy-MM-dd hh:mm:ss")
	</#if>
	private ${item.type} ${item.name?lower_case};
	</#if>
</#list>

<#list columns as item>

	<#if item.name?lower_case != "bianh" && item.name?lower_case != "chuangjsj" && item.name?lower_case != "chuangjyh" && item.name?lower_case != "xiugsj" && item.name?lower_case != "xiugyh" && item.name?lower_case != "banbh">
	/**
	 * 获取[${item.comments}]
	 */
	public ${item.type} get${item.name?lower_case?cap_first}() {
		return ${item.name?lower_case};
	}
	/**
	 * 设置[${item.comments}]
	 */
	public void set${item.name?lower_case?cap_first}(${item.type} ${item.name?lower_case}) {
		this.${item.name?lower_case} = ${item.name?lower_case};
	}
	</#if>
</#list>

}
