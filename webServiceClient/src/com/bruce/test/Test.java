package com.bruce.test;

import java.rmi.RemoteException;

import com.bruce.model.xsd.User;
import com.bruce.service.GetUsers;
import com.bruce.service.GetUsersResponse;
import com.bruce.service.UserServiceStub;

public class Test {

	/**
	 * @param args
	 * @throws RemoteException
	 */
	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub

		UserServiceStub userServiceStub = new UserServiceStub(
				"http://localhost:8080/axis2/services/userService?wsdl");

		GetUsers getUsers = new GetUsers();
		GetUsersResponse getUsersResponse = userServiceStub.getUsers(getUsers);

		User[] users = getUsersResponse.get_return();

		for (User u : users) {
			System.out
					.println("id:" + u.getId() + ";name:" + u.getUsername()
							+ ";gender:" + u.getGender() + ";address:"
							+ u.getAddress());
			
		}
	}
}
