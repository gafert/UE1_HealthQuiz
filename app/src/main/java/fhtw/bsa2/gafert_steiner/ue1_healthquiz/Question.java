package fhtw.bsa2.gafert_steiner.ue1_healthquiz;

public class Question {
    private int question_ID;
    private boolean answer;

    public Question(int id, boolean answer) {
        this.question_ID=id;
        this.answer = answer;
    }

    public int getQuestion_ID() {
        return question_ID;
    }

    public void setQuestion_ID(int question_ID) {
        this.question_ID = question_ID;
    }

    public boolean getAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
}
