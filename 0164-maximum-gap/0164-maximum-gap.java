class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;

        if (n < 2) {
            return 0;
        }

        // Find minimum and maximum
        int min = nums[0];
        int max = nums[0];

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        if (min == max) {
            return 0;
        }

        // Size of each bucket
        int bucketSize = Math.max(1, (max - min) / (n - 1));

        // Number of buckets
        int bucketCount = (max - min) / bucketSize + 1;

        int[] bucketMin = new int[bucketCount];
        int[] bucketMax = new int[bucketCount];

        // Initialize buckets
        for (int i = 0; i < bucketCount; i++) {
            bucketMin[i] = Integer.MAX_VALUE;
            bucketMax[i] = Integer.MIN_VALUE;
        }

        // Put numbers into buckets
        for (int num : nums) {
            int index = (num - min) / bucketSize;

            bucketMin[index] = Math.min(bucketMin[index], num);
            bucketMax[index] = Math.max(bucketMax[index], num);
        }

        // Find maximum gap between buckets
        int answer = 0;
        int previousMax = min;

        for (int i = 0; i < bucketCount; i++) {

            // Empty bucket
            if (bucketMin[i] == Integer.MAX_VALUE) {
                continue;
            }

            // Gap between previous bucket and current bucket
            answer = Math.max(answer, bucketMin[i] - previousMax);

            previousMax = bucketMax[i];
        }

        return answer;
    }
}