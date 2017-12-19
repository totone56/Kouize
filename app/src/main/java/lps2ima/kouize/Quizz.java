package lps2ima.kouize;

import java.util.ArrayList;

/**
 * Created by toton on 12/12/2017.
 */

public class Quizz {

    private ArrayList<Question> questions;
    int difficulté;

    public Quizz (int difficulté) {
        this.difficulté = difficulté;
        createQuestions(difficulté);
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

    public int getDifficulté() {
        return difficulté;
    }

    public void setDifficulté(int difficulté) {
        this.difficulté = difficulté;
    }
}
