package com.bruce.utils;

import java.io.File;

public class CommonUtils {

	public static final String AGENT_ANDROID = "android";

	public static final String AGENT_IPHONE = "iphone";

	public static final String AGENT_COMPUTER = "computer";

	public static String getAgent(String userAgent) {
		if (userAgent.indexOf("Android") != -1) {
			// 安卓
			return AGENT_ANDROID;
		} else if (userAgent.indexOf("iPhone") != -1
				|| userAgent.indexOf("iPad") != -1) {
			// 苹果
			return AGENT_IPHONE;
		} else {
			// 电脑
			return AGENT_COMPUTER;
		}
	}

	public static String getPath(String userAgent) {
		if (userAgent.indexOf("Android") != -1) {
			// 安卓
			return "mobile" + File.separator;
		} else if (userAgent.indexOf("iPhone") != -1
				|| userAgent.indexOf("iPad") != -1) {
			// 苹果
			return "mobile" + File.separator;
		} else {
			// 电脑
			return "";
		}
	}
}
