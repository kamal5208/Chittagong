package practice;

public class LearnLoop {
    public void whileLoop(int x){
        while (x<20) {
            System.out.println("value of X is:" +x);
            x++;
        }
    }
    public void forLoop(int a){
        for (int x = a; x<20; x++){
            System.out.println("value of x is :"  + x);
        }

    }
    public void doWhileLoop(int x){
        do{
            System.out.println("value of x is:"  + x);
            x++;
        }while (x<20);
    }

}