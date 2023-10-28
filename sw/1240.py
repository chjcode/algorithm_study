# sw 1240
T = int(input())

for t in range(1, T+1) :
    N, M = map(int, input().split())
    input_code = []
    for _ in range(N) :
        input_code.append(list(input()))

    num = ['0001101', '0011001', '0010011', '0111101', '0100011', '0110001', '0101111', '0111011', '0110111', '0001011']

    code = ''
    for i in range(N) :
        if '1' in input_code[i] :
            for j in range(M) :
                code += input_code[i][j]
            break

    rev_code = code[::-1]
    for i in range(M) :
        if rev_code[i] == '1' :
            rev_code = rev_code[i:i+56]
            break
    code = rev_code[::-1]

    code_num = [code[0:7], code[7:14], code[14:21], code[21:28], code[28:35], code[35: 42], code[42:49], code[49:56]]

    for i in range(8) :
        code_num[i] = num.index(code_num[i])

    sum_odd = code_num[0] + code_num[2] + code_num[4] + code_num[6]
    sum_even = code_num[1] + code_num[3] + code_num[5]
    ver = (sum_odd * 3) + sum_even + code_num[7]

    if ver % 10 == 0 :
        print("#{} {}".format(t, sum(code_num)))
    else :
        print("#{} {}".format(t, 0))