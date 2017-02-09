package com.example.macgyver.numberconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize the view objects inside of the oncreate method
        final EditText numberInput = (EditText) findViewById(R.id.input_number);
        final EditText baseInput = (EditText) findViewById(R.id.input_base);
        final EditText newBaseInput = (EditText) findViewById(R.id.input_new_base);
        final TextView newNumber = (TextView) findViewById(R.id.num_display);
        Button create = (Button) findViewById(R.id.convert_button);

        /**
         * A method to set the listener for a button click. When pressed, the button will create a new numberconversion object,
         * the number will be converted, and if an error was thrown a text will be displayed. Otherwise, the new number will be displayed.
         */
        create.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String number = numberInput.getText().toString();
                String base = baseInput.getText().toString();
                String newBase = newBaseInput.getText().toString();

                //constructor for the number converting object
                NumberConversion converter = new NumberConversion(number, base, newBase);
                String convertedNum = converter.baseConvert();

                if (convertedNum == null) {
                    Toast toast = Toast.makeText(MainActivity.this, R.string.toast_error, Toast.LENGTH_LONG);
                    toast.show();
                }
                else {
                    newNumber.setText(convertedNum);
                }
            }
        });
    }
}
