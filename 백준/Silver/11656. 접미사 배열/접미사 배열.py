word = list(input())
lst = []
for i in range(len(word)):
    lst.append(''.join(word[i:]))

lst = sorted(lst)

for l in lst:
    print(l)