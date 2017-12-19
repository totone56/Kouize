package lps2ima.kouize.data;

import android.content.Context;
import java.util.ArrayList;
import lps2ima.kouize.Question;
import lps2ima.kouize.Quizz;

/**
 * Created by toton on 19/12/2017.
 */

public class Parser {
    //Surement besoin ailleurs que pour init quizzHelper
    public static Quizz quizzByJson(String nameFile) {
        //TODO : Récupérer un quizz via un fichier JSON en utilisant l'api Google
        return new Quizz();
    }

    public static ArrayList<Question> questionsByJson(String nameFile, String difficulte) {
        Quizz quizzCourant = quizzByJson(nameFile);
        return quizzCourant.getQuizz().get(difficulte);
    }
}