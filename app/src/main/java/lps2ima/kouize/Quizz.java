package lps2ima.kouize;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by toton on 12/12/2017.
 */

public class Quizz {

    public static String[] diffilculties = {"Débutant", "Confirmé", "Expert"};
    public static String[] themes = {"Culture Generale", "Linux"};

    private String fournisseur;
    @SerializedName(value = "redacteur", alternate = {"rédacteur"})
    private String redacteur;
    @SerializedName(value = "theme", alternate = {"thème"})
    private String theme;
    @SerializedName(value = "difficulte", alternate = {"difficulté"})
    private int difficulte;
    private HashMap<String, ArrayList<Question>> quizz;

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

    public HashMap<String, ArrayList<Question>> getQuizz() {
        return quizz;
    }

    public void setQuizz(HashMap<String, ArrayList<Question>> quizz) {
        this.quizz = quizz;
    }
}
