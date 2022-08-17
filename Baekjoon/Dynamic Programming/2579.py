import sys
input = sys.stdin.readline

arr = []
dp = []

n = int(input())
for _ in range(n):
    arr.append(int(input()))

if n == 1:
    print(arr[0])
elif n == 2:
    print(arr[0]+arr[1])
else :
    dp.append(arr[0])
    dp.append(arr[0] + arr[1])
    dp.append(arr[2] + max(dp[0], arr[1]))

    for i in range(3,n):
        dp.append(arr[i] +  max(dp[i-2], dp[i-3] + arr[i-1]))

    print(dp.pop())