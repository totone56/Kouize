package lps2ima.kouize.data;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import lps2ima.kouize.Question;
import lps2ima.kouize.Quizz;

/**
 * Created by Asouphie on 24/12/2017.
 */

public class Tests {

    public static void main(String[] args) throws FileNotFoundException {

        /*****************
         * TEST DU QUIZZ *
         *****************/

        //Création du quizz grâce au fichier .json
        Quizz quizz = Parser.quizzByJson("C:\\Users\\Asouphie\\Documents\\LP_S2IMa\\" +
                "UE3\\Kouize\\app\\src\\main\\res\\raw\\culture_generale.json");

        //On affiche quelques informations pour voir si tout marche bien.
        System.out.println("Thème du culture_generale : " + quizz.getTheme());
        System.out.println("Le redacteur : " + quizz.getRedacteur());

        //Puis, par difficulté on affiche les questions.
        for(String difficulte : quizz.getQuizz().keySet()) {
            System.out.println("Difficulté : " + difficulte);
            ArrayList<Question> listQuizz = quizz.getQuizz().get(difficulte);
            for (int i = 0; i < listQuizz.size(); i++) {
                System.out.println("question " + (i+1) + " : " + listQuizz.get(i).getQuestion());
            }
        }

        System.out.println("\n===================================================================\n");

        //Création du quizz grâce au fichier .json
        Quizz quizz2 = Parser.quizzByJson("C:\\Users\\Asouphie\\Documents\\LP_S2IMa\\" +
                "UE3\\Kouize\\app\\src\\main\\res\\raw\\linux.json");

        //On affiche quelques informations pour voir si tout marche bien.
        System.out.println("Thème du quizz : " + quizz2.getTheme());
        System.out.println("Le redacteur : " + quizz2.getRedacteur());

        //Puis, par difficulté on affiche les questions.
        for(String difficulte : quizz2.getQuizz().keySet()) {
            System.out.println("Difficulté : " + difficulte);
            ArrayList<Question> listQuizz2 = quizz2.getQuizz().get(difficulte);
            for (int i = 0; i < listQuizz2.size(); i++) {
                System.out.println("question " + (i+1) + " : " + listQuizz2.get(i).getQuestion());
            }
        }

        System.out.println("\n===================================================================\n");


        /***********************
         * TEST DU QUIZZHELPER *
         ***********************/

        //Création de l'objet QuizzHelper
        QuizzHelper quizzHelper = new QuizzHelper(null);

        //Initialisation de l'objet
        quizzHelper.initQuizzHelper("C:\\Users\\Asouphie\\Documents\\LP_S2IMa\\" +
                "UE3\\Kouize\\app\\src\\main\\res\\raw\\linux.json", "expert");

        //Affichage de quelques valeurs pour tester
        System.out.println("Question courante après l\'initialisation : " + quizzHelper.getQuestions()
                .indexOf(quizzHelper.getQuestionCourante()));
        for(Question question : quizzHelper.getQuestions()) {
            System.out.println("Question " + quizzHelper.getQuestions().indexOf(question) + " : " + question.getQuestion());
        }
    }
}
