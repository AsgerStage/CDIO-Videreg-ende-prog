package edu.example.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.example.client.service.ExampleService;

public class ExampleServiceImpl extends RemoteServiceServlet implements ExampleService
{
	@Override
	public String sayHello(String name) {
		return "Hello " + name;
	}

	@Override
	public int addTwonumbers(int num1, int num2) {
		return num1 + num2;
	}
}