class Solution:
    def maxArea(self, height: List[int]) -> int:
        left = 0
        right = len(height)-1
        area = 0

        while left < right:
            temp_area = min(height[left],height[right])*(right-left)
            area = max(area,temp_area)

            if height[left] < height[right]:
                left += 1
            else:
                right -= 1

        return area