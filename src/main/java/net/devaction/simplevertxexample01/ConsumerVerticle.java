package net.devaction.simplevertxexample01;

import org.apache.logging.log4j.Logger;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;

import org.apache.logging.log4j.LogManager;

/**
 * @author Víctor Gil
 * 
 * since Tue 2018-May-29 
 */
public class ConsumerVerticle extends AbstractVerticle{
    private static final Logger log = LogManager.getLogger(ConsumerVerticle.class);
  
    @Override
    public void start(){
        log.info("Starting " + ConsumerVerticle.class.getSimpleName());
        try{
            super.start();
        } catch(Exception ex){
            log.error(ex, ex);
            throw new RuntimeException(ex);
        }
        
        EventBus eventBus = vertx.eventBus();
        eventBus.consumer(PublisherVerticle.money, new MoneyMessageReceivedHandler());
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        log.info("Verticle has been stopped");
    }
}
