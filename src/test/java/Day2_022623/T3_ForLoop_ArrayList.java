package Day2_022623;

import java.util.ArrayList;

public class T3_ForLoop_ArrayList {
    public static void main(String[] args) {
        //create and arraylist of countries
        ArrayList<String> countries = new ArrayList<>();
        countries.add("USA");
        countries.add("India");
        countries.add("Bangladesh");
        countries.add("Pakistan");
        countries.add("Russia");
        countries.add("Canada");
        countries.add("Argentina");
        ArrayList<Integer> areaCode = new ArrayList<>();
        areaCode.add(111);
        areaCode.add(222);
        areaCode.add(333);
        areaCode.add(444);
        areaCode.add(555);
        areaCode.add(666);
        areaCode.add(777);
        areaCode.add(888);
        //if you are using one loop for 2 or more array list, then they all should have the same amount of count
        //if not then it needs to be in a separate loop statement
        for (int i = 0; i < countries.size(); i++) {
            System.out.println("Country is " + countries.get(i) + " area code is " + areaCode.get(i));

        }//end of loop
    }//end of main
}//end of class
