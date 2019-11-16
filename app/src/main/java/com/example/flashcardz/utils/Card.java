package com.example.flashcardz.utils;

import java.io.Serializable;

public class Card implements Serializable {

    /* Fields */
    private String key;
    private String definition;


    /* Methods */

    /**
     * The contructor for the Card class.
     * @param key: The key for this Card.
     * @param definition: The definition of the key.
     */
    public Card(String key, String definition) {

        this.key = key;
        this.definition = definition;
    }


    // Getters and Setters.
    public void setKey(String key) {
        this.key = key;
    }
    public String getKey() {
        return this.key;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }
    public String getDefinition() {
        return this.definition;
    }
}
