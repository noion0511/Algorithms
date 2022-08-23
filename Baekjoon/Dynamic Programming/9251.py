n, m = input(), input()
w, h = len(n), len(m)
dp = [[0 for _ in range(w+1)] for _ in range(h+1)]

for i in range(1, h+1):
    for j in range(1, w+1):
        if m[i-1] == n[j-1]:
            dp[i][j] = dp[i-1][j-1] + 1
        else:
            dp[i][j] = max(dp[i-1][j], dp[i][j-1])
        
print(dp[-1][-1])