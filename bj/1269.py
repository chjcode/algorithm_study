A,B = map(int,input().split())

S_a = set(input().split())
S_b = set(input().split())

print(len(S_a - S_b) + len(S_b - S_a))