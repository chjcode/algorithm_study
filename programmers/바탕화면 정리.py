# def solution(wallpaper):
#     len_x = len(wallpaper)
#     len_y = len(wallpaper[0])
#     lux,luy = 50 ,50
#     rdx,rdy = 0 , 0
    
#     for i in range(len_x):   # i : 0,1,2
#         for j in range(len_y):   # j : 0,1,2 k:.,#
#             if wallpaper[i][j] == '#':
#                 if i < lux:
#                     lux = i
#                 if j < luy:
#                     luy = j
#                 if i > rdx:
#                     rdx = i
#                 if j > rdy:
#                     rdy = j
    
#     answer = [lux,luy,rdx+1,rdy+1]
    
#     return answer

def solution(wall):
    a, b = [], []
    for i in range(len(wall)):
        for j in range(len(wall[i])):
            if wall[i][j] == "#":
                a.append(i)
                b.append(j)
    return [min(a), min(b), max(a) + 1, max(b) + 1]
