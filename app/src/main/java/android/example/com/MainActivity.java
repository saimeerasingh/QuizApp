package android.example.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when submit order button is clicked
     *
     *
     */
    public void submitAnswer(View view) {
        EditText nameField = findViewById(R.id.enter_name_view);
        String name = nameField.getText().toString();

        RadioButton wonBtn = (RadioButton) findViewById(R.id.sk_answer_one_radio_button);
        TextView firstAnswerView = (TextView) findViewById(R.id.feedback_first_answer_view);
        checkQuestion(wonBtn, firstAnswerView);

        RadioButton rubbleBtn = (RadioButton) findViewById(R.id.rus_answer_two_radio_button);
        TextView secondAnswerView = (TextView) findViewById(R.id.feedback_second_answer_view);
        checkQuestion(rubbleBtn, secondAnswerView);

        RadioButton poundBtn = (RadioButton) findViewById(R.id.egypt_answer_three_radio_button);
        TextView thirdAnswerView = (TextView) findViewById(R.id.feedback_third_answer_view);
        checkQuestion(poundBtn, thirdAnswerView);

        RadioButton pesoBtn = (RadioButton) findViewById(R.id.mexi_answer_two_radio_button);
        TextView fourthAnswerView = (TextView) findViewById(R.id.feedback_fourth_answer_view);
        checkQuestion(pesoBtn, fourthAnswerView);

        RadioButton ringgitBtn = (RadioButton) findViewById(R.id.malay_answer_two_radio_button);
        TextView fifthAnswerView = (TextView) findViewById(R.id.feedback_fifth_answer_view);
        checkQuestion(ringgitBtn, fifthAnswerView);

        RadioButton dirhamBtn = (RadioButton) findViewById(R.id.moroccan_answer_two_radio_button);
        TextView sixthAnswerView = (TextView) findViewById(R.id.feedback_sixth_answer_view);
        checkQuestion(dirhamBtn, sixthAnswerView);

        RadioButton bahtBtn = (RadioButton) findViewById(R.id.thai_answer_two_radio_button);
        TextView seventhAnswerView = (TextView) findViewById(R.id.feedback_seventh_answer_view);
        checkQuestion(bahtBtn, seventhAnswerView);

        EditText rupeeAnswer = findViewById(R.id.rupee_answer_view);
        checkQuestion8(rupeeAnswer);

        CheckBox answer_iran_checkbox = findViewById(R.id.answer_iran_checkbox);
        CheckBox answer_oman_checkbox = findViewById(R.id.answer_oman_checkbox);
        CheckBox answer_Yemen_checkbox = findViewById(R.id.answer_Yemen_checkbox);
        checkQuestion9(answer_iran_checkbox, answer_oman_checkbox, answer_Yemen_checkbox);


        TextView finalScore = (TextView) findViewById(R.id.final_score_view);
        finalScore.setText(createScoreCard(name, score));
        score = 0;
    }

    /**
     *
     * @param button checks if the right answer button is clicked
     * @param answerView displays the correct answer if wrong answer is selected
     */
    private void checkQuestion(RadioButton button, TextView answerView) {
        boolean isQuestionChecked = button.isChecked();
        if (isQuestionChecked) {
            score = score + 1;
        } else {
            answerView.setVisibility(View.VISIBLE);
        }
    }

    /**
     *
     * @checkQuestion8  checks answer for question number 8
     * @param rupeeAnswer gets text input as answer
     */
    private void checkQuestion8(EditText rupeeAnswer) {
        String answerNumber8 = rupeeAnswer.getText().toString();

        if (answerNumber8.equals("Rupee") || answerNumber8.equals("rupee")) {
            score = score + 1;
        } else {
            TextView eighthAnswerView = (TextView) findViewById(R.id.feedback_eighth_answer_view);
            eighthAnswerView.setVisibility(View.VISIBLE);
        }
    }

    /**
     * @checkQuestion9 gets checkbox input and checks answer for question number 9
     * @param answer_iran_checkbox checks if answer Iran is checked
     * @param answer_oman_checkbox checks if answer Oman is checked
     * @param answer_Yemen_checkbox checks if answer Yemen is checked
     */
    public void checkQuestion9(CheckBox answer_iran_checkbox,
                               CheckBox answer_oman_checkbox,
                               CheckBox answer_Yemen_checkbox) {
        boolean isCheckedIran = answer_iran_checkbox.isChecked();
        boolean isCheckedOman = answer_oman_checkbox.isChecked();
        boolean isCheckedYemen = answer_Yemen_checkbox.isChecked();
        if (isCheckedIran && isCheckedOman && isCheckedYemen) {
            score = score + 1;
        } else {
            TextView ninthAnswerView = (TextView) findViewById(R.id.feedback_ninth_answer_view);
            ninthAnswerView.setVisibility(View.VISIBLE);
        }

    }

    /**
     *
     * @param name gets the name of the user
     * @param score is the total score of the user
     * @return displays the score message
     */
    private String createScoreCard(String name, int score) {
        String scoreMessage = " Hi " + name + "!";
        scoreMessage += "\n Your Score is :" + score;
        if (score == 7) {
            Toast.makeText(getApplicationContext(),
                    "Congrats, You are a Currency expert!",
                    Toast.LENGTH_LONG)
                    .show();
        } else if (score < 7 && score >= 5) {
            Toast.makeText(getApplicationContext(),
                    "You are almost there!",
                    Toast.LENGTH_LONG)
                    .show();
        } else if (score <= 4) {
            Toast.makeText(getApplicationContext(),
                    "You will get there soon!",
                    Toast.LENGTH_LONG)
                    .show();
        }
        return scoreMessage;

    }

}