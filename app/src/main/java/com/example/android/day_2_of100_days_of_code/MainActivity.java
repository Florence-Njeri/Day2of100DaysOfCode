package com.example.android.day_2_of100_days_of_code;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    public static String EXTRA_MESSAGE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
//passwordd validation
    public static boolean isValidPassword(final String password) {
        Pattern pattern;
        Matcher matcher;
        String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();

    }
    /**
     * @method putExtra() adds edit text value to the intent
     * @method startActivity() starts an instance of the MAin2Activity specified in the intent constructor
     * NB intents carry data-types values as key-value pairs called extras
     * EXTRA_MESSAGE is a public constant because its key is used to retrieve the key value for the next activity
     * @param view is used to get the view being accessed
     */

    //Defines action to be taken when the submit button is clicked
    public void onSubmit(View view) {
        //Email Validation
        EditText editText = (EditText) findViewById(R.id.email);//Find email editText view by its id
        String email = editText.getText().toString();//gets the input text and converts it to a string then stores it in the variable email
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if(email.matches(emailPattern)){

            Toast.makeText(this,"Valid email address", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"Invalid Email!",Toast.LENGTH_SHORT).show();
        }
        //First intent to open up the second activity on submit and display the email input
        Intent emailIntent = new Intent(this, Main2Activity.class);//
        emailIntent.putExtra(EXTRA_MESSAGE, email);
        startActivity(emailIntent);

        //Second intent to display the password to second activity on submit
        Intent passwordIntent = new Intent(this, Main2Activity.class);//Intent constructor with the class name of the activity to be started
        EditText editText2 = (EditText) findViewById(R.id.password);//Find password editText view by its id
        String password = editText2.getText().toString();//gets the input text and converts it to a string then stores it in the variable email
        emailIntent.putExtra(EXTRA_MESSAGE, password);
        startActivity(passwordIntent);
    }


}
