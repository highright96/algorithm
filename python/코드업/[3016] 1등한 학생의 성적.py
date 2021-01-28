n = int(input())
students = []

for i in range(n):
    name, score1, score2, score3 = input().split()
    students.append({
        "name": name,
        "score1": int(score1),
        "score2": int(score2),
        "score3": int(score3)
    })

s1 = sorted(students, key=(lambda x: x['score1']), reverse=True)
s2 = sorted(students, key=(lambda x: x['score2']), reverse=True)
s3 = sorted(students, key=(lambda x: x['score3']), reverse=True)

name = s1[0]["name"]
rank2 = 1
rank3 = 1
for i in range(n):

    if s2[i]["score2"] != s1[0]["score2"]:
        rank2 += 1
    if s3[i]["score3"] != s1[0]["score3"]:
        rank3 += 1

    if s2[i]["name"] == name:
        ans2 = rank2
    if s3[i]["name"] == name:
        ans3 = rank3

print(name, ans2, ans3)
