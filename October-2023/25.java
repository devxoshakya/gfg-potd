//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int solve(int ind, int w, int val[], int wt[], int dp[][]) {
        if(ind == 0) 
            return val[0] * (w / wt[0]);
        
        if(dp[ind][w] != -1)
            return dp[ind][w];
        
        int notTake = solve(ind - 1, w, val, wt, dp);
        int take = Integer.MIN_VALUE;
        
        if(wt[ind] <= w) 
            take = val[ind] + solve(ind, w - wt[ind], val, wt, dp);
        
        return dp[ind][w] = Math.max(take, notTake);
    }
    
    static int knapSack(int n, int w, int val[], int wt[]) {
        int [][]dp = new int[n][w + 1];
        for(int i = 0; i < n; i++)
            for(int j = 0; j <= w; j++)
                dp[i][j] = -1;
            
        return solve(n - 1, w, val, wt, dp);
    }
}