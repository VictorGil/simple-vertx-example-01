package net.devaction.simplevertxexample01;

import org.apache.logging.log4j.Logger;

import io.vertx.core.AbstractVerticle;

import org.apache.logging.log4j.LogManager;

/**
 * @author Víctor Gil
 * 
 * since Tue 2018-May-29 
 */
public class PublisherVerticle extends AbstractVerticle{
    private static final Logger log = LogManager.getLogger(PublisherVerticle.class);
    
    static final String money = "money";
    
    @Override
    public void start() throws Exception{
        log.info("Starting " + PublisherVerticle.class.getSimpleName());
        super.start();

        publishMessages();           
    }
        
    public void publishMessages(){
        for (int i = 0; i <= 5; i++){
            PublishSomeMoneyHandler publishSomeMoneyHandler = 
                    new PublishSomeMoneyHandler(1000 + i, vertx, money);                
            
            vertx.setTimer(1000 + 1000 * i, publishSomeMoneyHandler);
        }
    }
    
    @Override
    public void stop() throws Exception {
        super.stop();
        log.info("Verticle has been stopped");
    }
}

