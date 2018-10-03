package com.example.dungtt.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText text;
    float so1, so2, kq;
    String toantu, stringOut = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.editKQ);
        int[] intBtn = {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5,
                R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9, R.id.btnCong,R.id.btnTru,R.id.btnNhan,
                R.id.btnChia,R.id.btnCham,R.id.btnBang,R.id.btnDel};

        for (int i:intBtn){
            View v = findViewById(i);
            v.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnDel:
                if (stringOut.length()>0)stringOut = stringOut.substring(0, stringOut.length()-1);
                text.setText(stringOut);
                break;
            case R.id.btnCong:
                so1 = Float.parseFloat(text.getText().toString());
                stringOut = "0";
                text.setText("0");
                toantu = "+";
                break;
            case R.id.btnTru:
                so1 = Float.parseFloat(text.getText().toString());
                stringOut = "0";
                text.setText("0");
                toantu = "-";
                break;
            case R.id.btnNhan:
                so1 = Float.parseFloat(text.getText().toString());
                stringOut = "0";
                text.setText("0");
                toantu = "*";
                break;
            case R.id.btnChia:
                so1 = Float.parseFloat(text.getText().toString());
                stringOut = "0";
                text.setText("0");
                toantu = "/";
                break;
            case R.id.btnBang:
                so2 = Float.parseFloat(text.getText().toString());
                if (toantu.equals("+")){
                    kq = so1 + so2;
                }
                if (toantu.equals("-")){
                    kq = so1 - so2;
                }
                if (toantu.equals("*")){
                    kq = so1 * so2;
                }
                if (toantu.equals("/")){
                    kq = so1 / so2;
                }
                stringOut = String.valueOf(kq);
                text.setText(stringOut);
                System.out.println(stringOut);
                break;
            default:
                if (stringOut.equals("0")){stringOut = "";};
                stringOut += ((TextView) view).getText().toString();
                text.setText(stringOut);
                Toast.makeText(this, stringOut, Toast.LENGTH_SHORT).show();
                break;

        }
//        text.setText(stringOut);
    }
}
