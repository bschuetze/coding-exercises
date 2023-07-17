import java.util.Scanner;

public class Solution {

    static boolean isAnagram(String a, String b) {
        // Complete the function
        if (a.length() != b.length()) {
            return false;
        }
        
        a = a.toLowerCase();
        b = b.toLowerCase();
        
        java.util.HashMap<Character, Integer> aMap = new java.util.HashMap<>();
        java.util.HashMap<Character, Integer> bMap = new java.util.HashMap<>();
        
        for (int i = 0; i < a.length() && i < b.length(); i++) {
            aMap.putIfAbsent(a.charAt(i), 0);
            aMap.put(a.charAt(i), aMap.get(a.charAt(i)) + 1);
            
            bMap.putIfAbsent(b.charAt(i), 0);
            bMap.put(b.charAt(i), bMap.get(b.charAt(i)) + 1);
        }
        
        for (Character c : aMap.keySet()) {
            if (aMap.get(c) != bMap.get(c)) {
                return false;
            }
        }
        
        return true;
    }

  public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
