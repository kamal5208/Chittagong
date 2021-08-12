package practice;

public class Encapsulation {
  private String myName;
  private int  myAge;

  public String getName(){
      return myName;
  }
  public int getAge(){
      return myAge;
  }
  public void setName(String newName){
      myName = newName;
  }
  public void setAge(int newAge){
      myAge = newAge;
  }
}
