package com.tests;

import com.actions.MyActions;

import junit.framework.TestCase;

public class MyTest extends TestCase {

	public void test()
	{
		MyActions actions=new MyActions();
		actions.setup();
		actions.openUrl("http://store.nike.com");
	}
}
