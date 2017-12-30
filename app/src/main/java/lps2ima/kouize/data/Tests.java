package lps2ima.kouize.data;

import android.app.Application;
import android.content.Context;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

import lps2ima.kouize.KouizeApp;
import lps2ima.kouize.Question;
import lps2ima.kouize.Quizz;
import lps2ima.kouize.R;

/**
 * Created by Asouphie on 24/12/2017.
 */

public class Tests {

    public static void main(String[] args) throws FileNotFoundException {

        /*****************
         * TEST DU QUIZZ *
         *****************/

        //Création du quizz grâce au fichier .json
        Context context = KouizeApp.getContext();
        File f = new File("res/raw/culture_generale.json");
        InputStream in = context.getResources().openRawResource(R.raw.culture_generale);
        in = new BufferedInputStream(new FileInputStream(f));
        Quizz quizz = Parser.quizzByJson(f);

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
        f = new File("res/raw/culture_generale.json");
        in = context.getResources().openRawResource(R.raw.linux);
        in = new BufferedInputStream(new FileInputStream(f));
        Quizz quizz2 = Parser.quizzByJson(new File("raw/linux"));

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
        f = new File("res/raw/linux.json");
        in = context.getResources().openRawResource(R.raw.linux);
        in = new BufferedInputStream(new FileInputStream(f));
        quizzHelper.initQuizzHelper(f, "débutant");

        //Affichage de quelques valeurs pour tester
        System.out.println("Question courante après l\'initialisation : " + quizzHelper.getQuestions()
                .indexOf(quizzHelper.getQuestionCourante()));
        for(Question question : quizzHelper.getQuestions()) {
            System.out.println("Question " + quizzHelper.getQuestions().indexOf(question) + " : " + question.getQuestion());
        }
    }




}
