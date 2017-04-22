package fhtw.bsa2.gafert_steiner.ue1_healthquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    // Strings to identify extra variables stored in the Intent
    public static final String EXTRA_ANSWER_IS_TRUE = "fhtw.bsa2.gafert_steiner.ue1_healthquiz.answer_is_true";
    public static final String CHEATED = "fhtw.bsa2.gafert_steiner.ue1_healthquiz.cheated";

    private boolean answer;
    private TextView answerTextView;
    private Button showAnswerButton;
    private Button backButton;
    private boolean cheated = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        // Gets the answer which was passed to the Intent by Quiz Activity
        answer = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);

        // Get layout elements
        answerTextView = (TextView) findViewById(R.id.show_answer_textView);
        showAnswerButton = (Button) findViewById(R.id.show_answer_button);
        backButton = (Button) findViewById(R.id.back_button);

        // When the button is clicked show the answer
        // Set the cheated var to true
        showAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer) {
                    answerTextView.setText(R.string.true_button);
                } else {
                    answerTextView.setText(R.string.false_button);
                }
                cheated = true;
                showAnswerButton.setVisibility(View.INVISIBLE);
                backButton.setVisibility(View.VISIBLE);
            }
        });

        // When back button is clicked
        // Make new Intent
        // Put the variable if the user cheated
        // Set the intent to the results
        // And finish the activity
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent();
                myIntent.putExtra(CHEATED, cheated);
                setResult(RESULT_OK, myIntent);
                finish();
            }
        });
    }
}