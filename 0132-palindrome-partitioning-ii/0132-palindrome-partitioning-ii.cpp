class Solution {
public:

    int minCut(string s) {

        int n = s.size();

        vector<vector<bool>> palindrome(n, vector<bool>(n, false));

        // Precompute palindrome table
        for (int end = 0; end < n; end++) {

            for (int start = 0; start <= end; start++) {

                if (s[start] == s[end] &&
                   (end - start <= 2 || palindrome[start + 1][end - 1])) {

                    palindrome[start][end] = true;
                }
            }
        }

        vector<int> dp(n);

        for (int i = 0; i < n; i++) {

            if (palindrome[0][i]) {

                dp[i] = 0;
            }
            else {

                dp[i] = i;

                for (int j = 0; j < i; j++) {

                    if (palindrome[j + 1][i]) {

                        dp[i] = min(dp[i], dp[j] + 1);
                    }
                }
            }
        }

        return dp[n - 1];
    }
};