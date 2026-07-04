class Solution {
    public char findKthBit(int n, int k) {
        String s = build(n);
        return s.charAt(k - 1);
    }

    private String build(int n) {
        if (n == 1) {
            return "0";
        }

        String prev = build(n - 1);
        StringBuilder sb = new StringBuilder();

        // invert and reverse
        for (int i = prev.length() - 1; i >= 0; i--) {
            if (prev.charAt(i) == '0') {
                sb.append('1');
            } else {
                sb.append('0');
            }
        }

        return prev + "1" + sb.toString();
    }
}