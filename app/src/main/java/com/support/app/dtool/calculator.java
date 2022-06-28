package com.support.app.dtool;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class calculator extends AppCompatActivity {

    Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_0;
    Button btn_C, btn_poi, btn_equ, btn_plu, btn_min, btn_di, btn_mul, btn_Per, btn_Del, btn_bra;

    TextView inPutTxt, outPutTxt;
    String data;
    String operation;
    String del;
    boolean checkBracket = false;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);

        getWindow().setStatusBarColor(ContextCompat.getColor(calculator.this,R.color.colorAccent));


        outPutTxt = findViewById(R.id.outPutTxt);
        inPutTxt = findViewById(R.id.inPutTxt);

        btn_0 = findViewById(R.id.btn_0);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);

        btn_poi = findViewById(R.id.btn_poi);
        btn_equ = findViewById(R.id.btn_equ);
        btn_C = findViewById(R.id.btn_C);
        btn_di = findViewById(R.id.btn_di);
        btn_plu = findViewById(R.id.btn_plu);
        btn_min = findViewById(R.id.btn_min);
        btn_mul = findViewById(R.id.btn_mul);
        btn_Per = findViewById(R.id.btn_Per);
        btn_Del = findViewById(R.id.btn_Del);
        btn_bra = findViewById(R.id.btn_bra);


        ///input first operand.

        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inPutTxt.getText().toString();
                inPutTxt.setText(data + "0");
            }
        });

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inPutTxt.getText().toString();
                inPutTxt.setText(data + "1");
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inPutTxt.getText().toString();
                inPutTxt.setText(data + "2");
            }
        });


        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inPutTxt.getText().toString();
                inPutTxt.setText(data + "3");
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inPutTxt.getText().toString();
                inPutTxt.setText(data + "4");
            }
        });

        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inPutTxt.getText().toString();
                inPutTxt.setText(data + "5");
            }
        });

        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inPutTxt.getText().toString();
                inPutTxt.setText(data + "6");
            }
        });

        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inPutTxt.getText().toString();
                inPutTxt.setText(data + "7");
            }
        });

        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inPutTxt.getText().toString();
                inPutTxt.setText(data + "8");
            }
        });

        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inPutTxt.getText().toString();
                inPutTxt.setText(data + "9");
            }
        });


        ///input operator.

        btn_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inPutTxt.setText("");
                outPutTxt.setText("");
            }
        });

        btn_poi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inPutTxt.getText().toString();
                inPutTxt.setText(data + ".");
            }
        });

        btn_plu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inPutTxt.getText().toString();
                inPutTxt.setText(data + "+");
                operation = "+";
            }
        });

        btn_min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inPutTxt.getText().toString();
                inPutTxt.setText(data + "-");
                operation = "-";
            }
        });

        btn_di.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inPutTxt.getText().toString();
                inPutTxt.setText(data + "/");
                operation = "/";
            }
        });

        btn_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inPutTxt.getText().toString();
                inPutTxt.setText(data + "×");
                operation = "*";
            }
        });

        btn_Per.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inPutTxt.getText().toString();
                inPutTxt.setText(data + "%");
                operation = "%";
            }
        });

        btn_Del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                del = null;
                if(inPutTxt.getText().length()>0){
                    StringBuilder stringBuilder = new StringBuilder(inPutTxt.getText());
                    stringBuilder.deleteCharAt(inPutTxt.getText().length()-1);
                    del = stringBuilder.toString();
                    inPutTxt.setText(del);
                }
            }
        });

        btn_bra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkBracket){
                    data = inPutTxt.getText().toString();
                    inPutTxt.setText(data + ")");
                    checkBracket = false;
                }else{
                    data = inPutTxt.getText().toString();
                    inPutTxt.setText(data + "(");
                    checkBracket = true;
                }

            }
        });


        btn_equ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inPutTxt.getText().toString();

                data = data.replaceAll("×","*");
                data = data.replaceAll("%","/100");
                data = data.replaceAll("÷","/");

                Context rhino = Context.enter();

                rhino.setOptimizationLevel(-1);

                String res = "";

                try {
                    Scriptable scriptable = rhino.initStandardObjects();
                    res = rhino.evaluateString(scriptable,data,"javascript",1,null).toString();
                }catch (Exception e){
                    res="0";
                }

                outPutTxt.setText(res);
            }
        });

    }
}