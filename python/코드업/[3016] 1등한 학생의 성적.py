import operator
import sys
input = sys.stdin.readline

tmp = []
for i in range(int(input())):
    tmp.append(input().split())
tmp.sort(key=lambda x: int(x[1]), reverse=True)

ans = [tmp[0][0], 1, 1]
for i in tmp:
    if int(i[2]) > int(tmp[0][2]):
        ans[1] += 1
    if int(i[3]) > int(tmp[0][3]):
        ans[2] += 1

print(*ans)
