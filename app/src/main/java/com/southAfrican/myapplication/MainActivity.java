package com.southAfrican.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edID;
    Button btnButton;
    TextView tvResults;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edID = findViewById(R.id.etID);
        btnButton = findViewById(R.id.btnSubmit);
        tvResults = findViewById(R.id.tvResults);

        tvResults.setVisibility(View.GONE);
        btnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idNumber = edID.getText().toString().trim();

                String dob = idNumber.substring(0, 6);

//                int gender = idNumber.charAt(6) - '0';
                int gender = Integer.parseInt(Character.toString(idNumber.charAt(6)));
                String sGender = "";
                if (gender >= 5) {
                    sGender = getString(R.string.male);
                } else {
                    sGender = getString(R.string.female);
                }
                char isCitizen = idNumber.charAt(10);
                String sIsCitizen = "";
                if (isCitizen == '0') {
                    sIsCitizen = getString(R.string.citizen);
                } else if (isCitizen == '1') {
                    sIsCitizen = getString(R.string.permanent_resident);
                } else {
                    sIsCitizen = "Unknown Nationality";
                }

                tvResults.setText(getString(R.string.dob) + dob + getString(R.string.newline) +
                                  getString(R.string.gender) + sGender + getString(R.string.newline) +
                                  getString(R.string.nationality) + sIsCitizen);

                tvResults.setVisibility(View.VISIBLE);
            }
        });
    }


}