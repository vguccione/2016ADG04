package com.ADG04.Servidor.util;

import java.io.IOException;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class ExceptionManager {

    public static void LogException(Exception ex, Logger logger){
        
    	ex.printStackTrace();
    	
    	String msg = "";
        StackTraceElement[] ts = ex.getStackTrace();
        for(StackTraceElement t:ts){
        	msg += " - " + t.toString();
        	msg += " - " + t.getClassName() +" - " + t.getFileName()+" - " +t.getMethodName()+" - " + t.getLineNumber();
        }

        msg += " - " + ex.getCause().getMessage();
        
        logger.severe(msg);
        
    }

	public static Logger InitLogger(String type, Logger logger) {
	
		Date date = new Date();
		Long ticks = date.getTime();
		String fileName = "./logs/"+type +"-"+ticks.toString()+".log";
		FileHandler fh = null;
        // This block configure the logger with handler and formatter  
        try {
			fh = new FileHandler(fileName);
		} catch (SecurityException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        SimpleFormatter formatter = new SimpleFormatter();  
        fh.setFormatter(formatter);
        
        logger.addHandler(fh);

        return logger;
	}
	
}
