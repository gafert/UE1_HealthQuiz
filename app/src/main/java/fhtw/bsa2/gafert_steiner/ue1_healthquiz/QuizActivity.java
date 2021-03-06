package fhtw.bsa2.gafert_steiner.ue1_healthquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private static final String TAG = "QuizActivity";
    private static final String KEY_INDEX = "index";

    private Button trueButton;
    private Button falseButton;
    private Button nextButton;
    private Button cheatButton;
    private TextView questionText;
    private TextView cheaterTextView;

    // Load questions into questionBank array
    private Question[] questionBank = new Question[]{
            new Question(R.string.question0, true),
            new Question(R.string.question1, true),
            new Question(R.string.question2, false),
            new Question(R.string.question3, false),
            new Question(R.string.question4, true),
            new Question(R.string.question5, false),
            new Question(R.string.question6, true),
            new Question(R.string.question7, true),
            new Question(R.string.question8, true),
            new Question(R.string.question9, false)
    };

    private int questionIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Assign layout button variables
        trueButton = (Button) findViewById(R.id.true_button);
        falseButton = (Button) findViewById(R.id.false_button);
        nextButton = (Button) findViewById(R.id.next_button);
        cheatButton = (Button) findViewById(R.id.cheat_button);
        questionText = (TextView) findViewById(R.id.question_text);
        cheaterTextView = (TextView) findViewById(R.id.cheater_textView);

        if(savedInstanceState != null){
            questionIndex = savedInstanceState.getInt(KEY_INDEX, 0);
        }

        updateQuestion();

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });

        // When nextButton is clicked show the next question
        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                questionIndex = (questionIndex + 1) % questionBank.length;
                updateQuestion();
            }
        });

        // Makes new Intent
        // Puts the correct answer of the question in the new intent
        // And starts Activity
        cheatButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(QuizActivity.this, CheatActivity.class);

                boolean answer = questionBank[questionIndex].getAnswer();
                i.putExtra(CheatActivity.EXTRA_ANSWER_IS_TRUE, answer);

                startActivityForResult(i, 0);
            }
        });
    }

    // Gets the question to the corresponding question index and shows it in the layout
    private void updateQuestion() {
        questionText.setText(questionBank[questionIndex].getQuestion_ID());
        cheaterTextView.setText("");
    }

    // Checks if the userInput (true/false) equals the answer of the question
    // -> True: Show correct message
    // -> False: Show incorrect message
    private void checkAnswer(boolean userInput) {
        boolean answerBoolean = questionBank[questionIndex].getAnswer();
        int messageID = 0;

        if (userInput == answerBoolean) {
            messageID = R.string.correct_toast;
        } else {
            messageID = R.string.incorrect_toast;
        }

        Toast.makeText(QuizActivity.this, messageID,Toast.LENGTH_SHORT).show();
    }

    // Function is called before the activity closes and saves the current questionIndex to the instance
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState");
        savedInstanceState.putInt(KEY_INDEX, questionIndex);
    }

    // Called when received results from CheatActivity
    // Get the variable if the user cheated in the CheatActivity from the data Intent
    // -> If cheated: Set cheat text
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != RESULT_OK) {
            return;
        }
        if (data.getExtras() != null) {
            boolean cheated = data.getBooleanExtra(CheatActivity.CHEATED, false);
            if (cheated) {
                cheaterTextView.setText(R.string.judgement_toast);
            }
        }
    }

    // Logging
    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called!");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called!");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called!");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume called!");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy called!");
    }
}

