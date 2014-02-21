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
 * class BaseProperty
 * BaseProperty class for loading properties
 */

package com.econcept.selenium.property;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseProperty 
{
	public final static String DEBUG="DEBUG";
	public final static String CHROME_EXECUTABLE_PATH="CHROME_EXECUTABLE_PATH";
	public final static String INITIAL_URL = "INITIAL_URL";

	public final static String LOGIN_USERNAME="LOGIN_USERNAME";
	public final static String LOGIN_PASSWORD="LOGIN_PASSWORD";

	public final static String TIMEOUT="TIMEOUT";
	
	private Map <String, String> mMap;
	protected String mPropertySource;
	
	/**
	 * Constructor to initialize variables
	 */
	public BaseProperty()
	{
		mMap = new HashMap<String, String>();
	}  // BaseProperty
	
	/**
	 * Get the property value assoicate with the property name
	 * @param pPropertyName The property name to be setting
	 * @return String The property value associates with the property name
	 */
	public String getProperty(String pPropertyName)
	{
		return mMap.get(pPropertyName);
	}  // String getProperty
	
	/**
	 * Set the property
	 * @param pPropertyName The property name to be setting
	 * @param pPropertyValue The property value to be setting
	 */
	public void setProperty(String pPropertyName, String pPropertyValue)
	{
		mMap.put(pPropertyName, pPropertyValue);
	}  // void setProperty
	
	/**
	 * Clear all properties
	 */
	public void clearAll()
	{
		mMap.clear();
	}  // void setProperty
	
	/**
	 * Get the property source
	 * @return String The property source
	 */
	public String getPropertySource(String pPropertySource)
	{
		return mPropertySource;
	}  // String getPropertySource
	
	/**
	 * Set the property source
	 * @param pPropertySource String The property source to be setting
	 */
	public void setPropertySource(String pPropertySource)
	{
		mPropertySource = pPropertySource;
	}  // void setPropertySource
	
	
	/**
	 * Load properties from source
	 * @throws Exception Excpetion in loading properties
	 */
	public abstract void loadProperties() throws Exception;
	
	/**
	 * List all available properties
	 */
	public void debug()
	{
		System.out.println("Current avialble properties:");
		for(String lKey : mMap.keySet())
		 {
			System.out.println(lKey + "=" + mMap.get(lKey));
		 }  // while
	}  // void debug
}  // BaseProperty
