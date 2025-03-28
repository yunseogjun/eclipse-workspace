/**
 *
 */
package com.example.spring.myapp.model.mapper;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.spring.myapp.dto.EMPDTO;
import com.example.spring.myapp.dto.MENUDTO;

/**
 * @author CafeAlle
 *
 */

@Mapper
public interface TestTableMapper {
	//select * from Test_Table
	public List<EMPDTO> SelectAllList(String id) throws Exception;
	public EMPDTO SelectOne(String id) throws Exception;
	public List<MENUDTO> SelectMenuList() throws Exception;
	public int insert(EMPDTO empdto) throws Exception;
	public int update(EMPDTO empdto) throws Exception;

}
