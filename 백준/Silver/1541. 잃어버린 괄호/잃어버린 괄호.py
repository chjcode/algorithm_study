# 1541 잃어버린 괄호

lst = input().split('-')
result = 0
for i in lst[0].split('+'):
  result += int(i)
for i in lst[1:]:
  i_split = i.split('+')
  i_int = list(map(int,i_split))
  i_sum = sum(i_int)
  result -= i_sum

print(result)