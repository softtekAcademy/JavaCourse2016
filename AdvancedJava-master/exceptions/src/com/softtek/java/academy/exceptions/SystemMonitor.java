package com.softtek.java.academy.exceptions;


public class SystemMonitor {
    
    public void sendError(Throwable e) {
        
        System.out.println("Send error to the support team via email " + e.getMessage());
    }

}
