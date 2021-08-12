package practice;

public class LearnStringMethod {
    public void indexOf(){
        String myStr = "I live in New York city";
        System.out.println(myStr.indexOf("New"));
        System.out.println(myStr.indexOf("e",6));

    }
    public void learFormat(){
        String name = "John";
        int age = 20;
        int salary = 40000;
        String duration = "yearly";
        System.out.println("My name is "+ name+" and I am "+ age +" years old and my salary is "+ salary +" yearly");
        System.out.println(String.format("My name is %s and I am %d years old and my salary is %d %s", name, age, salary, duration));
    }
    public void learFormatArray(){
        String [] names = {"John", "Kamal"};
        int [] ages = {30, 40};
        int[] salaries = {30000, 40000};

        for (int i = 0; i < names.length; i++){
            String sentence =String.format("My name is %s and I am %d years old and my salary is $%d yearly",names[i],ages[i],salaries[i]);
        System.out.println(sentence);
        }
    }
    public void learnContains(){
        String sentence = "My name is kamal";
        System.out.println(sentence.contains("li"));
    }



    public void learnSplit(){
        String names= "Jon,Ali,Abraham";
       String[] arrayname = names.split(",");
       for(String name:arrayname){
           System.out.println("Person name is:" + name);
       }

    }
    public void learnSplitArray(){
        String sentence = "I live in New York";
        String[] words = sentence.split(" ");
        for(String word: words){
            System.out.println("Word is:" + word);
        }
String reverse = "";
        for(int i = words.length - 1; i>= 0; i--){
            reverse = reverse + words[i] + " ";
        }
        System.out.println("reverse sentence is:" + reverse);

    }

}
