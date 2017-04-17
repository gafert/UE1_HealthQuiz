package fhtw.bsa2.gafert_steiner.ue1_healthquiz;

/**
 * Created by michi on 07.04.17.
 */


public class Question {
    private int question_ID;
    private boolean answere;

    public Question(int id, boolean answere){
        this.question_ID=id;
        this.answere=answere;
    }

    public int getQuestion_ID() {
        return question_ID;
    }

    public void setQuestion_ID(int question_ID) {
        this.question_ID = question_ID;
    }

    public boolean isAnswere() {
        return answere;
    }

    public void setAnswere(boolean answere) {
        this.answere = answere;
    }
}
