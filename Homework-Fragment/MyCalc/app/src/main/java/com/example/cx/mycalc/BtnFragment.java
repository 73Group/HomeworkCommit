package com.example.cx.mycalc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;

import static com.example.cx.mycalc.R.layout.btn_fragment;
import static java.lang.Double.parseDouble;

/**
 * Created by cx on 17/1/18.
 */

public class BtnFragment extends Fragment {



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        return  inflater.inflate(btn_fragment, container, false);
    }


    TextView textview;
    Button button7,button8,button9,button6,button5,button4,button3,button2,button1,button0,buttondoc;
    Button buttonP,buttonS,buttonM,buttonD;
    Button buttonEqu,buttonAC,buttonPandS,buttonPer;
    private EditText calctext;//显示
    private Boolean clean = false;//判断是否清屏过
    private Boolean flag = true;//小数点个数控制
    private Boolean inputDone = false;// 标志是否按过计算按钮
    private Double num_a = null;
    private Double num_b = null;
    private String temp="";//计算符号
    public String add(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return String.valueOf(b1.add(b2));
    }
    public String sub(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return String.valueOf(b1.subtract(b2));
    }
    public String mul(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return String.valueOf(b1.multiply(b2));
    }
    public String div(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return String.valueOf(b1.divide(b2));
    }

    private void calculate() {
        if ("add".equals(temp)) {
            calctext.setText(add(num_a,num_b));
        } else if ("sub".equals(temp)) {
            calctext.setText(sub(num_a,num_b));
        } else if ("mul".equals(temp)) {
            calctext.setText(mul(num_a,num_b));
        } else if ("div".equals(temp)) {
            if (calctext.getText().toString().equals("0")) {

                calctext.setText("000000");
            } else {
                calctext.setText(div(num_a,num_b));
            }
        }
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        calctext = (EditText) getActivity().findViewById(R.id.calctext);

        //AC、＋—、％

        buttonAC = (Button) getActivity().findViewById(R.id.onBtnACClick);
        buttonAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calctext.setText("0");
                clean = true;
                flag = true;
                temp="";
                num_a = null;
                num_b = null;
            }
        });
        buttonPandS = (Button) getActivity().findViewById(R.id.onBtnPandSClick);
        buttonPandS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = calctext.getText().toString();
                if(s.charAt(0)=='-'){
                    calctext.setText(s.substring(1,s.length()));
                }
                else{
                    calctext.setText("-"+s);
                }
            }
        });
        buttonPer = (Button) getActivity().findViewById(R.id.onBtnPerClick);
        buttonPer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = calctext.getText().toString();
                Double d = parseDouble(s);
                d = d * 0.01;
                s = String.valueOf(d);
                calctext.setText(s);
            }
        });


        //加减乘除
        buttonP = (Button) getActivity().findViewById(R.id.onBtnPClick);
        buttonP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDone = true;

                if(calctext != null &&  temp.equals("") ){
                    num_a = Double.parseDouble(calctext.getText().toString());
                    temp = "add";
                    flag = true;

                }else{
                    num_b = Double.parseDouble(calctext.getText().toString());
                    calculate();
                    num_a = Double.parseDouble(calctext.getText().toString());
                    num_b = null;
                    temp = "add";
                    flag = true;
                }
            }
        });
        buttonS = (Button) getActivity().findViewById(R.id.onBtnSClick);
        buttonS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDone = true;
                if(calctext != null &&  temp.equals("") ){
                    num_a = Double.parseDouble(calctext.getText().toString());
                    temp = "sub";
                    flag = true;


                }else{
                    num_b = Double.parseDouble(calctext.getText().toString());
                    calculate();
                    num_a = Double.parseDouble(calctext.getText().toString());
                    temp = "sub";
                    flag = true;
                }
            }
        });
        buttonM = (Button) getActivity().findViewById(R.id.onBtnMClick);
        buttonM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDone = true;
                if(calctext != null &&  temp.equals("") ){
                    num_a = Double.parseDouble(calctext.getText().toString());
                    temp = "mul";
                    flag = true;


                }else{
                    num_b = Double.parseDouble(calctext.getText().toString());
                    calculate();
                    num_a = Double.parseDouble(calctext.getText().toString());
                    temp = "mul";
                    flag = true;
                }
            }
        });
        buttonD = (Button) getActivity().findViewById(R.id.onBtnDClick);
        buttonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDone = true;
                if(calctext != null &&  temp.equals("") ){
                    num_a = Double.parseDouble(calctext.getText().toString());
                    temp = "div";
                    flag = true;


                }else{
                    num_b = Double.parseDouble(calctext.getText().toString());
                    calculate();
                    num_a = Double.parseDouble(calctext.getText().toString());
                    temp = "div";
                    flag = true;
                }
            }
        });
        //等于
        buttonEqu = (Button) getActivity().findViewById(R.id.onBtnEquClick);
        buttonEqu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num_b = Double.parseDouble(calctext.getText().toString());
                calculate();
                num_a = Double.parseDouble(calctext.getText().toString());
                temp = "";
                flag = true;
                num_b = null;
                inputDone = true;
                clean = true;
            }
        });

        //数字键以及小数点
        button7 = (Button) getActivity().findViewById(R.id.onBtn7Click);
        button7.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(!inputDone || !flag){
                   if(calctext.getText().toString().equals("0")){
                      calctext.setText("7");
                      }else{
                            calctext.append("7");
                        }

                      }else{

                           calctext.setText("7");
                           inputDone = false;
                           clean = false;
               }
           }
       });
        button8 = (Button) getActivity().findViewById(R.id.onBtn8Click);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!inputDone || !flag){
                    if(calctext.getText().toString().equals("0")){
                        calctext.setText("8");
                    }else{
                        calctext.append("8");
                    }

                }else{

                    calctext.setText("8");
                    inputDone = false;
                    clean = false;
                }
            }
        });
        button9 = (Button) getActivity().findViewById(R.id.onBtn9Click);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!inputDone || !flag){
                    if(calctext.getText().toString().equals("0")){
                        calctext.setText("9");
                    }else{
                        calctext.append("9");
                    }

                }else{

                    calctext.setText("9");
                    inputDone = false;
                    clean = false;
                }
            }
        });



        button6 = (Button) getActivity().findViewById(R.id.onBtn6Click);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!inputDone || !flag){
                    if(calctext.getText().toString().equals("0")){
                        calctext.setText("6");
                    }else{
                        calctext.append("6");
                    }

                }else{

                    calctext.setText("6");
                    inputDone = false;
                    clean = false;
                }
            }
        });
        button5 = (Button) getActivity().findViewById(R.id.onBtn5Click);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!inputDone || !flag){
                    if(calctext.getText().toString().equals("0")){
                        calctext.setText("5");
                    }else{
                        calctext.append("5");
                    }

                }else{

                    calctext.setText("5");
                    inputDone = false;
                    clean = false;
                }
            }
        });
        button4 = (Button) getActivity().findViewById(R.id.onBtn4Click);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!inputDone || !flag){
                    if(calctext.getText().toString().equals("0")){
                        calctext.setText("4");
                    }else{
                        calctext.append("4");
                    }

                }else{

                    calctext.setText("4");
                    inputDone = false;
                    clean = false;
                }
            }
        });
        button3 = (Button) getActivity().findViewById(R.id.onBtn3Click);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!inputDone || !flag){
                    if(calctext.getText().toString().equals("0")){
                        calctext.setText("3");
                    }else{
                        calctext.append("3");
                    }

                }else{

                    calctext.setText("3");
                    inputDone = false;
                    clean = false;
                }
            }
        });
        button2 = (Button) getActivity().findViewById(R.id.onBtn2Click);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!inputDone || !flag){
                    if(calctext.getText().toString().equals("0")){
                        calctext.setText("2");
                    }else{
                        calctext.append("2");
                    }

                }else{

                    calctext.setText("2");
                    inputDone = false;
                    clean = false;
                }
            }
        });
        button1 = (Button) getActivity().findViewById(R.id.onBtn1Click);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!inputDone || !flag){
                    if(calctext.getText().toString().equals("0")){
                        calctext.setText("1");
                    }else{
                        calctext.append("1");
                    }

                }else{

                    calctext.setText("1");
                    inputDone = false;
                    clean = false;
                }
            }
        });

        button0 = (Button) getActivity().findViewById(R.id.onBtn0Click);
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!inputDone || !flag){
                    if(calctext.getText().toString().equals("0")){
                        calctext.setText("0");
                    }else{
                        calctext.append("0");
                    }

                }else{

                    calctext.setText("0");
                    inputDone = false;
                    clean = false;
                }
            }
        });


        buttondoc = (Button) getActivity().findViewById(R.id.onBtnDocClick);
        buttondoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!inputDone && flag){
                    if(calctext.getText().toString().equals("0")){
                        calctext.setText("0.");
                    }else{
                        calctext.append(".");
                    }

                }else{

                    calctext.setText("0.");
                    inputDone = false;
                    clean = false;
                }
                flag = false;
            }
        });





    }
}
