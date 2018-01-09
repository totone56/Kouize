package lps2ima.kouize;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;

import lps2ima.kouize.data.Parser;
import lps2ima.kouize.data.QuizzHelper;

import static java.lang.System.exit;

public class QuestionActivity extends AppCompatActivity {

    static final int REQUEST = 1;

    QuizzHelper quizzHelper;
    Bundle extras;
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

        initView();

        //Button de validation de la réponse selectionné.
        Button validateAnswer = (Button) findViewById(R.id.validateAnswer);
        validateAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeActivity();
            }
        });
    }

    private void initView() {
        //Je vérifie que j'ai bien des valeurs dans mes extras.
        extras = getIntent().getExtras();
        if (extras == null) {
            Toast.makeText(getApplicationContext(), "Extras == null", Toast.LENGTH_LONG);
            return;
        }

        //Si c'est le cas, alors je récupère le QuizzHelper correspondant, avec la difficulté et le thème passé dans les extras
        quizzHelper = new QuizzHelper(getApplicationContext());

        String nameFile = extras.getString("theme").replace(" ", "_").toLowerCase();
        String difficulty = extras.getString("difficulty").toLowerCase();

        //Puis l'initialise mon quizzHelper
        quizzHelper.initQuizzHelper(nameFile, difficulty);

        //Puis je charge la vue des questions
        chargeView();
    }

    private void chargeView() {
        TextView question = (TextView) findViewById(R.id.question);
        question.setText(quizzHelper.getQuestionCourante().getQuestion());

        if(answer1.isChecked()) {
           answer1.setChecked(false);
        }
        if(answer2.isChecked()) {
            answer2.setChecked(false);
        }
        if(answer3.isChecked()) {
            answer3.setChecked(false);
        }
        if(answer4.isChecked()) {
            answer4.setChecked(false);
        }
        answer1.setText(quizzHelper.getQuestionCourante().getPropositions().get(0));
        answer2.setText(quizzHelper.getQuestionCourante().getPropositions().get(1));
        answer3.setText(quizzHelper.getQuestionCourante().getPropositions().get(2));
        answer4.setText(quizzHelper.getQuestionCourante().getPropositions().get(3));
    }

    private void changeActivity() {
        if(answer1.isChecked() || answer2.isChecked() || answer3.isChecked() || answer4.isChecked()) {
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

            //Si c'est la dernière question, on ne souhaite pas retourner sur la vue des questions.
            if(quizzHelper.getQuestions().size() == quizzHelper.getIndexQuestionCourante()+1) {
                intent.putExtra("lastQuestion", true);
                startActivity(intent);
            } else { //Mais si il reste des questions oui
                intent.putExtra("lastQuestion", false);
                startActivityForResult(intent, REQUEST);
            }
        } else {
            Toast.makeText(getApplicationContext(), "WES TA OUBLIE 2 REPONDRE", Toast.LENGTH_LONG);
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        //On passe à la question suivante
        quizzHelper.questionSuivante();
        //On change les valeurs de la page
        chargeView();
    }
}
