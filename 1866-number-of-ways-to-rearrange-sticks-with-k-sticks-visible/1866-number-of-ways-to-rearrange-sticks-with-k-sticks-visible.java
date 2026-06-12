class Solution {
    private static final int MOD = 1000000007;
    private Long[][] memo;

    public int rearrangeSticks(int n, int k) {
        memo = new Long[n + 1][k + 1];
        return (int) solve(n, k);
    }

    private long solve(int n, int k) {
        if (n == 0 && k == 0) return 1;
        if (n == 0 || k == 0) return 0;

        if (memo[n][k] != null) {
            return memo[n][k];
        }

        long visible =
                solve(n - 1, k - 1);

        long hidden =
                ((long) (n - 1) * solve(n - 1, k)) % MOD;

        return memo[n][k] = (visible + hidden) % MOD;
    }
}