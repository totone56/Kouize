package lps2ima.kouize;

import android.app.Application;
import android.content.Context;

/**
 * Created by toton on 13/12/2017.
 */

public class KouizeApp extends Application {

    public int sessionScore = 0;
    public String user;
    public String difficulty;
    public String nameQuizz;
    public static Context context;

    @Override
    public void onCreate(){
        super.onCreate();
        context = getApplicationContext();
    }

    public int getSessionScore() {
        return sessionScore;
    }

    public void setSessionScore(int sessionScore) {
        this.sessionScore = sessionScore;
    }

    public void upScore() {
        this.sessionScore ++;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public static Context getContext() {
        return context;
    }

    public String getNameQuizz() {
        return nameQuizz;
    }

    public void setNameQuizz(String nameQuizz) {
        this.nameQuizz = nameQuizz;
    }
}
