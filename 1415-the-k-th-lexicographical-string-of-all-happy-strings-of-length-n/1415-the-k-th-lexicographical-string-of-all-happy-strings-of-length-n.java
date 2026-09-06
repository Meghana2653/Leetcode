class Solution {
    String ans = "";
    int count = 0;

    public String getHappyString(int n, int k) {
        backtrack(n, k, "");
        return ans;
    }

    private void backtrack(int n, int k, String current) {
        if (!ans.equals("")) return;

        if (current.length() == n) {
            count++;

            if (count == k) {
                ans = current;
            }
            return;
        }

        for (char ch = 'a'; ch <= 'c'; ch++) {
            // Adjacent characters should be different
            if (current.length() > 0 &&
                current.charAt(current.length() - 1) == ch) {
                continue;
            }

            backtrack(n, k, current + ch);
        }
    }
}