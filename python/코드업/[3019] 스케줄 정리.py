n = int(input())
l = []
ans = []
for i in range(n):
    name, year, month, date = input().split()
    ans.append([int(year), int(month), int(date), name])
ans.sort()
for i in ans:
    print(i[3])
