class Solution:
    def exclusiveTime(self, n, logs):

        ans = [0] * n
        stack = []
        prev_time = 0

        for log in logs:

            fn, typ, t = log.split(":")
            fn = int(fn)
            t = int(t)

            if typ == "start":

                if stack:
                    ans[stack[-1]] += t - prev_time

                stack.append(fn)
                prev_time = t

            else:

                ans[stack.pop()] += t - prev_time + 1
                prev_time = t + 1

        return ans