import java.util.*;

public class Quadratics{
    int[] qArray;
    Random rand;
    //Constructor
    public Quadratics(){
        rand = new Random();
        this.qArray = new int[2];

        qArray[0] = 1 + rand.nextInt(9);
        qArray[1] = 1 + rand.nextInt(9);
    }

    public int[] getqArray() {
        return qArray;
    }

    @Override public String toString(){
        return qArray[0] + " or " + qArray[1];
    }

    public String getEquation(){
        return "x^2 + " + (qArray[0] + qArray[1]) + " + " + (qArray[0] * qArray[1]);
    }

    public String getEquation(int i){
        return i + "x^2 + " + (i*(qArray[0] + qArray[1])) + " + " + (i * qArray[0] * qArray[1]);
    }

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
        System.out.println(q2.getEquation(2));
        System.out.println(q3);
        System.out.println(q3.getEquation());
        System.out.println(q3.getEquation(2));
        System.out.println(q4);
        System.out.println(q4.getEquation());
        System.out.println(q4.getEquation(2));
    }
}