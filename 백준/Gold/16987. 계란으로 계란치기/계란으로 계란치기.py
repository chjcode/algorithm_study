# 8
# 222 117
# 176 92
# 287 6
# 284 81
# 221 96
# 263 96
# 188 40
# 225 1

# 4

# 16987 계란으로 계란치기
'''
1. 계란 들기 (계란 idx = depth)
2. 계란 치기 (어떤 순서로 치냐에 따라 결과가 달라지므로 여기서부터 순서 바꿔가며 탐색(백트래킹))
3. 계란 깨지면 다음 계란 들기 (depth + 1)
4. 
'''
def dfs(depth):
    global answer

    if depth == n:  # 맨 오른쪽 계란의 idx가 n-1이므로 n은 한 바퀴 다 돌은 것을 의미
        cnt = 0 # 깨진 계란 count
        for i in range(n):
            if egg[i][0] <= 0:
                cnt += 1
        answer = max(answer,cnt)
        return
    
    if egg[depth][0] <= 0:  # 깨진 계란이면 다음 계란을 들기위해 depth+1
        dfs(depth+1)
        
    else:
        only_broken_eggs = True    # 깨진 계란만 있는지 확인
        for i in range(n):
            if depth == i or egg[i][0] <= 0: # 자기 자신 or 깨진 계란이면 건너뛰기
                continue
            only_broken_eggs = False     # 안깨진 계란이 있으면 False
            egg[i][0] -= egg[depth][1]  # (내구도 - 무게) 들고있는 계란과 내려친 계란에 적용
            egg[depth][0] -= egg[i][1]
            dfs(depth+1)     # 내려친 계란 내려놓고 오른쪽 계란 들기
            egg[i][0] += egg[depth][1]  # 다른 경우의 수를 위해 깎인 내구도 복원
            egg[depth][0] += egg[i][1]

        if only_broken_eggs:    # 깨진 계란만 있으면 탐색비용을 아끼기 위해 depth를 곧바로 n으로 설정
            dfs(n)

    return

n = int(input())
egg = [list(map(int,input().split())) for _ in range(n)]   # 내구도, 무게

answer = 0

dfs(0)
print(answer)