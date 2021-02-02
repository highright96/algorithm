n1, n2 = map(int, input().split())
students = []

for i in range(n1):
    name, score = input().split()
    students.append({
        "name": name,
        "score": int(score)
    })

ans = sorted(students, key=(lambda x: x['score']), reverse=True)

for i in range(n2):
    print(ans[i]["name"])

[{}, {}, {}, {}]
