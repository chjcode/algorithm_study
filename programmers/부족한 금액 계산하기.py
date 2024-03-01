#price : 놀이기구 처음 이용료
#money : 처음 가지고 있던 금액
#count : 놀이기구 탑승 횟수
#return : count번 탑승하면 얼마가 모자르는지
def solution(price, money, count):
    
    while count:
        money -= price * count
        count -= 1
    if money > 0:
        return 0
    else:
        return abs(money)