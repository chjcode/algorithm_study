def solution(lottos, win_nums):
    dic = {6:1, 5:2, 4:3, 3:4, 2:5, 1:6, 0:6}
    same_num = 0
    count0 = 0
    for i in lottos:
        if i == 0:
            count0 += 1
        elif i in win_nums:
            same_num += 1
    max = dic[same_num + count0]
    min = dic[same_num]

    return [max,min]