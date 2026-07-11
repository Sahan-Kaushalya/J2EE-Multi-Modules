package lk.kaushalya.ecomm.cdi;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import lk.kaushalya.ecomm.annotation.Console;

@ApplicationScoped
public class Logger {
    public void log(@Observes String message){
        System.out.println("Logging : "+message);
    }

    public void consoleLog(@Observes @Console String message){
        System.out.println("Console Logging : "+message);
    }
}
