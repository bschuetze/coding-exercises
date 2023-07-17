import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        try {
            int numerator = s.nextInt();
            int denominator = s.nextInt();
            System.out.println(numerator / denominator);
        }
        catch (InputMismatchException e) {
            System.out.println("java.util.InputMismatchException");
        }
        catch (ArithmeticException e) {
            System.out.println(e.toString());
        }
        finally {
            s.close();
        }
    }
}
