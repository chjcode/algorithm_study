class Solution:
    def processQueries(self, queries: List[int], m: int) -> List[int]:
        '''
        queries[i] : P에서 해당하는 숫자의 idx만큼 움직인다.
        해야할 것
        1. 리스트 P 만들기
        2. P에서 queries[i]에 맞는 값 찾아서 맨 앞으로 옮기기
        2. queries 값을 P에서 찾아서 그 값의 idx 저장해놓고, P 내에서 맨 앞으로 옮기기, 
        3. result에 idx를 append 해놓기
        deque 활용하면 빠를까? -> deque는 idx로 접근 불가능!
        '''

        def P_idx(x):
            x_idx = P.index(x)
            P.insert(0, P.pop(x_idx))
            print(x_idx)
            return x_idx

        # 리스트 p만들기
        P = [i for i in range(1,m+1)]

        result = []
        # queries에서
        for query in queries:
            # p 순서 조절 해주는 함수
            idx = P_idx(query)
            result.append(idx)
        
        return result