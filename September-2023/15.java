//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    
    static boolean canpartition(int arr[],int targetsum,int indx,int currsum){
        if(currsum==targetsum){
            return true;
        }
        
        for(int i=indx;i<arr.length;i++){
            if(arr[i]+currsum<=targetsum){
                if(canpartition(arr,targetsum,i+1,currsum+arr[i])){
                    return true;
                }
            }
        }
       return false; 
    }
    
    static int equalPartition(int N, int arr[]){
        int totalsum=0;
        for(int val:arr){
            totalsum+=val;
        }
        
        if(totalsum%2!=0){
            return 0;
        }
        
        int targetsum=totalsum/2;
        canpartition(arr,targetsum,0,0);
            
        return (canpartition(arr,targetsum,0,0) ? 1 :0);
    }
}