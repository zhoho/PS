n, m = map(int, input().split())
row_cheker = []
col_cheker = []

for i in range(n):
    castle = input()
    if 'X' in castle:
        col_cheker.append(i)
    for j in range(m):
        if castle[j] == 'X':
            row_cheker.append(j)

row_checker_len = len(set(row_cheker))
col_checker_len = len(set(col_cheker))
missing_row = m - row_checker_len
missing_col = n - col_checker_len

print(max(missing_row,missing_col))