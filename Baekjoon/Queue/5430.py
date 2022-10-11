import sys
from collections import deque
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    p = input().rstrip()
    n = int(input())
    queue = deque(input().rstrip()[1:-1].split(","))
    rev, error = 0, 0

    if n == 0:
        queue = deque()

    for i in p:
        if i == "R":
            rev += 1
        elif i == "D":
            if len(queue) < 1:
                error += 1
                print("error")
                break
            else:
                if rev % 2 == 0:
                    queue.popleft()
                else:
                    queue.pop()
            
    if error == 0:
        if rev % 2 != 0:
            queue.reverse()
        print("[" + ",".join(queue) + "]")