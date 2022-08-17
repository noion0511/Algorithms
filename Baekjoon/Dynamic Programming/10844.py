n = int(input())
arr = [[0 for _ in range(10)] for _ in range(n + 1)]

arr[1] = [0, 1, 1, 1, 1, 1, 1, 1, 1, 1]

for i in range(2, n+1):
    arr[i][0] = arr[i-1][1]
    arr[i][9] = arr[i-1][8]

    for j in range(1, 9):
        arr[i][j] = arr[i-1][j-1] + arr[i-1][j+1]

print(sum(arr[n]) % 1000000000)