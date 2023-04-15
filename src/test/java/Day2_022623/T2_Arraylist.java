package Day2_022623;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class T2_Arraylist {
    public static void main(String[] args) {
        //create an array list of countries
        ArrayList <String> countries = new ArrayList<>();
        countries.add("USA");
        countries.add("Malaysia");
        countries.add("Argentina");
        countries.add("France");
        //get the count list
        System.out.println("Countries list:" + countries.size());
        //Print only USA, Malaysia, and Argentina
        System.out.println("Countries are:" + countries.get(0) + "," + countries.get(1) + "," + countries.get(2));
        countries.add("Russia");
        //get the count of the list
        System.out.println("Countries list:" + countries.size());
        System.out.println(countries.get(4));
        //to get the last count dynamically do the following
        //System.out.println(countries.get(countries.size()(-1));
        ArrayList <Integer> areaCode = new ArrayList<>();
        areaCode.add(777);
        areaCode.add(222);
        areaCode.add(333);
        //get the count of the list
        System.out.println("Area code list: " + areaCode.size());
        //print the first and third area code
        System.out.println("Area codes are " + areaCode.get(0) + "," + areaCode.get(2));
    }// end of main
}//end of class
