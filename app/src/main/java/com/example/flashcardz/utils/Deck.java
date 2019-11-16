package com.example.flashcardz.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck implements Serializable {


    /* Fields */
    private List<Card> mCards;
    private Queue<Card> mPlayingCards;
    private String mName;
    private String mDescription;



    /* Methods */
    public Deck(String name, String description) {
        this.mName = name;
        this.mDescription = description;

        this.mCards = new ArrayList<Card>();
        this.mPlayingCards = new Queue<Card>();
    }


    public void add(Card card) { this.mCards.add(card); }
    public void remove(Card card) { this.mCards.remove(card); }
    public Card get(int card) { return this.mCards.get(card); }

    public void setName(String name) { this.mName = name; }
    public void setDescription(String description) { this.mDescription = description; }
    public String getName() { return this.mName; }
    public String getDescription() { return this.mDescription; }

    public List<Card> getCards() { return this.mCards; }

    public void resetDeck() {

        // Shuffle the deck.
        Collections.shuffle(this.mCards);

        // Add cards to Queue to be popped.
        for (Card card: this.mCards) {
            this.mPlayingCards.enqueue(card);
        }
    }

    public Card nextCard() { return this.mPlayingCards.dequeue(); }
}
