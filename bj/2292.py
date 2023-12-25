num = int(input())

room = 1 #방
x = 1 #벌집 개수

while num > x :
  x += room * 6
  room += 1
print(room)