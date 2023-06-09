#include <stdio.h>
#include <string.h>

int main()
{
    char words[255];
    printf("Input a text: ");
    fgets(words, 255, stdin);

    int len = strlen(words);
    char newwords[255] = "";
    strcat(newwords, "[");

    for (int i = 0; i < len; i++)
    {
        char word = words[i];
        if (word == ' ' || word == '\n' || word == '\t')
        {
            strcat(newwords, "]");
            if (len > i + 1)
                strcat(newwords, "[");
        }
        else
        {
            strcat(newwords, " ");
        }
    }

    printf("%s", newwords);
    return 0;
}
