package fhtw.bsa2.gafert_steiner.ue1_healthquiz;

/**
 * Created by michi on 07.04.17.
 */

public class Question {
    private int mTextResId;
    private boolean mAnswerTrue;

    public Question(int textResId, boolean answerTrue) {
        mTextResId = textResId;
        mAnswerTrue = answerTrue;
    }

    public int getTextResId () {
        return mTextResId ;
    }

    public void setTextResId (int textResId) {
        this.mTextResId = textResId;
    }

    public boolean isAnswerTrue () {
        return mAnswerTrue;
    }

    public void setAnswerTrue (boolean answerTrue) {
        this.mAnswerTrue = answerTrue;
    }
}
