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
 * class BaseMethod
 * BaseMethod class for operation
 */

package com.econcept.selenium.method;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.openqa.selenium.WebDriver;

public abstract class BaseMethod {
	protected WebDriver mDriver;

	protected boolean mDebug;
	
	protected int mTimeOut;
	
	/**
	 * Constructor
	 */
	public BaseMethod()
	{
		mDriver=null;
		mDebug=true;
		// Set default to 120 seconds
		mTimeOut=120;
	}  // BaseMethod
	
	/**
	 * Get current debug seeting
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
	 * Get the timeout
	 * @return int pTimeOut The timeout in integer
	 */
	public int getTimeOut() 
	{
		return mTimeOut;
	}  // void setTimeOut
	
	/**
	 * Set the timeout
	 * @param int pTimeOut The timeout in integer
	 */
	public void setTimeOut(int pTimeOut) 
	{
		mTimeOut = pTimeOut;
	}  // void setTimeOut

	/**
	 * Show debug info
	 */
	public void debug()
	{
		System.out.println("Current Property settings");
		System.out.println("Debug=" + mDebug);
		System.out.println("TimeOut=" + mTimeOut + " Seconds");
	}  // void debug
	
	/**
	 * Pause the current thread for operation
	 * @pMessage String message to explain about particular debug point
	 */
	public void debugPoint(String pMessage)
	{
		if(mDebug)
		{
			try {
				System.out.println("[DEBUG " + System.currentTimeMillis() + "]: Debug point for: " + pMessage);
				System.out.println("[DEBUG " + System.currentTimeMillis() + "]: Please press enter to continue...");
				BufferedReader lBufferedReader = new BufferedReader(new InputStreamReader(System.in));
				lBufferedReader.readLine();
			} catch (IOException pException) {
				pException.printStackTrace();
			} // catch
		}  // if
	}  // void debugPoint
	
	
	
	/**
	 * Get current employed webdriver
	 * @return WebDriver The current employed webdriver
	 */
	public WebDriver getDriver()
	{
		return mDriver;
	}  // getDriver
	
	/**
	 * Set webdriver to perform operation on
	 * @param pDriver WebDriver to be inputed
	 */
	public void setDriver(WebDriver pDriver)
	{
		mDriver = pDriver;
	}  // BaseMethod
	
	/**
	 * Set webdriver to perform operation on
	 * @param Boolean Indicate whether the webdriver is valid
	 */
	public boolean isValid()
	{
		// Currently only check whether it is null or not
		if(mDriver != null)
		{
			return true;
		}  // if
		
		return false;
	}  // BaseMethod
	
	/**
	 * Invoke operation to perform with inputed webdriver
	 */
	public abstract void activate() throws Exception;
	
	
}  // class BaseMethod
