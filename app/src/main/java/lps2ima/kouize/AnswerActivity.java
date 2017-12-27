package lps2ima.kouize;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class AnswerActivity extends AppCompatActivity {

    Boolean lastQuestion;

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

        TextView answer = (TextView) findViewById(R.id.answer);
        answer.setText(question.getReponse());

        TextView anecdote = (TextView) findViewById(R.id.anecdote);
        anecdote.setText(question.getAnecdote());

        Button nextQuestion = (Button) findViewById(R.id.nextQuestion);
        nextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lastQuestion) { //On affiche les résultats
                    //TODO : Passer à l'activité des résultats
                } else { //On retourne sur l'activité des questions pour la question suivante
                    setResult(RESULT_OK);
                    finish();
                }
            }
        });
    }
}
