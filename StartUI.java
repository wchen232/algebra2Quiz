/**
 * Class with UI to choose whether to create a new quiz or take a quiz.
 * @author Warren Chen
 * @version 1.0
 */

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class StartUI extends JFrame{
    JFrame Jr;
    JLabel l1;
    JLabel l2;
    JTextField txt1;
    JTextField txt2;
    JButton b1;
    JButton b2;

    public StartUI(){
        Jr = new JFrame();
        Jr.setLayout(new FlowLayout());
        b1 = new JButton("Take Quiz");
        b2 = new JButton("Create Quiz");
        Jr.add(b1);
        Jr.add(b2);
        Handler h1 = new Handler();
        b1.addActionListener(h1);
        b2.addActionListener(h1);
        Jr.setSize(720,480);
        Jr.setVisible(true);
    }
    class Handler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource().equals(b1)){
                Jr.dispatchEvent(new WindowEvent(Jr, WindowEvent.WINDOW_CLOSING));
                new TakeQuiz();
            }
            else if (e.getSource().equals(b2)){
                Jr.dispatchEvent(new WindowEvent(Jr, WindowEvent.WINDOW_CLOSING));
                new CreateQuiz();
            }
        }
    }
    public static void main(String args[]){
        new StartUI();
    }
}
