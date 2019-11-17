/**
    * Class representing a single quadratic equation using the 2 possible values of x
    * @author Warren Chen
    * @version 1.0
 */
import java.util.*;

public class Quadratics{
    int[] qArray;
    int neg;
    Random rand;

    //Constructor:
    public Quadratics(){
        rand = new Random();
        this.qArray = new int[2];
        //Generates two int values between 1 and 9
        qArray[0] = 1 + rand.nextInt(9);
        qArray[1] = 1 + rand.nextInt(9);
        //Changes 2nd value into a negative if neg randomly generates as 0
        neg = 0 + rand.nextInt(2);
        if(neg == 0){
            qArray[1] = (qArray[1] * -1);
        }
    }

    //Getter
    public int[] getqArray() {
        return qArray;
    }

    @Override public String toString(){
        return qArray[0] + " or " + qArray[1];
    }

    //Methods
    /**
        *@return The quadratic equation as a string
     */
    public String getEquation(){
        if(qArray[0]+qArray[1] < 0){
            return "x^2 - " + (-(qArray[0] + qArray[1])) + " - " + (-qArray[0] * qArray[1]);
        }
        else if(neg == 0){
            return "x^2 + " + (qArray[0] + qArray[1]) + " - " + (-qArray[0] * qArray[1]);
        }
        else{
            return "x^2 + " + (qArray[0] + qArray[1]) + " + " + (qArray[0] * qArray[1]);
        }
    }

    /**
        *@param An int representing the equation's coefficient
        *@return The quadratic equation as a string
     */
    public String getEquation(int i){
        if(qArray[0]+qArray[1] < 0){
            return i + "x^2 - " + (-i*(qArray[0] + qArray[1])) + " - " + (-i * qArray[0] * qArray[1]);
        }
        else if(neg == 0){
            return i + "x^2 + " + (i*(qArray[0] + qArray[1])) + " - " + (-i * qArray[0] * qArray[1]);
        }
        else {
            return i + "x^2 + " + (i*(qArray[0] + qArray[1])) + " + " + (i * qArray[0] * qArray[1]);
        }
    }

    /* Testing */
    public static void main(String args[]){
        Quadratics q1 = new Quadratics();
        Quadratics q2 = new Quadratics();
        Quadratics q3 = new Quadratics();
        Quadratics q4 = new Quadratics();
        System.out.println(q1);
        System.out.println(q1.getEquation());
        System.out.println(q1.getEquation(2));
        System.out.println(q2);
        System.out.println(q2.getEquation());
        System.out.println(q2.getEquation(3));
        System.out.println(q3);
        System.out.println(q3.getEquation());
        System.out.println(q3.getEquation(4));
        System.out.println(q4);
        System.out.println(q4.getEquation());
        System.out.println(q4.getEquation(5));
    }
}