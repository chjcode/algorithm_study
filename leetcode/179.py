# from itertools import permutations
# class Solution:
#     def largestNumber(self, nums: List[int]) -> str:
#         max_num = 0
#         for lst in permutations(map(str,nums),len(nums)):
#             num = ''.join(lst)
#             max_num = max(int(num),max_num)

#         return str(max_num)

from functools import cmp_to_key

class Solution:
    def largestNumber(self, nums: List[int]) -> str:
        def compare(a,b):
            if a+b < b+a:
                return 1
            else:
                return -1

        nums = list(map(str,nums))
        nums = sorted(nums, key=cmp_to_key(compare))
        return str(int(''.join(nums)))
