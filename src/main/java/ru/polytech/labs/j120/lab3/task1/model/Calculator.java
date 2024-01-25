package ru.polytech.labs.j120.lab3.task1.model;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import static ru.polytech.labs.j120.lab3.task1.model.Operation.ADDITION;
import static ru.polytech.labs.j120.lab3.task1.model.Operation.DIVISION;
import static ru.polytech.labs.j120.lab3.task1.model.Operation.MULTIPLICATION;
import static ru.polytech.labs.j120.lab3.task1.model.Operation.SUBTRACTION;

public class Calculator extends JFrame {

    private final JLabel screen;

    private double register;

    private Operation operation;

    private boolean nextDigitResetsScreen;

    public Calculator() {
        super("My calculator");

        setBounds(1000, 500, 400, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        screen = new JLabel("0", SwingConstants.RIGHT);
        screen.setFont(screen.getFont().deriveFont(48.f));
        add(screen, BorderLayout.NORTH);

        JPanel p = new JPanel(new GridLayout(4, 4));
        p.add(createButton("7", e -> processDigit('7')));
        p.add(createButton("8", e -> processDigit('8')));
        p.add(createButton("9", e -> processDigit('9')));
        p.add(createButton("+", e -> processOperation(ADDITION)));

        p.add(createButton("4", e -> processDigit('4')));
        p.add(createButton("5", e -> processDigit('5')));
        p.add(createButton("6", e -> processDigit('6')));
        p.add(createButton("-", e -> processOperation(SUBTRACTION)));

        p.add(createButton("1", e -> processDigit('1')));
        p.add(createButton("2", e -> processDigit('2')));
        p.add(createButton("3", e -> processDigit('3')));
        p.add(createButton("*", e -> processOperation(MULTIPLICATION)));

        p.add(createButton("0", e -> processDigit('0')));
        p.add(createButton(".", e -> processDot()));
        p.add(createButton("C", e -> {
            register = 0;
            operation = null;
            screen.setText("0");
        }));
        p.add(createButton("/", e -> processOperation(DIVISION)));

        add(p, BorderLayout.CENTER);

        add(createButton("=", e -> processOperation(null)), BorderLayout.SOUTH);
    }

    private JButton createButton(String text, ActionListener l) {
        JButton btn = new JButton(text);
        btn.setFont(btn.getFont().deriveFont(36.f));
        btn.addActionListener(l);
        return btn;
    }

    /**
     * Обрабатывает ввод цифры
     *
     * @param digit цифра для обработки
     */
    private void processDigit(char digit) {
        String num = screen.getText();
        if(num.equals("0") || nextDigitResetsScreen) {
            num = Character.toString(digit);
            nextDigitResetsScreen = false;
        } else
            num += digit;
        screen.setText(num);
    }

    /**
     * Обрабатывает ввод точки (десятичного разделителя)
     */
    private void processDot() {
        String num;
        if(nextDigitResetsScreen) {
            num = "0";
            nextDigitResetsScreen = false;
        } else
            num = screen.getText();

        if(!num.contains(".")) {
            num += ".";
            screen.setText(num);
        }
    }

    /**
     * Обрабатывает операции (сложение, вычитание, умножение, деление)
     *
     * @param operation операция для выполнения
     */
    private void processOperation(Operation operation) {
        double d;
        try {
            d = Double.parseDouble(screen.getText());
        } catch(NumberFormatException e) {
            return;
        }
        boolean error = false;
        if(this.operation != null) {
            try {
                register = this.operation.operator.eval(register, d);
            } catch(ArithmeticException e) {
                error = true;
            }
        } else
            register = d;

        screen.setText(error ? "error" : Double.toString(register));
        this.operation = operation;
        nextDigitResetsScreen = true;
    }
}
