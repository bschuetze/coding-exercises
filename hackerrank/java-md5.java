import java.io.*;
import java.util.*;
import java.security.*;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        String value = s.nextLine();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(value.getBytes());
            byte[] digest = md.digest();
            /* Print the encoded value in hexadecimal */
            for (byte b : digest) {
                System.out.format("%02x", b);
            }
        } catch (Exception e) {
            // 
        }
        s.close();
    }
}