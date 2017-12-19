package lps2ima.kouize;

import android.app.Application;

/**
 * Created by toton on 13/12/2017.
 */

public class MyApplication extends Application {

    int sessionScore;
    String user;
    int difficulty;

    public void onCreate(){
        super.onCreate();
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
}
