package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import com.company.Q_End;

public class T implements ActionListener {
    public static void main(String[] args) {
        T obj = new T();
        obj.GUI();
    }

    DataHandler Dh = new DataHandler();
    public int score ;

    JFrame F_main = new JFrame();
    JLabel lblQn, lblQs, lblYc;
    JTextField tfAns;
    JButton bPrev, bNxt, bSub, bEq;

    public void GUI(){
        F_main.setTitle("QUIZ");
        F_main.setSize(800,400);
        F_main.setLayout(null);
        F_main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        lblQn = new JLabel("Question No. 1");
        lblQn.setBounds(10,10,100,50);
        F_main.add(lblQn);

        lblQs = new JLabel(Dh.current());
        lblQs.setBounds(10,50,500,70);
        F_main.add(lblQs);

        lblYc = new JLabel("Your Choice: ");
        lblYc.setBounds(10,250,100,50);
        F_main.add(lblYc);

        tfAns = new JTextField(10);
        tfAns.setBounds(100,265,100,25);
        F_main.add(tfAns);

        bSub = new JButton("Submit");
        bSub.setBounds(225,265,150,25);
        //bSub.setBackground(Color.green);
        bSub.setBackground(Color.getHSBColor(26,57,14));
        bSub.addActionListener(this);
        F_main.add(bSub);

        bPrev = new JButton("Previous");
        bPrev.setBounds(100,300,150,50);
        bPrev.setBackground(Color.cyan);
        bPrev.addActionListener(this);
        F_main.add(bPrev);

        bNxt = new JButton("Next");
        bNxt.setBounds(300,300,150,50);
        bNxt.setBackground(Color.cyan);
        bNxt.addActionListener(this);
        F_main.add(bNxt);

        bEq = new JButton("End Quiz");
        bEq.setBounds(600,300,150,50);
        //bEq.setBackground(Color.pink);
        bEq.setBackground(Color.getHSBColor(60,17,44));
        //bEq.setBackground(Color.getHSBColor(27,55,60));
        bEq.addActionListener(this);
        F_main.add(bEq);

        F_main.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String btnClicked = ((JButton)e.getSource()).getText();
        if (btnClicked == "Submit") {
            if(Dh.checkAns(tfAns.getText())) {
                score++;
            }
            tfAns.setText(null);
        }

        else if (btnClicked == "Previous") {
            tfAns.setText(null);
            lblQn.setText("Question No. " + (Dh.counter));
            lblQs.setText(Dh.prev());
        }

        else if (btnClicked == "Next") {
            tfAns.setText(null);
            lblQn.setText("Question No. " + (Dh.counter + 2));
            lblQs.setText(Dh.next());
        }

        else if (btnClicked == "End Quiz") {
            //lblQn.setText(null);
            //lblYc.setText(null);
            //lblQs.setText("Your score: " + Dh.score + "/" + "10");

            Quiz_End qe = new Quiz_End();
            qe.End();
            F_main.dispose();
        }
    }
}

class DataHandler {
    public int counter;
    public ArrayList<String> que, ans;
    //public int score = 0;
    public DataHandler(){
        que = new ArrayList<String>();
        que.add("Choose the odd man out:        A. While    B. for    C. do-while     D. String");
        que.add("What is JAVA?      A. Programming Language     B. Address      C.Name      D. Number");
        que.add("AWT is used for?       A. Notifications       B. GUI in Java      C. Display     D. Pop ups");
        que.add("Choose the odd man out:    A. Python   B. C++      C. Java     D. Method");
        que.add("Swing is built on top of AWT in java?      A. True       B. False");
        que.add("India's capital is?        A. Mumbai       B. Chennai      C. Hyderabad    D. New Delhi");
        que.add("5 + 7 is       A. 8       B. 23       C. 12       D. 50");
        que.add("What is Valorant?      A. VideoGame      B. A dish      C. A language      D. Place");
        que.add("A normal year has how many days?       A. 509     B. 365        C. 400       D. 120");
        que.add("10 + 15 is     A. 25        B. 12        C. 90        D. 53");

        ans = new ArrayList<String>();
        ans.add("D");
        ans.add("A");
        ans.add("B");
        ans.add("D");
        ans.add("A");
        ans.add("D");
        ans.add("C");
        ans.add("A");
        ans.add("B");
        ans.add("A");
    }

    public String next(){
        counter++;
        if (counter == 10){
            return "Quiz Over!!!    Please press End Quiz to see your score";
        }
        return que.get(counter);
    }

    public String prev() {
        counter--;
        if (counter == -1){
            counter = 9;
        }
        return que.get(counter);
    }

    public String current() {return que.get(counter);}

    public boolean checkAns(String userAns) {
        if (userAns.equalsIgnoreCase(ans.get(counter))) {
            //score++;
            return true;
        }
        else {
            return false;
        }
    }
}

class Quiz_End implements ActionListener {

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
}
