package practice;

import java.util.Arrays;
import java.util.Collections;

public class LearnArray {

    public void array(){
        String[] myList = {"NY", "VA", "FL", "AL"};
        for (String States : myList){
            System.out.println("States name is:"  + States);
        }



        }
        public void sortArray(){
        String[] mylist= {"NY", "FL", "AL", "BO"};
            Arrays.sort(mylist);
            System.out.println(Arrays.toString(mylist));
        }

        public void sortDescOrder(){
        String [] myList = {"NY", "FL", "AL", "BO"};
        Arrays.sort(myList, Collections.reverseOrder());
        System.out.println(Arrays.toString(myList));
        }

        public void arraylist(){
        String [] mylist = {"NY", "FL", "AL", "BO"};
        for (int i = 0; i< mylist.length; i++){
            System.out.println("States name is:" +mylist[i]);
        }
        }
}
