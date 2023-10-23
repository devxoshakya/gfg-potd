//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSumIS(Arr,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution{
    public int MaxSum(int arr[],int n,int curr,int prev,int dp[][]){
        if(curr >= n){
            return 0;
        }
        if(dp[curr][prev+1] != -1){
            return dp[curr][prev+1];
        }
        int pick = Integer.MIN_VALUE;
        if(prev == -1 || arr[curr] > arr[prev]){
           pick = arr[curr] +  MaxSum(arr,n,curr+1,curr,dp);
        }
        int notpick = MaxSum(arr,n,curr+1,prev,dp);
        return dp[curr][prev+1] = Math.max(pick,notpick);
    } 
    public int maxSumIS(int arr[], int n) {  
        //code here.
        int dp[][] = new int[n][n+1];
        for(int i = 0; i <= n - 1; i++){
            for(int j = 0; j <= n; j++){
                dp[i][j] = -1;
            }
        }
        return MaxSum(arr,n,0,-1,dp);
    }  
}