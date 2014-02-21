/**
 * 
 * The MIT License (MIT)
 * 
 * Copyright (c) 2013 @author Kai-Ting (Danil) Ko
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
 * class Login
 * Auto login method through Gmail Web Interface
 */
package com.econcept.selenium.method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class Login extends BaseMethod
{
	private String mLoginUsername;
	private String mLoginPassword;
	
	public Login() 
	{
		super();
	}  // Login

	/**
	 * The login username
	 * @return String The login username
	 */
	public String getLoginUsername() {
		return mLoginUsername;
	}

	/**
	 * The login password
	 * @param pLoginUsername The login password
	 */
	public void setLoginUsername(String pLoginUsername) 
	{
		mLoginUsername = pLoginUsername;
	}  //  void setLoginUsername

	/**
	 * The login password
	 * @return String The login password
	 */
	public String getLoginPassword() 
	{
		return mLoginUsername;
	}  // String getLoginPassword

	/**
	 * The login password
	 * @param pLoginUsername The login password
	 */
	public void setLoginPssword(String pLoginPssword) {
		mLoginPassword = pLoginPssword;
	}  // void setLoginPssword
	
	public void activate() throws Exception
	{
		// If not even valid, return
		if(!isValid())
		{
			return;
		}  // if
		
		try
		{
			WebElement lInput = mDriver.findElement(By.id("Email"));
			lInput.sendKeys(mLoginUsername);
	    
			lInput = mDriver.findElement(By.id("Passwd"));
			lInput.sendKeys(mLoginPassword);
	    
			// Set debug point
			debugPoint("Check login menu");
	    
			lInput =  mDriver.findElement(By.id("signIn"));
			lInput.click();
		}  // try
		catch(Exception pException)
		{
			pException.printStackTrace();
			throw new Exception(pException);
		}  // catch
	}  // void activate

	@Override
	public void debug() 
	{
		super.debug();
		System.out.println("LoginUsername=" + mLoginUsername);
		System.out.println("LoginPassword=" + mLoginPassword);
	}  // void debug
}  // class Login
