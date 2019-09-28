package com.example.currencyconversionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    double amountEntered;
    double convertedPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher_foreground);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        final EditText amount = (EditText) findViewById(R.id.txtAmount);
        final RadioButton radToeuro = (RadioButton) findViewById(R.id.radToEuro);
        final RadioButton radTopeso =(RadioButton) findViewById(R.id.radToPeso);
        final RadioButton radToCadollars = (RadioButton) findViewById(R.id.radToCADollars);
        final TextView result = (TextView) findViewById(R.id.txtResult);
        Button convert = (Button) findViewById(R.id.btnConvert);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amountEntered = Double.parseDouble(amount.getText().toString());
                DecimalFormat currency = new DecimalFormat("€###,###.##");
                DecimalFormat currency1 = new DecimalFormat("₱###,###.##");
                DecimalFormat currency2 = new DecimalFormat("C$###,###.##");


                if(radToeuro.isChecked( )) {
                    if (amountEntered <= 100000) {
                        convertedPrice = amountEntered * 0.91;
                        result.setText("The Converted Amount is " + currency.format(convertedPrice));
                    } else {
                        Toast.makeText(MainActivity.this,"Amount must be less than $100,000", Toast.LENGTH_LONG).show( );
                    }


                }
                if(radTopeso.isChecked( )) {
                    if (amountEntered <= 100000) {
                        convertedPrice = amountEntered * 19.69;
                        result.setText("The Converted Amount is " + currency1.format(convertedPrice));
                    } else {
                        Toast.makeText(MainActivity.this, "Amount must be less than $100,000", Toast.LENGTH_LONG).show();
                    }
                }
                if(radToCadollars.isChecked( )) {
                    if (amountEntered <= 100000) {
                        convertedPrice = amountEntered * 1.29;
                        result.setText("The Converted Amount is " + currency2.format(convertedPrice));
                    } else {
                        Toast.makeText(MainActivity.this, "Amount must be less than $100,000", Toast.LENGTH_LONG).show();
                    }
                }



            }
        });



    }
}
