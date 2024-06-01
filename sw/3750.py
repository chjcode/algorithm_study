# swea 3750. Digit sum

t = int(input())
result = []
for tc in range(1,t+1):
    n = input()
    lst = list(map(int,n))
    answer = n

    while True:
        if len(lst) == 1:
            break
        answer = 0

        for num in lst:
            answer += int(num)

        lst = str(answer)

    result.append(answer)

for idx,r in enumerate(result):
    print(f'#{idx+1} {r}')




'''
입력
3
5
108
588432	// Test Case 수
// Test Case 1, n = 5


sample_input.txt
출력
#1 5
#2 9
#3 3	// Test Case 1의 정답


'''