import java.util.*;



class Solution{
    public static void main(String []argh)
    {

        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();

        for(int i=0;i<t;i++) {

            try {
                long x=sc.nextLong();
                System.out.println(x+" can be fitted in:");
                // The following are not mutually exclusive
                if(x>=Byte.MIN_VALUE && x<= Byte.MAX_VALUE)System.out.println("* byte");
                if(x>=Short.MIN_VALUE && x<= Short.MAX_VALUE)System.out.println("* short");
                if(x>=Integer.MIN_VALUE && x<= Integer.MAX_VALUE)System.out.println("* int");
                // Because it is trying to be read in as a long, this if is redundant 
                // bvut is kept in for readability
                if(x>=Long.MIN_VALUE && x<= Long.MAX_VALUE)System.out.println("* long");
                
            }
            catch(Exception e) {
                // Because it is trying to be read in as a long, naturally it will throw 
                // an exception if it is too large
                System.out.println(sc.next()+" can't be fitted anywhere.");
            }

        }
    }
}