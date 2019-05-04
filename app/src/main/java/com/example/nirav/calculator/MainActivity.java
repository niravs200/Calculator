package com.example.nirav.calculator;


import android.icu.text.UnicodeSetSpanner;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import java.lang.String;


public class MainActivity extends AppCompatActivity {

    String display = "";
    char operation;
    String first_value; //Stores value before operation
    String second_value; //Stores value after operation
    String memory = "0"; //Variable used to perform memory operations
    Boolean flag = false; //Used to remove sign, when performing calculation
    Boolean point_flag = false; //Used to stop more then one '.' from being used in a value
    Boolean replace_text = false; //After pressing equal Button used to replace displayed value with new value
    Button one,two,three,four,five,six,seven,eight,nine,zero;
    Button minus,plus,multiply,divide;
    Button point,clear,equal,plus_minus;
    Button mc,m_plus,m_minus,mr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Buttons Stored in Button variable for quick access
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        zero = findViewById(R.id.zero);
        minus = findViewById(R.id.minus);
        plus = findViewById(R.id.plus);
        multiply = findViewById(R.id.multiply);
        divide = findViewById(R.id.divide);
        point = findViewById(R.id.dot);
        clear = findViewById(R.id.Clean);
        equal = findViewById(R.id.equal);
        plus_minus = findViewById(R.id.plus_minus);
        mc = findViewById(R.id.mc);
        m_plus = findViewById(R.id.m_plus);
        m_minus = findViewById(R.id.m_minus);
        mr = findViewById(R.id.mr);

        //Adding digits to variable display and print it in text view
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check_whether_new_value cleans display if button is pressed after equal button
                check_whether_new_value();

