package com.mbition.devops.DevOpsCodeChallenge;

import org.junit.jupiter.api.Test;

import com.rest.controller.UserListController;

public class UserListControllerTest {

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
