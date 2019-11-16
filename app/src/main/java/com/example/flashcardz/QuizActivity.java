package com.example.flashcardz;

import android.content.Intent;
import android.os.Bundle;
import com.example.flashcardz.utils.Card;
import com.example.flashcardz.utils.Deck;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    /* Fields */
    private Deck mDeck;
    private ArrayList<String> keys;
    private TextView mDescription;
    private Button mButton_A;
    private Button mButton_B;
    private Button mButton_C;
    private Button mButton_D;
    private FloatingActionButton fab;
//    private TextView mScoreboard;

    // Helper variables.
    private int correctAnswers, questionsPlayed;
    private Card nextCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Get all views.
        mDescription = findViewById(R.id.description_text_view);
        mButton_A = findViewById(R.id.button_1);
        mButton_B = findViewById(R.id.button_2);
        mButton_C = findViewById(R.id.button_3);
        mButton_D = findViewById(R.id.button_4);
        fab = findViewById(R.id.fab);
//        mScoreboard = findViewById(R.id.scoreboard_text_view);

        // Get Intent.
        Intent intent = getIntent();
        mDeck = (Deck) intent.getSerializableExtra(MainActivity.INTENT_EXTRA_DECK);
        mDeck.resetDeck();
        keys = mDeck.getKeys();

        // Setup View.
        resetView(getCurrentFocus());
    }


    public void buttonPressed(View view) {
        // Get button.
        Button b = (Button) view;

        // If answer is correct.
        if (b.getText().equals((nextCard.getKey()))) {
            questionsPlayed++;
            correctAnswers++;
            Toast toast = Toast.makeText(getApplicationContext(), "Correct Answer! :)", Toast.LENGTH_SHORT);
            toast.show();
        }
        // Else.
        else {
            questionsPlayed++;
            Toast toast = Toast.makeText(getApplicationContext(), "Wrong Answer... :/", Toast.LENGTH_SHORT);
            toast.show();
        }
        fab.setVisibility(View.VISIBLE);
        setButtonAnswer();
    }

    /**
     * Paints the buttons according to their texts. Green for the right answer, and red for the wrong ones.
     */
    private void setButtonAnswer() {

        if (mButton_A.getText().equals(nextCard.getKey())) {
            mButton_A.setBackgroundColor(getResources().getColor(R.color.Green));
            mButton_A.setTextColor(getResources().getColor(R.color.White));
        } else {
            mButton_A.setBackgroundColor(getResources().getColor(R.color.Magenta));
            mButton_A.setTextColor(getResources().getColor(R.color.White));
        }

        if (mButton_B.getText().equals((nextCard.getKey()))) {
            mButton_B.setBackgroundColor(getResources().getColor(R.color.Green));
            mButton_B.setTextColor(getResources().getColor(R.color.White));
        } else {
            mButton_B.setBackgroundColor(getResources().getColor(R.color.Magenta));
            mButton_B.setTextColor(getResources().getColor(R.color.White));
        }

        if (mButton_C.getText().equals((nextCard.getKey()))) {
            mButton_C.setBackgroundColor(getResources().getColor(R.color.Green));
            mButton_C.setTextColor(getResources().getColor(R.color.White));
        } else {
            mButton_C.setBackgroundColor(getResources().getColor(R.color.Magenta));
            mButton_C.setTextColor(getResources().getColor(R.color.White));
        }

        if (mButton_D.getText().equals((nextCard.getKey()))) {
            mButton_D.setBackgroundColor(getResources().getColor(R.color.Green));
            mButton_D.setTextColor(getResources().getColor(R.color.White));
        } else {
            mButton_D.setBackgroundColor(getResources().getColor(R.color.Magenta));
            mButton_D.setTextColor(getResources().getColor(R.color.White));
        }
    }

    private void resetButtons() {

        mButton_A.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        mButton_A.setTextColor(getResources().getColor(R.color.White));

        mButton_B.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        mButton_B.setTextColor(getResources().getColor(R.color.White));

        mButton_C.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        mButton_C.setTextColor(getResources().getColor(R.color.White));

        mButton_D.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        mButton_D.setTextColor(getResources().getColor(R.color.White));

    }

    public void resetView(View view) {

        resetButtons();
        nextCard = mDeck.nextCard();

        Random random = new Random();

        // If nextQuestion is not null (flag for empty deck)
        if (nextCard != null) {

            fab.setVisibility(FloatingActionButton.INVISIBLE);

            // Local array of keys.
            ArrayList<String> roundKeys = new ArrayList<String>();
            roundKeys.add(nextCard.getKey());
            while (roundKeys.size() < 4) {
                String randKey = keys.get(random.nextInt(keys.size()));
                if (!roundKeys.contains(randKey))
                    roundKeys.add(randKey);
            }
            Collections.shuffle(roundKeys);

            // Populate elements
            mDescription.setText(nextCard.getDefinition());
            mButton_A.setText(roundKeys.get(0));
            mButton_B.setText(roundKeys.get(1));
            mButton_C.setText(roundKeys.get(2));
            mButton_D.setText(roundKeys.get(3));

        } else {    // End of game
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

}
