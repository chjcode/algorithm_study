class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        '''
        가까운것을 어떻게 저장하고 뺄건지? -> 힙 사용?
        '''
        heap = []
        for x,y in points:
            dist = x**2 + y**2
            heapq.heappush(heap, [dist,x,y])

        output = []
        for _ in range(k):
            dist,x,y = heapq.heappop(heap)
            output.append([x,y])

        return output

# class Solution:
#     def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:

#         distances = []
#         res = []

#         for i in range(len(points)):
#             distance =  math.sqrt( ( points[i][0] ) **2 + ( points[i][1] ) **2  )
#             distances.append([distance,points[i]])

#         distances.sort()


#         for i in range(k):
#             res.append(distances[i][1])


#         return res