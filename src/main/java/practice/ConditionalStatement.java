package practice;

public class ConditionalStatement {
    public void ifStatement(int x){

        if (x<20){
            System.out.println("this is if statement");
        }
    }
    public void ifElseStatement(int x){

        if (x<18){
            System.out.println("This is if statement");
        }
        else {
            System.out.println("this is else statement");
        }

    }
    public void nestedStatement(int x, int y){
        if (x<15){
            if (y<25){
                System.out.println("X = " + x + " Y = " + y);
            }
        }
    }

}

