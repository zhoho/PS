def solution(arr, queries):
    for i in range(len(queries)):
        tmp = arr[queries[i][0]] 
        arr[queries[i][0]] = arr[queries[i][1]]
        arr[queries[i][1]] = tmp
    return arr