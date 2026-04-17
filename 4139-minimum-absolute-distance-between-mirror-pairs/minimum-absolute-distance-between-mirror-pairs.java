import java.util.*;

class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int res = 100000, i = 0;
        HashMap<Integer, Integer> seen = new HashMap<>();

        for (int n : nums) {
            if (seen.containsKey(n)) {
                res = Math.min(res, i - seen.get(n));
            }

            int r = 0, temp = n;
            while (temp > 0) {
                r = r * 10 + (temp % 10);
                temp /= 10;
            }

            seen.put(r, i++);
        }

        return res == 100000 ? -1 : res;
    }
}