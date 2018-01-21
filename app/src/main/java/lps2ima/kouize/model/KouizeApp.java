package lps2ima.kouize.model;

import android.app.Application;
import android.content.Context;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import lps2ima.kouize.model.Parser;
import lps2ima.kouize.model.Question;

/**
 * Created by toton on 13/12/2017.
 */

public class KouizeApp extends Application {

    public int sessionScore;
    public String difficulty;
    public String nameQuizz;
    public List<Question> listQuestions;
    public int indexQuestion;
    public static Context context;

    @Override
    public void onCreate(){
        super.onCreate();
        context = getApplicationContext();
        listQuestions = new ArrayList<>();
    }

    public static Context getContext() {
        return context;
    }

    /**
     * Permet d'initialiser ou réinitialiser les valeurs contenu dans notre application KouizeApp.
     * @param nameQuizz - Nom du quizz souhaité.
     * @param difficulty - Difficulté du quizz souhaité.
     */
    public void initKouizeApp(String nameQuizz, String difficulty) {
        this.sessionScore = 0;
        this.indexQuestion = 0;
        this.difficulty = difficulty;
        this.nameQuizz = nameQuizz;
        try {
            nameQuizz = nameQuizz.replace(" ", "_").toLowerCase();
            difficulty = difficulty.toLowerCase();
            listQuestions = Parser.questionsByJson(nameQuizz, difficulty);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return le score de l'utilisateur.
     */
    public int getSessionScore() {
        return sessionScore;
    }

    /**
     * Augmente de 1 le score.
     */
    public void upScore() {
        this.sessionScore ++;
    }

    /**
     * @return l'index de la question courante.
     */
    public int getIndexQuestion() {
        return indexQuestion;
    }

    /**
     * Augmente l'index pour passer à la question suivante.
     */
    public void nextQuestion() {
        this.indexQuestion ++;
    }

    /**
     * @return la question courante.
     */
    public Question getQuestionCourante() {
        return this.listQuestions.get(indexQuestion);
    }

    /**
     * @return toutes les questions du quizz pour la difficulté choisie.
     */
    public List<Question> getListQuestions() {
        return listQuestions;
    }
}
