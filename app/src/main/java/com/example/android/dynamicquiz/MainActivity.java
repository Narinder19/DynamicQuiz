package com.example.android.dynamicquiz;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int totalQuestions;
    int totalScore = 0;
    int answer;
    int correctId;
    String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        ArrayList<Question> questionList = new ArrayList<>();

        questionList.add(new Question("1.The energy of motion is called?", "light energy, kinetic energy, nuclear energy, thermal energy", "kinetic energy", "MultipleChoice"));
        questionList.add(new Question("2.What did Albert Einstein invent?", "Quantum Theory of Light, E=mc2,General Theory of Relativity, Theory of Gravity", "Quantum Theory of Light, E=mc2,General Theory of Relativity", "CheckBoxes"));
        questionList.add(new Question("3.energy of moving electrons is kinetic energy.", "True,False", "True", "TrueorFalse"));
        questionList.add(new Question("4.The energy of motion.", "", "kinetic energy", "FillInBlank"));

        totalQuestions = questionList.size();

        for (Question qu : questionList) {
            if (qu.getQuestionType() == "MultipleChoice") {
                createRadioButtons(qu);
            } else if (qu.getQuestionType() == "CheckBoxes") {
                createCheckBoxes(qu);
            } else if (qu.getQuestionType() == "TrueorFalse") {
                createTrueFalse(qu);
            } else if (qu.getQuestionType() == "FillInBlank") {
                createFillInBlank(qu);

            }
        }
    }

    public void createRadioButtons(final Question question) {

        TextView txView = new TextView(this);
        txView.setTextSize(20);
        txView.setTextColor(Color.BLACK);
        txView.setText(question.getQuestion());
        LinearLayout ll = findViewById(R.id.lltest);
        ll.setOrientation(LinearLayout.VERTICAL);
        ll.addView(txView);

        RadioGroup radiogroup = new RadioGroup(this); // create the Radio Group
        radiogroup.setId(R.id.radiogroup1);
        radiogroup.setOrientation(RadioGroup.VERTICAL);


        for (int i = 0; i < question.getAnswers().size(); i++) {
            RadioButton rdbtn = new RadioButton(this);
            if (i == 0) {
                rdbtn.setId(R.id.answer1A);
            } else if (i == 1) {
                rdbtn.setId(R.id.answer1B);
            } else if (i == 2) {
                rdbtn.setId(R.id.answer1C);
            } else if (i == 3) {
                rdbtn.setId(R.id.answer1D);
            }
            rdbtn.setTextSize(20);
            rdbtn.setText(question.getAnswers().get(i));
            radiogroup.addView(rdbtn);
        }
        ll.addView(radiogroup);

    }

    public void createCheckBoxes(Question question) {

        TextView txView = new TextView(this);
        txView.setTextSize(20);
        txView.setTextColor(Color.BLACK);
        txView.setText(question.getQuestion());
        LinearLayout ll = findViewById(R.id.lltest);
        ll.setOrientation(LinearLayout.VERTICAL);
        ll.addView(txView);

        for (int i = 0; i < question.getAnswers().size(); i++) {
            CheckBox chkbtn = new CheckBox(this);
            if (i == 0) {
                chkbtn.setId(R.id.answer2A);
            } else if (i == 1) {
                chkbtn.setId(R.id.answer2B);
            } else if (i == 2) {
                chkbtn.setId(R.id.answer2C);
            } else if (i == 3) {
                chkbtn.setId(R.id.answer2D);
            }
            chkbtn.setTextSize(20);
            chkbtn.setText(question.getAnswers().get(i));
            ll.addView(chkbtn);
        }


    }

    public void createTrueFalse(Question question) {

        TextView txView = new TextView(this);
        txView.setTextSize(20);
        txView.setTextColor(Color.BLACK);
        txView.setText(question.getQuestion());
        LinearLayout ll = findViewById(R.id.lltest);
        ll.setOrientation(LinearLayout.VERTICAL);
        ll.addView(txView);

        RadioGroup radiogroup = new RadioGroup(this); // create the Radio Group
        radiogroup.setId(R.id.radiogroup3);
        radiogroup.setOrientation(RadioGroup.VERTICAL);

        for (int i = 0; i < question.getAnswers().size(); i++) {
            RadioButton rdbtn = new RadioButton(this);
            if (i == 0) {
                rdbtn.setId(R.id.answer3A);
            } else if (i == 1) {
                rdbtn.setId(R.id.answer3B);
            }
            rdbtn.setTextSize(20);
            rdbtn.setText(question.getAnswers().get(i));
            radiogroup.addView(rdbtn);
        }
        ll.addView(radiogroup);

    }

    public void createFillInBlank(Question question) {
        TextView txView = new TextView(this);
        txView.setTextSize(20);
        txView.setTextColor(Color.BLACK);
        txView.setText(question.getQuestion());
        LinearLayout ll = findViewById(R.id.lltest);
        ll.setOrientation(LinearLayout.VERTICAL);
        ll.addView(txView);

        EditText edText = new EditText(this);
        edText.setSingleLine(true);
        edText.setId(R.id.answer4);
        edText.setTextSize(20);
        ll.addView(edText);


    }

    public void submit(View view) {

        RadioGroup radioGroup1 = findViewById(R.id.radiogroup1);
        answer = radioGroup1.getCheckedRadioButtonId();
        RadioButton radioButton1 = findViewById(R.id.answer1B);
        correctId = radioButton1.getId();
        if (answer == correctId) {
            totalScore++;
        }

        CheckBox checkBox1 = findViewById(R.id.answer2A);
        CheckBox checkbox2 = findViewById(R.id.answer2B);
        CheckBox checkBox3 = findViewById(R.id.answer2C);
        CheckBox checkBox4 = findViewById(R.id.answer2D);
        if (checkBox1.isChecked() && checkbox2.isChecked() && checkBox3.isChecked()) {
            totalScore++;
        }

        RadioGroup radioGroup3 = findViewById(R.id.radiogroup3);
        answer = radioGroup3.getCheckedRadioButtonId();
        RadioButton radioButton2 = findViewById(R.id.answer3A);
        correctId = radioButton2.getId();
        if (answer == correctId) {
            totalScore++;
        }

        EditText editText = findViewById(R.id.answer4);
        String answer = String.valueOf(editText.getText()).toLowerCase();
        if (answer.equals("kinetic") || answer.equals("kinetic energy")) {
            totalScore++;
        }

        message = "You have " + totalScore + " correct answers out of " + totalQuestions;


        //Using toast to display result
        totalScore = 0;
        Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG);
        toast.show();

        // Reset all the fields.
        radioGroup1.clearCheck();
        radioGroup3.clearCheck();
        checkBox1.setChecked(false);
        checkbox2.setChecked(false);
        checkBox3.setChecked(false);
        checkBox4.setChecked(false);
        editText.setText("");
    }

}
