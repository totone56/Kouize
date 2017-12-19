package lps2ima.kouize.data;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import lps2ima.kouize.Question;
import lps2ima.kouize.Quizz;

/**
 * Created by toton on 19/12/2017.
 */

public class Parser {
    /**
     * @param nameFile - Chemin + nom du fichier .json
     * @return le quizz souhaité.
     * @throws FileNotFoundException
     */
    public static Quizz quizzByJson(String nameFile) throws FileNotFoundException {
        FileReader reader = new FileReader(nameFile);
        return new Gson().fromJson(reader, Quizz.class);
    }

    /**
     * @param nameFile - Chemin + nom du fichier .json
     * @param difficulte - correspondant au niveau de difficulté du quizz :
     *                   <li>"débutant"</li>
     *                   <li>"confirmé"</li>
     *                   <li>"expert"</li>
     * @return une ArrayList contenant les questions souhaitées.
     * @throws FileNotFoundException
     */
    public static ArrayList<Question> questionsByJson(String nameFile, String difficulte) throws FileNotFoundException {
        Quizz quizzCourant = quizzByJson(nameFile);
        return quizzCourant.getQuizz().get(difficulte);
    }
}