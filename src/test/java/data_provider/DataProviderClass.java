package data_provider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderClass {
    @DataProvider(name = "SingleValue")
    public Object[][] storeSingleValue(){
        return new Object[][]{
                {"Saifan"},
                {"Rafan"},
                {"Kamal"}
        };
    }
    @DataProvider(name = "MultipleValues")
    public Object[][] storeMultipleValues(){
        return new Object[][] {
                {"Saifan","New York",11432},
                {"Rafan","North Carolina", 1108},
                {"Kamal","New York", 11435}
        };
    }
    @DataProvider(name="RealAprRates")
    public Object[][] storeRealAprRates(){
        return new Object[][]{
                {"200000","15000","3","3.130%"}
        };
    }

    @Test(dataProvider="SingleValue")
    public void run (String name){
        System.out.println("[Single Value] name is: "  + name);
    }
    @Test(dataProvider = "MultipleValues")
    public void run (String name,String State,int zipCode){
        System.out.println("[Multiple Value] name is: "  + name);
        System.out.println("[Multiple Value] State is: "  + State);
        System.out.println("[Multiple Value] zipcode is: "  + zipCode);


    }

}
