class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = getMax(weights);
        int high = getSum(weights);

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (canShip(weights, days, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private int getMax(int[] weights) {
        int max = 0;
        for (int w : weights) {
            max = Math.max(max, w);
        }
        return max;
    }

    private int getSum(int[] weights) {
        int sum = 0;
        for (int w : weights) {
            sum += w;
        }
        return sum;
    }

    private boolean canShip(int[] weights, int days, int capacity) {
        int currentWeight = 0;
        int requiredDays = 1;

        for (int w : weights) {
            if (currentWeight + w > capacity) {
                requiredDays++;
                currentWeight = w;
            } else {
                currentWeight += w;
            }
        }

        return requiredDays <= days;
    }
}