n = int(input())
l = []
ans = []
for i in range(n):
    name, year, month, date = input().split()
    l. append({
        "name": name,
        "sum": int(year + month + date)
    })

s = sorted(l, key=(lambda x: x['sum']))

# 날짜가 같은 스케줄끼리 따로 모아 2차원 배열로 만듬
# 예제
# [
# ['baseball'],
# ['sleep', 'study'],
# ['golf']
# ]

prev = s[0]["sum"]
tmp = []
for i in s:
    if i == s[n-1]:  # 배열의 마지막
        if i["sum"] == prev:
            tmp.append(i["name"])
            tmp.sort()
            ans.append(tmp.copy())  # 배열 깊은 복사
        else:
            tmp.sort()
            ans.append(tmp.copy())
            tmp.clear()
            tmp.append(i["name"])
            ans.append(tmp.copy())

    elif i["sum"] == prev:
        tmp.append(i["name"])
    elif i["sum"] != prev:
        prev = i["sum"]
        tmp.sort()
        ans.append(tmp.copy())
        tmp.clear()
        tmp.append(i["name"])


for i in ans:
    for j in i:
        print(j)
