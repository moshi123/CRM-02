package com.atguigu.crm.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.atguigu.crm.entitys.SalesChance;

public interface SalesChanceMapper {
	
	//删除机会信息
	@Select("DELETE FROM sales_chances WHERE id=#{id}")
	void delete(@Param("id")Integer id);
	
	
	//新增机会信息
	@Insert("INSERT INTO sales_chances(id, source, cust_name, rate, title, contact, contact_tel, description, created_user_id, create_date, status) "
			+ "VALUES(crm_seq.nextval, #{source}, #{custName}, #{rate}, #{title}, #{contact}, #{contactTel}, #{description}, #{createBy.id}, #{createDate}, 1)")
	void insert(SalesChance salesChance);
	
	//查找总记录数
	@Select("SELECT count(id) FROM sales_chances")
	long getTotalElements();
	
	//MySQL 分页使用 limit, Oracle 分页使用 rownum
		/*@Select("SELECT * FROM "
				+ "(SELECT rownum rn , id, cust_name, title, contact, contact_tel, create_date"
				+"FROM sales_chances "
				+"ORDER BY id) "
				+"WHERE rn >= #{firstIndex} AND rn < #{endIndex}")
	List<SalesChance> getContent(@Param("firstIndex") int firstIndex, @Param("endIndex") int endIndex);*/

	
		//获取所有机会管理信息
		@Select("SELECT * FROM "
				+ "(SELECT rownum rn, id, cust_name, title, contact, contact_tel, create_date "
				+ "FROM sales_chances "
				+ "ORDER BY id) "
				+ "WHERE rn >= #{firstIndex} AND rn < #{endIndex}")
		List<SalesChance> getContent(@Param("firstIndex") int firstIndex, @Param("endIndex") int endIndex);


		@Update("UPDATE sales_chances SET source = #{source}, cust_name = #{custName}, rate = #{rate}, title = #{title}, contact = #{contact}, contact_tel = #{contactTel}, description = #{description} "
				+ "WHERE id = #{id}")
		void update(SalesChance chance);


		@Select("SELECT s.id, source, cust_name, rate, title, contact, contact_tel, s.description, created_user_id as \"createBy.id\", u.name as \"createBy.name\", r.name as \"createBy.role.name\", create_date "
				+ "FROM sales_chances s "
				+ "LEFT OUTER JOIN users u "
				+ "ON s.created_user_id = u.id "
				+ "LEFT OUTER JOIN roles r "
				+ "ON u.role_id = r.id "
				+ "WHERE s.id = #{id}")
		SalesChance get(@Param("id") Integer id);
		



}
