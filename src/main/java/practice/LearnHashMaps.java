package practice;

import java.util.HashMap;
import java.util.Map;

public class LearnHashMaps {

    public void AddHashvalue(){
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("IE", "Internet Explorer");
        hashMap.put("Chrome", "Chrome browser");
        System.out.println("Browser name:" + hashMap.get("IE"));
        System.out.println(hashMap);


        //for(Map.Entry map: hashMap.entrySet()){
           // System.out.println(map.getKey() + "  " + map.getValue());
        }

    public void HashMapWithDifferentDataType(){
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Kamal", 10);
        hashMap.put("Sara",30);
        hashMap.put("Saifan",20);

        System.out.println("Size of map is:" + hashMap.size());
        System.out.println(hashMap);
    System.out.println(hashMap.get("Sara"));
    hashMap.remove("Sara");
    System.out.println(hashMap);
    }

    }


