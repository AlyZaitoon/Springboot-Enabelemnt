package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.UserDao;
import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;


@Service("userService")
@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	@Override
	public void create(UserModel user) {
		userDao.create(user);

	}

	@Override
	public void update(UserModel user) {
		userDao.update(user);

	}

	@Override
	public UserModel edit(Long userId) {
		
		return userDao.edit(userId);
	}

	@Override
	public void delete(Long userId) {
		userDao.delete(userId);

	}

	@Override
	public UserModel find(Long userId) {
		
		return userDao.find(userId);
	}

	@Override
	public List<UserModel> getAll() {
		
		return userDao.getAll();
	}

}
