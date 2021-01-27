# a 와 b가 주어졌을때 b 이하의 제네레이터는 b 이하의 수이다.
# 따라서 크기 b의 배열을 생성후 1부터 제네레이터를 찾아 해당 배열을 True로 만들어준다
# 그럼 셀프 넘버(제네레이터가 없는) 수는 False일 것이다.

a, b = map(int, input().split())

l = [False] * (b+1)
ans = 0

for i in range(1, b+1):
    num = str(i)
    sum = 0
    for j in num:
        sum += int(j)
    sum += i
    if sum < len(l):
        l[sum] = True

for i in range(a, b+1):
    if l[i] == False:
        ans += i

print(ans)
