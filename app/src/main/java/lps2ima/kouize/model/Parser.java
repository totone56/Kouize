package lps2ima.kouize.model;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;

/**
 * Created by toton on 19/12/2017.
 */

public class Parser {

    /**
     * @param nameFile       - fichier .json
     * @param difficulty - correspondant au niveau de difficulté du culture_generale :
     *                   <li>"débutant"</li>
     *                   <li>"confirmé"</li>
     *                   <li>"expert"</li>
     * @return une ArrayList contenant les questions souhaitées.
     * @throws FileNotFoundException
     */
    public static ArrayList<Question> questionsByJson(String nameFile, String difficulty) throws IOException {
        int rawId = KouizeApp.getContext().getResources().getIdentifier(nameFile, "raw",
                KouizeApp.getContext().getPackageName());

        InputStream is = KouizeApp.getContext().getResources().openRawResource(rawId);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            is.close();
        }

        Quizz quizz = new Gson().fromJson(writer.toString(), Quizz.class);
        return quizz.getQuizz().get(difficulty);
    }
}