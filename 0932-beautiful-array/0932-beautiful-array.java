import java.util.*;

class Solution {
    public int[] beautifulArray(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(1);

        while (result.size() < n) {
            List<Integer> temp = new ArrayList<>();

            // Generate odd numbers
            for (int x : result) {
                if (2 * x - 1 <= n) {
                    temp.add(2 * x - 1);
                }
            }

            // Generate even numbers
            for (int x : result) {
                if (2 * x <= n) {
                    temp.add(2 * x);
                }
            }

            result = temp;
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }
}