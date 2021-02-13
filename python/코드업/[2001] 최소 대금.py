p = [int(input()) for _ in range(3)]
j = [int(input()) for _ in range(2)]

pMin = sorted(p)
jMin = sorted(j)
sum = pMin[0]+jMin[0]
sum += sum * 0.1
print('%.1f' % sum)
