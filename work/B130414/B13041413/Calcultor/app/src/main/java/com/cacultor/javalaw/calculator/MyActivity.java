package com.cacultor.javalaw.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Stack;

public class MyActivity extends AppCompatActivity {


    Stack<Double> numStack = new Stack<>(); //使用栈来实现运算的优先级,定义用来保存数字的栈
    Stack<String> signStack = new Stack<>(); //定义运算符栈
    private StringBuffer number = new StringBuffer();
    //private TextView textViewProcess = (TextView) findViewById(R.id.process);   //textview to show the process
    //private TextView textViewResult = (TextView) findViewById(R.id.result); //textview to show the result
    private Boolean isCalculate = false;
    private Boolean isAutoClean = false;

    protected void numOnClick(View v) {

        Log.w("v.id", Integer.toString(v.getId()));
        autoClean();
        switch (v.getId()) {
            case R.id.zero:
                dealNum("0");
                break;
            case R.id.one:
                dealNum("1");
                break;
            case R.id.two:
                dealNum("2");
                break;
            case R.id.three:
                dealNum("3");
                break;
            case R.id.four:
                dealNum("4");
                break;
            case R.id.five:
                dealNum("5");
                break;
            case R.id.six:
                dealNum("6");
                break;
            case R.id.seven:
                dealNum("7");
                break;
            case R.id.eight:
                dealNum("8");
                break;
            case R.id.nine:
                dealNum("9");
                break;
            case R.id.dot:
                dealNum(".");
            default:
                break;
        }
    }

