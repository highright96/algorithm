factory = []

n = int(input())

for i in range(n):
    a, b = map(int, input().split())
    factory.append({
        "a": a,
        "b": b
    })

ans = sorted(factory, key=(lambda x: x['a']))

for i in ans:
    print(i["a"], i["b"])
