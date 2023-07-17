import java.util.Scanner;

public class Solution {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        
        if (s.length() >= k) {
            smallest = s.substring(0, k);
            largest = s.substring(0, k);
            for (int i = 1; i <= s.length() - k; i++) {
                String currentSubstring = s.substring(i, i + k);
                
                if (currentSubstring.compareTo(smallest) < 0) {
                    smallest = currentSubstring;
                }
                if (currentSubstring.compareTo(largest) > 0) {
                    largest = currentSubstring;
                }
            }
        }
        
        return smallest + "\n" + largest;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();
      
        System.out.println(getSmallestAndLargest(s, k));
    }
}