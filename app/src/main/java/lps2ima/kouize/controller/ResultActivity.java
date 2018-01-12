package lps2ima.kouize.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import lps2ima.kouize.KouizeApp;
import lps2ima.kouize.R;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView scorePourcentage = (TextView) findViewById(R.id.score);
        double score = ((KouizeApp) getApplication()).getSessionScore();
        score = (score/10)*100;
        scorePourcentage.setText(score + "%");

        //Button correspondant à la validation du formulaire pour commencé le quizz.
        Button restartButton = (Button) findViewById(R.id.restart);
        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ResultActivity.this, MainActivity.class));
                finish();
            }
        });
    }
}
