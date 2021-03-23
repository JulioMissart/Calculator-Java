package Course;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import static java.lang.Math.sqrt;

public class MainFrame extends JFrame implements ActionListener, KeyListener {

    // MyFrame is child class while JFrame is the super or parent class, import swing.
    // Basicamente declaramos un hijo de la clase JFrame ya definida en Java Swing, llamado MyFrame,
    // cuyos parametros estan definidos en un constructor vacío, así al llamar a esta clase la GUI sola.

    Border emptyBorder = BorderFactory.createEmptyBorder();

    ImageIcon logo = new ImageIcon("logo.png");

    // Keypad Buttons
    KeypadButton buttonMod, buttonRoot, buttonRaised, buttonOneDividedX, buttonCE, buttonC;
    KeypadButton buttonDelete, buttonDivide, buttonMultiply;
    KeypadButton buttonSub, buttonAdd;
    KeypadButton buttonNeg, buttonDecimate, buttonEquals;

    KeypadButton[] numberButtons = new KeypadButton[10];

    KeypadButton button = new KeypadButton("", 210, 180);


    JTextField screenTextfield, subScreenTextfield;
    double num1=0, num2=0, result=0;
    String operator, shorterResult, largerResult;
    Image icon = new BufferedImage(1,1,BufferedImage.TYPE_INT_ARGB_PRE);


    MainFrame() {

        // Declarations
        String mainFrameTitle = "Calculator";

        //-------------------------------------------------------------------------
        ImageIcon settingsImage = new ImageIcon("info.png"); // Declaro la imagen ícono
        Image image = settingsImage.getImage(); //Obtengo la imágen del ícono en un objeto de la clase Image
        Image newSettingsImage = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH); // Redimensiono la imagen en el objeto de la clase Image
        settingsImage = new ImageIcon(newSettingsImage); // Vuelvo a obtener el ImageIcon desde el objeto clase Image redimensionado.
        //-------------------------------------------------------------------------

        JLabel modeLabel = new JLabel( // Label con tres parametros (Text, Icon & Align). El align es tipo int.
                "Standard",
                null,
                SwingConstants.LEFT);
        modeLabel.setBounds(42, 0, 200, 40);
        modeLabel.setFont(new Font("MS Sans Serif", Font.BOLD, 16));


        JPanel panelTop = new JPanel();
        panelTop.setBounds(0, 0, 344, 40);
        panelTop.setBackground(new Color(210, 210, 210));
        panelTop.setLayout(null);

        JPanel panelScreen = new JPanel();
        panelScreen.setBounds(0, 40, 344, 120);
        panelScreen.setBackground(new Color(210, 210, 210));
        panelScreen.setLayout(null);

        JPanel panelKeypad = new JPanel();
        panelKeypad.setBounds(2, 160, 340, 370);
        panelKeypad.setBackground(new Color(210, 210, 210));
        panelKeypad.setLayout(new GridLayout(6, 4, 1, 1));



        screenTextfield = new JTextField("0");
        screenTextfield.setBounds(0,40,342,80);
        screenTextfield.setBorder(emptyBorder);
        screenTextfield.setHorizontalAlignment(SwingConstants.RIGHT);
        screenTextfield.setFont(new Font("MS Sans Serif", Font.BOLD, 45));
        screenTextfield.setBackground(new Color(210,210,210));
        screenTextfield.setEditable(false);

        subScreenTextfield = new JTextField("");
        subScreenTextfield.setBounds(0,0,342,40);
        subScreenTextfield.setBorder(emptyBorder);
        subScreenTextfield.setHorizontalAlignment(SwingConstants.RIGHT);
        subScreenTextfield.setFont(new Font("MS Sans Serif", Font.BOLD, 20));
        subScreenTextfield.setBackground(new Color(210,210,210));
        subScreenTextfield.setEditable(false);

        // Settings button
        button.setIcon(settingsImage);
        button.setSize(40, 40);
        button.addActionListener(this);

        //Keypad Rows
        // ROW 1
        buttonMod = new KeypadButton("%", 229, 204);
        buttonMod.addActionListener(this);
        buttonRoot = new KeypadButton("√", 229, 204);
        buttonRoot.addActionListener(this);
        buttonRaised = new KeypadButton("x²", 229, 204);
        buttonRaised.addActionListener(this);
        buttonOneDividedX = new KeypadButton("1/x", 229, 204);
        buttonOneDividedX.addActionListener(this);

