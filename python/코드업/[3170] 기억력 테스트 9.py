import operator  # 연산 로직을 짤때 연산속도를 더욱 빠르게한다.
import sys  # 사용자의 입력을 받을때 input() 보다 더 빠름
input = sys.stdin.readline

dic = {}
s, q = map(int, input().split())

for i in range(s):
    a, b = input().split()
    if a in dic.keys():
        dic[a] += int(b)
    else:
        dic[a] = int(b)

ans = []
for j in range(q):
    a = input()[:-1]
    if a in dic.keys():
        ans.append(dic[a])
    else:
        ans.append(0)

for k in ans:
    print(k)

# n, m = map(int, input().split())
# tmp = {}
# test = []
# for i in range(n):
#     t = input().split()
#     tmp.setdefault(t[0], 0)
#     tmp[t[0]] += int(t[1])
# for i in range(m):
#     test.append(input()[:-1])
# for i in test:
#     tmp.setdefault(i, 0)
#     print(tmp[i])
