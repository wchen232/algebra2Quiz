/**
    * Class representing a generic math problem
    * @author Warren Chen
    * @version 2.0
*/
import java.util.*;

public class Problem{
    String problem;
    String correctAns;
    //String[] WrongAnswerArray;
    //Random rand = new Random();

    //Constructor
    public Problem(String problem, String correctAns){
        this.problem = problem;
        this.correctAns = correctAns;
        //WrongAnswerArray = new String[3];
    }

    //Getters
    public String getProblem() {
        return problem;
    }

    public String getCorrectAns() {
        return correctAns;
    }

    //Testing
    /*@Override public String toString(){
        return "Problem:" + correctAns.getEquation() + "\n\nMultiple Choice Answers: " + answerArray[0] + ", " + answerArray[1] + ", " + answerArray[2] + ", " + answerArray[3] + "\n\nCorrect Answer = " + correctAns;
    }

    public static void main(String args[]){
        System.out.println(new Problem());
        System.out.println("\n\n"+new Problem());
        System.out.println("\n\n"+new Problem());
        System.out.println("\n\n"+new Problem());
        System.out.println("\n\n"+new Problem());
    }*/
}