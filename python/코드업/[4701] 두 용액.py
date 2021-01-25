n = int(input())
l = list(map(int, input().split()))

min = 2000000001
a, b = 0, 0
left, right = 0, n-1

l.sort()

while(True):
    if left == right:
        break

    sum = l[left] + l[right]
    if abs(sum) < min:
        min = abs(sum)
        a, b = l[left], l[right]

    if sum > 0:
        right -= 1
    elif sum < 0:
        left += 1
    elif sum == 0:
        break

if a < b:
    print(a, b)
else:
    print(b, a)
