class Solution {
    public int magicalString(int n) {
        if (n <= 3) return 1;

        int[] s = new int[n + 2];
        s[0] = 1;
        s[1] = 2;
        s[2] = 2;

        int head = 2;
        int tail = 3;
        int num = 1;
        int ones = 1;

        while (tail < n) {
            for (int i = 0; i < s[head] && tail < n; i++) {
                s[tail++] = num;

                if (num == 1) {
                    ones++;
                }
            }

            num = (num == 1) ? 2 : 1;
            head++;
        }

        return ones;
    }
}