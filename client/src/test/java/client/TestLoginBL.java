package client;

import java.rmi.RemoteException;

import businessLogic.loginBL.LoginBL;

public class TestLoginBL {
	private LoginBL loginBL;
	
	public void setUp() throws RemoteException{
		loginBL=new LoginBL();
	}

}
