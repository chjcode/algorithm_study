# bj 1436 영화감독 숌

n = int(input())
apocalypseNumber = 666
cnt = 0

while True:
    if '666' in str(apocalypseNumber):
        cnt += 1

    if cnt == n:
        break

    apocalypseNumber += 1

print(apocalypseNumber)