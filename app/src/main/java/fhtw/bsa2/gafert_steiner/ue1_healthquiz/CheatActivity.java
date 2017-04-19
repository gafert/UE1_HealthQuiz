package fhtw.bsa2.gafert_steiner.ue1_healthquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    public static final String EXTRA_ANSWER_IS_TRUE = "fhtw.bsa2.steiner.healthquiz.answer_is_true";
    public static final String CHEATED = "fhtw.bsa2.steiner.healthquiz.cheated";

    private boolean answerIsTrue;
    private TextView answerTextView;
    private Button showAnswerButton;
    private Button backButton;
    private boolean cheated = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        answerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);

        answerTextView = (TextView) findViewById(R.id.show_answer_textView);
        showAnswerButton = (Button) findViewById(R.id.show_answer_button);
        backButton = (Button) findViewById(R.id.back_button);

        showAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answerIsTrue) {
                    answerTextView.setText(R.string.true_button);
                } else {
                    answerTextView.setText(R.string.false_button);
                }
                cheated = true;
                showAnswerButton.setVisibility(View.INVISIBLE);
                backButton.setVisibility(View.VISIBLE);
            }
        });

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

    /*
    public static Intent newIntent(Context packageContext, boolean answerIsTrue){
        Intent i = new Intent(packageContext, CheatActivity.class);
        i.putExtra(EXTRA_ANSWER_IS_TRUE,answerIsTrue);
        return i;

    }
    */
}