import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        // Write your code here.
        scan.close();
        
        s = s.trim();
        if (s.length() == 0) {
            System.out.println(0);
        } else {
            s = s.replaceAll("[! ,?._'@]+", " ");
            String[] tokens = s.split(" ");
            
            System.out.println(tokens.length);
            for (String token : tokens) {
                System.out.println(token);
            }
        }
    }
}

