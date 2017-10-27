package com.soft.util;

import org.apache.log4j.Logger;

/**
 * @author caesar
 *
 *  日志类
 */

public class Log {
	
	public static void info(Class<?> clazz,String exceptionMsg){
		
		Logger.getLogger(clazz).info(exceptionMsg);
	}
	
    public static void debug(Class<?> clazz,String exceptionMsg){
		Logger.getLogger(clazz).debug(exceptionMsg);
	}

}
