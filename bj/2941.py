sen = input()
croatia = ['c=','c-','dz=','d-','lj','nj','s=','z=']

for i in croatia:
  sen = sen.replace(i,'1')
print(len(sen))