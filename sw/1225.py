# swea 1225 암호생성기

from collections import deque

def code(deq):
    while True:
        for i in range(1,6):
            front = deq.popleft()
            end = front - i
            if end <= 0:
                deq.append(0)
                return list(deq)
            deq.append(end)

for _ in range(10):
    test_case = int(input())
    deq = deque(list(map(int,input().split())))

    answer = ' '.join(map(str,code(deq)))

    print(f"#{test_case} {answer}")