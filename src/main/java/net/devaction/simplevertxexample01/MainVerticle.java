package net.devaction.simplevertxexample01;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import io.vertx.core.AbstractVerticle;

/**
 * @author Víctor Gil
 * 
 * since Tue 2018-May-29 
 */
public class MainVerticle extends AbstractVerticle{
    private static final Logger log = LogManager.getLogger(MainVerticle.class);
  
    @Override
    public void start(){
        log.info("Starting " + MainVerticle.class.getSimpleName());
        
        try{
            super.start();
        } catch(Exception ex){
            log.error(ex, ex);
            throw new RuntimeException(ex);
        }
        deployVerticle02();
        deployVerticle03();
        
        int seconds = 10;
        log.info("vertx will be closed after " + seconds + " seconds");
        vertx.setTimer(1000 * seconds, timerHandler -> {
            vertx.close(closeHandler -> {
                log.info("vertx has been closed");
            });
        });    
    }
    
    public void deployVerticle02(){
        log.info("Going to deploy " + PublisherVerticle.class.getSimpleName());
        vertx.deployVerticle(new PublisherVerticle(), asyncResult -> {
            if (asyncResult.succeeded()) {
                log.info("Successfully deployed " +  
                        PublisherVerticle.class.getSimpleName() + ". Result: " + asyncResult.result());
            } else {
                log.error("Error when trying to deploy " + PublisherVerticle.class.getSimpleName());
            }
        });    
    }
    
    public void deployVerticle03(){
        log.info("Going to deploy " + ConsumerVerticle.class.getSimpleName());
        vertx.deployVerticle(new ConsumerVerticle(), asyncResult -> {
            if (asyncResult.succeeded()) {
                log.info("Successfully deployed " +  
                        ConsumerVerticle.class.getSimpleName() + ". Result: " + asyncResult.result());
            } else {
                log.error("Error when trying to deploy " + ConsumerVerticle.class.getSimpleName());
            }
        });    
    }
    
    @Override
    public void stop() throws Exception {
        super.stop();
        log.info("Verticle has been stopped");
    }
}

