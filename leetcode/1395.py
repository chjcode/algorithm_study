class Solution:
    def numTeams(self, rating: List[int]) -> int:

        # #### 백트래킹
        # soldier = []
        # cnt = 0
        # n = len(rating)


        # def dfs(start):
        #     nonlocal cnt

        #     if len(soldier) == 3:
        #         if soldier[0] < soldier[1] < soldier[2] or soldier[0] > soldier[1] > soldier[2] :
        #             cnt += 1
        #             return
        #         return

        #     for i in range(start,n):
        #         soldier.append(rating[i])
        #         dfs(i+1)
        #         soldier.pop()
        #     return

        # dfs(0)

        # return cnt

        # #### 완전 탐색
        # n = len(rating)
        # cnt = 0

        # for i in range(n):
        #     for j in range(i+1,n):
        #         for k in range(j+1,n):
        #             if rating[i]<rating[j]<rating[k] or rating[i]>rating[j]>rating[k]:
        #                 cnt += 1

        # return cnt

        ans = 0
        left = [0 for _ in range(len(rating))]
        right = [0 for _ in range(len(rating))]
        for i in range(len(rating)):
            for j in range(0,i):
                if rating[i] > rating[j]:
                    left[i] = left[i] + 1
                    ans = ans + left[j]
                else:
                    right[i] = right[i] + 1
                    ans = ans + right[j]

        return ans