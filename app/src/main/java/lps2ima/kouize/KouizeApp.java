package lps2ima.kouize;

import android.app.Application;
import android.content.Context;

/**
 * Created by toton on 13/12/2017.
 */

public class KouizeApp extends Application {

    public int sessionScore;
    public String user;
    public int difficulty;
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public static Context getContext() {
        return context;
    }
}
