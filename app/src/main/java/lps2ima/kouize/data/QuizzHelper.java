package lps2ima.kouize.data;

import lps2ima.kouize.Quizz;

/**
 * Created by toton on 13/12/2017.
 */

public class QuizzHelper {

    //Cette classe va servir à stocker le Quizz courant en dehors des vues, ça évite de faire passer des objets ou autres dans les Intents, c'est moins casse couille

    static Quizz currentQuizz;

    public static void setCurrentQuizz(Quizz quizz){
        currentQuizz = quizz;
    }

    public static Quizz getCurrentQuizz(){
        return currentQuizz;
    }

}
