import operator
n = int(input())
arr = [0, 0, 1, 3, 6]
sum = 0
for i in range(5, n+1):
    for j in range(2, i):
        sum += arr[j]
    arr.append(sum+i)
    sum = 0
print(arr[n])
