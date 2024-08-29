#include <stdio.h>
#include <stdlib.h>

int compare(const void *a, const void *b) {
    return (*(int *)a - *(int *)b);
}

int main() {
    int n;
    scanf("%d", &n);
    
    int nums[n];
    for (int i = 0; i < n; i++) {
        scanf("%d", &nums[i]);
    }
    
    // 배열을 정렬합니다.
    qsort(nums, n, sizeof(int), compare);
    
    int count = 0;
    
    for (int k = 0; k < n; k++) {
        int i = 0;
        int j = n - 1;
        
        while (i < j) {
            if (i == k) {
                i++;
                continue;
            }
            if (j == k) {
                j--;
                continue;
            }
            
            if (nums[i] + nums[j] == nums[k]) {
                count++;
                break;
            } else if (nums[i] + nums[j] < nums[k]) {
                i++;
            } else {
                j--;
            }
        }
    }
    
    printf("%d\n", count);
    
    return 0;
}