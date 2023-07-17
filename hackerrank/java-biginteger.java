import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        BigInteger a = s.nextBigInteger();
        BigInteger b = s.nextBigInteger();
        
        System.out.println(a.add(b));
        System.out.println(a.multiply(b));
        
        s.close();
    }
}