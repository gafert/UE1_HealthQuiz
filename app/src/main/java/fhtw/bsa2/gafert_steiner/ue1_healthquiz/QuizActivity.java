package fhtw.bsa2.gafert_steiner.ue1_healthquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private static final String TAG ="QuizActivity";
    private static final String KEY_INDEX = "index" ;

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private TextView mQuestionView;
    private int mCurrentIndex = 0;

    private Question[] mQuestionBank = new Question[]{
            new Question(R.string.question0, true),
            new Question(R.string.question1, true),
            new Question(R.string.question2, true),
            new Question(R.string.question3, false),
            new Question(R.string.question4, false),
            new Question(R.string.question5, false),
            new Question(R.string.question6, true),
            new Question(R.string.question7, true),
            new Question(R.string.question8, false),
            new Question(R.string.question9, false),
    };

    private void updateQuestion () {
        mQuestionView.setText(mQuestionBank[mCurrentIndex].getTextResId());
        Log.i(TAG,"Updated Question");
    }
    private void checkAnswer(boolean userPressedTrue) {
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();
        int messageId = 0;
        if (userPressedTrue == answerIsTrue) {
            messageId = R.string.correct_toast;
        } else{
            messageId = R.string.incorrect_toast;
        }
        Toast.makeText(QuizActivity.this, messageId, Toast.LENGTH_SHORT).show();
    }
        
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Log.d(TAG, "onCreate() called");

        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalseButton = (Button) findViewById(R.id.false_button);
        mNextButton = (Button) findViewById(R.id.next_button);
        mQuestionView = (TextView) findViewById(R.id.question_view);

        if(savedInstanceState != null){
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0);
        }

        updateQuestion();

        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
             }
        });

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.d(TAG, "onSaveInstanceState() called");
        savedInstanceState.putInt(KEY_INDEX, mCurrentIndex);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    @Override
    public void onPause () {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called " );
    }
}
