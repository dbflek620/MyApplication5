package com.example.com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText, editText2;
    Button  buttonadd, buttonsub, buttonmul, buttondiv;
    Button[] numButtons = new Button[10];
    Integer[] numBtnIDs = {R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9};
    TextView textView;
    String num1, num2;
    Integer result;
    int i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("그리드 레이아웃 계산기");

        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        buttonadd = (Button) findViewById(R.id.buttonadd);
        buttondiv = (Button) findViewById(R.id.buttondiv);
        buttonmul = (Button) findViewById(R.id.buttonmul);
        buttonsub = (Button) findViewById(R.id.buttonsub);

        textView = (TextView) findViewById(R.id.textView);

        buttonadd.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1 = editText.getText().toString();
                num2 = editText2.getText().toString();
                result = Integer.parseInt(num1) + Integer.parseInt(num2);
                textView.setText("계산결과: " + result.toString());
                return false;
            }
        });

        buttondiv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1 = editText.getText().toString();
                num2 = editText2.getText().toString();
                result = Integer.parseInt(num1) / Integer.parseInt(num2);
                textView.setText("계산결과: " + result.toString());
                return false;
            }
        });

        buttonsub.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1 = editText.getText().toString();
                num2 = editText2.getText().toString();
                result = Integer.parseInt(num1) - Integer.parseInt(num2);
                textView.setText("계산결과: " + result.toString());
                return false;
            }
        });

        buttonmul.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1 = editText.getText().toString();
                num2 = editText2.getText().toString();
                result = Integer.parseInt(num1) * Integer.parseInt(num2);
                textView.setText("계산결과: " + result.toString());
                return false;
            }
        });

        for (i = 0; i<numBtnIDs.length; i++){
            numButtons[i] = (Button) findViewById(numBtnIDs[i]);
        }

        for (i = 0; i<numBtnIDs.length; i++){
            final int index;
            index = i;

            numButtons[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (editText.isFocused() == true){
                        num1 = editText.getText().toString() + numButtons[index].getText().toString();
                        editText.setText(num1);
                    }
                    else if (editText2.isFocused() == true){
                        num2 = editText2.getText().toString() + numButtons[index].getText().toString();
                        editText2.setText(num2);
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "먼저 에디트 텍스트를 선택하세요", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
