# 1459 걷기

# 입력받기
x,y,w,s = map(int,input().split())
anser = 0

if 2*w <= s: # 두번 이동하는게 걸리는시간이 더 적을 때
    answer = (x+y) * w
else:
    small = min(x,y)
    large = max(x,y)
    answer = small * s
    if (large-small)%2==0:
        if w > s:
            answer += (large-small) * s
        else:
            answer += (large-small) * w
    else:
        if w > s:
            answer += (large-small-1) * s + w
        else:
            answer += (large-small) * w

print(answer)