package com.example.flashcardz.utils;

import androidx.annotation.Nullable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Deck implements Serializable {


    /* Fields */
    private HashMap<String, Card> mCards;
    private Queue<Card> mPlayingCards;
    private String mName;
    private String mDescription;



    /* Methods */

    /**
     * The constructor for the Deck class.
     * @param name: The name of the Deck.
     * @param description: The description of the Deck.
     */
    public Deck(String name, String description) {
        this.mName = name;
        this.mDescription = description;

        this.mCards = new HashMap<String, Card>();
        this.mPlayingCards = new Queue<Card>();
    }


    /**
     * Add a Card to the Deck.
     * @param card: The Card.
     */
    public void add(Card card) { this.mCards.put(card.getKey(), card); }

    /**
     * Remove a Card from Deck.
     * @param card: The Card to be removed.
     */
    public void remove(Card card) { this.mCards.remove(card.getKey()); }

    /**
     * Remove a Card from Deck.
     * @param cardName: The name of the Card to be removed.
     */
    public void remove(String cardName) { this.mCards.remove(cardName); }

    /**
     * Get a Card from the Deck.
     * @param cardName: The name of the Card.
     * @return The matching Card.
     */
    public Card get(String cardName) { return this.mCards.get(cardName); }

    /**
     * Get a Set with all keys from the Deck.
     * @return The Set.
     */
    public ArrayList<String> getKeys() { return new ArrayList<String>(this.mCards.keySet()); }

    /**
     * Set the name of the Deck.
     * @param name: New name of the Deck.
     */
    public void setName(String name) { this.mName = name; }

    /**
     * Set the description of the Deck.
     * @param description: New description.
     */
    public void setDescription(String description) { this.mDescription = description; }

    /**
     * Get Deck name.
     * @return The name of this Deck.
     */
    public String getName() { return this.mName; }

    /**
     * Get the description of this Deck.
     * @return The description.
     */
    public String getDescription() { return this.mDescription; }

    /**
     * Returns the entire Deck of Cards.
     * @return The Cards.
     */
    public HashMap<String, Card> getCards() { return this.mCards; }

    /**
     * Resets the Queue with the shuffled Cards.
     */
    public void resetDeck() {

        // Shuffle the deck.
        List<Card> shuffledCards = new ArrayList<Card>(this.mCards.values());
        Collections.shuffle(shuffledCards);

        // Add cards to Queue to be popped.
        for (Card card: shuffledCards) {
            this.mPlayingCards.enqueue(card);
        }

        shuffledCards = null;
    }

    /**
     * Gets the next Card from the Queue to be played.
     * @return The next Card.
     */
    public Card nextCard() { return this.mPlayingCards.dequeue(); }

    @Override
    public boolean equals(@Nullable Object obj) {
        Deck d = (Deck) obj;
        return d.getName().equals(this.getName());
    }
}
