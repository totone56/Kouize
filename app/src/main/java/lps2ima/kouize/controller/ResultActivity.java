package lps2ima.kouize.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import lps2ima.kouize.model.KouizeApp;
import lps2ima.kouize.R;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //Nos scores seront affichés en pourcentage
        TextView scorePourcentage = (TextView) findViewById(R.id.score);
        double score = ((KouizeApp) getApplication()).getSessionScore();
        score = (score/10)*100;
        scorePourcentage.setText(score + "%");

        //Button pour recommencer le quizz.
        Button restartButton = (Button) findViewById(R.id.restart);
        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //On retourne sur la première activité si l'utilisateur souhaite refaire un quizz.
                startActivity(new Intent(ResultActivity.this, MainActivity.class));
                finish();
            }
        });
    }

    /**
     * Méthode utilisé lors d'un clic sur le bouton retour du téléphone.
     */
    public void onBackPressed() {
        startActivity(new Intent(ResultActivity.this, MainActivity.class));
        finish();
    }
}
