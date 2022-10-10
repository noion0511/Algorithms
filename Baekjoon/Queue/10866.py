from collections import deque
import sys
input = sys.stdin.readline

n = int(input())
queue = deque()

for _ in range(n):
    c = input().split()
    if c[0] == "push_front":
        queue.appendleft(int(c[1]))
    elif c[0] == "push_back":
        queue.append(int(c[1]))
    elif c[0] == "pop_front":
        if len(queue) == 0:
            print(-1)
        else:
            print(queue.popleft())
    elif c[0] == "pop_back":
        if len(queue) == 0:
            print(-1)
        else:
            print(queue.pop())
    elif c[0] == "size":
        print(len(queue))
    elif c[0] == "empty":
        if len(queue) == 0:
            print(1)
        else:
            print(0)
    elif c[0] == "front":
        if len(queue) < 1:
            print(-1)
        else:
            front = queue.popleft()
            print(front)
            queue.appendleft(front)
    elif c[0] == "back":
        if len(queue) < 1:
            print(-1)
        else:
            back = queue.pop()
            print(back)
            queue.append(back)