package ph.adoremus.suspensiontraining.utils;

import android.util.Log;

public class Logger {
	public static void log(StackTraceElement[] ste, String message, Integer logLevel){
		String prefix = "";//ste[2].getMethodName() + " -> " + ste[3].getMethodName();
		String tag = Logger.class.getName();
//		for (StackTraceElement element : ste){
//			prefix += element.getMethodName() + " -> ";
//		}
		switch(logLevel){
		case Log.ASSERT:
			break;
		case Log.DEBUG:
			Log.d(tag, prefix + message);
			break;
		case Log.ERROR:
			Log.e(tag, prefix + message);
			break;
		case Log.INFO:
			Log.i(tag, prefix + message);
			break;
		case Log.VERBOSE:
			Log.v(tag, prefix + message);
			break;
		case Log.WARN:
			Log.w(tag, prefix + message);
			break;
		}
	}
}
