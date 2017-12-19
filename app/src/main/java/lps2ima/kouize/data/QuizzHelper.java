package lps2ima.kouize.data;

import android.content.Context;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import lps2ima.kouize.Question;

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

    /**
     * @param nameFile - Chemin + nom du fichier .json.
     * @param difficulte - Correspond à la difficulté du quizz choisi par le joueur :
     *                   <li>"débutant"</li>
     *                   <li>"confirmé"</li>
     *                   <li>"expert"</li>
     */
    public void initQuizzHelper(String nameFile, String difficulte) {
        try {
            questions = Parser.questionsByJson(nameFile, difficulte);
        } catch (FileNotFoundException e) {
            e.getMessage();
        }
        indexQuestionCourante = 0;
    }

    /**
     * @return la question courante. Celle qui va être utilisé pour la vue.
     */
    public Question getQuestionCourante() {
        return questions.get(indexQuestionCourante);
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

    //A VOIR SI BESOIN DE GETTER ET SETTER ICI
}
