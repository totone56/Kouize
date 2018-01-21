package lps2ima.kouize.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import lps2ima.kouize.model.KouizeApp;
import lps2ima.kouize.model.Question;
import lps2ima.kouize.R;

public class AnswerActivity extends AppCompatActivity {

    public Boolean lastQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        TextView isTrue = (TextView) findViewById(R.id.isTrue);
        TextView answer = (TextView) findViewById(R.id.answer);
        TextView anecdote = (TextView) findViewById(R.id.anecdote);

        //On souhaite récupérer nos objets passé dans les extras de notre Intent.
        Bundle bundle = getIntent().getExtras();
        //Je vérifie qu'il y a bien des extras sur notre Intent
        if (bundle == null) {
            Toast.makeText(getApplicationContext(), "Extras == null", Toast.LENGTH_LONG);
            return;
        }
        lastQuestion = bundle.getBoolean("lastQuestion");

        //Je récupère la question courante stocké sur l'application.
        Question question = ((KouizeApp) getApplication()).getQuestionCourante();

        //Je vérifie que la réponse selectionné par l'utilisateur est bien la bonne réponse.
        if(bundle.getString("reponse").equals(question.getReponse())) {
            isTrue.setText("VRAI");
            ((KouizeApp) getApplication()).upScore();
        } else {
            isTrue.setText("FAUX");
        }

        answer.setText("Réponse : " + question.getReponse());

        anecdote.setText(question.getAnecdote());

        //Button pour passer à la question suivante, ou finir le questionnaire.
        final Button nextQuestion = (Button) findViewById(R.id.nextQuestion);
        nextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lastQuestion) { //On affiche les résultats
                    nextQuestion.setText("Terminer");
                    startActivity(new Intent(AnswerActivity.this, ResultActivity.class));
                } else { //On retourne sur l'activité des questions pour la question suivante
                    ((KouizeApp) getApplication()).nextQuestion();
                    startActivity(new Intent(AnswerActivity.this, QuestionActivity.class));
                }
                finish();
            }
        });
    }

    /**
     * Méthode utilisé lors d'un clic sur le bouton retour du téléphone.
     */

    public void onBackPressed() {
        startActivity(new Intent(AnswerActivity.this, MainActivity.class));
        finish();
    }
}
