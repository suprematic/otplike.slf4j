package otplike.slf4j;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

public class LoggerFactory implements ILoggerFactory {
	ConcurrentMap<String, Logger> loggers = new ConcurrentHashMap<String, Logger>();
	
	@Override
	public Logger getLogger(String name) {
		Logger logger = this.loggers.get(name);
        if (logger != null) {
            return logger;
        } else {
            Logger new_ = new LoggerImpl(name);
            Logger old = this.loggers.putIfAbsent(name, new_);
            
            return old == null ? new_ : old;
        }
	}
}
