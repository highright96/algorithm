def BSort(l, len):
    for i in range(len):
        chk = 0
        for j in range(len-i-1):
            if l[j] > l[j+1]:
                chk += 1
                l[j], l[j+1] = l[j+1], l[j]
        if chk == 0:
            print(i)
            return


n = int(input())
l = list(map(int, input().split()))
BSort(l, n)
