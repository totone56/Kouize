package lps2ima.kouize;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String userName = "";
    String difficulty = "";
    String themeText = "";
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.context = getApplicationContext();

        //Button correspondant à la validation du formulaire pour commencé le quizz.
        Button okButton = (Button) findViewById(R.id.okMain);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextActivity();
            }
        });

        //Button correspondant au choix de la difficulté
        final Button difficultyText = (Button) findViewById(R.id.difficultyMain);
        difficultyText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createDialogDifficulty(difficultyText);
            }
        });

        //Button correspondant au choix du thème
        final Button themeText = (Button) findViewById(R.id.themeMain);
        themeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                createDialogTheme(themeText);
            }
        });
    }

    private void createDialogTheme(final Button buttonText) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle("Choix de Thème");
        builder.setItems(Quizz.themes, new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                themeText = Quizz.themes[which];
                buttonText.setText(themeText);
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("cancel",
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        android.app.AlertDialog alert = builder.create();
        alert.show();
    }

    private void createDialogDifficulty(final Button buttonText) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle("Choix de difficulte");
        builder.setItems(Quizz.diffilculties, new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                difficulty = Quizz.diffilculties[which];
                buttonText.setText(difficulty);
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("cancel",
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        android.app.AlertDialog alert = builder.create();
        alert.show();
    }

    private void nextActivity() {
        final EditText name = (EditText) findViewById(R.id.nameText);
        userName = name.getText().toString();
        if (userName != "" && difficulty != "" && themeText != "") { // Check des paramètres
            ((KouizeApp) getApplication()).setUser(userName);

            //L'objet intent permet de lancer l'activité suivante : QuestionActivity
            Intent intent = new Intent(MainActivity.this, QuestionActivity.class);
            //A voir pour les stocker par la suite sur l'application directement ou pas
            intent.putExtra("theme", themeText);
            intent.putExtra("difficulty", difficulty);
            ////////////////////////////////////////////////////////////////////
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "TAT PAS CLIKUER PARTOUS WESH", Toast.LENGTH_SHORT).show();
        }
    }
}

