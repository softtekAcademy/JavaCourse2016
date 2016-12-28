package com.softtek.jpa.services;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.softtek.jpa.domain.UserEntity;


@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( locations={"classpath:spring/application-context.xml"} )
public class UserServiceImplIt {

	@Autowired
	private UserService userService;
	
	@Test
	public void testFindAllUsers(){
		List<UserEntity> users = userService.findUsers();
		Assert.assertNotNull(users);
		Assert.assertEquals( 3 , users.size());
	}
	
	
}
