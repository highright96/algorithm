n = int(input())
data = [[0 for _ in range(3)] for __ in range(n)]
idx = 1
for i in range(n):
    a, b = map(int, input().split())
    data[i][0] = idx
    data[i][1] = a
    data[i][2] = b
    idx += 1

for i in range(n):
    for j in range(n-i-1):
        if data[j][1] < data[j+1][1]:
            data[j], data[j+1] = data[j+1], data[j]
        elif data[j][1] == data[j+1][1]:
            if data[j][2] < data[j+1][2]:
                data[j], data[j+1] = data[j+1], data[j]
            elif data[j][2] == data[j+1][2]:
                if data[j][0] > data[j+1][0]:
                    data[j], data[j+1] = data[j+1], data[j]

for i in data:
    for j in i:
        print(j, end=" ")
    print()
