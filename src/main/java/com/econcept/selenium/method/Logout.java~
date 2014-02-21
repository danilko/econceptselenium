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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author Kai-Ting (Danil) Ko
 * The method for logout
 * 
 */

public class Logout extends BaseMethod
{
	/**
	 * Empty constructor
	 */
	public Logout() 
	{
		super();
	}  // Login

	@Override
	public void activate() throws Exception
	{
		// If not even valid, return
		if(!isValid())
		{
			return;
		}  // if
		
		try
		{
			String lXpathAction = "(//div[ ./a[starts-with(@class, 'gb_r gb_P gb_j identityWidgetIcon')]])[last()]";
			// Wait until element is visbile for 120 seconds
			WebDriverWait lWait = new WebDriverWait(mDriver, mTimeOut);
			Thread.sleep(WebDriverWait.DEFAULT_SLEEP_TIMEOUT);
			WebElement lElement = lWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lXpathAction)));
			lElement.click();

 lXpathAction = "(//div[ ./a[starts-with(@href, '?logout&')]])[last()]";

			Thread.sleep(WebDriverWait.DEFAULT_SLEEP_TIMEOUT);
			lElement = lWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lXpathAction)));
			lElement.click();
		}  // try
		catch(Exception pException)
		{
			pException.printStackTrace();
			throw new Exception(pException);
		}  // catch
	}  // void activate
}  // class Login
