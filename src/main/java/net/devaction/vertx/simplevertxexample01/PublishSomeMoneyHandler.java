package net.devaction.vertx.simplevertxexample01;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import io.vertx.core.Handler;
import io.vertx.core.Vertx;

/**
 * @author Víctor Gil
 * 
 * since Tue 2018-May-29 
 */
public class PublishSomeMoneyHandler implements Handler<Long>{
    private static final Logger log = LogManager.getLogger(PublishSomeMoneyHandler.class);
    
    private final int amount;
    private Vertx vertx;
    private String address;
    
    public PublishSomeMoneyHandler(int amount, Vertx vertx, String address){
        this.amount = amount;
        this.vertx = vertx;
        this.address = address;
    }
    
    @Override
    public void handle(Long event){
        log.info("Going to send " + amount + " USD.");
        vertx.eventBus().publish(address, new SomeMoney(amount, "USD").toJsonObject());        
    }    
}

