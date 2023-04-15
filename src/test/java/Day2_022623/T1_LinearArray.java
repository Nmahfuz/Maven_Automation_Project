package Day2_022623;

public class T1_LinearArray {
    public static void main(String[] args) {
        //create a list of cities in a linear array
        //array count always starts from the index of 0

        String[] cities = new String[] {"Brooklyn", "Queens", "Manhattan", "Bronx", "Staten Island"};
        System.out.println("Cities count" + cities.length);
        //print out brooklyn and bronx from the lst
        System.out.println("My cities are" + cities[0] + ", "+ cities[3]);
        //create a list of zipcode
        int[] zipCode = new int [] {11218, 22222, 33333, 55555};
        // get the count of the list of zipcode
        System.out.println("Cities count"+ zipCode.length);
        //print out 11218 & 33333 from the list
        System.out.println("My cities are " + zipCode[0]+ "," + zipCode[2]);

    }//end of main
}// end of class
