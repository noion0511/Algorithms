import sys
from collections import deque
input = sys.stdin.readline

n,m = map(int, input().split())
arr = list(map(int, input().split()))
queue = deque()
count = 0

for i in range(1, n+1):
    queue.append(i)

for i in arr:
    if queue.index(i) >= n - queue.index(i):
        min = n - queue.index(i)
        queue.rotate(min)
    else:
        min = queue.index(i)
        queue.rotate(-min)
    queue.popleft()
    n -= 1
    count += min

print(count)