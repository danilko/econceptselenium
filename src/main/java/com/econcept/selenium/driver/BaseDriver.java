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

package com.econcept.selenium.driver;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

import com.econcept.selenium.method.BaseMethod;

public abstract class BaseDriver 
{
	protected WebDriver mDriver;
	private boolean mDebug;
	private String mInitialURL;
	private ArrayList <BaseMethod> mMethods;
	
	/**
	 * The constructor for setting the driver to be employed for testing
	 */
	BaseDriver()
	{
		mDebug=false;
		mMethods = null;
	}  // BaseDriver
	
	/**
	 * Get current debug setting
	 * @return True debug is on, false if debug if off
	 */
	public boolean getDebug()
	{
		return mDebug;
	}  // boolean getDebug
	
	/**
	 * Set debug mode to perform operation on
	 * @param pDriver WebDriver to be inputed
	 */
	public void setDebug(boolean pDebug)
	{
		mDebug = pDebug;
	}  // void setDebug
	
	/**
	 * Setup for current driver
	 * @return 
	 */
	public abstract void setup() throws Exception ;
	
	/**
	 * Set the initial URL that is currently used
	 * @param pInitialURL String the initial URL
	 */
	public void setInitialURL(String pInitialURL)
	{
		mInitialURL = pInitialURL;
	}  // void setInitialURL
	
	/**
	 * Get the initial URL that is currently used
	 * @return String the initial URL
	 */
	public String getInitialURL()
	{
		return mInitialURL;
	}  // String setInitialURL
	
	/**
	 * Set the array of methods to be executed
	 * @param pTestMethods The array list of methods to be executed
	 */
	public void setMethods(ArrayList<BaseMethod> pTestMethods)
	{
		mMethods = pTestMethods;
	}  // void setMethod
	
	/**
	 * Get the array of methods to be executed
	 * @return  ArrayList <BaseMethod> The array list of methods to be executed
	 */
	public ArrayList <BaseMethod> getMethods()
	{
		return mMethods;
	}  //  ArrayList <BaseMethod>getMethods
	
	
	/**
	 * Activate driver to execute current methods
	 * @throws Exception Exception when one of methods is null
	 */
	public void activate() throws Exception
	{
		// Do not do anything if the driver is null
		if(mDriver == null || mMethods == null)
		{
			return;
		}  // if
		
		
    	mDriver.get(mInitialURL);

	    for(BaseMethod lMethod : mMethods)
	    {
	    	if(lMethod != null)
	    	{
	    		lMethod.setDriver(mDriver);
	    		lMethod.setDebug(mDebug);
	    		lMethod.activate();
	    	}  // if
	    }  // for
	}  // void activate
	
	/**
	 * Clean up web driver and other settings
	 */
	public abstract void cleanUp();
	
	/**
	 * Clean up the driver
	 */
	protected void DriverCleanUp()
	{
		mDriver.quit();
	}  // void DriverCleanUp
}  // class BaseDriver 
