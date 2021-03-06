/**
 * 
 * The MIT License (MIT)
 * 
 * Copyright (c) 2013 Kai-Ting (Danil) Ko
 * 
 * Permission is hereby granted, free of charge, 
 * to any person obtaining a copy of this software 
 * and associated documentation files (the "Software"), 
 * to deal in the Software without restriction, including 
 * without limitation the rights to use, copy, modify, 
 * merge, publish, distribute, sublicense, and/or sell 
 * copies of the Software, and to permit persons to whom 
 * the Software is furnished to do so, subject to the 
 * following conditions:
 * 
 * The above copyright notice and this permission notice 
 * shall be included in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY 
 * OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED 
 * TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR 
 * PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS 
 * OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER 
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, 
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE 
 * USE OR OTHER DEALINGS IN THE SOFTWARE.
 * 
 */

/**
 * 
 * @author Kai-Ting (Danil) Ko
 * 
 * class EndToEndTest 
 * Perform end to end test
 */


package com.econcept.selenium;

import java.util.ArrayList;

import junit.framework.Assert;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.econcept.selenium.driver.BaseDriver;
import com.econcept.selenium.driver.ChromeImplDriver;
import com.econcept.selenium.method.BaseMethod;
import com.econcept.selenium.method.Login;
import com.econcept.selenium.method.Logout;
import com.econcept.selenium.property.BaseProperty;
import com.econcept.selenium.property.FileProertyImpl;

public class EndToEndTest 
{
	private BaseDriver mDriver;
	private BaseProperty mProperty;
	private ArrayList <BaseMethod> mTestMethods;
	
	@BeforeTest(alwaysRun=true)
	public void initialzeSuite()
	{
		mProperty = new FileProertyImpl();
		
		mProperty.setPropertySource(ClassLoader.getSystemResource("application.properties").getFile());
		
		try 
		{
			mProperty.loadProperties();
		}  // try 
		catch (Exception pException) 
		{
			Assert.fail(pException.toString());
		}  // catch
		
		// Create methods
		mTestMethods = new ArrayList<BaseMethod>();
		
		 // Print out debug message
		mProperty.debug();
		
		mDriver = new ChromeImplDriver();
		try 
		{
			// Set Chrome driver executable
			((ChromeImplDriver)mDriver).setChromeDriverExecutablePath(mProperty.getProperty(BaseProperty.CHROME_EXECUTABLE_PATH));
			mDriver.setInitialURL(mProperty.getProperty(BaseProperty.INITIAL_URL));
			
			mDriver.setup();
			
		} //try
		catch (Exception pException) {
			Assert.fail(pException.toString());
		}  // catch
		
		// Add necessary methods
		addLogin();
		addDatabase();
		addJob();
		addLogout();
	}  // void initializeTest
	
	/**
	 * After suite clean up
	 */
	@AfterTest
	public void cleanUpTest()
	{
		mProperty.clearAll();
		mDriver.cleanUp();
	}  // void cleanUpTest
	
	/**
	 * Add login to test
	 */
	public void addLogin()
	{
		// Create new login method and add to list of test methods
		Login lLoginMethod = new Login();
		lLoginMethod.setLoginPssword(mProperty
				.getProperty(BaseProperty.LOGIN_PASSWORD));
		lLoginMethod.setLoginUsername(mProperty
				.getProperty(BaseProperty.LOGIN_USERNAME));
		lLoginMethod.setTimeOut(Integer.parseInt(mProperty
				.getProperty(BaseProperty.TIMEOUT)));

		// Printout all properties
		lLoginMethod.debug();

		// Add current methods to list of test method
		mTestMethods.add(lLoginMethod);

		mDriver.setMethods(mTestMethods);
	}  // void addLogin
	

	/**
	 * Add logout to test
	 */
	public void addLogout()
	{
	    // Create new logout method and add to list of test methods
		Logout lLogoutMethod = new Logout();
		
		// Printout all properties
		lLogoutMethod.debug();
		
		// Add logout method
		mTestMethods.add(lLogoutMethod);
	}  // void addLogout
	
	/**
	 * From login to create database, test database connection, delete connection, logout
	 */
	@Test
	public void testEndToEnd()
	{
		try 
		{
			mDriver.activate();
		}  // try 
		catch (Exception pException) 
		{
			Assert.fail(pException.toString());
		}  // catch
	}  // void testEndToEnd()
}  // class EndToEndTest 
