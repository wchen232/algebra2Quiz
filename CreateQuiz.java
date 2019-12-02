/**
 * Class with UI to Create new Quizzes as txt files
 * @author Warren Chen
 * @version 2.0
 */
import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class CreateQuiz{
    String fileName;
    File fout;
    FileOutputStream fos;
    BufferedWriter bw;
    int qNum;

    public CreateQuiz(){
        new GenerateQuizFile();
    }
    public class TeacherQuestionGUI extends JFrame{
        JFrame Jr;
        JLabel l1;
        JLabel l2;
        JTextField txt1;
        JTextField txt2;
        JButton b1;
        JButton b2;
        int rec;

        public TeacherQuestionGUI(int i){
            rec = i;
            Jr = new JFrame();
            Jr.setLayout(new FlowLayout());
            l1 = new JLabel("Question");
            l2 = new JLabel("Answer");
            txt1 = new JTextField(50);
            txt2 = new JTextField(50);
            b1 = new JButton("Next");
            b2 = new JButton("Quit");
            Jr.add(l1);
            Jr.add(txt1);
            Jr.add(l2);
            Jr.add(txt2);
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
                    try{
                        if(rec > 1){
                            bw.write(txt1.getText());
                            bw.newLine();
                            bw.write(txt2.getText());
                            bw.newLine();
                            Jr.dispatchEvent(new WindowEvent(Jr, WindowEvent.WINDOW_CLOSING));
                            new TeacherQuestionGUI(rec-1);
                        }
                        else{
                            bw.write(txt1.getText());
                            bw.newLine();
                            bw.write(txt2.getText());
                            bw.newLine();
                            bw.close();
                            Jr.dispatchEvent(new WindowEvent(Jr, WindowEvent.WINDOW_CLOSING));
                            System.exit(0);
                        }
                    }
                    catch(IOException exc){ }
                }
                else if (e.getSource().equals(b2)) {
                    System.exit(0);
                }
            }
        }
    }
    public class GenerateQuizFile extends JFrame{
        JFrame Jr;
        JLabel l1;
        JTextField txt1;
        JLabel l2;
        JTextField txt2;
        JButton b1;
        JButton b2;

        public GenerateQuizFile(){
            Jr = new JFrame();
            Jr.setLayout(new FlowLayout());
            l1 = new JLabel("How Many Questions?");
            txt1 = new JTextField(50);
            l2 = new JLabel("Quiz Name?");
            txt2 = new JTextField(50);
            b1 = new JButton("Next");
            b2 = new JButton("Quit");
            Jr.add(l1);
            Jr.add(txt1);
            Jr.add(l2);
            Jr.add(txt2);
            Jr.add(b1);
            Jr.add(b2);
            GenHandler h2 = new GenHandler();
            b1.addActionListener(h2);
            b2.addActionListener(h2);
            Jr.setSize(720,480);
            Jr.setVisible(true);
        }
        class GenHandler implements ActionListener{
            public void actionPerformed(ActionEvent e){
                if (e.getSource().equals(b1)) {
                    try{
                        qNum = Integer.parseInt(txt1.getText());
                        fileName = txt2.getText() + ".txt";
                        fout = new File(fileName);
                        fos = new FileOutputStream(fout);
                        bw = new BufferedWriter(new OutputStreamWriter(fos));
                        new TeacherQuestionGUI(qNum);
                        Jr.dispatchEvent(new WindowEvent(Jr, WindowEvent.WINDOW_CLOSING));
                    } catch(IOException ex){ }
                }
                else if (e.getSource().equals(b2)) {
                    System.exit(0);
                }
            }
        }
    }
}