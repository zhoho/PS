#include <stdio.h>
#include <stdlib.h>
#include <sys/time.h>
#include <time.h>
#define max(x, y) (x) > (y) ? (x) : (y)
void GenSeq(char *s, int n);
const int num_alphabet = 5;
void PrintSeq(char *s, int n);
int LCS(char *X, char *Y, int i, int j);
int LCS_Length(char *X, char *Y, int i, int j);
int **c;
int **b; // 0: '↖', -1: '↑', 1: '←'
void PRINT_LCS(int **b, char *X, int i, int j);
int FindMax(int a, int b);
int GetCurrentUsec();

int main(void)
{
    int i = 5; // length of X
    int j = 5; // length of Y

    char *X, *Y; // sequences
    X = (char *)malloc(sizeof(char) * i);
    Y = (char *)malloc(sizeof(char) * j);

    c = (int **)malloc(sizeof(int *) * (i + 1));
    for (int k = 0; k < i + 1; k++)
        c[k] = (int *)malloc(sizeof(int) * (j + 1));
    b = (int **)malloc(sizeof(int *) * (i + 1));
    for (int k = 0; k < i + 1; k++)
        b[k] = (int *)malloc(sizeof(int) * (j + 1));

    srand(time(NULL));
    GenSeq(X, i);
    GenSeq(Y, j);

    PrintSeq(X, i);
    PrintSeq(Y, j);

    int t1, t2, result;

    // Divide and Conquer
    t1 = GetCurrentUsec();
    result = LCS(X, Y, i, j);
    t2 = GetCurrentUsec();
    printf("Then length of LCS is %d.\n", result);
    printf("Divide and Conquer took %d usec.\n", t2 - t1);

    // Dynaic Programming
    t1 = GetCurrentUsec();
    result = LCS_Length(X, Y, i, j);
    t2 = GetCurrentUsec();
    printf("Then length of LCS is %d.\n", result);
    printf("Dynamic Programming took %d usec.\n", t2 - t1);

    printf("<");
    PRINT_LCS(b, X, i, j);
    printf(">\n");

    return 0;
}

//////////////////////////////
//  write your answer below //
//////////////////////////////
/*

for i = 2, j = 2
Divide and Conquer took : [ ] usec.
Dynamic Programming took : [ ] usec.

for i = 5, j = 5
Divide and Conquer took : [ ] usec.
Dynamic Programming took : [ ] usec.

for i = 10, j = 10
Divide and Conquer took : [ ] usec.
Dynamic Programming took : [ ] usec.

for i = 15, j = 15
Divide and Conquer took : [ ] usec.
Dynamic Programming took : [ ] usec.

*/
//////////////////////////////

int LCS(char *X, char *Y, int i, int j)
{
    // int c;
    // your code here, Divide and Conquer method using recursion
    // if (X[i] == Y[j]) {
    //   c[i][j] = LCS(X, Y, i - 1, j - 1) + 1;
    // } else {
    //   c[i][j] = max(LCS(X, Y, i - 1, j), LCS(X, Y, i, j - 1));
    // }
    // return c[i][j];

    if (c[i][j] != -1)
    {
        return c[i][j];
    }
    if (X[i] == Y[j])
    {
        c[i][j] = LCS(X, Y, i + 1, j + 1) + 1;
    }
    else
    {
        c[i][j] = max(LCS(X, Y, i + 1, j), LCS(X, Y, i, j + 1));
    }
    return c[i][j];
}

int FindMax(int a, int b)
{
    if (a >= b)
        return a;
    else
        return b;
}

int LCS_Length(char *X, char *Y, int i, int j)
{
    for (int k = 0; k < i + 1; k++)
        c[i][0] = 0;
    for (int k = 0; k < j + 1; k++)
        c[0][j] = 0;
    for (int k = 1; k < i + 1; k++)
    {
        for (int l = 1; l < j + 1; l++)
        {
            // your code here
            if (X[i] == Y[j])
            {
                c[i][j] = c[i - 1][j - 1] + 1;
                b[i][j] = 0;
            }
            else
            {
                if (c[i - 1][j] >= c[i][j - 1])
                {
                    c[i][j] = c[i - 1][j];
                    b[i][j] = -1;
                }
                else
                {
                    c[i][j] = c[i][j - 1];
                    b[i][j] = 1;
                }
            }
        }
    }
    return c[i][j];
}

void PRINT_LCS(int **b, char *X, int i, int j)
{
    // your code here
    if (i == 0 || j == 0)
    {
        return;
    }
    if (b[i][j] == 0)
    {
        PRINT_LCS(b, X, i - 1, j - 1);
        printf("%c", X[i - 1]);
    }
    else if (b[i][j] == -1)
    {
        PRINT_LCS(b, X, i - 1, j);
    }
    else
    {
        PRINT_LCS(b, X, i, j - 1);
    }
}

int GetCurrentUsec()
{
    struct timeval tv;
    gettimeofday(&tv, NULL);
    return tv.tv_usec;
}

void GenSeq(char *s, int n)
{
    for (int i = 0; i < n; i++)
    {
        s[i] = (char)((random() % num_alphabet) + 'A');
    }
    return;
}

void PrintSeq(char *s, int n)
{
    printf("<");
    for (int i = 0; i < n; i++)
    {
        printf("%c, ", s[i]);
    }
    printf(">\n");
}
