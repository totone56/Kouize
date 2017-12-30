package lps2ima.kouize.data;

import android.content.Context;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import lps2ima.kouize.KouizeApp;
import lps2ima.kouize.Question;
import lps2ima.kouize.Quizz;

/**
 * Created by toton on 19/12/2017.
 */

public class Parser {

    Context context;

    public Parser() throws FileNotFoundException, IOException {
        this.context = KouizeApp.getContext();
    }

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
     * @param file       - fichier .json
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