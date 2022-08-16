n = int(input())

arr = [0]*(n+2)
arr[1] = 1
arr[2] = 2

for i in range(3, n+1):
    arr[i] = (arr[i-1] + arr[i-2])%15746

print(arr[n])