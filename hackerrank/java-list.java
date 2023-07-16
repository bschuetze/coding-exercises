import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);
        
        int N = Integer.parseInt(s.nextLine());
        
        List<String> L = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            L.add(s.next());
        }
        s.nextLine(); // cr / nl
        
        int Q = Integer.parseInt(s.nextLine());
        for (int i = 0; i < Q; i++) {
            String req = s.nextLine();
            if (req.equals("Insert")) {
                int x = s.nextInt();
                String y = s.next();
                L.add(x, y);
            } else { // req == "Delete"
                int x = s.nextInt();
                L.remove(x);
            }
            if (s.hasNext()) {
                s.nextLine();
            }
        }

        System.out.println(String.join(" ", L));
    }
}