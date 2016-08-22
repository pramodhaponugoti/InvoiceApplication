package com.exp;

@SuppressWarnings("serial")
public class ServicessException  extends Exception{
	public ServicessException(){
		
	}
	public ServicessException(String expMsg){
		System.out.println(expMsg);
	}

}
