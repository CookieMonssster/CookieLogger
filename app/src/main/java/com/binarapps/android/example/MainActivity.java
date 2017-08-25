package com.binarapps.android.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.binarapps.android.cookielogger.AppContext;
import com.binarapps.android.cookielogger.CLog;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CLog.initialize(getApplicationContext(), new SendReportApi(), "klop");

        initializeComponents();
    }

    private void initializeComponents() {
        Button operationOne = (Button) findViewById(R.id.operation_one);
        operationOne.setOnClickListener(new ButtonClick(R.string.operation_one));
        Button operationTwo = (Button) findViewById(R.id.operation_two);
        operationTwo.setOnClickListener(new ButtonClick(R.string.operation_two));
        Button operationThree = (Button) findViewById(R.id.operation_three);
        operationThree.setOnClickListener(new ButtonClick(R.string.operation_three));
        Button operationFour = (Button) findViewById(R.id.operation_four);
        operationFour.setOnClickListener(new ButtonClick(R.string.operation_four));
        Button operationFive = (Button) findViewById(R.id.operation_five);
        operationFive.setOnClickListener(new ButtonClick(R.string.operation_five));
        Button operationSix = (Button) findViewById(R.id.operation_six);
        operationSix.setOnClickListener(new ButtonClick(R.string.operation_six));
        Button operationSeven = (Button) findViewById(R.id.operation_seven);
        operationSeven.setOnClickListener(new ButtonClick(R.string.operation_seven));
        Button operationEight = (Button) findViewById(R.id.operation_eight);
        operationEight.setOnClickListener(new ButtonClick(R.string.operation_eight));
        Button operationNine = (Button) findViewById(R.id.operation_nine);
        operationNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CLog.printSingleReport();
                CLog.sendSingleReport();
                CLog.sendGlobalReport();
            }
        });
    }

    private class ButtonClick implements View.OnClickListener {

        private int stringRes;

        private ButtonClick(int stringRes) {
            this.stringRes = stringRes;
        }

        @Override
        public void onClick(View v) {
            CLog.d(getString(stringRes));
        }
    }
}
