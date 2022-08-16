T = int(input())
arr = [0]*101
arr[1], arr[2], arr[3] = 1, 1, 1

for _ in range(T):
    n = int(input())

    if n > 3:
        for i in range(4,n+1):
            arr[i] = arr[i-3] + arr[i-2]
    print(arr[n])