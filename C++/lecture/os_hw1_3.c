#include <stdio.h>
#include <string.h>

int main()
{
    char words[255];
    printf("Input a text: ");
    fgets(words, 255, stdin);

    int len = strlen(words);
    int start = -1;
    int end = -1;
    int count = 0;

    for (int i = 0; i < len; i++)
    {
        char word = words[i];
        if (word == ' ' || word == '\n' || word == '\t')
        {
            if (start != -1 && end != -1)
            {
                printf("words[%d] = (%d, %d, %.*s) \n", count, start, end, end - start,
                       &words[start]);
                start = -1;
                end = -1;
                count += 1;
            }
        }
        else
        {
            if (start == -1)
            {
                start = i;
            }
            end = i + 1;
        }
    }
    return 0;
}
