
# 2179 비슷한 단어 -> 문자열

def count(a,b):
    cnt = 0
    for i in range(min(len(a),len(b))):
        if a[i] == b[i]:
            cnt += 1
        else:
            break
    return cnt


# 입력 받기
n = int(input())
voca = [(input(),i) for i in range(n)]
s_voca = sorted(voca,key=lambda x:x[0])

voca_len = [0 for _ in range(n+1)]
max_len_voca = 0

for i in range(n-1):
    cnt = count(s_voca[i][0],s_voca[i+1][0])
    max_len_voca = max(cnt,max_len_voca)
    voca_len[s_voca[i][1]] = max(voca_len[s_voca[i][1]],cnt)
    voca_len[s_voca[i+1][1]] = max(voca_len[s_voca[i+1][1]],cnt)

flag = False
for i in range(n):
    if not flag:
        if voca_len[i] == max(voca_len):
            print(voca[i][0])
            same = voca[i][0][:max_len_voca]
            flag = True
    else:
        if voca_len[i] == max(voca_len) and voca[i][0][:max_len_voca] == same:
            print(voca[i][0])
            break