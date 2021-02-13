import sys
input = sys.stdin.readline
n = int(input())
l = list(input())
ans = []
cnt = 0
while l:
    if cnt == 3:
        ans.append(",")
        cnt = 0
    ans.append(str(l.pop()))
    cnt += 1

print("".join(ans))
