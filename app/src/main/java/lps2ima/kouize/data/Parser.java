package lps2ima.kouize.data;

import com.google.gson.Gson;

import java.io.File;
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
     * @param file - fichier .json
     * @return le culture_generale souhaité.
     * @throws FileNotFoundException
     */
    public static Quizz quizzByJson(File file) throws FileNotFoundException {
        FileReader reader = new FileReader(file);
        return new Gson().fromJson(reader, Quizz.class);
    }

    /**
     * @param file - fichier .json
     * @param difficulte - correspondant au niveau de difficulté du culture_generale :
     *                   <li>"débutant"</li>
     *                   <li>"confirmé"</li>
     *                   <li>"expert"</li>
     * @return une ArrayList contenant les questions souhaitées.
     * @throws FileNotFoundException
     */
    public static ArrayList<Question> questionsByJson(File file, String difficulte) throws FileNotFoundException {
        Quizz quizzCourant = quizzByJson(file);
        return quizzCourant.getQuizz().get(difficulte);
    }
}