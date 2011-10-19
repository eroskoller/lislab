/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.utils.tipstricks;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 *
 * @author eros
 */
public class MsgsUtils {

	protected static ClassLoader getCurrentClassLoader(Object defaultObject){

		ClassLoader loader = Thread.currentThread().getContextClassLoader();

		if(loader == null){
			loader = defaultObject.getClass().getClassLoader();
		}

		return loader;
	}

	public static String getMessageResourceString(
							String bundleName,
							String key,
							Object params[],
							Locale locale){

		String text = null;

		ResourceBundle bundle =
				ResourceBundle.getBundle(bundleName, locale,
										getCurrentClassLoader(params));

		try{
			text = bundle.getString(key);
		} catch(MissingResourceException e){
			text = "?? key " + key + " not found ??";
		}

		if(params != null){
			MessageFormat mf = new MessageFormat(text, locale);
			text = mf.format(params, new StringBuffer(), null).toString();
		}

		return text;
	}
        public static String getMessageResourceString(String key,Locale locale){
            return MsgsUtils.getMessageResourceString("org.icefaces.application.showcase.view.resources.messages", key, null, locale);
        }



//        public  static void main(String... args){
//            String text = MsgsUtils.getMessageResourceString("org.icefaces.application.showcase.view.resources.messages", "page.outputResource.synopsis", null, new Locale("ES"));
//            System.out.println(text);
//        }
}