n = int(input())
arr = []
for i in range(n):
    arr.append(list(map(int, input().split())))

for i in range(1,n):
    for j in range(i+1):
        if j == 0:
            arr[i][j] = arr[i][j] + arr[i-1][j]
        elif i == j:
            arr[i][j] = arr[i][j] + arr[i-1][j-1]
        else:
            arr[i][j] = arr[i][j] + max(arr[i-1][j], arr[i-1][j-1])
print(max(arr[n-1]))