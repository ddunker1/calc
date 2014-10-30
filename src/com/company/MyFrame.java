package com.company;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import javax.swing.*;

public class MyFrame extends JFrame {
    private String firstNum = "";
    private String secondNum = "";
    private String tmpSecondNum = "";
    private String tmpOper = "";
    private String prevScreen = "";
    boolean error = false;
    boolean letsAddNewNumber = false;
    boolean isAnswer = false;
    private final static String PLUS_OPER = "PLUS";
    private final static String MINUS_OPER = "MINUS";
    private final static String DIV_OPER = "DIV";
    private final static String MULT_OPER = "MULT";
    private final static String CANCEL_OPER = "CANCEL";
    private final static String EQUAL_OPER = "EQUAL";
    private final static String BACKSPACE_OPER = "BACKSPACE";
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
    private JButton bBack;  //back

    private MyFrame() {
        super("Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        createGUI();
        initListeners();
        keyDispatcher();
    }

    private void createGUI() {
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
        bBack = new JButton("<");

        /* !!! issue #3 */
        bSign.setEnabled(false);

        /* issue #9 */
        bOne.setFocusPainted(false);
        bTwo.setFocusPainted(false);
        bThree.setFocusPainted(false);
        bFour.setFocusPainted(false);
        bFive.setFocusPainted(false);
        bSix.setFocusPainted(false);
        bSeven.setFocusPainted(false);
        bEight.setFocusPainted(false);
        bNine.setFocusPainted(false);
        bDot.setFocusPainted(false);
        bZero.setFocusPainted(false);
        bMinus.setFocusPainted(false);
        bPlus.setFocusPainted(false);
        bMult.setFocusPainted(false);
        bDiv.setFocusPainted(false);
        bEqual.setFocusPainted(false);
        bSign.setFocusPainted(false);
        bCancel.setFocusPainted(false);
        bBack.setFocusPainted(false);

        JPanel screenPanel = new JPanel();
        screenPanel.setLayout(null);
        add(screenPanel);

        screenPanel.add(screen);
        screenPanel.add(bSeven);
        screenPanel.add(bEight);
        screenPanel.add(bNine);
        screenPanel.add(bDiv);
        screenPanel.add(bCancel);
        screenPanel.add(bFour);
        screenPanel.add(bFive);
        screenPanel.add(bSix);
        screenPanel.add(bMult);
        screenPanel.add(bOne);
        screenPanel.add(bTwo);
        screenPanel.add(bThree);
        screenPanel.add(bMinus);
        screenPanel.add(bZero);
        screenPanel.add(bDot);
        screenPanel.add(bSign);
        screenPanel.add(bPlus);
        screenPanel.add(bEqual);
        screenPanel.add(bBack);

        screen.setBounds(10, 10, 276, 65);
        /* 1st row */
        bSeven.setBounds(10, 80, 55, 55);
        bEight.setBounds(70, 80, 55, 55);
        bNine.setBounds(130, 80, 55, 55);
        bDiv.setBounds(190, 80, 45, 55);
        bCancel.setBounds(240, 80, 45, 55);
        /* 2nd row */
        bFour.setBounds(10, 140, 55, 55);
        bFive.setBounds(70, 140, 55, 55);
        bSix.setBounds(130, 140, 55, 55);
        bMult.setBounds(190, 140, 45, 55);
        bBack.setBounds(240, 140, 45, 55);
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

        screen.setSelectedTextColor(Color.black);
        screen.setSelectionColor(getForeground());
        screen.setEditable(false);
        screen.setHorizontalAlignment(JTextField.RIGHT);
        Font screenFont = new Font("Verdana", Font.TRUETYPE_FONT, 34);
        screen.setFont(screenFont);
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
        bBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pressedKey(BACKSPACE_OPER);
            }
        });
    }

    private void keyDispatcher() {
        KeyEventDispatcher keyEventDispatcher = new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(final KeyEvent e) {
                if (e.getID() == KeyEvent.KEY_PRESSED) {
                    if (!error) {
                        if (e.getKeyCode() == KeyEvent.VK_1 || e.getKeyCode() == KeyEvent.VK_NUMPAD1)
                            pressedKey("1");
                        if (e.getKeyCode() == KeyEvent.VK_2 || e.getKeyCode() == KeyEvent.VK_NUMPAD2)
                            pressedKey("2");
                        if (e.getKeyCode() == KeyEvent.VK_3 || e.getKeyCode() == KeyEvent.VK_NUMPAD3)
                            pressedKey("3");
                        if (e.getKeyCode() == KeyEvent.VK_4 || e.getKeyCode() == KeyEvent.VK_NUMPAD4)
                            pressedKey("4");
                        if (e.getKeyCode() == KeyEvent.VK_5 || e.getKeyCode() == KeyEvent.VK_NUMPAD5)
                            pressedKey("5");
                        if (e.getKeyCode() == KeyEvent.VK_6 || e.getKeyCode() == KeyEvent.VK_NUMPAD6)
                            pressedKey("6");
                        if (e.getKeyCode() == KeyEvent.VK_7 || e.getKeyCode() == KeyEvent.VK_NUMPAD7)
                            pressedKey("7");
                        if (e.getKeyCode() == KeyEvent.VK_8 || e.getKeyCode() == KeyEvent.VK_NUMPAD8)
                            pressedKey("8");
                        if (e.getKeyCode() == KeyEvent.VK_9 || e.getKeyCode() == KeyEvent.VK_NUMPAD9)
                            pressedKey("9");
                        if (e.getKeyCode() == KeyEvent.VK_0 || e.getKeyCode() == KeyEvent.VK_NUMPAD0)
                            pressedKey("0");
                        if (e.getKeyCode() == KeyEvent.VK_COMMA || e.getKeyCode() == KeyEvent.VK_PERIOD ||
                                e.getKeyCode() == KeyEvent.VK_DECIMAL)
                            pressedKey(".");
                        if (e.getKeyCode() == KeyEvent.VK_ADD)
                            pressedKey(PLUS_OPER);
                        if (e.getKeyCode() == KeyEvent.VK_MULTIPLY)
                            pressedKey(MULT_OPER);
                        if (e.getKeyCode() == KeyEvent.VK_DIVIDE)
                            pressedKey(DIV_OPER);
                        if (e.getKeyCode() == KeyEvent.VK_SUBTRACT)
                            pressedKey(MINUS_OPER);
                        if (e.getKeyCode() == KeyEvent.VK_ENTER)
                            pressedKey(EQUAL_OPER);
                    }
                    if (e.getKeyCode() == KeyEvent.VK_DELETE)
                        pressedKey(CANCEL_OPER);
                    if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
                        pressedKey(BACKSPACE_OPER);
                }
                return false;
            }
        };
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(keyEventDispatcher);
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
        String out;
        if (letsAddNewNumber) {
            screen.setText("");
            letsAddNewNumber = false;
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
        if (out.contains(".")) {
            int intPartLength = out.substring(0, out.indexOf(".")).length();
            int fractPartLength = out.substring(out.indexOf(".")).length();
            if (intPartLength + fractPartLength > 10) {
                if (intPartLength >= 10) {
                    out = out.substring(0, 10);
                    if (isAnswer) {
                        out = "e" + out + ".";
                        error = true;
                        isAnswer = false;
                    }
                } else {
                    out = out.substring(0, 11);
                }
            }
        } else if (out.length() > 11) {
            out = out.substring(0, 11);
            if (isAnswer) {
                out = "e" + out;
                error = true;
                isAnswer = false;
            }
        }
        if (out.contains("E")) {
            out = "e" + prevScreen;
            error = true;
        }
        screen.setText(out);
        prevScreen = screen.getText();
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
                letsAddNewNumber = true;
                isAnswer = true;
                display(parseDot0(doCalc(firstNum, secondNum, tmpOper)));
                firstNum = screen.getText();
            } else if (instruction.equals(CANCEL_OPER)) {
                clearParams();
            } else if (instruction.equals(BACKSPACE_OPER)) {
                backSpace();
            } else {
                letsAddNewNumber = true;
                firstNum = screen.getText();
                tmpOper = instruction;
                tmpSecondNum = "";
            }
        }
    }

    private String doCalc(String firstNum, String secondNum, String operation) {
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

    private boolean isOperation(String instruction) {
        boolean isOper = false;
        if (instruction.equals(EQUAL_OPER) || instruction.equals(CANCEL_OPER) || instruction.equals(PLUS_OPER) ||
                instruction.equals(MINUS_OPER) || instruction.equals(DIV_OPER) || instruction.equals(MULT_OPER) ||
                instruction.equals(BACKSPACE_OPER)) {
            isOper = true;
        }
        return isOper;
    }

    private void clearParams() {
        firstNum = "";
        secondNum = "";
        tmpSecondNum = "";
        error = false;
        screen.setText("0");
    }

    private void backSpace() {
        if (error) {
            error = false;
            screen.setText(screen.getText().substring(1));
        } else {
            if (screen.getText().length() > 1)
                screen.setText(screen.getText().substring(0, screen.getText().length() - 1));
            else screen.setText("0");
        }
    }

    public static void main(String[] args) {
        MyFrame app = new MyFrame();
        app.setBounds(0,0,295,325);
        app.setLocationRelativeTo(null);
        app.setResizable(false);
        app.setUndecorated(false);
        app.setVisible(true);
    }
}
