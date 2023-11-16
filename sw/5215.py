# swea 햄버거 다이어트 - 백트래킹 활용

# swea 햄버거 다이어트 - 미완성 진행중

def check(num,hamburger):
    cnt_score = 0
    cnt_kal = 0
    for i in range(num):
        cnt_score += hamburger[i][0]
        cnt_kal += hamburger[i][1]
    if cnt_kal <= l:
        return cnt_score
    return 0
def dfs(num):
    global answer
    if num == len(hamburger):
        answer = max(answer, check(num,hamburger))
        return

    for i in range(num):
        if ingredients[i] in hamburger:
            continue
        hamburger.append(ingredients[i])
        print(hamburger)
        dfs(num)
        hamburger.pop()
    return

T = int(input())
for test_case in range(1,T+1):
    n, l = map(int,input().split())

    # 햄버거 재료 입력 받기
    ingredients = []
    for _ in range(n):
        t,k = map(int,input().split())  # 점수, 칼로리
        ingredients.append([t,k])

    answer = 0
    hamburger = []
    for i in range(1,n+1):
        dfs(i)

    print(f"#{test_case} {answer}")
