package lps2ima.kouize.data;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import lps2ima.kouize.Question;
import lps2ima.kouize.Quizz;

/**
 * Created by toton on 13/12/2017.
 */

public class QuizzHelper {
    public Context context;
    private int indexQuestionCourante; //ou id de la question courante, à voir ??????
    private List<Question> questions;

    public QuizzHelper(Context context) {
        this.context = context;
        questions = new ArrayList<>();
        indexQuestionCourante = -1;
    }

    //Quand l'utilisateur choisi son quizz et sa difficulté, on initialise notre objet avec cette méthode.
    public void initQuizzHelper(String nameFile, String difficulte) {
        //TODO : APPEL AU PARSER POUR REMPLIR LES ATTRIBUTS DU QUIZZHELPER
        questions = Parser.questionsByJson(nameFile, difficulte);
        indexQuestionCourante = 0;
    }

    //Pour la vue des questions, appel à cette méthode pour avoir la question courante
    public Question getQuestionCourante() {
        return questions.get(indexQuestionCourante);
    }

    //Lors du passage à la question suivante, appel à cette méthode pour passer à la question suivante.
    public void questionSuivante() {
        indexQuestionCourante ++;
    }

    //A VOIR SI BESOIN DE GETTER ET SETTER ICI
}
