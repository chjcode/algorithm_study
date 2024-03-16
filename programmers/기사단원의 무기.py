'''
1부터 5까지 기사 5명 모두의 약수의 개수를 knight[]에 저장해두고(저장할 때 limit고려할 것)
'''

def solution(number, limit, power):

    knight = []
    for i in range(1,number+1): #기사 5명
        cnt = 0 # 약수 개수
        for j in range(1,int(i**(1/2))+1):  #약수 개수 구하기
            if i % j == 0:
                cnt += 1
                if j < i//j:
                    cnt += 1
        if cnt > limit:
            knight.append(power)
        else:
            knight.append(cnt)
                
    return sum(knight)