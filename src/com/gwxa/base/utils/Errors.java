package com.gwxa.base.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;

public class Errors {
	/**
	 * 直接生成异常对象并抛出
	 *
	 * @param message
	 *            异常提示信息
	 * @return 返回值仅是语法糖
	 */
	public static <T> T cast(String message) {
		throw removeTopStackTrace(new RuntimeException(message), 1);
	}

	/**
	 * 包装异常为RuntimeException
	 */
	public static RuntimeException wrap(Throwable e) {
		return new RuntimeException(e);
	}

	/**
	 * 生成RuntimeException
	 */
	public static RuntimeException wrap(String message) {
		return removeTopStackTrace(new RuntimeException(message), 1);
	}

	/**
	 * 包装异常为RuntimeException
	 */
	public static RuntimeException wrap(String message, Throwable e) {
		return removeTopStackTrace(new RuntimeException(message, e), 1);
	}

	/**
	 * removeTopStackTrace
	 */
	public static RuntimeException removeTopStackTrace(RuntimeException runtimeException, Integer toRemoveNumAtTop) {
		StackTraceElement[] stackTrace = runtimeException.getStackTrace();
		runtimeException.setStackTrace(Arrays.copyOfRange(stackTrace, toRemoveNumAtTop, stackTrace.length));
		return runtimeException;
	}

	/**
	 * 未实现的方法
	 */
	public static RuntimeException noImplement() {
		return new RuntimeException("not implement yet");
	}

	/**
	 * 不支持的功能
	 */
	public static RuntimeException noSupport() {
		return new RuntimeException("not supported yet");
	}

	public static String stackTraceToString(Throwable e) {
		StringWriter stringWriter = new StringWriter();
		e.printStackTrace(new PrintWriter(stringWriter));
		return stringWriter.toString();
	}

	/**
	 * �?般用来代码追�?
	 */
	public static void printStackTrace() {
		System.err.println(stackTraceToString(new Throwable("PrintStackTrace")));
	}

	public static String stackTraceToString(StackTraceElement[] stackTraceElements) {
		String str = "";
		for (StackTraceElement stackTraceElement : stackTraceElements) {
			str += stackTraceElement.getClassName() + " " + stackTraceElement.getMethodName() + " "
					+ stackTraceElement.getFileName() + " " + stackTraceElement.getLineNumber() + "\n";
		}
		return str;
	}
}
