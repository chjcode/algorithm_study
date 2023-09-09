import heapq
class Solution:
    def kSmallestPairs(self, nums1: List[int], nums2: List[int], k: int) -> List[List[int]]:

        heap = []
        lst = []
        max_num = 0
        for i in range(len(nums1)):
            for j in range(len(nums2)):
                s = nums1[i] + nums2[j]
                if len(heap) == k:
                    if s > -heap[0][0]:
                        break
                    heapq.heappushpop(heap,(-s,[nums1[i],nums2[j]]))
                else:
                    heapq.heappush(heap,(-s,[nums1[i],nums2[j]]))
        output = []
        for _,lst in heap:
            output.append(lst)
            
        return output
                    

# import heapq

# class Solution:
#     def kClosest(self, points: List[List[int]], K: int) -> List[List[int]]:
        
#         heap = []
        
#         for (x, y) in points:
#             dist = -(x*x + y*y)
#             if len(heap) == K:
#                 heapq.heappushpop(heap, (dist, x, y))
#             else:
#                 heapq.heappush(heap, (dist, x, y))
        
#         return [(x,y) for (dist,x, y) in heap]