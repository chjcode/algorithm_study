def solution(numbers, hand):
    answer = ''
    left_hand = (0,3)
    right_hand = (2,3)
    dic = {1:(0,0), 2:(1,0), 3:(2,0), 4:(0,1), 5:(1,1),
          6:(2,1), 7:(0,2), 8:(1,2), 9:(2,2),0:(1,3)}
    for i in numbers:
        if i in [1,4,7]:
            answer += 'L'
            left_hand = dic[i]
        elif i in [3,6,9]:
            answer += 'R'
            right_hand = dic[i]
        else:
            left_dis = abs(dic[i][0] - left_hand[0]) + abs(dic[i][1] - left_hand[1])
            right_dis = abs(dic[i][0] - right_hand[0]) + abs(dic[i][1] - right_hand[1])
            if left_dis < right_dis:
                left_hand = dic[i]
                answer += 'L'
            elif left_dis > right_dis:
                right_hand = dic[i]
                answer += 'R'
            else:
                if hand == 'left':
                    left_hand = dic[i]
                    answer += 'L'
                else:
                    right_hand = dic[i]
                    answer += 'R'    
    
    return answer