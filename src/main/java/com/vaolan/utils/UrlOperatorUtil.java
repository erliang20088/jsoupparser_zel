package com.vaolan.utils;

import java.net.MalformedURLException;
import java.net.URL;
 
/**
 * 关于url操作的工具类，如提取url的域名、keyword等
 *   
 * @author zel
 * 
 */
public class UrlOperatorUtil {

	public static boolean isValidUrl(String url) {
		if (url == null || url.isEmpty()) {
			return false;
		}
		try {
			URL urlObj = new URL(url);
			return true;
		} catch (MalformedURLException e) {
			// e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		UrlOperatorUtil urlOperatorUtil = new UrlOperatorUtil();

	}
}
