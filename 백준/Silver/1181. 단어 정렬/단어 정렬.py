N = int(input()) #단어의 개수
word = []

for i in range(N):
  word.append(input())

set_word = list(set(word)) #중복값 제거

sort_word = []
for i in set_word:
  sort_word.append((len(i),i))

result = sorted(sort_word)

for word_len, word in result:
  print(word)
