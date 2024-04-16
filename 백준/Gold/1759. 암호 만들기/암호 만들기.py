# 1759 암호 만들기
'''
4 6
a t c i s w
예제 출력 1 
acis
acit
aciw
acst
acsw
actw
aist
aisw
aitw
astw
cist
cisw
citw
istw
'''
# 최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음으로 구성
def dfs(depth,cnt,s):
    if depth == c:
        if cnt == l:
            # 모음1,자음2 구성인지 체크
            temp1 = 0   # 모음
            temp2 = 0   # 자음
            for i in range(l):
                if s[i] in ['a','e','i','o','u']:
                    temp1 += 1
                else:
                    temp2 += 1
            if temp1 > 0 and temp2 > 1:    
                print(s)
        
        return
    
    dfs(depth+1, cnt+1, s+alpha[depth])
    dfs(depth+1, cnt, s)

    return

l,c = map(int,input().split())
alpha = sorted(list(input().split()))
dfs(0,0,'')
