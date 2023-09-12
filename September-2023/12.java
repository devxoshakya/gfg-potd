//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            long N = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.isPerfectNumber(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
     
    static int isPerfectNumber(long N) {
        if(N == 1)  return 0;
// Storing sqrt of N to iterate the loop till it
        long sqrt = (long)Math.sqrt(N);
// Assigning sum as 1 as 1 is always a factor.
        long sum = 1;
        for(int i = 2; i <= sqrt; i++){
//Checking if number is divisible by current number then add both divident and the quotient obtained.
            if(N%i == 0){
                sum += i;
                sum += N/(long)i;
            }
        }
        if(sum == N)    return 1;
        else return 0;
   }
};
