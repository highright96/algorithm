n = int(input())
dic = {}
for i in range(n):
    type, num, name = input().split()
    if type == 'D' and int(num) in dic:
        del dic[int(num)]
    elif type == 'I' and int(num) not in dic:
        dic[int(num)] = name

result = list(map(int, input().split()))
ans = sorted(dic.keys())
for i in result:
    print(ans[i-1], dic[ans[i-1]])
