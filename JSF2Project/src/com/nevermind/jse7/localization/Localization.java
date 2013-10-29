package com.nevermind.jse7.localization;

import java.util.Locale;
import java.util.ResourceBundle;

public class Localization {

	public static void main(String[] args) {
		Locale[] locales = Locale.getAvailableLocales();
		for (Locale locale : locales) {
			System.out.printf("The country code is %s and the name is %s.\n", locale.getCountry(), locale.getDisplayCountry());
		}
		Locale locale = new Locale("it", "IT");
		Locale.setDefault(locale);
		Locale defaultLocale = Locale.getDefault();
		ResourceBundle resourceBundle = ResourceBundle.getBundle("Messages", defaultLocale);
		System.out.println(resourceBundle.getString("hello"));
	}

}
