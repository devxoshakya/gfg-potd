//{ Driver Code Starts
    import java.util.*;
    import java.io.*;
    
    class GFG
     {
        public static void main (String[] args)
         {
          
          //taking input using Scanner class
          Scanner sc = new Scanner(System.in);
          
          //taking count of testcases
          int t = sc.nextInt();
          while(t-- > 0){
              
              //taking count of houses
              int n = sc.nextInt();
              int arr[] = new int[n];
              
              //inserting money present in 
              //each house in the array
              for(int i = 0; i<n; ++i)
                   arr[i] = sc.nextInt();
                
                //calling method FindMaxSum() of class solve
                System.out.println(new Solution().FindMaxSum(arr, n));
         }
       }
    }
    // } Driver Code Ends
    
    class Solution {
        // Function to find the maximum money the thief can get.
        public int FindMaxSum(int arr[], int n) {
            // If there is only one house, return the money in that house.
            if (n == 1) return arr[0];
    
            // Create an array dp to store the maximum money that can be looted
            // up to each house while following the rule.
            int dp[] = new int[n];
    
            // Initialize dp[0] with the money in the first house.
            dp[0] = arr[0];
    
            // Initialize dp[1] with the maximum of money in the first two houses.
            dp[1] = Math.max(arr[0], arr[1]);
    
            // Iterate through the remaining houses starting from the 3rd house.
            for (int i = 2; i < n; i++) {
                // We have two choices for each house:
                // 1. Don't loot the current house (i), and take the maximum money from the previous house (i-1).
                // 2. Loot the current house (i), and add its money to the maximum money obtained two houses before (i-2).
                // Take the maximum of these two choices.
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i]);
            }
    
            // Return the maximum money that can be looted from all the houses without looting two consecutive houses.
            return dp[n - 1];
        }
    }