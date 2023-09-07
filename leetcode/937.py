class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        # '''
        # 1. 문자 로그는 모든 숫자로그 앞에 온다.
        # 2. letter-log는 사전순으로 정렬되는데, 내용이 동일하면 식별자를 기준으로 사전순으로 정렬된다.
        # 3. digit-log는 상대적 순서를 유지한다.
        # -------------------
        # 1. 문자 로그는 숫자로그 앞에 오므로
        # 문자로그와 숫자로그를 구분한다.
        # 2. letter-log 조건에 맞게 정렬한다.
        # 3. digit-log는 그대로 저장한다.
        # 4. letter-log와 digit-log합친다.
        # '''

        # letter_logs = []
        # digit_logs = []
        # for log in logs:
        #     log_lst = log.split()
        #     if log_lst[1].isdigit():
        #         digit_logs.append(log)
        #     else:
        #         letter_logs.append(log_lst)

        # letter_logs = sorted(letter_logs, key=lambda x:(x[1:],x[0]))

        # output = []
        # for log in letter_logs:
        #     log = ' '.join(log)
        #     output.append(log)
        # output += digit_logs

        # return output

        letter_logs = []
        digit_logs = []
        for log in logs:
            log_lst = log.split()
            if log_lst[1].isdigit():
                digit_logs.append(log)
            else:
                letter_logs.append(log_lst)

        def compare(a,b):
            # 큰 값이 뒤로 와야 되니까 순서 바꾸기 위해 return 1
            if a[1:] > b[1:]:
                return 1
            # 작은 값이 앞에 있는게 맞으니까 순서 바꾸지 않기 위해 return -1
            elif a[1:] < b[1:]:
                return -1
            # 값이 같을 경우 식별자 기준으로 정렬
            else:
                if a[0] > b[0]:
                    return 1
                elif a[0] < b[0]:
                    return -1
                else:
                    return 0

        letter_logs = sorted(letter_logs, key=cmp_to_key(compare))

        output = []
        for log in letter_logs:
            log = ' '.join(log)
            output.append(log)
        output += digit_logs

        return output