package Day3_030423;

public class T2_Multiple_Conditions {

    public static void main(String[] args) {
        // using multiple conditional statements verify when a+b > c, a+b<c, a+b ==d

        int a = 2;
        int b = 3;
        int c = 5;

        if (a + b > c) {
            System.out.println("a & b is greater than c");
        } else if (a + b < c) {
            System.out.println("a & b id less than c");
        } else if (a + b == c) {
            // when you compare two values it will always be == double equal sign
            System.out.println("a & b is equal to c");
        }// end of multiple conditions
    }// end of main
}// end of java class
