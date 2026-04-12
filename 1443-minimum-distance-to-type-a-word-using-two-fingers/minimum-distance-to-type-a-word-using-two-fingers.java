class Solution {
    public int minimumDistance(String word) {
        int[][] dp = new int[27][27];
        for (int[] row : dp)
            Arrays.fill(row, 1_000_000);
        dp[26][26] = 0; 

        for (char ch : word.toCharArray()) {
            int c = ch - 'A';
            int[][] ndp = new int[27][27];
            for (int[] row : ndp)
                Arrays.fill(row, 1_000_000);

            for (int i = 0; i <= 26; i++) {
                for (int j = 0; j <= 26; j++) {
                    int val = dp[i][j];
                    if (val == 1_000_000)
                        continue;

                    // move finger1
                    ndp[c][j] = Math.min(ndp[c][j], val + dist(i, c));
                   
                    ndp[i][c] = Math.min(ndp[i][c], val + dist(j, c));
                }
            }
            dp = ndp;
        }

        int res = Integer.MAX_VALUE;
        for (int[] row : dp)
            for (int v : row)
                res = Math.min(res, v);
        return res;
    }

    private int dist(int a, int b) {
        if (a == 26)
            return 0;
        return Math.abs(a / 6 - b / 6) + Math.abs(a % 6 - b % 6);
    }
}