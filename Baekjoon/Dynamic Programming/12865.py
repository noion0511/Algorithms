n, k = map(int, input().split())
arr = [[0,0]]
dp = [[0 for _ in range(k+1)] for _ in range(n+1)]

for _ in range(n):
    arr.append(list(map(int, input().split())))

for i in range(1, n+1):
    for j in range(1, k+1):
        weight = arr[i][0]
        value = arr[i][1]

        if weight > j:
            dp[i][j] = dp[i-1][j]
        else:
            dp[i][j] = max(value + dp[i-1][j-weight], dp[i-1][j])

        print(dp[i][j], end=" ")
    print("")

print(dp[n][k])