                //Function allows digits until only 10
                check_digit_limit();
                display = display + "1";
                setDisplay();
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_whether_new_value();
                check_digit_limit();
                display = display + "2";
                setDisplay();
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_whether_new_value();
                check_digit_limit();
                display = display + "3";
                setDisplay();
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_whether_new_value();
                check_digit_limit();
                display = display + "4";
                setDisplay();
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_whether_new_value();
                check_digit_limit();
                display = display + "5";
                setDisplay();
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_whether_new_value();
                check_digit_limit();
                display = display + "6";
                setDisplay();
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_whether_new_value();
                check_digit_limit();
                display = display + "7";
                setDisplay();
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_whether_new_value();
                check_digit_limit();
                display = display + "8";
                setDisplay();
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_whether_new_value();
                check_digit_limit();
                display = display + "9";
                setDisplay();
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_whether_new_value();
                check_digit_limit();
                display = display + "0";
                setDisplay();
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //If there is no value on screen no computation performed
                if(display == "0" || display == "")
                {
                    return;
                }
                //Check if Previously any operation present in the screen and perform calculation if present
                check_previous_value();
                display = display + "+";
                //point_flag only allows only one '.'
                point_flag = false;
                setDisplay();
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //If there is no value on screen no computation performed
                if(display == "0" || display == "")
                {
                    return;
                }
                //Check if Previously any operation present in the screen and perform calculation if present
                check_previous_value();
                display = display + "-";
                //point_flag only allows only one '.'
                point_flag = false;
                setDisplay();
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //If there is no value on screen no computation performed
                if(display == "0" || display == "")
                {
                    return;
                }
                //Check if Previously any operation present in the screen and perform calculation if present
                check_previous_value();
                display = display + "*";
                //point_flag only allows only one '.'
                point_flag = false;
                setDisplay();
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //If there is no value on screen no computation performed
                if(display == "0" || display == "")
                {
                    return;
                }
                //Check if Previously any operation present in the screen and perform calculation if present
                check_previous_value();
                display = display + "/";
                //point_flag only allows only one '.'
                point_flag = false;
                setDisplay();
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display = "";
                //Allows point to be added
                point_flag = false;
                setDisplay();
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(display.length()==0)
                {
                    return;
                }
                check_previous_value();
                setDisplay();
                //Allows point to be added
                point_flag = false;
                //Allows printed value to be replaced if key pressed not operation
                replace_text = true;
            }
        });

        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //If no value no value present add 0
                if(display.length()==0 || display.charAt(display.length()-1)=='+' ||  display.charAt(display.length()-1)=='-' || display.charAt(display.length()-1)=='*' || display.charAt(display.length()-1)=='/')
                {
                    display = display + "0";
                }
                //If one '.' present not add more '.'
                if(point_flag)
                {
                    return;
                }
                display = display + ".";
                point_flag = true;
                setDisplay();
            }
        });

        //Clears value stored in Memory
        mc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                memory = "0.0";
            }
        });

        //Adds value of display to
        m_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                char temp = '\0';
                //If value is negative, store '-' temporarily to be added later
                if(display.charAt(0)=='-')
                {
                    temp = '-';
                }
                //Solve if operations present
                check_previous_value();
                display = temp + display;
                setDisplay();
                //Add value of display to memory
                Double num1 = Double.parseDouble(memory);
                Double num2 = Double.parseDouble(display);
                Double addition = num1 + num2;
                memory = Double.toString(addition);
            }
        });

        //Remove value of display from memory
        m_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                char temp = '\0';
                //If value is negative, store '-' temporarily to be added later
                if(display.charAt(0)=='-')
                {
                    temp = '-';
                }
                //Solve if operations present
                check_previous_value();
                display = temp + display;
                setDisplay();
                //Add value of display to memory
                Double num1 = Double.parseDouble(memory);
                Double num2 = Double.parseDouble(display);
                Double subtraction = num1 - num2;
                memory = Double.toString(subtraction);
            }
        });

        //Displays value of memory on screen
        mr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(display.length()>0) {
                    //If Last value of display is operator add memory value after operator for calculation
                    if (display.charAt(display.length() - 1) == '+' || display.charAt(display.length() - 1) == '-' || display.charAt(display.length() - 1) == '*' || display.charAt(display.length() - 1) == '/') {
                        if (memory.charAt(0) == '-' && display.contains("-")) {
                            display = display.substring(0, display.length() - 1) + "+" + memory.substring(1);
                            setDisplay();
                            return;
                        }
                        display = display + memory;
                    }
                }
                else
                {
                    //If no operator present directly display Memory value
                   display = memory;
                }
                setDisplay();
            }
        });

        //Toggle button to change sign of value
        plus_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //If no value present no need to change sign
                if(display.equals("") || display.equals("0"))
                {
                    return;
                }
                //If Operation is positive change it to negative
                if(display.charAt(display.length()-1)=='+')
                {
                    display = display.substring(0,display.length()-1);
                    display = display + "-";
                }
                //If Operation is negative change it to positive
                else if(display.charAt(display.length()-1)=='-')
                {
                    display = display.substring(0,display.length()-1);
                    display = display + "+";
                }
                //If Value after operation is changed, change operation '+' or '-'
                //If Value after operation is changed and operation is '*' or '/'; calculate value and change it's sign
                else if(display.contains("+") || display.contains("-") || display.contains("*") || display.contains("/"))
                {
                    int position;
                    if (display.contains("+")) {
                        position = display.indexOf("+");
                        display = display.substring(0,position) + '-' + display.substring(position+1,display.length());
                    } else if (display.contains("-")) {
                        position = display.indexOf("-");
                        display = display.substring(0,position) + '+' + display.substring(position+1,display.length());
                    }
                    else {
                        if (display.contains("*")) {
                            operation = '*';
                        } else if (display.contains("/")) {
                            operation = '/';
                        }
                        separate_values(operation);
                        calculate(first_value,second_value,operation);
                        display = "-" + display;
                    }
                }
                else
                {
                    //If first value, switch sign
                    if(display.charAt(0)=='-'){
                        display = display.substring(1,display.length());
                    }
                    else
                    {
                        display = "-" + display;
                    }
                }
                setDisplay();
            }
        });
    }

    //print display variable on screen
    private void setDisplay(){
        TextView displayView = findViewById(R.id.display);
        displayView.setText(display);
    }

    //Function checks if previously any operation is present in display String and perform calculation if present
    private void check_previous_value() {
        if(display.charAt(0)=='-')
        {
            //String reads all operation sign, so if '-' is present, program removes it, flag is initiated
            flag = true;
            display = display.substring(1,display.length());
        }
        if (display.contains("+") || display.contains("-") || display.contains("*") || display.contains("/")) {
            if(display.charAt(display.length()-1)=='+' || display.charAt(display.length()-1)=='-' || display.charAt(display.length()-1)=='*' || display.charAt(display.length()-1)=='/')
            {
                display = display.substring(0,display.length()-1);
                return;
            }
            //Stores operation
            if (display.contains("+")) {
                operation = '+';
            } else if (display.contains("-")) {
                operation = '-';
            } else if (display.contains("*")) {
                operation = '*';
            } else if (display.contains("/")) {
                operation = '/';
            }
            separate_values(operation);
            calculate(first_value,second_value,operation);
        }
    }

    //Operation are performed on first_value and second value
    private void calculate(String first_value,String second_value,char operation)
    {
        double  A = Double.parseDouble(first_value);
        double B = Double.parseDouble(second_value);
        Double result;
        switch (operation)
        {
            case '+':
                result = A + B;
                display = Double.toString(result);
                break;
            case '-':
                result = A - B;
                display =  Double.toString(result);
                break;
            case '*':
                result = A * B;
                display = Double.toString(result);
                break;
            case '/':
                //If divided by 0, replaced 0 with 1
                if(B==0.0)
                {
                    Toast.makeText(getApplicationContext(),"1 taken instead of 0",Toast.LENGTH_SHORT).show();
                    B = 1.0;
                }
                result = A / B;
                display = Double.toString(result);
                break;
            default:
                result = 0.0;
                display = Double.toString(result);
                break;
        }
    }

    //Separates first_value and second_value, using '+','-','*','/'
    private void separate_values(char o)
    {
        String S = String.valueOf(o);
        int position = display.indexOf(S);
        first_value = display.substring(0,position);
        second_value = display.substring(position+1,display.length());
        if(first_value.charAt(0)=='.')
        {
            first_value = "0" + first_value;
        }
        if(second_value.charAt(0)=='.')
        {
            second_value = "0" + second_value;
        }
        if(flag)
        {
            flag = false;
            first_value = "-" + first_value;
        }
    }

    //Allows only digits upto 10, if more then that replace it using value in double format
    private void check_digit_limit(){
        int count = 0;
        //Condition to check for limit of value after operation, If limit is crossed only remove value after operation
        if(display.contains("+") || display.contains("-") || display.contains("*") || display.contains("/"))
        {
            int position = 0;
            Double conversion;
            //Stores postion of operation
            if (display.contains("+")) {
                position = display.indexOf('+');
            } else if (display.contains("-")) {
                position = display.indexOf('-');
            } else if (display.contains("*")) {
                position = display.indexOf('*');
            } else if (display.contains("/")) {
                position = display.indexOf('/');
            }
            //If 'E' is present display is cleaned and Toast message is displayed
            if(display.substring(position).contains("E"))
            {
                Toast.makeText(getApplicationContext(),"Higher Value cannot be displayed",Toast.LENGTH_SHORT).show();
                display = display.substring(0,position);
                setDisplay();
                return;
            }
            for (int i = 0, len = display.substring(position+1).length(); i < len; i++) {
                if (Character.isDigit(display.charAt(i))) {
                    count++;
                }
            }
            if(count<10)
            {
                return;
            }
            conversion = (Double.parseDouble(display.substring(position+1)));
            display = display.substring(0,position+1) + Double.toString(conversion);
        }
        else
        {
            //If 'E' is present display is cleaned and Toast message is displayed
            if(display.contains("E"))
            {
                Toast.makeText(getApplicationContext(),"Higher Value cannot be displayed",Toast.LENGTH_SHORT).show();
                display = "";
                setDisplay();
                return;
            }
            for (int i = 0, len = display.length(); i < len; i++) {
                if (Character.isDigit(display.charAt(i))) {
                    count++;
                }
            }
            if(count<10)
            {
                return;
            }
            Double temp = Double.parseDouble(display);
            display = Double.toString(temp);
        }
    }
    //If flag present display is cleaned
    private void check_whether_new_value()
    {
        if(replace_text)
        {
            display = "";
            replace_text = false;
        }
    }
}



