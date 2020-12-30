package org.slf4j.impl;

import org.slf4j.ILoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;

import otplike.slf4j.LoggerFactory;

public class StaticLoggerBinder implements LoggerFactoryBinder {
	private final ILoggerFactory factory = new LoggerFactory();
	private static final StaticLoggerBinder instance = new StaticLoggerBinder();
	
	@Override
	public ILoggerFactory getLoggerFactory() {
		return factory;
	}

	@Override
	public String getLoggerFactoryClassStr() {
		return LoggerFactory.class.getName();
	}
	
	public static StaticLoggerBinder getSingleton() {
		return StaticLoggerBinder.instance;
	}
}
