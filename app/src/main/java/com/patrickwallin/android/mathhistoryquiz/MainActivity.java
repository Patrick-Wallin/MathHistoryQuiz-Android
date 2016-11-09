package com.patrickwallin.android.mathhistoryquiz;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitAnswers(View view) {
        Context context = getApplicationContext();
        CharSequence text = "";
        int duration = Toast.LENGTH_LONG;

        int numberofanswer = numberOfQuestionsBeenAnsweredInCorrectly();

        if(numberofanswer == 0) {
            text = "Congratulations! You got 5/5!";
        }else {
            text = "You got " + String.valueOf(5-numberofanswer) + "/5!";
        }

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();


    }

    // check if all have been answers or missing
    public int numberOfQuestionsBeenAnsweredInCorrectly() {
        int numberOfQuestionThatHasNotBeenAnsweredCorrectly = 0;

        TextView textView_Question1 = (TextView) findViewById(R.id.answerquiz1);
        String question1Answer = textView_Question1.getText().toString().trim();
        if(question1Answer.isEmpty() || !question1Answer.equalsIgnoreCase(getResources().getString(R.string.answer1))) {
            numberOfQuestionThatHasNotBeenAnsweredCorrectly++;
        }else {

        }

        TextView textView_Question2 = (TextView) findViewById(R.id.answerquiz2);
        String question2Answer = textView_Question2.getText().toString().trim();
        if(question2Answer.isEmpty() || !question2Answer.equalsIgnoreCase(getResources().getString(R.string.answer2))) {
            numberOfQuestionThatHasNotBeenAnsweredCorrectly++;
        }else {

        }


        TableLayout tableLayout_Question3 = (TableLayout) findViewById(R.id.answerquiz3_table);
        String[] question3CorrectAnswers = getResources().getString(R.string.answer3).split(",",-1);
        int numberOfQuestion3ThatHasBeenCorrectlyAnswered = 0;
        for (int i = 0; i < tableLayout_Question3.getChildCount(); i++) {
            View child = tableLayout_Question3.getChildAt(i);

            if (child instanceof TableRow) {
                TableRow row = (TableRow) child;

                for (int x = 0; x < row.getChildCount(); x++) {
                    CheckBox answer_checkbox = (CheckBox)row.getChildAt(x);
                    if(answer_checkbox.isChecked()) {
                        for(int y = 0; y < question3CorrectAnswers.length; y++) {
                            if(answer_checkbox.getText().toString().equalsIgnoreCase(question3CorrectAnswers[y])) {
                                numberOfQuestion3ThatHasBeenCorrectlyAnswered++;
                            }
                        }
                    }
                }
            }
        }
        if(numberOfQuestion3ThatHasBeenCorrectlyAnswered != question3CorrectAnswers.length) {
            numberOfQuestionThatHasNotBeenAnsweredCorrectly++;
        }

        RadioGroup radioGroup_Question4 = (RadioGroup) findViewById(R.id.answerquiz4_radiogroup);
        String question4CorrectAnswer = getResources().getString(R.string.answer4);
        for (int i = 0; i < radioGroup_Question4.getChildCount(); i++) {
            RadioButton answer_radiobutton = (RadioButton) radioGroup_Question4.getChildAt(i);
            if(answer_radiobutton.isChecked() && answer_radiobutton.getText().toString().equalsIgnoreCase(question4CorrectAnswer)) {
                break;
            }else if(answer_radiobutton.isChecked()) {
                numberOfQuestionThatHasNotBeenAnsweredCorrectly++;
                break;
            }
        }

        RadioGroup radioGroup_Question5 = (RadioGroup) findViewById(R.id.answerquiz5_radiogroup);
        String question5CorrectAnswer = getResources().getString(R.string.answer5);
        for (int i = 0; i < radioGroup_Question5.getChildCount(); i++) {
            RadioButton answer_radiobutton = (RadioButton) radioGroup_Question5.getChildAt(i);
            if(answer_radiobutton.isChecked() && answer_radiobutton.getText().toString().equalsIgnoreCase(question5CorrectAnswer)) {
                break;
            }else if(answer_radiobutton.isChecked()) {
                numberOfQuestionThatHasNotBeenAnsweredCorrectly++;
                break;
            }
        }

        return numberOfQuestionThatHasNotBeenAnsweredCorrectly;
    }
}
