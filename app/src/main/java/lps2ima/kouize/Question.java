package lps2ima.kouize;

/**
 * Created by toton on 12/12/2017.
 */

public class Question {

    private String question;
    private String[] reponses;
    private int reponse;
    private String anecdote;
    private int difficulte;

    public Question(String question, String[] reponses, int reponse, String anecdote, int difficulte) {
        this.question = question;
        this.reponses = reponses;
        this.reponse = reponse;
        this.anecdote = anecdote;
        this.difficulte = difficulte;
    }

    public Question(){}

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getReponses() {
        return reponses;
    }

    public String getReponse(int i) {
        return this.reponses[i];
    }

    public void setReponses(String[] reponses) {
        this.reponses = reponses;
    }

    public int getReponse() {
        return reponse;
    }

    public void setReponse(int reponse) {
        this.reponse = reponse;
    }

    public String getAnecdote() {
        return anecdote;
    }

    public void setAnecdote(String anecdote) {
        this.anecdote = anecdote;
    }

    public int getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(int difficulte) {
        this.difficulte = difficulte;
    }
}
