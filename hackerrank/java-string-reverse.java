import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        
        StringBuilder sb = new StringBuilder(A);
        sb = sb.reverse();
        
        System.out.println((A.compareTo(sb.toString()) == 0) ? "Yes" : "No");
    }
}



