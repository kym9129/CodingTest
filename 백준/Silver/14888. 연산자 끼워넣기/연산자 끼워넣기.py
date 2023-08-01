N = int(input())
numbers = list(map(int, input().split()))
operands = list(map(int, input().split())) # + - * /

max_val = -1e9
min_val = 1e9

def dfs(depth, result, add, sub, multi, divis):
    global max_val, min_val
    if depth == N:
        max_val = max(result, max_val)
        min_val = min(result, min_val)
        return
    
    if add:
        dfs(depth+1, result + numbers[depth], add-1, sub, multi, divis)
    if sub:
        dfs(depth+1, result - numbers[depth], add, sub-1, multi, divis)
    if multi:
        dfs(depth+1, result * numbers[depth], add, sub, multi-1, divis)
    if divis:
        dfs(depth+1, int(result / numbers[depth]), add, sub, multi, divis-1)

dfs(1, numbers[0], operands[0], operands[1], operands[2], operands[3])

print(max_val)
print(min_val)
