package com.example.quizapp_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String questions[] = {"Garbage Collection is manual process.",
                                  "Constructor overloading is not possible in Java.",
                                  "a .class file contains bytecodes.",
                                  "James Gosling is father of Java?",
                                  "The \"switch\" selection structure must end with the default case."};
    private Boolean answers[] = {false, false, true, true, false};
    private int score = 0;
    private int index = 0;
    Button yes;
    Button no;
    TextView textView;

//    public static final String EXTRA_RESULT = "njnjndknfkfnfknrkrnjknkjnrtknrntkrn.extra.result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        yes = findViewById(R.id.buttonTrue);
        no = findViewById(R.id.buttonFalse);
        textView = findViewById(R.id.questions);

//        Populate Array Data on Text View
        textView.setText("Q"+(index+1)+". "+questions[index]);


        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                use '(index<=questions.length-1)' for avoid array gose out of Bound Exception
                if (index<=questions.length-1) {
                    if(answers[index]) {
                        score++;
                    }
                    index++;

                    if (index<=questions.length-1) {
                        textView.setText("Q"+(index+1)+". "+questions[index]);
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Your Score is "+score, Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index<=questions.length-1) {
                    if(!answers[index]) {
                        score++;
                    }
                    index++;

                    if (index<=questions.length-1) {
                        textView.setText("Q"+(index+1)+". "+questions[index]);
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Your Score is "+score, Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });
    }
}