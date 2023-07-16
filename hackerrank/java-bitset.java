import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        
        // Collect N and M
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.nextLine(); // Clear newline cr
        
        // Create out bitsets
        BitSet b1 = new BitSet(N);
        BitSet b2 = new BitSet(N);
        BitSet[] b = {b1, b2};
        
        for (int i = 0; i < M; i++) {
            // Read M lines
            String operation = scanner.next();
            int set1 = scanner.nextInt() - 1;
            int operand2 = scanner.nextInt();
            int set2 = operand2 - 1;
            if (scanner.hasNext()) {
                scanner.nextLine(); // Clear newline cr
            }
            
            // Better to have this be an interface and use strategy pattern
            // but overcomplicated for this example
            switch (operation) {
                case "AND":
                    b[set1].and(b[set2]);
                    break;
                case "OR":
                    b[set1].or(b[set2]);
                    break;
                case "XOR":
                    b[set1].xor(b[set2]);
                    break;
                case "FLIP":
                    b[set1].flip(operand2);;
                    break;
                case "SET":
                    b[set1].set(operand2);;
                    break;
                default:
                    // Not defined
                    break;
            }
            // Count set bits
            String[] cardinalities = new String[b.length];
            for (int j = 0; j < b.length; j++) {
                cardinalities[j] = Integer.toString(b[j].cardinality());
            }
            System.out.println(String.join(" ", cardinalities));
        }
    }
}