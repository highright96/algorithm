import sys
input = sys.stdin.readline
a, b = map(int, input().split())

arr = [0, 1, 2, 3, 2, 1, 2, 3, 3, 2, 1]

c = abs(a-b)
div = int(c / 10)
rm = c % 10

print(div + arr[rm])
