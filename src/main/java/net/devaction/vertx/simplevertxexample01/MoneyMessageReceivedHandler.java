package net.devaction.vertx.simplevertxexample01;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import io.vertx.core.Handler;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.JsonObject;

/**
 * @author Víctor Gil
 * 
 * since Tue 2018-May-29 
 */
public class MoneyMessageReceivedHandler implements Handler<Message<JsonObject>>{
    private static final Logger log = LogManager.getLogger(MoneyMessageReceivedHandler.class);
    
   @Override
    public void handle(Message<JsonObject> message) {
        log.info("Message received: " + message.toString());
        log.info("Message headers: " + message.headers());
        log.info("Message body: " + message.body());
        JsonObject someMoneyJsonObject = message.body();
        SomeMoney someMoney = SomeMoney.getNewInstance(someMoneyJsonObject);
        log.info("Reconstructed SomeMoney object received: " + someMoney + "\n");       
    }    
}

