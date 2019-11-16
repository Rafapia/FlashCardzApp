package com.example.flashcardz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flashcardz.utils.Deck;

import java.util.LinkedHashMap;

public class MainActivity_Recyclerview_Adapter extends RecyclerView.Adapter<MainActivity_Recyclerview_Adapter.ViewHolder> {


    /* Fields */
    private LinkedHashMap<String, Deck> mDecks;


    /* Methods */
    // Constructor.
    public MainActivity_Recyclerview_Adapter(LinkedHashMap<String, Deck> decks) {
        this.mDecks = decks;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Get parent to inflate on and inflater object.
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the layout.
        View deckView = inflater.inflate(R.layout.deck_recyclerview_item, parent, false);

        // Return a new holder instance.
        ViewHolder viewHolder = new ViewHolder(deckView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Get data based on its position.
        Deck deck = this.mDecks.get(position);

        //Set items in the View based on the characteristics of each deck.
        Button mDeckSelectButton = holder.mDeckSelectButton;
        mDeckSelectButton.setText(deck.getName());
    }

    @Override
    public int getItemCount() {
        return this.mDecks.size();
    }


    /* Classes */
    // Class that holds each item.
    public class ViewHolder extends RecyclerView.ViewHolder {

        /* Fields */
        private Button mDeckSelectButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.mDeckSelectButton = itemView.findViewById(R.id.deck_select_button);
        }
    }
}
