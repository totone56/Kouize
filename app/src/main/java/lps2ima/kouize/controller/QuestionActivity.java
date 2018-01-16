package lps2ima.kouize.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import lps2ima.kouize.KouizeApp;
import lps2ima.kouize.model.Question;
import lps2ima.kouize.R;
import lps2ima.kouize.model.QuizzHelper;

public class QuestionActivity extends AppCompatActivity {

    RadioButton answer1;
    RadioButton answer2;
    RadioButton answer3;
    RadioButton answer4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        answer4 = findViewById(R.id.answer4);

        chargeView();

        //Button de validation de la réponse selectionné.
        Button validateAnswer = (Button) findViewById(R.id.validateAnswer);
        validateAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeActivity();
            }
        });
    }

    private void chargeView() {
        TextView question = (TextView) findViewById(R.id.question);
        QuizzHelper quizzHelper = ((KouizeApp) getApplication()).getQuizzHelper();

        question.setText(quizzHelper.getQuestionCourante().getQuestion());

        answer1.setChecked(false);
        answer2.setChecked(false);
        answer3.setChecked(false);
        answer4.setChecked(false);

        answer1.setText(quizzHelper.getQuestionCourante().getPropositions().get(0));
        answer2.setText(quizzHelper.getQuestionCourante().getPropositions().get(1));
        answer3.setText(quizzHelper.getQuestionCourante().getPropositions().get(2));
        answer4.setText(quizzHelper.getQuestionCourante().getPropositions().get(3));
    }

    private void changeActivity() {
        if(answer1.isChecked() || answer2.isChecked() || answer3.isChecked() || answer4.isChecked()) {
            QuizzHelper quizzHelper = ((KouizeApp) getApplication()).getQuizzHelper();

            Intent intent = new Intent(QuestionActivity.this, AnswerActivity.class);
            Bundle bundle = new Bundle();
            //Je passe la question courante dans les extras de l'Intent.
            bundle.putSerializable("question", (Question) quizzHelper.getQuestionCourante());
            intent.putExtras(bundle);

            //Plus la réponse selectionné.
            String reponse = "";
            if(answer1.isChecked()) {
                reponse = answer1.getText().toString();
            } else if (answer2.isChecked()) {
                reponse = answer2.getText().toString();
            } else if (answer3.isChecked()) {
                reponse = answer3.getText().toString();
            } else if (answer4.isChecked()) {
                reponse = answer4.getText().toString();
            }
            intent.putExtra("reponse", reponse);

            Boolean lastQuestion = quizzHelper.getQuestions().size() == quizzHelper.getIndexQuestionCourante()+1;
            intent.putExtra("lastQuestion", lastQuestion);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(getApplicationContext(), "WES TA OUBLIE 2 REPONDRE", Toast.LENGTH_LONG);
        }
    }

    public void onBackPressed() {
        startActivity(new Intent(QuestionActivity.this, MainActivity.class));
        finish();
    }
}
