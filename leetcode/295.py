# leetcode 295. Find Median from Data Stream -> 정렬

class MedianFinder:

    def __init__(self):
        self.lst = []

    def addNum(self, num: int) -> None:
        self.lst.append(num)

    def findMedian(self) -> float:
        self.lst.sort()
        len_lst = len(self.lst)
        if len_lst%2 == 1:
            return self.lst[len_lst//2]
        else:
            return (self.lst[len_lst//2] + self.lst[len_lst//2-1])/2