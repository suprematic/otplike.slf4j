package otplike.slf4j;

import java.util.Collections;

import org.slf4j.helpers.MarkerIgnoringBase;
import org.slf4j.helpers.MessageFormatter;

import clojure.java.api.Clojure;
import clojure.lang.IFn;
import clojure.lang.Keyword;

public final class LoggerImpl extends MarkerIgnoringBase {
	private static final long serialVersionUID = 1L;
	private static final IFn is_enabled = Clojure.var("otplike.logger", "j-enabled?");
	private static final IFn log = Clojure.var("otplike.logger", "j-log");
	private static final Keyword throwable = Keyword.intern("throwable");

	@SuppressWarnings("unused")
	private static final int Emergency = 0;
	@SuppressWarnings("unused")
	private static final int Alert = 1;
	@SuppressWarnings("unused")
	private static final int Critical = 2;
	private static final int Error = 3;
	private static final int Warn = 4;
	@SuppressWarnings("unused")
	private static final int Notice = 5;
	private static final int Info = 6;
	private static final int Debug = 7;
	private static final int Trace = 8;
	
	LoggerImpl(String name) {
		this.name = name;
	}
	
	@Override
	public boolean isTraceEnabled() {
		return (boolean) is_enabled.invoke(this.name, LoggerImpl.Trace);
	}

	@Override
	public void trace(String msg) {
		log.invoke(this.name, Trace, msg, null);
	}

	@Override
	public void trace(String format, Object arg) {
		log.invoke(this.name, Trace, MessageFormatter.format(format, arg).getMessage(), null);
	}

	@Override
	public void trace(String format, Object arg1, Object arg2) {
		log.invoke(this.name, Trace, MessageFormatter.format(format, arg1, arg2).getMessage(), null);
	}

	@Override
	public void trace(String format, Object... arguments) {
		log.invoke(this.name, Trace, MessageFormatter.format(format, arguments).getMessage(), null);

	}

	@Override
	public void trace(String msg, Throwable t) {
		log.invoke(this.name, Trace, msg, Collections.singletonMap(throwable, t));
	}
	
	
	@Override
	public boolean isDebugEnabled() {
		return (boolean) is_enabled.invoke(this.name, LoggerImpl.Debug);
	}

	@Override
	public void debug(String msg) {
		log.invoke(this.name, Debug, msg, null);
	}

	@Override
	public void debug(String format, Object arg) {
		log.invoke(this.name, Debug, MessageFormatter.format(format, arg).getMessage(), null);
	}

	@Override
	public void debug(String format, Object arg1, Object arg2) {
		log.invoke(this.name, Debug, MessageFormatter.format(format, arg1, arg2).getMessage(), null);
	}

	@Override
	public void debug(String format, Object... arguments) {
		log.invoke(this.name, Debug, MessageFormatter.arrayFormat(format, arguments).getMessage(), null);
	}

	@Override
	public void debug(String msg, Throwable t) {
		log.invoke(this.name, Debug, msg, Collections.singletonMap(throwable, t));
	}

	@Override
	public boolean isInfoEnabled() {
		return (boolean) is_enabled.invoke(this.name, LoggerImpl.Info);
	}

	@Override
	public void info(String msg) {
		log.invoke(this.name, Info, msg, null);
	}

	@Override
	public void info(String format, Object arg) {
		log.invoke(this.name, Info, MessageFormatter.format(format, arg).getMessage(), null);
	}

	@Override
	public void info(String format, Object arg1, Object arg2) {
		log.invoke(this.name, Info, MessageFormatter.format(format, arg1, arg2).getMessage(), null);
	}

	@Override
	public void info(String format, Object... arguments) {
		log.invoke(this.name, Info, MessageFormatter.arrayFormat(format, arguments).getMessage(), null);
	}

	@Override
	public void info(String msg, Throwable t) {
		log.invoke(this.name, Info, msg, Collections.singletonMap(throwable, t));
	}

	@Override
	public boolean isWarnEnabled() {
		return (boolean) is_enabled.invoke(this.name, LoggerImpl.Warn);
	}

	@Override
	public void warn(String msg) {
		log.invoke(this.name, Warn, msg, null);
	}

	@Override
	public void warn(String format, Object arg) {
		log.invoke(this.name, Warn, MessageFormatter.format(format, arg).getMessage(), null);
	}

	@Override
	public void warn(String format, Object... arguments) {
		log.invoke(this.name, Warn, MessageFormatter.arrayFormat(format, arguments).getMessage(), null);
	}

	@Override
	public void warn(String format, Object arg1, Object arg2) {
		log.invoke(this.name, Warn, MessageFormatter.format(format, arg1, arg2).getMessage(), null);
	}

	@Override
	public void warn(String msg, Throwable t) {
		log.invoke(this.name, Warn, msg, Collections.singletonMap(throwable, t));
	}

	@Override
	public boolean isErrorEnabled() {
		return (boolean) is_enabled.invoke(this.name, LoggerImpl.Error);
	}

	@Override
	public void error(String msg) {
		log.invoke(this.name, Error, msg, null);
	}

	@Override
	public void error(String format, Object arg) {
		log.invoke(this.name, Error, MessageFormatter.format(format, arg).getMessage(), null);
	}

	@Override
	public void error(String format, Object arg1, Object arg2) {
		log.invoke(this.name, Error, MessageFormatter.format(format, arg1, arg2).getMessage(), null);
	}

	@Override
	public void error(String format, Object... arguments) {
		log.invoke(this.name, Error, MessageFormatter.arrayFormat(format, arguments).getMessage(), null);
	}

	@Override
	public void error(String msg, Throwable t) {
		log.invoke(this.name, Error, msg, Collections.singletonMap(throwable, t));
	}
}
