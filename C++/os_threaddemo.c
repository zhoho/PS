#include <stdio.h>

#include <unistd.h>
#include <pthread.h>

#define NO_THREAD 4

typedef struct
{
    int int_arg;
    char char_arg;
} Thread_Arg;

void *thread_fn(void *arg);

int main()
{
    pthread_t tid[NO_THREAD] = {0};
    Thread_Arg arg[NO_THREAD] = {0};

    int i = 0;
    for (i = 0; i < NO_THREAD; i++)
    {
        arg[i].int_arg = ... arg[i].char_arg = ... pthread_create(&tid[i], NULL, thread_fn, &arg[i]);
    }

    for (i = 0; i < NO_THREAD; i++)
        pthread_join(tid[i], NULL);

    printf("Bye!\n");

    return 0;
}

void *thread_fn(void *arg)
{
    Thread_Arg *targ = (Thread_Arg *)arg;

    //	int *int_arg = (int*)arg;
    printf("Hello, World (idx = %d)\n", *int_arg);

    return NULL;
}
