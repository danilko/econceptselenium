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

import java.io.File;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Driver for setting up chrome driver as the driver for testing
 *
 */
public class ChromeImplDriver extends BaseDriver
{
	private ChromeDriverService mService;
	
	private String mExecutablePath;
	
	/**
	 * Empty constructor 
	 */
	public ChromeImplDriver() 
	{
		super();
		mService = null;
	}  // ChromeDriver

	/**
	 * Set the Chrome Driver Executable path
	 * @param pPath String Chrome Driver path that will be used
	 */
	public void setChromeDriverExecutablePath(String pPath)
	{
		mExecutablePath = pPath;
	}  // void setChromeDriverExecutable
	
	/**
	 * Get the Chrome Driver Executable path
	 * @return String Chrome Driver path that is currently used
	 */
	public String getChromeDriverExecutablePath()
	{
		return mExecutablePath;
	}  // void setChromeDriverExecutable
	
	@Override
	public void setup() throws Exception 
	{
		// Create service out of builder
		mService = new ChromeDriverService.Builder()
        .usingDriverExecutable(new File(mExecutablePath))
        .usingAnyFreePort()
        .build();
	
		// If there is problem within service, terminate the program
	    try 
	    {
			mService.start();
			mDriver = new RemoteWebDriver(mService.getUrl(),
		            DesiredCapabilities.chrome());
		} // try
	    catch (Exception pExcetpion) 
		{
	    	mDriver = null;
			pExcetpion.printStackTrace();
			
			throw pExcetpion;
		}  // catch
	}  // setup

	@Override
	public void cleanUp() {
		DriverCleanUp();
		
		if(mService != null)
		{
			mService.stop();
		}  // if
	}  // void cleanUp
}  // class ChromeImplDriver
