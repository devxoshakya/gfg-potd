import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    public List<List<Integer>> fourSum(int[] arr, int k) {
        int n = arr.length;
        Map<Integer, List<int[]>> d = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = arr[i] + arr[j];
                if (!d.containsKey(sum)) {
                    d.put(sum, new ArrayList<>());
                }
                d.get(sum).add(new int[]{i, j});
            }
        }
        Set<List<Integer>> output = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        for (Map.Entry<Integer, List<int[]>> entry : d.entrySet()) {
            int s = entry.getKey();
            List<int[]> ijs = entry.getValue();
            if (visited.contains(s)) {
                continue;
            }
            int r = k - s;
            if (!d.containsKey(r)) {
                continue;
            }
            visited.add(r);
            for (int[] ij : ijs) {
                for (int[] kl : d.get(r)) {
                    if (ij[0] != kl[0] && ij[1] != kl[1]) {
                        List<Integer> quadruplet = new ArrayList<>();
                        quadruplet.add(arr[ij[0]]);
                        quadruplet.add(arr[ij[1]]);
                        quadruplet.add(arr[kl[0]]);
                        quadruplet.add(arr[kl[1]]);
                        output.add(quadruplet);
                    }
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>(output);
        result.sort((a, b) -> {
            for (int i = 0; i < 4; i++) {
                if (a.get(i) != b.get(i)) {
                    return a.get(i) - b.get(i);
                }
            }
            return 0;
        });
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t > 0) {
            t--;
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            Solution ob = new Solution();
            List<List<Integer>> ans = ob.fourSum(a, k);
            for (List<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.print("$");
            }
            if (ans.size() == 0) {
                System.out.print(-1);
            }
            System.out.println();
        }
        scanner.close();
    }
}