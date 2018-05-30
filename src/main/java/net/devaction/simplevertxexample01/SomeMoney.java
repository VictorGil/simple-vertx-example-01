package net.devaction.simplevertxexample01;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.vertx.core.json.JsonObject;
import java.io.Serializable;

/**
 * @author Víctor Gil
 * 
 * since Tue 2018-May-29 
 */
public class SomeMoney implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @JsonProperty   
    private long amount;
    @JsonProperty
    private String currency;

    //Jackson needs this constructor to be able to 
    //deserialise/unmarshal/construct the object
    public SomeMoney(){}
        
    public SomeMoney(long amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public JsonObject toJsonObject(){
        return JsonObject.mapFrom(this);        
    }
    
    public static SomeMoney getNewInstance(JsonObject jsonObject){
        return jsonObject.mapTo(SomeMoney.class);
    }
    
    @Override
    public String toString() {
        return "SomeMoney [amount=" + amount + ", currency=" + currency + "]";
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }   
}

