package com.shsxt.util;

/**
 * 字符串 工具类
 * 
 * @author Mr.YongGan.Zhang
 * @versin 1.0.0
 * @since JDK1.8
 */
public final class StringUtil {

	/**
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotNullOrEmpty(final String str) {
		if (str == null || "".equals(str)) {
			return false;
		}
		return true;
	}

}
