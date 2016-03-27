package com.atguigu.crm.mappers;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.atguigu.crm.entitys.User;

public interface UserMapper {
	@Select("SELECT u.name, password, u.enabled, r.name as \"role.name\" "
			+ "FROM users u "
			+ "LEFT OUTER JOIN roles r "
			+ "ON role_id = r.id "
			+ "WHERE u.name = #{name}")
	/*@Select("SELECT name , password  FROM users WHERE name = #{name}")*/
	User getByName(@Param("name") String name);
}
