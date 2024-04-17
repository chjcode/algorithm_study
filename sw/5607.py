# swea 5607. [Professional] 조합

# 자연수 N와 R가 주어진다. 이 때의 N combination R의 값을 1234567891로 나눈 나머지를  출력하세요.


# 1
# 10 2	// 전체 테스트케이스 개수
# // 첫 번째 TC의 정수 N R

t = int(input())

for tc in range(1,t+1):
    n,r = map(int,input().split())

    tmp1 = 1
    tmp2 = 1
    for i in range(min(n-r,r)):
        tmp1 *= (n-i)%1234567891
        tmp2 *= (i+1)%1234567891

    print(f'#{tc} {(tmp1//tmp2)}')