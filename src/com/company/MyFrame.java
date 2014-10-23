package com.company;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import javax.swing.*;

public class MyFrame extends JFrame {
    private String firstNum = "";
    private String secondNum = "";
    private String tmpSecondNum = "";
    private String tmpOper = "";
    boolean error = false;
    boolean isOperationButtonWasPressed = false;
    boolean isResult = false;

    private final static String PLUS_OPER = "PLUS";
    private final static String MINUS_OPER = "MINUS";
    private final static String DIV_OPER = "DIV";
    private final static String MULT_OPER = "MULT";
    private final static String CANCEL_OPER = "CANCEL";
    private final static String EQUAL_OPER = "EQUAL";
//    private final static String ERROR = "ERROR";

    private JTextField screen;
    private JButton bOne;   //1
    private JButton bTwo;   //2
    private JButton bThree; //3
    private JButton bFour;  //4
    private JButton bFive;  //5
    private JButton bSix;   //6
    private JButton bSeven; //7
    private JButton bEight; //8
    private JButton bNine;  //9
    private JButton bDot;   //,
    private JButton bZero;  //0
    private JButton bMinus; //-
    private JButton bPlus;  //+
    private JButton bMult;  //*
    private JButton bDiv;   ///
    private JButton bEqual; //=
    private JButton bSign;  //+/-
    private JButton bCancel;//C

