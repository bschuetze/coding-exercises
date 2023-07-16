import java.util.*;

class Solution{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            
            String[] results = new String[n];
            double previousResult = a;
            for (int j = 0; j < n; j++) {
                double currentResult = previousResult + ((Math.pow(2, j) * b));
                results[j] = Long.toString(Math.round(Math.floor(currentResult)));
                previousResult = currentResult;
            }
            System.out.println(String.join(" ", results));
        }
        in.close();
    }
}
