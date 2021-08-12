package practice;

import java.util.Random;

public class LearnMath {
    public void learnMath() {
        Random rand = new Random();

        int rand_value1 = rand.nextInt(1000);
        int rand_value2 = rand.nextInt(1000);

        System.out.println("random number is:" + rand_value1);
        System.out.println("Random number is:" + rand_value2);

        float rand_float1 = rand.nextFloat();
        float rand_float2 = rand.nextFloat();
        System.out.println("random float number is:" +rand_float1);
        System.out.println("Random float number is:" + rand_float2);

        double rand_double1 = rand.nextDouble();
        double rand_double2 = rand.nextDouble();
        System.out.println("random double number is:" +rand_double1);
        System.out.println("Random float number is:" + rand_double2);
}

public void learnMathRound(){
        double num1 = 74.57;
        System.out.println(Math.round(num1));
        float num2 = 1223.534555f;
        System.out.println(Math.round(num2));

}

public void learnMax(int a, int b){
        System.out.println(Math.max(a,b));
}

public void learMin(int a, int b){
        System.out.println(Math.min(a,b));
}
}
