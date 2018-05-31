package net.devaction.vertx.simplevertxexample01;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import io.vertx.core.Launcher;

/**
 * @author Víctor Gil
 * 
 * since Tue 2018-May-29 
 */
public class MainClass{
    private static final Logger log = LogManager.getLogger(MainClass.class);
    private static final String run = "run";
    
    public static void main(String[] args){
        log.info("Starting application");
        Launcher.executeCommand(run, MainVerticle.class.getName());  
        log.info("Main method has finished");
    }  
}

