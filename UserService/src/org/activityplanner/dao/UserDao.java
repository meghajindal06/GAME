package org.activityplanner.dao;

import org.activityplanner.entity.UserEntity;
@SuppressWarnings("rawtypes")
public interface UserDao {
	UserEntity createUser(UserEntity userEntity) throws UserAccountAlreadyExistException;

	UserEntity authenticateUser(String email, String password);

	
}
