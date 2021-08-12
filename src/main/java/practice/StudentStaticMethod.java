package practice;

public class StudentStaticMethod {
    int a;
    static int b;
    StudentStaticMethod(){
        b++;
    }
    public void showData(){
        System.out.println("Value of A is: " +a);
        System.out.println("Value of B is:" +b);
    }



}
