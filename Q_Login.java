package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.company.T;

public class Q_Login implements ActionListener {

    JFrame frame = new JFrame();
    JLabel userLabel, rnlabel, passwordLabel, success;
    JTextField userText, rntf;
    JPasswordField passwordText;
    JButton btnLogin, btnReset;

    public static String L_name;

    void login(){
        frame.setSize(500,400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        userLabel = new JLabel("Username: ");
        userText = new JTextField(10);
        L_name = userText.getText();
        passwordLabel = new JLabel("Password: ");
        passwordText = new JPasswordField(10);

        /*rnlabel = new JLabel("Roll No.:");
        rnlabel.setBounds(10, 30, 80, 25);
        frame.add(rnlabel);

        //rntf = new JTextField(15);
        //userText.setBounds(10, 30, 165, 25);
        frame.add(rntf);*/

        btnLogin = new JButton("Login");
        btnLogin.setBackground(Color.cyan);
        btnLogin.addActionListener(this);

        btnReset = new JButton("Reset");
        btnReset.setBackground(Color.cyan);
        btnReset.addActionListener(this);

        success = new JLabel("");

        Panel panel = new Panel();
        panel.setBounds(50,10,400,400);
        panel.add(userLabel);
        panel.add(userText);
        panel.add(passwordLabel);
        panel.add(passwordText);
        panel.add(btnLogin);
        panel.add(btnReset);
        panel.add(success);
        frame.add(panel);

        frame.getContentPane().add(BorderLayout.CENTER,panel);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user = userText.getText();
        String password = passwordText.getText();
        System.out.println(user + ", " + password);

        String btnPress = ((JButton)e.getSource()).getText();
        if (btnPress == "Login"){
            if((user.length() >= 1) && (password.length()>=1)) {
                T obj = new T();
                obj.GUI();
                frame.dispose();
            }
            else {
                success.setText("Please enter valid details");
            }
        }
        else if (btnPress == "Reset") {
            userText.setText(null);
            passwordText.setText(null);
        }
    }

    public static void main(String[] args) {
        Q_Login qt = new Q_Login();
        qt.login();
    }

}