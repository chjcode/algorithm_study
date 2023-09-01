class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        # '''
        # '(' n개, ')' n개로 만들 수 있는 모든 조합을 만든 후
        # stack을 이용해서 짝이 맞는지 확인 후 맞는것만 append

        # '''
        # combi = []
        # def all_Combi(left,right,lst):
        #     if left+right == 2*n:
        #         if Stack(lst):
        #             combi.append(lst)
        #         return
        #     all_Combi(left+1,right,lst+'(')
        #     all_Combi(left,right+1,lst+')')


        # def Stack(lst):
        #     if lst[0] == ')':
        #         return False

        #     stack = []
        #     stack.append(lst[0])
        #     for i in range(1,2*n):
        #         if lst[i] == '(':
        #             stack.append(lst[i])
        #         else:
        #             if not stack: # stack이 비어있는데 ')'이 나오면 짝x
        #                 return False
        #             stack.pop()

        #     if stack:   #stack에 뭔가가 들어있으면 짝이 맞지 않음
        #         return False
        #     return True

        # all_Combi(0,0,'')

        # return combi

        combi = []
        def all_Combi(left,right,lst):
            if left+right == 2*n:
                combi.append(lst)
                return

            if left < n:
                all_Combi(left+1,right,lst+'(')
            if right < left:
                all_Combi(left,right+1,lst+')')
        all_Combi(0,0,'')
        return combi