import sys
input = sys.stdin.readline

n = int(input())  # 토핑의 종류 수
a, b = map(int, input().split())  # 도우 가격, 토핑 가격
d = int(input())  # 도우 칼로리
t = [int(input()) for _ in range(n)]  # 토핑 칼로리

max = 0
t.sort(reverse=True)
kal = d
price = a
for k in t:
    if max < k//b:
        kal += k
        price += b
        max = kal // price
print(max)
