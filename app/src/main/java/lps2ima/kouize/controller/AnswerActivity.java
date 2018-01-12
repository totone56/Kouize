package lps2ima.kouize.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import lps2ima.kouize.KouizeApp;
import lps2ima.kouize.model.Question;
import lps2ima.kouize.R;

public class AnswerActivity extends AppCompatActivity {

    public Boolean lastQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        //On souhaite récupérer directement l'objet Question plutôt que de refaire une requête.
        Bundle bundle = getIntent().getExtras();
        //Je vérifie qu'il y a bien des extras sur notre Intent
        if (bundle == null) {
            Toast.makeText(getApplicationContext(), "Extras == null", Toast.LENGTH_LONG);
            return;
        }
        Question question = (Question)(bundle.getSerializable("question"));
        lastQuestion = bundle.getBoolean("lastQuestion");

        TextView isTrue = (TextView) findViewById(R.id.isTrue);
        TextView answer = (TextView) findViewById(R.id.answer);

        if(bundle.getString("reponse").equals(question.getReponse())) {
            isTrue.setText("VRAI");
            ((KouizeApp) getApplication()).upScore();
        } else {
            isTrue.setText("FAUX");
        }

        answer.setText("Réponse : " + question.getReponse());

        TextView anecdote = (TextView) findViewById(R.id.anecdote);
        anecdote.setText(question.getAnecdote());

        Button nextQuestion = (Button) findViewById(R.id.nextQuestion);
        nextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lastQuestion) { //On affiche les résultats
                    startActivity(new Intent(AnswerActivity.this, ResultActivity.class));
                } else { //On retourne sur l'activité des questions pour la question suivante
                    setResult(RESULT_OK);
                }
                finish();
            }
        });
    }
}
