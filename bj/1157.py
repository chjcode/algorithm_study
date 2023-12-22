alpha = input().upper()
dic = {}
for i in alpha:
    if i in dic:
        dic[i] += 1
    else:
        dic[i] = 1

temp = list(dic.values())
if temp.count(max(temp)) > 1:
    print('?')
else:
    for key, value in dic.items():
        if value == max(temp):
            print(key)