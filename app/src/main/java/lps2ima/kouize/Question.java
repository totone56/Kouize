package lps2ima.kouize;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by toton on 12/12/2017.
 */

public class Question {

    private int id;
    private String question;
    private List<String> propositions;
    private String anecdote;
    @SerializedName(value = "reponse", alternate = {"réponse"})
    private String reponse;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public String getAnecdote() {
        return anecdote;
    }

    public void setAnecdote(String anecdote) {
        this.anecdote = anecdote;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getPropositions() {
        return propositions;
    }

    public void setPropositions(List<String> propositions) {
        this.propositions = propositions;
    }
}