    protected void signOnClick(View v) {
        Log.e("signOnclick", Integer.toString(v.getId()));
        autoClean();
        switch (v.getId()) {
            case R.id.plus:
                dealSign("+");
                break;
            case R.id.minus:
                dealSign("-");
                break;
            case R.id.and:
                dealSign("x");
                break;
            case R.id.divide:
                dealSign("÷");
                break;
            case R.id.equal:
                dealSign("=");
                break;
            case R.id.radical:
                dealSign("√");
                break;
            default:
                break;
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        Button button0 = (Button) findViewById(R.id.zero);
        Button button1 = (Button) findViewById(R.id.one);
        Button button2 = (Button) findViewById(R.id.two);
        Button button3 = (Button) findViewById(R.id.three);
        Button button4 = (Button) findViewById(R.id.four);
        Button button5 = (Button) findViewById(R.id.five);
        Button button6 = (Button) findViewById(R.id.six);
        Button button7 = (Button) findViewById(R.id.seven);
        Button button8 = (Button) findViewById(R.id.eight);
        Button button9 = (Button) findViewById(R.id.nine);

        Button buttonDot = (Button) findViewById(R.id.dot);
        Button buttonPlus = (Button) findViewById(R.id.plus);
        Button buttonMinus = (Button) findViewById(R.id.minus);
        Button buttonAnd = (Button) findViewById(R.id.and);
        Button buttonDivide = (Button) findViewById(R.id.divide);
        Button buttonEqual = (Button) findViewById(R.id.equal);
        Button buttonRadical = (Button) findViewById(R.id.radical);
        Button buttonCE = (Button) findViewById(R.id.clean);
        Button buttonBackStep = (Button) findViewById(R.id.backStep);
        Button buttonChange = (Button) findViewById(R.id.change);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numOnClick(v);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numOnClick(v);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numOnClick(v);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numOnClick(v);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numOnClick(v);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numOnClick(v);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numOnClick(v);
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numOnClick(v);
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numOnClick(v);
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numOnClick(v);
            }
        });

        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numOnClick(v);
            }
        });

        buttonAnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOnClick(v);
            }
        });
        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOnClick(v);
            }
        });
        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOnClick(v);
            }
        });
        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOnClick(v);
            }
        });
        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOnClick(v);
            }
        });
        buttonRadical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOnClick(v);
            }
        });

        buttonCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clean();
            }
        });
        buttonChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change();
            }
        });
        buttonBackStep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backStep();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my, menu);
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

    protected void dealNum(String string) {
        Log.e("dealNum", "called");
        TextView textViewProcess = (TextView) findViewById(R.id.process);
        textViewProcess.append(string);
        number.append(string);
    }

    protected void dealSign(String string) {
        Log.e("dealSign", "called");
        TextView textViewProcess = (TextView) findViewById(R.id.process);
        textViewProcess.append(string); //将符号添加到运算过程中
        if (!number.toString().equals("")) {
            numStack.push(Double.parseDouble(number.toString())); //将数字字符串转换成数字后压入栈
        }
        //numStack.push(Double.parseDouble(number.toString())); //将数字字符串转换成数字后压入栈
        number.delete(0, number.length());
        cal();
        signStack.push(string); //将符号压入栈
        if (string.equals("x") || string.equals("÷") || string.equals("√")) {
            isCalculate = true;
        } else if (string.equals("=")) {
            equal();
        } else {
            isCalculate = false;
        }
    }

    protected void cal() {
        Log.e("cal", "called");
        if (isCalculate) {
            double secondNum = numStack.peek();
            Log.e("secondNum", Double.toString(secondNum));
            numStack.pop();
            double firstNum = 0;
            if (!numStack.isEmpty()) {

                firstNum = numStack.peek();
                Log.e("firstNum", Double.toString(firstNum));
                numStack.pop();
            }

            String sign = signStack.peek();
            double result = 0;

            switch (sign) {
                case "x":
                    result = firstNum * secondNum;
                    numStack.push(result);
                    signStack.pop();
                    break;
                case "÷":
                    result = firstNum / secondNum;
                    numStack.push(result);
                    signStack.pop();

                    break;
                case "+":
                    result = firstNum + secondNum;
                    numStack.push(result);
                    signStack.pop();
                    break;
                case "-":
                    result = firstNum - secondNum;
                    numStack.push(result);
                    signStack.pop();
                    break;
                case "√":
                    result = Math.sqrt(secondNum);
                    numStack.push(firstNum);
                    numStack.push(result);
                    signStack.pop();
                default:
                    break;
            }
//           if(Double.isInfinite(result) || Double.isNaN(result) ){
//               TextView textViewResult = (TextView) findViewById(R.id.result);
//               textViewResult.setText("ERROR");
//               isAutoClean = true;
//           }
        }
    }

    protected void equal() {
        Log.w("equal", "called");
        autoClean();
        if (signStack.peek().equals("=")) {
            signStack.pop();
        }
        while (!signStack.isEmpty()) {


            Log.e("signStack", signStack.toString());
            Log.e("numStack", numStack.toString());
            isCalculate = true;
            cal();
        }
        Log.w("equal", "cal() down");
        double result = 0;
        if (!numStack.isEmpty()) {
            result = numStack.peek();
            numStack.pop();
        }

        TextView textViewResult = (TextView) findViewById(R.id.result);
        if (Double.isInfinite(result) || Double.isNaN(result)) {
            // Log.e("errorString ","Yes");
            textViewResult.setText("错误");
        } else if (result == (int) result) {

            textViewResult.setText(Integer.toString((int) result));
        } else {
            textViewResult.setText(Double.toString(result));
        }
        isAutoClean = true;
    }

    protected void clean() {
        numStack.empty();
        signStack.empty();
        number.delete(0, number.length());
        isCalculate = false;
        TextView textViewProcess = (TextView) findViewById(R.id.process);
        TextView textViewResult = (TextView) findViewById(R.id.result);
        textViewProcess.setText(null);
        textViewResult.setText(null);
    }

    protected void change() {
        if (number.charAt(0) == '-') {
            number.replace(0, 1, "+");
        } else if (number.charAt(0) != '+') {
            number.insert(0, "-");
        } else if (number.charAt(0) == '+') {
            number.replace(0, 1, "-");
        }

        TextView textViewProcess = (TextView) findViewById(R.id.process);
        String processText = textViewProcess.getText().toString();
        if (processText.length() != 0) {
            textViewProcess.setText(processText.substring(0, processText.length() - number.length()) + number);
        }
    }

    protected void autoClean() {
        if (isAutoClean) {
            clean();
            isAutoClean = false;
        }
    }

    protected void backStep() {
        int oldLength = number.length();
        if (number.length() != 0) {
            number.deleteCharAt(number.length() - 1);
        }
        TextView textViewProcess = (TextView) findViewById(R.id.process);
        String processText = textViewProcess.getText().toString();
        if (processText.length() != 0) {
            textViewProcess.setText(processText.substring(0, processText.length() - oldLength) + number);

        }
    }
}

