package practice;


import java.util.Scanner;

public class LearnTerminal {
    public void getInputFromUsers(){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your name:       ");
        String xyz = input.nextLine();
        System.out.println("My name is:  " + xyz);

        System.out.print("Enter your salary    ");
        int salary = input.nextInt();
        System.out.println("My salary is:"   + salary);
    }


}
