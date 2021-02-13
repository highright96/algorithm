def dp(x):
    for i in range(2, x+1):
        arr.append(arr[-2] + arr[-1])


n = int(input())
arr = [0, 1]

dp(n)
print(arr[n])
