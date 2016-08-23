package com.exp;

@SuppressWarnings("serial")
public class DataSourceException  extends Exception{
	public DataSourceException(){
		
	}
	public DataSourceException(String expMsg){
		System.out.println(expMsg);
	}

	
}
