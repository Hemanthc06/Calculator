import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ScientificCalculatorUI extends JFrame implements ActionListener {

    private JTextField textField;
    private double num1, num2, result;
    private String operator = "";

    private CalculatorLogic logic = new CalculatorLogic();

    public ScientificCalculatorUI() {

        setTitle("Scientific Calculator");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.BOLD, 24));
        textField.setEditable(false);
        add(textField, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 4, 5, 5));

        String[] buttons = {
                "7","8","9","/",
                "4","5","6","*",
                "1","2","3","-",
                "0",".","=","+",
                "sin","cos","tan","log",
                "√","x²","xʸ","C"
        };

        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("Arial", Font.BOLD, 18));
            btn.addActionListener(this);
            panel.add(btn);
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.matches("[0-9.]")) {
            textField.setText(textField.getText() + command);
        }
        else if (command.equals("C")) {
            textField.setText("");
        }
        else if (command.equals("=")) {
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case "+": result = logic.add(num1, num2); break;
                case "-": result = logic.subtract(num1, num2); break;
                case "*": result = logic.multiply(num1, num2); break;
                case "/": result = logic.divide(num1, num2); break;
                case "xʸ": result = logic.power(num1, num2); break;
            }

            textField.setText(String.valueOf(result));
        }
        else if (command.equals("sin")) {
            num1 = Double.parseDouble(textField.getText());
            result = logic.sin(num1);
            textField.setText(String.valueOf(result));
        }
        else if (command.equals("cos")) {
            num1 = Double.parseDouble(textField.getText());
            result = logic.cos(num1);
            textField.setText(String.valueOf(result));
        }
        else if (command.equals("tan")) {
            num1 = Double.parseDouble(textField.getText());
            result = logic.tan(num1);
            textField.setText(String.valueOf(result));
        }
        else if (command.equals("log")) {
            num1 = Double.parseDouble(textField.getText());
            result = logic.log(num1);
            textField.setText(String.valueOf(result));
        }
        else if (command.equals("√")) {
            num1 = Double.parseDouble(textField.getText());
            result = logic.sqrt(num1);
            textField.setText(String.valueOf(result));
        }
        else if (command.equals("x²")) {
            num1 = Double.parseDouble(textField.getText());
            result = logic.square(num1);
            textField.setText(String.valueOf(result));
        }
        else {
            num1 = Double.parseDouble(textField.getText());
            operator = command;
            textField.setText("");
        }
    }

    public static void main(String[] args) {
        new ScientificCalculatorUI();
    }
}