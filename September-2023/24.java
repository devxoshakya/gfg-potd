//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            Solution g = new Solution();
            ArrayList<Integer> ans = g.duplicates(a, n);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        // code here
         ArrayList<Integer> result=new ArrayList();
        HashMap<Integer,Integer> map=new HashMap<>();
        Integer count;
        for(int i:arr){
            if(map.containsKey(i)){
                count=map.get(i);
            }
            else{
                count=0;
            }
            map.put(i,count+1);
        }
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            int r=e.getKey();
            int val=e.getValue();
            if(val>1){
                result.add(r);
            }
        }
        if(result.isEmpty()){
            result.add(-1);
        }
        Collections.sort(result);
        return result;
    }
}
