num = int(input())
num_list = []

for _ in range(num):
  order = int(input())
  if order == 0:
    num_list.pop(-1)
  else:
    num_list.append(order)
print(sum(num_list))