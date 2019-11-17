/**
    * Class representing a quadratic math problem using 4 quadratics classes
    * @author Warren Chen
    * @version 1.0
*/
import java.util.*;

public class Problem{
    Quadratics correctAns;
    Quadratics[] answerArray;
    Random rand = new Random();

    //Constructor
    public Problem(){
        this.answerArray = new Quadratics[4];
        //Fill array with Quadratics
        this.answerArray[0] = new Quadratics();
        this.answerArray[1] = new Quadratics();
        this.answerArray[2] = new Quadratics();
        this.answerArray[3] = new Quadratics();
        //Randomly Choose one as answer
        int corrInt = rand.nextInt(4);
        this.correctAns = answerArray[corrInt];
    }

    //Testing
    @Override public String toString(){
        return "Problem:" + correctAns.getEquation() + "\n\nMultiple Choice Answers: " + answerArray[0] + ", " + answerArray[1] + ", " + answerArray[2] + ", " + answerArray[3] + "\n\nCorrect Answer = " + correctAns;
    }

    public static void main(String args[]){
        System.out.println(new Problem());
        System.out.println("\n\n"+new Problem());
        System.out.println("\n\n"+new Problem());
        System.out.println("\n\n"+new Problem());
        System.out.println("\n\n"+new Problem());
    }
}