        // ROW 2
        buttonCE = new KeypadButton("CE", 229, 204);
        buttonCE.addActionListener(this);
        buttonC = new KeypadButton("C", 229, 204);
        buttonC.addActionListener(this);
        buttonDelete = new KeypadButton("Delete", 229, 204);
        buttonDelete.addActionListener(this);
        buttonDivide = new KeypadButton("÷", 229, 204);
        buttonDivide.addActionListener(this);

        // ROW 3
        buttonMultiply = new KeypadButton("x", 229, 204);
        buttonMultiply.addActionListener(this);

        // ROW 4
        buttonSub = new KeypadButton("-", 229, 204);
        buttonSub.addActionListener(this);

        // ROW 5
        buttonAdd = new KeypadButton("+", 229, 204);
        buttonAdd.addActionListener(this);

        // ROW 6
        buttonNeg = new KeypadButton("(-)", 229, 204);
        buttonNeg.addActionListener(this);
        buttonDecimate = new KeypadButton(".", 229, 204);
        buttonDecimate.addActionListener(this);
        buttonEquals = new KeypadButton("=", 229, 204);
        buttonEquals.addActionListener(this);

        // Modifications
        this.setTitle(mainFrameTitle); // Set JFrame title.
        this.setIconImage(logo.getImage());
        this.setSize(360, 568); //Sets the x-dimension and y-dimension of our this.
        this.setResizable(false); // Prevent this from being resizable.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit out of application.
        this.setLayout(null);

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new KeypadButton(String.valueOf(i), 247, 204);
            numberButtons[i].addActionListener(this);
        }

        this.add(panelTop);
        this.add(panelScreen);
        this.add(panelKeypad);

        this.setBackground(Color.lightGray); // Change color of background. Can use new Color(RBG, RBH, RBG) or hexadecimals.
        panelTop.add(button);
        panelTop.add(modeLabel);


        panelScreen.add(screenTextfield);
        panelScreen.add(subScreenTextfield);

        panelKeypad.add(buttonMod);
        panelKeypad.add(buttonRoot);
        panelKeypad.add(buttonRaised);
        panelKeypad.add(buttonOneDividedX);
        panelKeypad.add(buttonCE);
        panelKeypad.add(buttonC);
        panelKeypad.add(buttonDelete);
        panelKeypad.add(buttonDivide);
        panelKeypad.add(numberButtons[7]);
        panelKeypad.add(numberButtons[8]);
        panelKeypad.add(numberButtons[9]);
        panelKeypad.add(buttonMultiply);
        panelKeypad.add(numberButtons[4]);
        panelKeypad.add(numberButtons[5]);
        panelKeypad.add(numberButtons[6]);
        panelKeypad.add(buttonSub);
        panelKeypad.add(numberButtons[1]);
        panelKeypad.add(numberButtons[2]);
        panelKeypad.add(numberButtons[3]);
        panelKeypad.add(buttonAdd);
        panelKeypad.add(buttonNeg);
        panelKeypad.add(numberButtons[0]);
        panelKeypad.add(buttonDecimate);
        panelKeypad.add(buttonEquals);


        this.addKeyListener(this);
        this.setVisible(true); // Make complete frame visible, doesn't work if it isn't at last line.
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        for( int i = 0; i < 10; i++) {
            if(e.getSource() == numberButtons[i]){
                if(screenTextfield.getText().equals("0")) {
                    screenTextfield.setText(String.valueOf(i));
                }else if (screenTextfield.getText().equals(String.valueOf(result))){
                    screenTextfield.setText(String.valueOf(i));
                    subScreenTextfield.setText("");
                }else {
                    screenTextfield.setText(screenTextfield.getText().concat(String.valueOf(i)));
                }
            }
        }

        if(e.getSource() == buttonAdd) {
            num1 = Double.parseDouble(screenTextfield.getText());
            operator = "+";
            subScreenTextfield.setText(num1 + " " + operator);
            screenTextfield.setText("0");
        }

        if(e.getSource() == buttonSub) {
            num1 = Double.parseDouble(screenTextfield.getText());
            operator = "-";
            subScreenTextfield.setText(num1 + " " + operator);
            screenTextfield.setText("0");
        }

        if(e.getSource() == buttonMultiply) {
            num1 = Double.parseDouble(screenTextfield.getText());
            operator = "x";
            subScreenTextfield.setText(num1 + " " + operator);
            screenTextfield.setText("0");
        }

        if(e.getSource() == buttonDivide) {
            num1 = Double.parseDouble(screenTextfield.getText());
            operator = "÷";
            subScreenTextfield.setText(num1 + " " + operator);
            screenTextfield.setText("0");
        }

        if(e.getSource() == buttonMod) {
            num1 = Double.parseDouble(screenTextfield.getText());
            operator = "%";
            subScreenTextfield.setText(num1 + " " + operator);
            screenTextfield.setText("0");
        }

        if(e.getSource() == buttonRoot) {
            String resultLarge, resultShort;
            num1 = Double.parseDouble(screenTextfield.getText());
            result = sqrt(num1);
            resultLarge = String.valueOf(result);
            if (resultLarge.length() > 12) {
                resultShort = resultLarge.substring(0,13);
                result = Double.parseDouble(resultShort);
            }

            subScreenTextfield.setText("√(" + num1 + ")");
            screenTextfield.setText(String.valueOf(result));
        }

        if(e.getSource() == buttonRaised){
            num1 = Double.parseDouble(screenTextfield.getText());
            result = Math.pow(num1, 2);
            subScreenTextfield.setText("sqr(" + num1 + ")");
            screenTextfield.setText(String.valueOf(result));
        }

        if(e.getSource() == buttonOneDividedX){
            num1 = Double.parseDouble(screenTextfield.getText());
            result = 1 / num1;
            subScreenTextfield.setText("1/(" + num1 + ")");
            screenTextfield.setText(String.valueOf(result));
        }


        if(e.getSource() == buttonNeg){
            double temp = Double.parseDouble(screenTextfield.getText());
            temp *= -1;
            screenTextfield.setText(String.valueOf(temp));
        }

        if(e.getSource() == button){
            JOptionPane.showMessageDialog(null, "Calculator 1.0.\n2021, Julio Missart.", "About", JOptionPane.INFORMATION_MESSAGE);
        }

        if(e.getSource() == buttonDecimate) {
            String resultText = screenTextfield.getText();
            boolean canDecimate = true;

            for (int i = 0; i < resultText.length(); i++) {
                if (resultText.charAt(i) == '.') {
                    canDecimate = false;
                    break;
                }
            }

            if (canDecimate){
                screenTextfield.setText(screenTextfield.getText().concat("."));
            }
        }

        if(e.getSource() == buttonCE) {
            screenTextfield.setText("0");
        }

        if(e.getSource() == buttonC) {
            screenTextfield.setText("0");
            subScreenTextfield.setText("");
        }

        if(e.getSource()==buttonDelete){
            if(!screenTextfield.getText().equals("0")) {
                if(!screenTextfield.getText().equals(String.valueOf(result))){
                    String string = screenTextfield.getText();
                    screenTextfield.setText("");
                    for (int i = 0; i < string.length() - 1; i++) {
                        screenTextfield.setText(screenTextfield.getText() + string.charAt(i));
                    }
                }
            }

            if(screenTextfield.getText().equals("")) {
                screenTextfield.setText("0");
            }
        }

        if(e.getSource() == buttonEquals) {
            num2 = Double.parseDouble(screenTextfield.getText());


            switch(operator) {
                case "+" -> result=num1+num2;
                case "-" -> result=num1-num2;
                case "x" -> result=num1*num2;
                case "÷" -> result=num1/num2;
                case "%" -> result=num1%num2;
            }

            largerResult = String.valueOf(result);
            if (largerResult.length() > 12) {
                shorterResult = largerResult.substring(0,13);
                result = Double.parseDouble(shorterResult);
            }
            screenTextfield.setText(String.valueOf(result));
            subScreenTextfield.setText("");
            num1=result;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }


    @Override
    public void keyReleased(KeyEvent e) {

    }
}