#include <math.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/time.h>
#include <time.h>

void InsertionSort(int *A, int n);
void MergeSort(int *A, int left, int right);
void Merge(int *A, int left, int mid, int right);

void GenerateRamdomIntegers(int *A, int n);
bool IsSorted(int *A, int n, bool accedingOrder);
void CheckTheResult(int *A, int n, bool accendingOrder);
void PrintArray(int *A, int n);
int GetCurrentUsec();

int main(void)
{
    int n = 3000;                            // line 20
    int *A = (int *)malloc(n * sizeof(int)); // line 21
    GenerateRamdomIntegers(A, n);            // line 22
    // int A[] = {31, 41, 59, 26, 41, 58}; // line 23
    // int n = sizeof(A) / sizeof(A[0]);   // line 24
    int *B = (int *)malloc(n * sizeof(int));
    memcpy(B, A, n * sizeof(int));

    // printf("Input : ");
    // PrintArray(A, n);
    // CheckTheResult(A, n, true);
    printf("input n : %d\n\n", n);

    int t1, t2;

    // Insertion Sort
    t1 = GetCurrentUsec();
    InsertionSort(A, n);
    t2 = GetCurrentUsec();
    // printf("Output : ");
    // PrintArray(A, n);
    CheckTheResult(A, n, true);
    printf("It took %d usec\n", t2 - t1);

    // Merge Sort
    t1 = GetCurrentUsec();
    MergeSort(B, 0, n - 1);
    t2 = GetCurrentUsec();
    // printf("Output : ");
    // PrintArray(B, n);
    CheckTheResult(B, n, true);
    printf("It took %d usec\n", t2 - t1);

    return 0;
}

void GenerateRamdomIntegers(int *A, int n)
{
    srand(time(NULL));
    for (int i = 0; i < n; i++)
    {
        A[i] = rand() % 100;
    }
    return;
}

void InsertionSort(int *A, int n)
{
    // your code here
    int key, j;
    for (int i = 1; i < n; i++)
    {
        key = A[i];
        for (j = i - 1; j >= 0 && key < A[j]; j--)
        {
            A[j + 1] = A[j];
        }
        A[j + 1] = key;
    }
    return;
}

void MergeSort(int *A, int left, int right)
{
    if (left < right)
    {
        int mid = floor((left + right) / 2);
        // your code here
        MergeSort(A, left, mid);
        MergeSort(A, mid + 1, right);
        Merge(A, left, mid, right);
    }
}

void Merge(int *A, int left, int mid, int right)
{
    int size = right - left + 1;
    int *M = (int *)malloc(sizeof(int) * (size));

    int i = left;
    int j = mid + 1;

    int m = 0;
    while ((i <= mid) && (j <= right))
    {
        if (A[i] <= A[j])
        {
            M[m] = A[i];
            i++;
        }
        else
        {
            M[m] = A[j];
            j++;
        }
        m++;
    }

    while (i <= mid)
    {
        M[m] = A[i];
        i++;
        m++;
    }

    while (j <= right)
    {
        M[m] = A[j];
        j++;
        m++;
    }

    for (int k = 0; k < size; k++)
    {
        A[left + k] = M[k];
    }

    return;
}

void PrintArray(int *A, int n)
{
    printf("{");
    for (int i = 0; i < n; i++)
    {
        printf("%d, ", A[i]);
    }
    printf("}\n");
}

int GetCurrentUsec()
{
    struct timeval tv;
    gettimeofday(&tv, NULL);
    return tv.tv_usec;
}

void CheckTheResult(int *A, int n, bool accendingOrder)
{
    printf("The result is ");
    if (!IsSorted(A, n, true))
        printf("not ");
    printf("sorted in ascending order.\n");
    return;
}

bool IsSorted(int *A, int n, bool accedingOrder)
{
    for (int i = 0; i < n - 1; i++)
    {
        if (accedingOrder)
        {
            if (A[i] > A[i + 1])
                return false;
        }
        else
        {
            if (A[i] < A[i + 1])
                return false;
        }
    }
    return true;
}
