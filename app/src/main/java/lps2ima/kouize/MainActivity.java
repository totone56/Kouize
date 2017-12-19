package lps2ima.kouize;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String userName;
    String difficulty;
    int difficultyPlace;
    String[] diffilculties;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.context = getApplicationContext();
        difficultyPlace = 0;
        difficulty = "";
        diffilculties = new String[3];
        diffilculties[0] = ("Facile");
        diffilculties[1] = ("Moyen");
        diffilculties[2] = ("Difficile");
        final EditText name = (EditText) findViewById(R.id.nameText);
        //name.setText("Entrez votre nom");
        Button okButton = (Button) findViewById(R.id.okMain);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userName != "" && difficulty != "") // Check des paramètres
                {
                    userName = name.getText().toString();
                    Toast.makeText(getApplicationContext(), userName + " / " + difficulty, Toast.LENGTH_LONG).show(); // Test
                    MyApplication myApp = (MyApplication) getApplication();
                    myApp.setUser(userName);
                    if (difficulty.equals("Facile")) myApp.setDifficulty(0);
                    else if (difficulty.equals("Moyen")) myApp.setDifficulty(1);
                    else myApp.setDifficulty(2);
                } else {
                    Toast.makeText(getApplicationContext(), "TAT PAS CLIKUER PARTOUS WESH", Toast.LENGTH_SHORT).show();
                }
            }
        });
        final Button difficultyText = (Button) findViewById(R.id.difficultyMain);
        difficultyText.setText("Séléction de Difficulté");
        difficultyText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createDialog(difficultyText);
            }
        });
    }

    public void createDialog(final Button buttonText) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle("Choix de difficulté");
        builder.setItems(diffilculties, new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                difficulty = diffilculties[which];
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
}

