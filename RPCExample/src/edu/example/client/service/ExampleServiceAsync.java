package edu.example.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ExampleServiceAsync 
{
	void sayHello(String name, AsyncCallback callback);
	
	void addTwonumbers(int num1, int num2, AsyncCallback callback);
	void getOpList(AsyncCallback callback);
}