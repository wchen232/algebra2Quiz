/**
 * Class with UI to Take a quiz chosen by inputted filename
 * @author Warren Chen
 * @version 1.0
 */
import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

@SuppressWarnings("serial")
public class TakeQuiz{
    ArrayList<Problem> probAl;
    int initialSize;
    int score;

    //Constructor for main class
    public TakeQuiz(){
        new ChooseQuizUI();
        score = 0;
    }

    //Nested for UI to get filename of quiz from user.
    public class ChooseQuizUI extends JFrame{
        JLabel l1;
        JTextField txt1;
        JButton b1;
        JButton b2;
        JFrame Jr;
        String fileName;

        //Constructor for UI to get filename of quiz from user
        public ChooseQuizUI(){
            probAl = new ArrayList<Problem>();
            Jr = new JFrame();
            Jr.setLayout(new FlowLayout());
            l1 = new JLabel("What Quiz file would you like to use?");
            txt1 = new JTextField(50);
            b1 = new JButton("Choose");
            b2 = new JButton("Quit");
            Jr.add(l1);
            Jr.add(txt1);
            //Jr.add(l2);
            //Jr.add(txt2);
            Jr.add(b1);
            Jr.add(b2);
            Handler h1 = new Handler();
            b1.addActionListener(h1);
            b2.addActionListener(h1);
            Jr.setSize(720,480);
            Jr.setVisible(true);
        } //Handler reads the quiz file specified the Arraylist size will be the number of questions in the quiz
        class Handler implements ActionListener{
            public void actionPerformed(ActionEvent e){
                if(e.getSource().equals(b1)){
                    try{
                        fileName = txt1.getText();
                        Scanner scanner = new Scanner(new File(fileName));
                        while (scanner.hasNextLine()) {
                            String question = scanner.nextLine();
                            String answer = scanner.nextLine();
                            Problem nextP = new Problem(question,answer);
                            probAl.add(nextP);
                        }
                        initialSize = probAl.size();
                        Jr.dispatchEvent(new WindowEvent(Jr, WindowEvent.WINDOW_CLOSING));
                        new QuestionUI(probAl);
                    } catch(IOException exc){ }
                }
                else if (e.getSource().equals(b2)){
                    System.exit(0);
                }
            }
        }
    }

    //Nested class for UI for each quiz question
    public class QuestionUI extends JFrame{
        JLabel l1;
        JLabel l2;
        JTextField txt1;
        JButton b1;
        JButton b2;
        JFrame Jr;
        ArrayList<Problem> al;
        //Constructor that sets up the UI
        //Recursively called until arrlist has one problem object left
        public QuestionUI(ArrayList<Problem> arrlist){
            this.al = arrlist;
            Jr = new JFrame();
            Jr.setLayout(new FlowLayout());
            l1 = new JLabel(arrlist.get(0).getProblem());
            l2 = new JLabel("Answer");
            txt1 = new JTextField(50);
            b1 = new JButton("Submit/Next");
            b2 = new JButton("Quit");
            Jr.add(l1);
            Jr.add(l2);
            Jr.add(txt1);
            Jr.add(b1);
            Jr.add(b2);
            QHandler h1 = new QHandler();
            b1.addActionListener(h1);
            b2.addActionListener(h1);
            Jr.setSize(720,480);
            Jr.setVisible(true);
        }//UI Handler
        class QHandler implements ActionListener{
            public void actionPerformed(ActionEvent e){
                if(e.getSource().equals(b1)){
                    if(probAl.size() > 1){
                        if(txt1.getText().equals(probAl.get(0).getCorrectAns())){
                            score++;
                        }
                        probAl.remove(0);
                        Jr.dispatchEvent(new WindowEvent(Jr, WindowEvent.WINDOW_CLOSING));
                        new QuestionUI(probAl);
                    }
                    else{
                        if(txt1.getText().equals(probAl.get(0).getCorrectAns())){
                            score++;
                        }
                        Jr.dispatchEvent(new WindowEvent(Jr, WindowEvent.WINDOW_CLOSING));
                        new FinalScoreUI();
                    }
                }
                else if (e.getSource().equals(b2)){
                }
            }
        }
    }

    //Nested Class for the results UI
    public class FinalScoreUI extends JFrame{
        JLabel l1;
        TextField txt1;
        JButton b1;
        JButton b2;
        JFrame Jr;
        //Constructor that sets up the UI
        public FinalScoreUI(){
            Jr = new JFrame();
            Jr.setLayout(new FlowLayout());
            l1 = new JLabel(score + "/" + initialSize);
            b1 = new JButton("Start Over");
            b2 = new JButton("Quit");
            Jr.add(l1);
            //Jr.add(txt1);
            Jr.add(b1);
            Jr.add(b2);
            ScoreHandler h1 = new ScoreHandler();
            b1.addActionListener(h1);
            b2.addActionListener(h1);
            Jr.setSize(720,480);
            Jr.setVisible(true);
        }
        class ScoreHandler implements ActionListener{
            public void actionPerformed(ActionEvent e){
                if(e.getSource().equals(b1)){
                    Jr.dispatchEvent(new WindowEvent(Jr, WindowEvent.WINDOW_CLOSING));
                    new StartUI();
                }
                else if (e.getSource().equals(b2)){
                    System.exit(0);
                }
            }
        }
    }
}
