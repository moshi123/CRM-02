package com.atguigu.crm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atguigu.crm.entitys.User;
import com.atguigu.crm.mappers.UserMapper;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;
		@Transactional(readOnly=true)
		public User login(String name,String password){
			User user = userMapper.getByName(name);
			String k =user.getPassword();
			int u=user.getEnabled();
		
			if(user != null 
					&& u==1
					&& k.equals(password)
					){
				return user;
			}
			return null;
		}
}
