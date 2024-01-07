import sys

N = int(sys.stdin.readline())  #숫자 카드 개수
N_list = list(map(int,sys.stdin.readline().split())) #숫자카드리스트
M = int(sys.stdin.readline())  #정수 M
M_list = list(map(int,sys.stdin.readline().split())) #N_list에 있는지 확인할 리스트
result = [0]*M  #M_list 각각의 객체들이 몇 개 들어있는지 세어줄 리스트

dic = {}

for i in N_list:  #없으면 추가하고 1, 있으면 +1
  if i in dic:
    dic[i] += 1
  else: 
    dic[i] = 1

for i in M_list:
  if i in dic:
    print(dic[i],end=' ')
  else:
    print(0,end=' ')