package practice;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListArray {

   public void arrayToList() {

      String[] array = {"AL", "NY", "FL"};
      System.out.println("Array name is:" + Arrays.toString(array));

      List<String> lists = new ArrayList<>();
      for (String lang : array) {
         lists.add(lang);
      }
      System.out.println("List name is:" + lists);


   }

   public void listToArray() {
      //Convert list to array
      List<String> fruitList = new ArrayList<>();

      fruitList.add("Apple");
      fruitList.add("OH");
      fruitList.add("Banana");

      String [] array = fruitList.toArray(new String[fruitList.size()]);
      System.out.println("printing array:" + Arrays.toString(array));
      System.out.println("printing list:"  + fruitList);

   }
}







