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

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Driver for setting up firefox driver as the driver for testing
 *
 */
public class FirefoxImplDriver extends BaseDriver
{
	
	private String mHubURL;
	
	/**
	 * Empty constructor 
	 */
	public FirefoxImplDriver() 
	{
		super();
	}  // ChromeDriver
	
	/**
	 * Get the hub URL for the Firefox Driver
	 * @return String The hub url to be employed
	 */
	public String getmHubURL() 
	{
		return mHubURL;
	}  // String getmHubURL

	/**
	 * Set the hub URL for the Firefox Driver
	 * @param pHubURL The hub url to be employed
	 */
	public void setmHubURL(String pHubURL) {
		mHubURL = pHubURL;
	}  // void setmHubURL

	@Override
	public void setup() throws Exception 
	{
    	// Connect to Selenium Grid
    	// Assign the test
    	DesiredCapabilities lCapability = DesiredCapabilities.firefox();
    	
    	// Connect webdriver with the test
    	try {
			mDriver = new RemoteWebDriver(new URL(mHubURL), lCapability);
		}  // try 
    	catch (MalformedURLException pException) 
		{
    		mDriver = null;
			throw pException;
		}  // catch
	}  // setup

	@Override
	public void cleanUp() 
	{
		mDriver.quit();
	} // void cleanUp() 
}  // class FirefoxImplDriver
