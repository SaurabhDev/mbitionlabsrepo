package com.mbition.devops.DevOpsCodeChallenge;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.rest.controller.*;

@SpringBootTest
class DevOpsCodeChallengeApplicationTests {
	
	UserListController testobj = new UserListController();
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void testUserList( ) {
		testobj.getUsers();
	}

}
