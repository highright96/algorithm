def bSearch(list, left, right, g):
    mid = int((left + right)/2)

    if list[mid] == g:
        return mid
    # 오른쪽
    elif list[mid] < g:
        return bSearch(list, mid+1, right, g)
    # 왼쪽
    elif list[mid] > g:
        return bSearch(list, left, mid-1, g)


n = int(input())

l = list(map(int, input().split()))

sl = sorted(l)

for i in l:
    print(bSearch(sl, 0, len(sl)-1, i), end=" ")
