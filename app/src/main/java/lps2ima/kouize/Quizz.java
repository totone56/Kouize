package lps2ima.kouize;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

/**
 * Created by toton on 12/12/2017.
 */

public class Quizz {

    private String fournisseur;
    @SerializedName(value = "redacteur", alternate = {"rédacteur"})
    private String redacteur;
    @SerializedName(value = "reponse", alternate = {"réponse"})
    private String theme;
    @SerializedName(value = "difficulte", alternate = {"difficulté"})
    private int difficulte;
    private Map<String, List<Question>> quizz;

    public String getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(String fournisseur) {
        this.fournisseur = fournisseur;
    }

    public String getRedacteur() {
        return redacteur;
    }

    public void setRedacteur(String redacteur) {
        this.redacteur = redacteur;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public int getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(int difficulte) {
        this.difficulte = difficulte;
    }

    public Map<String, List<Question>> getQuizz() {
        return quizz;
    }

    public void setQuizz(Map<String, List<Question>> quizz) {
        this.quizz = quizz;
    }
}
