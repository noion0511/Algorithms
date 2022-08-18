n = int(input())
arr = []
dp = [0 for _ in range(n)]

for _ in range(n):
    arr.append(int(input()))

dp[0] = arr[0]

if n > 1:
    dp[1] = arr[1] + arr[0]
if n > 2:
    dp[2] = max(arr[0] + arr[2], arr[1] + arr[2], dp[1])
if n > 3:
    for i in range(3, n):
        dp[i] = max(dp[i-2] + arr[i], dp[i-3] + arr[i-1] + arr[i], dp[i-1])

print(max(dp))