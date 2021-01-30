# I 입력시 무조건 배열안에 넣어줌, D 입력시 배열을 돌며 삭제
# 입력이 끝난 배열을 정렬, 동일한 값이 반복되면 첫번째값을 제외하고 모두 삭제
n = int(input())
l = []

for i in range(n):
    type, num, name = input().split()
    if type == "I":
        l.append({
            "num": int(num),
            "name": name
        })
    elif type == "D":
        for j in l[:]:
            if j['num'] == int(num):
                l.remove(j)

index = list(map(int, input().split()))

ans = sorted(l, key=(lambda x: x['num']))
prev = 0
for i in ans[:]:
    if prev == i['num']:
        ans.remove(i)
    else:
        prev = i['num']

for i in index:
    print(ans[i-1]['num'], ans[i-1]['name'])
