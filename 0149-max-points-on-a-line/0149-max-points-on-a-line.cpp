class Solution {
public:

    int maxPoints(vector<vector<int>>& points) {

        int n = points.size();

        if (n <= 2)
            return n;

        int answer = 0;

        for (int i = 0; i < n; i++) {

            unordered_map<string, int> slopeCount;

            int currentMax = 0;

            for (int j = i + 1; j < n; j++) {

                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                int g = gcd(dx, dy);

                dx /= g;
                dy /= g;

                // normalize sign
                if (dx < 0) {
                    dx *= -1;
                    dy *= -1;
                }

                if (dx == 0)
                    dy = 1;

                if (dy == 0)
                    dx = 1;

                string slope = to_string(dx) + "/" + to_string(dy);

                slopeCount[slope]++;

                currentMax = max(currentMax, slopeCount[slope]);
            }

            answer = max(answer, currentMax + 1);
        }

        return answer;
    }
};