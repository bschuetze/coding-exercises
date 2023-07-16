import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        // Collect arrays
        ArrayList<ArrayList<Integer>> lines = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int d = scanner.nextInt();
            ArrayList<Integer> numbers = new ArrayList<>();
            for (int j = 0; j < d; j++) {
                numbers.add(scanner.nextInt());
            }
            scanner.nextLine(); // nl / cr
            
            lines.add(numbers);
        }
        
        // Collect queries
        int q = Integer.parseInt(scanner.nextLine());
        
        for (int i = 0; i < q; i++) {
            int x = scanner.nextInt() - 1; // Index offset
            int y = scanner.nextInt() - 1; // Index offset
            scanner.nextLine(); // nl / cr
            
            if (x < lines.size() && y < lines.get(x).size()) {
                System.out.println(lines.get(x).get(y));
            } else {
                System.out.println("ERROR!");
            }
        }
    }
}