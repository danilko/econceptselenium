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
 * @author Kai -Ting(Danil) Ko
 * class BaseProperty
 * BaseProperty class for loading properties
 */

package com.econcept.selenium.property;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileProertyImpl extends BaseProperty
{
	/**
	 * Empty constructor
	 */
	 public FileProertyImpl()
	 {
		 super();
	 }  // FilePropertyImpl
	 
	@Override
	public void loadProperties() throws Exception
	{
		// Terminate if teh source is null
		if(mPropertySource == null)
		{
			throw new Exception("Property source is null, the operation cannot be continued");
		}  // if

		BufferedReader lReader = null;

		try {
			lReader = new BufferedReader(new FileReader(new File(
					mPropertySource)));

			String lLine = lReader.readLine();

			while (lLine != null) {
				
				
				// Split the line into property name and property value
				String[] lProperty = lLine.split("=");
				
				
				// Only process valid property
				if(lProperty.length == 2)
				{
					// Cut down the white space, and set the property
					setProperty(lProperty[0].trim(), lProperty[1].trim());
				}  // if
				
				// Read next line
				lLine = lReader.readLine();
			} // while
		} // try
		catch (IOException pException) {
			pException.printStackTrace();
			throw new Exception(pException);
		} // catch

		if (lReader != null) {
			// Close the reader to free resources
			lReader.close();
		} // if
	}  // loadProperties
}  // FileProertyImpl
