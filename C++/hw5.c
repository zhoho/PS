#include <stdio.h>

char coin_names[5][256] = {"half_dollar", "quarter", "dime", "nickel", "penny"};
int coin_prices[] = {50, 25, 10, 5, 1};
const int COINT_TYPE_CNT = 5;

int FindCoins(int cents, int *coins_needed);
void PrintCoinsNeeded(int *coins_needed);

int main(void)
{
    int cents;
    printf("Enter money in cents: ");
    scanf("%d", &cents);

    int coins_needed[COINT_TYPE_CNT];
    int totalCoinsCnt = FindCoins(cents, coins_needed);

    printf("%d cents =\n", cents);
    PrintCoinsNeeded(coins_needed);
    // 2(half_dollar) + 0(quarter) + 2(dime) + 0(nickel) + 3(penny) 출력 형태
    printf("Total number of coins: %d\n", totalCoinsCnt);

    return 0;
}

int FindCoins(int cents, int *coins_needed)
{
    int totalCoinsCnt = 0;
    for (int i = 0; i < COINT_TYPE_CNT; i++)
    {
        coins_needed[i] = cents / coin_prices[i];
        cents = cents % coin_prices[i];
        totalCoinsCnt += coins_needed[i];
    }
    return totalCoinsCnt;
}

void PrintCoinsNeeded(int *coins_needed)
{
    for (int i = 0; i < COINT_TYPE_CNT; i++)
    {
        printf("%d(%s)", coins_needed[i], coin_names[i]);
        if (i == COINT_TYPE_CNT - 1)
            continue;
        printf(" + ");
    }
    printf("\n");
}
