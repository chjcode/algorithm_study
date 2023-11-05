from copy import copy
class WordDictionary:

    def __init__(self):
        self.dic = defaultdict(list)

    def addWord(self, word: str) -> None:
        self.dic[len(word)].append(word)

        

    def search(self, word: str) -> bool:
        n=len(word)
        c=copy(self.dic[n])
        if '.'  in word:
            for i in range(n):
                if word[i]=='.':
                    for j in range(len(c)):
                        w=c[j]
                        w=w[:i]+'.'+w[i+1:]
                        c[j]=w
        return word in c



# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)s