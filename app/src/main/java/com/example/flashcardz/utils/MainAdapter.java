package com.example.flashcardz.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flashcardz.R;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    /* Fields */
    private ArrayList<Deck> mDecks;


    /* Methods */
    /**
     * Constructor method.
     * @param decks: The Decks to work with.
     */
    public MainAdapter(ArrayList<Deck> decks) {
        this.mDecks = decks;
    }

    /**
     * Create new views.
     * @param parent: Where to be constructed.
     * @param viewType: The type of the parent.
     * @return A ViewHolder.
     */
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setText(this.mDecks.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return this.mDecks.size();
    }


    /* Classes */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        /* Fields */
        private Button deckButton;

        public ViewHolder(View itemView) {
            super(itemView);
            deckButton = itemView.findViewById(R.id.deck_selector_button);
        }

        public void setText(String text) {
            this.deckButton.setText(text);
        }
    }
}
