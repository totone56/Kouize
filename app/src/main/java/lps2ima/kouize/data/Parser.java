package lps2ima.kouize.data;

import android.content.Context;
import java.util.ArrayList;
import lps2ima.kouize.Question;
import lps2ima.kouize.Quizz;

/**
 * Created by toton on 19/12/2017.
 */

public class Parser {

    public Context context;
    public Quizz quizz;
    public ArrayList<Question> questions;

    public Parser(Context context, Quizz quizz) {
        this.context = context;
        this.quizz = quizz;
        this.questions = quizz.getQuestions();
    }

}
