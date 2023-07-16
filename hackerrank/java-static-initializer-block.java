import java.util.*;

public class Solution {
    
    static int A;
    static int B;
    
    static {
        Scanner scanner = new Scanner(System.in);
        // Assume that the inputs are ints
        A = scanner.nextInt();
        scanner.nextLine(); // clear the carriage return
        B = scanner.nextInt();
        
        scanner.close();
        
        try {
            if (A <= 0 || B <= 0) {
                throw new Exception("Breadth and height must be positive");
            } else {
                System.out.println(String.format("%d", A*B));
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        // Nothing here
    }
}
