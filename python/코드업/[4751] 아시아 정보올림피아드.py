import operator  # 연산 로직을 짤때 연산속도를 더욱 빠르게한다.
import sys  # 사용자의 입력을 받을때 input() 보다 더 빠름
input = sys.stdin.readline

n = int(input())
rank = []
contry = [0] * (n+1)
for i in range(n):
    con, num, score = map(int, input().split())
    rank.append({
        "con": con,
        "num": num,
        "score": score
    })

ans = sorted(rank, key=(lambda x: x["score"]), reverse=True)

chk = 0
for i in ans:
    index = i["con"]
    if contry[index] >= 2:
        continue
    elif contry[index] < 2:
        contry[index] += 1
        print(i["con"], i["num"])
        chk += 1
        if chk == 3:
            break
