import operator

n = int(input())
l = list(map(int, input().split()))
dic = {}

sList = sorted(l)

for i in range(0, len(l)):
    dic[sList[i]] = i

for j in l:
    print(dic[j], end=' ')