    public MyFrame() {
        super("Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        createGUI();
        initListeners();
    }

    public void createGUI() {
        screen = new JTextField("0");
        bOne = new JButton("1");
        bTwo = new JButton("2");
        bThree = new JButton("3");
        bFour = new JButton("4");
        bFive = new JButton("5");
        bSix = new JButton("6");
        bSeven = new JButton("7");
        bEight = new JButton("8");
        bNine = new JButton("9");
        bDot = new JButton(",");
        bZero = new JButton("0");
        bMinus = new JButton("-");
        bPlus = new JButton("+");
        bMult = new JButton("*");
        bDiv = new JButton("/");
        bEqual = new JButton("=");
        bSign = new JButton("+/-");
        bCancel = new JButton("C");

        /* issue #3 */
        bSign.setEnabled(false);

        JPanel screenPanel = new JPanel(new FlowLayout());
        JPanel numPanel = new JPanel(new FlowLayout());

        screenPanel.setLayout(null);
        numPanel.setLayout(null);

        screenPanel.setBounds(0, 0, 295, 75);
        numPanel.setBounds(0, 0, 0, 0);//???

        add(screenPanel);
        add(numPanel);

        screen.setEditable(false);
        screen.setHorizontalAlignment(JTextField.RIGHT);
        Font screenFont = new Font("Verdana", Font.TRUETYPE_FONT, 34);
        screen.setFont(screenFont);

        screenPanel.add(screen);
        numPanel.add(bSeven);
        numPanel.add(bEight);
        numPanel.add(bNine);
        numPanel.add(bDiv);
        numPanel.add(bCancel);
        numPanel.add(bFour);
        numPanel.add(bFive);
        numPanel.add(bSix);
        numPanel.add(bMult);
        numPanel.add(bOne);
        numPanel.add(bTwo);
        numPanel.add(bThree);
        numPanel.add(bMinus);
        numPanel.add(bZero);
        numPanel.add(bDot);
        numPanel.add(bSign);
        numPanel.add(bPlus);
        numPanel.add(bEqual);

        screen.setBounds(10, 10, 276, 65);
        /* 1st row */
        bSeven.setBounds(10, 80, 55, 55);
        bEight.setBounds(70, 80, 55, 55);
        bNine.setBounds(130, 80, 55, 55);
        bDiv.setBounds(190, 80, 45, 55);
        bCancel.setBounds(240, 80, 45, 115);
        /* 2nd row */
        bFour.setBounds(10, 140, 55, 55);
        bFive.setBounds(70, 140, 55, 55);
        bSix.setBounds(130, 140, 55, 55);
        bMult.setBounds(190, 140, 45, 55);
        /* 3rd row */
        bOne.setBounds(10, 200, 55, 55);
        bTwo.setBounds(70, 200, 55, 55);
        bThree.setBounds(130, 200, 55, 55);
        bMinus.setBounds(190, 200, 45, 55);
        bEqual.setBounds(240, 200, 45, 115);
        /* 4th row */
        bZero.setBounds(10, 260, 55, 55);
        bDot.setBounds(70, 260, 55, 55);
        bSign.setBounds(130, 260, 55, 55);
        bPlus.setBounds(190, 260, 45, 55);

        /* disable selecting */
        screen.setSelectedTextColor(Color.black);
        screen.setSelectionColor(getForeground());
    }

    private void initListeners() {
            bOne.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (!error)
                        pressedKey("1");
                }
            });
            bTwo.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (!error)
                        pressedKey("2");
                }
            });
            bThree.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (!error)
                        pressedKey("3");
                }
            });
            bFour.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (!error)
                        pressedKey("4");
                }
            });
            bFive.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (!error)
                        pressedKey("5");
                }
            });
            bSix.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (!error)
                        pressedKey("6");
                }
            });
            bSeven.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (!error)
                        pressedKey("7");
                }
            });
            bEight.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (!error)
                        pressedKey("8");
                }
            });
            bNine.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (!error)
                        pressedKey("9");
                }
            });
            bZero.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (!error)
                        pressedKey("0");
                }
            });
            bDot.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (!error)
                        pressedKey(".");
                }
            });
            bSign.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (!error)
                        pressedKey("-");
                }
            });
            bDiv.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (!error)
                        pressedKey(DIV_OPER);
                }
            });
            bMult.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (!error)
                        pressedKey(MULT_OPER);
                }
            });
            bMinus.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (!error)
                        pressedKey(MINUS_OPER);
                }
            });
            bPlus.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (!error)
                        pressedKey(PLUS_OPER);
                }
            });
            bEqual.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (!error)
                        pressedKey(EQUAL_OPER);
                }
            });
        bCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pressedKey(CANCEL_OPER);
            }
        });
    }

    private String parseDot0(String str) {
        String integerPart;
        String fractionalPart;
        if (str.contains(".") && !str.contains("E")) {
            integerPart = str.substring(0, str.indexOf("."));
            fractionalPart = str.substring(str.indexOf("."));
            for (int i = fractionalPart.length() - 1; i != -1; i--) {
                if (fractionalPart.charAt(i) == '0') {
                    continue;
                } else {
                    fractionalPart = fractionalPart.substring(0, i + 1);
                    if (fractionalPart.charAt(i) == '.')
                        return integerPart;
                    return integerPart.concat(fractionalPart);
                }
            }
        }
        return str;
    }

    private void display(String instruction) {
        String out = "";
        if (!isOperationButtonWasPressed) {
            if (isResult) {
                isResult = false;
                screen.setText("");
            }
            if (!instruction.equals(".")) {
                if (!screen.getText().equals("0"))
                    out = screen.getText() + instruction;
                else out = instruction;
            } else {
                if (screen.getText().equals("")) {
                    out = "0.";
                } else if (!screen.getText().contains(".")) {
                    out = screen.getText() + instruction;
                } else {
                    out = screen.getText();
                }
            }
        } else {
            isOperationButtonWasPressed = false;
            if (instruction.equals("."))
                out = "0" + instruction;
            else out = instruction;
            isResult = false;
        }

        if (out.contains(".")) {
            int intPartLength = out.substring(0, out.indexOf(".")).length();
            int fractPartLength = out.substring(out.indexOf(".")).length();
            if (intPartLength + fractPartLength >= 12) {
                if (fractPartLength < 2 || intPartLength == 11) {
                    out = out.substring(0, 11);
                } else {
                    out = out.substring(0, 12);
                }
            }
        } else if (out.length() > 12) {
            out = "e" + out;
            out = out.substring(0, 12);
            error = true;
        }
        if (out.contains("E")) {
            out = "e";
            error = true;
        }
        screen.setText(out);
    }

    private void pressedKey(String instruction) {
        /* number button was pressed */
        if (!isOperation(instruction)) {
            display(instruction);
        }
        /* operation button was pressed */
        else {
            if (instruction.equals(EQUAL_OPER)) {
                secondNum = screen.getText();
                if (tmpSecondNum.length() == 0)
                    tmpSecondNum = secondNum;
                secondNum = tmpSecondNum;
                isOperationButtonWasPressed = true;
                display(parseDot0(doCalc(firstNum, secondNum, tmpOper)));
                firstNum = screen.getText();
                isResult = true;
            } else if (instruction.equals(CANCEL_OPER)) {
                clearParams();
            } else {
                isOperationButtonWasPressed = true;
                firstNum = screen.getText();
                tmpOper = instruction;
                tmpSecondNum = "";
            }
        }
    }

    public String doCalc(String firstNum, String secondNum, String operation) {
        String result = "";
            BigDecimal f = new BigDecimal(firstNum);
            BigDecimal s = new BigDecimal(secondNum);
        if (operation.equals(PLUS_OPER)) {
            f = f.add(s);
            result = String.valueOf(f);
        } else if (operation.equals(MINUS_OPER)) {
            f = f.subtract(s);
            result = String.valueOf(f);
        } else if (operation.equals(MULT_OPER)) {
            f = f.multiply(s);
            result = String.valueOf(f);
        } else if (operation.equals(DIV_OPER)) {
            BigDecimal bd3 = f.divide(s, 9, BigDecimal.ROUND_HALF_UP);
            result = String.valueOf(bd3);
        }
        return result;
    }

    public boolean isOperation(String instruction) {
        boolean isOper = false;
        if (instruction.equals(EQUAL_OPER) || instruction.equals(CANCEL_OPER) || instruction.equals(PLUS_OPER) ||
                instruction.equals(MINUS_OPER) || instruction.equals(DIV_OPER) || instruction.equals(MULT_OPER)) {
            isOper = true;
        }
        return isOper;
    }

    public void clearParams() {
        firstNum = "";
        secondNum = "";
        tmpSecondNum = "";
        error = false;
        screen.setText("0");
    }

    public static void main(String[] args) {
        MyFrame app = new MyFrame();
        app.setBounds(0,0,295,325);
        app.setVisible(true);
    }
}
