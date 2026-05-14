class Solution {
public:

    int ladderLength(string beginWord,
                     string endWord,
                     vector<string>& wordList) {

        unordered_set<string> dict(wordList.begin(), wordList.end());

        if (!dict.count(endWord))
            return 0;

        queue<pair<string, int>> q;

        q.push({beginWord, 1});

        while (!q.empty()) {

            auto front = q.front();
            q.pop();

            string word = front.first;
            int steps = front.second;

            if (word == endWord)
                return steps;

            for (int i = 0; i < word.size(); i++) {

                string temp = word;

                for (char ch = 'a'; ch <= 'z'; ch++) {

                    temp[i] = ch;

                    if (dict.count(temp)) {

                        q.push({temp, steps + 1});

                        dict.erase(temp);
                    }
                }
            }
        }

        return 0;
    }
};