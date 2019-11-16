package com.example.flashcardz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flashcardz.utils.Deck;

import java.util.LinkedHashMap;

public class MainActivity extends AppCompatActivity {

    /* Fields */
    private LinkedHashMap<String, Deck> mDecks;
    private final String INTENT_EXTRA_DECK = "com.example.flashcardz.MainActivity.DECK";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // RecyclerView stuff.
        RecyclerView decksView = findViewById(R.id.decks_recycler_view);
        MainActivity_Recyclerview_Adapter adapter = new MainActivity_Recyclerview_Adapter(this.mDecks);
        decksView.setAdapter(adapter);
        decksView.setLayoutManager(new LinearLayoutManager(this));
    }



    public void toQuizActivity(View view) {

        // Get Button pressed.
        Button button = (Button) view;

        // Get selected Deck and prepare it.
        Deck deck = this.mDecks.get(button.getText());
        deck.resetDeck();

        // Create Intent with the appropriate Deck.
        Intent intent = new Intent(this, QuizActivity.class);
        intent.putExtra(INTENT_EXTRA_DECK, deck);
    }
}
