# swea 1284. 수도 요금 경쟁

T = int(input())

for test_case in range(1,T+1):
    p,q,r,s,w = map(int,input().split())

    company_a = p * w
    company_b = 0
    if w > r:
        company_b = q + (w-r) * s
    else:
        company_b = q

    print(f"#{test_case} {min(company_a,company_b)}")