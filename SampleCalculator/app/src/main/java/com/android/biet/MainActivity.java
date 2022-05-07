package com.android.biet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    final String DEFAULT_DISPLAY = "0";
    StringBuffer temp = new StringBuffer(DEFAULT_DISPLAY);
    TextView displayText;
    boolean isFirstButtonClick = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayText = findViewById(R.id.display_text);
        displayText.setText(temp.toString());
    }

    public void buttonClicked(View view) {
        if(isFirstButtonClick)
        {
            temp = new StringBuffer();
            isFirstButtonClick = false;
        }
        switch (view.getId())
        {
            case R.id.button0:
                    temp.append("0");
                break;
            case R.id.button1:
                    temp.append("1");
                break;
            case R.id.button2:
                temp.append("2");
                break;
            case R.id.button3:
                temp.append("3");
                break;
            case R.id.button4:
                temp.append("4");
                break;
            case R.id.button5:
                temp.append("5");
                break;
            case R.id.button6:
                temp.append("6");
                break;
            case R.id.button7:
                temp.append("7");
                break;
            case R.id.button8:
                temp.append("8");
                break;
            case R.id.button9:
                temp.append("9");
                break;
            case R.id.button_div:
                    temp.append("/");
                break;
            case R.id.button_mul:
                temp.append("*");
                break;
            case R.id.button_sub:
                temp.append("-");
                break;
            case R.id.button_add:
                temp.append("+");
                break;
            case R.id.button_dot:
                temp.append(".");
                break;
            case R.id.button_equal:
                try {
                    temp = new StringBuffer().append(EvaluateString.evaluate(temp.toString()));
                }catch (UnsupportedOperationException e)
                {
                    Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }
        displayText.setText(temp.toString());
    }

    public void clearSpace(View view) {
        Toast.makeText(this, "Clicked on Clear", Toast.LENGTH_SHORT).show();
        temp = new StringBuffer(DEFAULT_DISPLAY);
        displayText.setText(temp.toString());
        isFirstButtonClick = true;
    }

}