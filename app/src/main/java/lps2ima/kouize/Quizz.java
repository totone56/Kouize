package lps2ima.kouize;

import java.util.ArrayList;

/**
 * Created by toton on 12/12/2017.
 */

public class Quizz {

    private ArrayList<Question> questions;
    int difficulte;

    public Quizz (int difficulte) {
        this.difficulte = difficulte;
        createQuestions(difficulte);
    }

    public Question getQuestion (int i){
        return this.questions.get(i);
    }

    private void createQuestions(int difficulté) {
        /* Todo Parser le fichier pour créer les questions*/
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public int getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(int difficulte) {
        this.difficulte = difficulte;
    }
}
