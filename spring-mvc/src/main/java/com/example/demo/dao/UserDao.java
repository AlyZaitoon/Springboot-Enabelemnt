package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.UserModel;

public interface UserDao {
	public void create(UserModel user);
	public void update(UserModel user);
	public UserModel edit(Long userId);
	public void delete(Long userId);
	public UserModel find(Long userId);
	public List<UserModel> getAll();
}
