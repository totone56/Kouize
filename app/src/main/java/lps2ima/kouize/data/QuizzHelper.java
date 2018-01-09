package lps2ima.kouize.data;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import lps2ima.kouize.Question;

/**
 * Created by toton on 13/12/2017.
 */

public class QuizzHelper {
    public Context context;
    private int indexQuestionCourante; //ou id de la question courante, à voir ??????
    private ArrayList<Question> questions;

    public QuizzHelper(Context context) {
        this.context = context;
        questions = new ArrayList<>();
        indexQuestionCourante = -1;
    }

    /**
     * @param nameFile - Chemin + nom du fichier .json.
     * @param difficulte - Correspond à la difficulté du culture_generale choisi par le joueur :
     *                   <li>"débutant"</li>
     *                   <li>"confirmé"</li>
     *                   <li>"expert"</li>
     */
    public void initQuizzHelper(String nameFile, String difficulte) {
        try {
            questions = Parser.questionsByJson(nameFile, difficulte);
            indexQuestionCourante = 0;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return la question courante. Celle qui va être utilisé pour la vue.
     */
    public Question getQuestionCourante() {
        if(indexQuestionCourante >= 0) {
            return questions.get(indexQuestionCourante);
        } else {
            return null;
        }
    }

    /**
     * Permet de passer à la question suivante en augmentant de 1 l'index courant. Sauf si on est à la dernière question.
     */
    public void questionSuivante() {
        if(questions.size() > indexQuestionCourante+1) {
            indexQuestionCourante ++;
        } else {
            //TODO : EXCEPTION OU MESSAGE ???
        }
    }

    /**
     *
     * @return la liste des questions
     */

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public int getIndexQuestionCourante() {
        return indexQuestionCourante;
    }

    //A VOIR SI BESOIN DE GETTER ET SETTER ICI
}
