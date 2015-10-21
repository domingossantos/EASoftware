/**
 * 
 */
package br.ufpa.easw;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * UsersResourceBundle.java 
 * 
 * <p>A example of a class the use a static method</p>
 * 
 * Based on post of roger.hughes at
 * http://www.javacodegeeks.com/2011/11/mock-static-methods-with-powermock.html
 * 
 * <p><i>This program is distributed without any warranty and it
 * can be freely redistributed for research, classes or private studies, 
 * since the copyright notices are not removed.</i></p>
 */
public class UsesResourceBundle {
	
	/*A class with static methods */
	private ResourceBundle bundle;
	
	public String getResourceString(String key) {

		if ( bundle == null) {
			this.bundle = ResourceBundle
					.getBundle("SomeBundleName", Locale.ENGLISH);
		}

		return bundle.getString(key);
	}

}


