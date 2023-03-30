package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.company.Q_Login;
import com.company.T;

public class Q_End implements ActionListener {

    JFrame frF = new JFrame("Quiz End");
    JLabel lblUsername, lblScore, lblRemark;
    JButton btnTryAgain, btnExit;
    //Panel p = new Panel();
    T obj = new T();
    Q_Login qt = new Q_Login();
    int scr = obj.score;
    String sc = Integer.toString(obj.score);
    String name = qt.L_name;

    void End() {
        frF.setSize(500,250);
        frF.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frF.setLayout(null);

        lblUsername = new JLabel();
        lblUsername.setBounds(170,10,100,25);
        lblUsername.setText("Username: " + name);
        frF.add(lblUsername);

        lblScore = new JLabel();
        lblScore.setBounds(170,30,100,25);
        lblScore.setText("Score: " + sc + "/10");
        frF.add(lblScore);

        lblRemark = new JLabel();
        if(scr>=8 && scr<=10){
            lblRemark.setText("Excellent");
        }

        else if (scr>=5 && scr<8) {
            lblRemark.setText("Good Work");
        }

        else if (scr>2 && scr<5) {
            lblRemark.setText("Better luck next time");
        }

        else if (scr>=0 && scr<2) {
            lblRemark.setText("Try Again!!");
        }

        lblRemark.setBounds(170,50,100,25);
        frF.add(lblRemark);

        btnTryAgain = new JButton("Try Again");
        btnTryAgain.setBounds(110,100,100,30);
        btnTryAgain.addActionListener(this);
        frF.add(btnTryAgain);

        btnExit = new JButton("Exit");
        btnExit.setBounds(240,100,100,30);
        btnExit.addActionListener(this);
        frF.add(btnExit);

        frF.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String btnPress = ((JButton)e.getSource()).getText();
        if (btnPress == "Try Again") {
            qt.login();
            frF.dispose();
        }
        else if (btnPress == "Exit") {
            frF.dispose();
        }
    }

    public static void main(String[] args) {
        Q_End qe = new Q_End();
        qe.End();
    }
}
