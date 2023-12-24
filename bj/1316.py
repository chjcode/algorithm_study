num = int(input())
word_num = 0

for _ in range(num):
  word = input()
  for i in word:
    word = word.lstrip(i)
    if i in word:
      break
  if len(word) == 0:
    word_num += 1
print(word_num)