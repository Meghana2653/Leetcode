class Solution {
public:

    vector<vector<string>> ans;

    void dfs(string word,
             string beginWord,
             unordered_map<string, vector<string>>& parent,
             vector<string>& path) {

        if (word == beginWord) {

            vector<string> temp = path;

            reverse(temp.begin(), temp.end());

            ans.push_back(temp);

            return;
        }

        for (string p : parent[word]) {

            path.push_back(p);

            dfs(p, beginWord, parent, path);

            path.pop_back();
        }
    }

    vector<vector<string>> findLadders(string beginWord,
                                       string endWord,
                                       vector<string>& wordList) {

        unordered_set<string> dict(wordList.begin(), wordList.end());

        if (!dict.count(endWord))
            return {};

        unordered_map<string, vector<string>> parent;

        unordered_set<string> currentLevel;

        currentLevel.insert(beginWord);

        bool found = false;

        while (!currentLevel.empty() && !found) {

            for (string word : currentLevel)
                dict.erase(word);

            unordered_set<string> nextLevel;

            for (string word : currentLevel) {

                string temp = word;

                for (int i = 0; i < temp.size(); i++) {

                    char original = temp[i];

                    for (char ch = 'a'; ch <= 'z'; ch++) {

                        temp[i] = ch;

                        if (dict.count(temp)) {

                            nextLevel.insert(temp);

                            parent[temp].push_back(word);

                            if (temp == endWord)
                                found = true;
                        }
                    }

                    temp[i] = original;
                }
            }

            currentLevel = nextLevel;
        }

        if (!found)
            return {};

        vector<string> path;

        path.push_back(endWord);

        dfs(endWord, beginWord, parent, path);

        return ans;
    }
};