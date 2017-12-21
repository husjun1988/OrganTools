/**
 * @filename ${name}Mapper.java
 * @directory /src/main/java/com/gwxa/${packagename}/${output}/mapper
 * @package com.gwxa.${packagename}.${output}.mapper
 * @description ${description!'[TODO]'}
 * @author ${author}
 * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
 * @version v0.1
 */
package com.gwxa.${packagename}.${output}.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.gwxa.framework.base.BaseMapper;
import com.gwxa.framework.util.Paramater;
import com.gwxa.${packagename}.${output}.pojo.${name};

/**
 * @author ${author}
 */
public interface ${name}Mapper extends BaseMapper<${name}>{

	/**
	 * 获取带编号数据
	 * @param Paramater 
	 * @return
	 */
	@Select("SELECT * FROM ${r'${tablename}'} WHERE BIANH = ${r'#{bh}'} ")
	public ${name} findByBh(Paramater para);
	
	/**
	 * 获取带KEY数据
	 * @param Paramater 
	 * @return
	 */
	@Select("SELECT * FROM ${r'${tablename}'}  ${r'${keys}'} ")
	public ${name} findByKeys(Paramater para);
	
	/**
	 * 获取数据列表
	 * @param Paramater 
	 * @return
	 */
	@Select("SELECT * FROM ${r'${tablename}'}   ${r'${wheresql}'}   ${r'${orderbysql}'} ")
	public List<${name}> selectPage(Paramater para);

	@Select("SELECT COUNT(1) FROM ${r'${tablename}'} ${r'${wheresql}'} ")
	public Integer selectCount(Paramater para);

	@Select("SELECT * FROM ${r'${tablename}'} ${r'${keys}'} ")
	public List<${name}> selectByKeys(Paramater para);

	@Delete("DELETE  FROM ${r'${tablename}'} WHERE BIANH IN (${r'${bhs}'}) ")
	public Integer deleteByBh(Paramater para);

	@Insert("INSERT INTO ${r'${tablename}'}  ${r'${insersql}'} ")
	@Options(useGeneratedKeys = true, keyProperty = "BIANH")  
	public Integer InsertByPojo(Paramater para);
	
	@Update("UPDATE ${r'${tablename}'} SET ${r'${updatesql}'} WHERE BIANH = ${r'#{para.bianh}'} ")
	public Integer updateByPojo(Paramater para);

}
