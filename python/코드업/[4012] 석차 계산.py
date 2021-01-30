n = int(input())
l = list(map(int, input().split()))
r = [0] * n

s = sorted(l, reverse=True)
prev = -1
rank = 1
for i in range(n):
    if prev != s[i]:
        prev = s[i]
        for j in range(n):
            if l[j] == s[i]:
                r[j] = rank
    rank += 1

for i in range(n):
    print(l[i], r[i])
