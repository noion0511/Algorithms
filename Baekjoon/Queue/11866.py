import sys
from collections import deque

n , m = map(int, sys.stdin.readline().split())
queue = deque()
list = []

for i in range(n):
    queue.append(i+1)

while len(queue) > 0:
    queue.rotate(-m)
    list.append(queue.pop())

print("<", end="")
for i in list:
    if i == list[-1]:
        print(i, end="")
    else:
        print(i, end=", ")
print(">")