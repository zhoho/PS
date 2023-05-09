
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include <unistd.h>
#include <wait.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <sys/ipc.h>
#include <sys/shm.h>

#define _DEBUG // do not disable this macro

#define TRUE 1
#define FALSE 0

#define P2C 0 // parent to child
#define C2P 1 // child to parent

#define MAX_LEN 128

typedef struct
{
    int is_loaded;        // is_loaded == TRUE indicates a data is loaded in buffer. otherwise, buffer is not ready
    char buffer[MAX_LEN]; // buffer to store the data
} SharedBuffer;

/*
    Transferring data through SharedBuffer

    sender:
        wait until is_loaded becomes FALSE
        store data in buffer
        set is_loaded to TRUE

    receiver:
        wait until is_loaded becomes TRUE
        retrieve data from buffer
        set is_loaded to FALSE

*/

void *Parent(void *arg);
void *Child(void *arg);
int Evaluate(char *expression);

int main(int argc, char *argv[])
{
    // TO DO: allocate an array composed of two SharedBuffer instances in a shared memory block
    //		the size of shared memory block should be sizeof(SharedBuffer) * 2.
    // 		one is for data transfer from the parent to the child.
    // 		the other is for data transfer from the child to the parent.
    //		call shmget() and shmat()
    // 		on failure, display an error message, deallocate the shared memory block if necessary, and quit.
    // 		otherwise, display the id of the shared memory block for debug.
    int shmid;
    SharedBuffer *shm_buffer;
    shmid = shmget(IPC_PRIVATE, sizeof(SharedBuffer) * 2, IPC_CREAT | 0666);
    if (shmid == -1)
    {
        printf("Error: shmget failed.\n");
        exit(1);
    }
    shm_buffer = (SharedBuffer *)shmat(shmid, NULL, 0);
    if (shm_buffer == (void *)-1)
    {
        printf("Error: shmat failed.\n");
        shmctl(shmid, IPC_RMID, NULL);
        exit(1);
    }
    printf("shmid=%d.\n", shmid);

    // initialize shm_buffer[0] and shm_buffer[1] (set the is_loaded fields to FALSE and the buffer fields to an empty string.)
    shm_buffer[P2C].is_loaded = FALSE;
    shm_buffer[P2C].buffer[0] = 0;
    shm_buffer[C2P].is_loaded = FALSE;
    shm_buffer[C2P].buffer[0] = 0;

    // TO DO: create a child process
    // 		on failure, display an error message, detatch and deallocate the shared memory block, and terminate.
    //		In the child process,
    //			call the Child() function passing the address to the SharedBuffer array.
    //			detatch the shared memory block
    //			call exit(0) for safety
    // 		In the parent process,
    //			call the Parent() function passing the address to the SharedBuffer array.
    //			detatch and destroy the shared memory block
    pid_t pid;
    pid = fork();
    if (pid == -1)
    {
        printf("Failed to fork");
        shmdt(shm_buffer);
        shmctl(shmid, IPC_RMID, NULL);
        exit(1);
    }
    if (pid == 0)
    {
        Child(shm_buffer);
        shmdt(shm_buffer);
        exit(0);
    }
    else
    {
        Parent(shm_buffer);
        shmdt(shm_buffer);
        shmctl(shmid, IPC_RMID, NULL);
    }

    system("ipcs"); // run 'icps' to check if the shared memory block was correctly deallocated
                    // if your VM does not have icps, install it by running 'sudo apt install util-linux'
    printf("Bye!\n");

    return 0;
}

void *Parent(void *arg)
{
    // TO DO: implement this function
    //         read integer expressions from the user
    //         send the expression to the child process through the shareed memory buffer
    //        receive the result from the child through the shared memory buffer
    //        display the expression and result
    SharedBuffer *shm_buffer = (SharedBuffer *)arg;

    // Algorithm)
    //    repeat until the user types "quit"
    //         read an integer expression as a string (e.g., "5+3", "7 * 5", etc.) - use fgets()
    //         if the input is not an empty string,
    //             send the expression to the child through shm_buffer[P2C]
    //                 wait until the is_loaded field is FALSE
    //                copy the expression into the buffer field
    //                set the is_loaded field to TRUE
    //             if the input string is "quit", break the loop
    //             receive the result of the expression from the child through shm_buffer[C2P]
    //                wait until the is_loaded field is TRUE
    //                copy the result from the buffer field
    //                set the is_loaded field to FALSE
    //             display the expression and the result from the child.
    //    display a message indicating that the parent is terminating.

    char expression[MAX_LEN];
    int result;
    while (1)
    {
        printf("[parent] Input an integer binary expression(type \"quit\" to finish.): ");
        fgets(expression, MAX_LEN, stdin);
        if (strcmp(expression, "quit\n") == 0)
        {
            break;
        }
        expression[strcspn(expression, "\n")] = 0;
        while (shm_buffer[P2C].is_loaded == TRUE)
        {
        }
        strcpy(shm_buffer[P2C].buffer, expression);
        shm_buffer[P2C].is_loaded = TRUE;

        while (shm_buffer[C2P].is_loaded == FALSE)
        {
        }
        result = atoi(shm_buffer[C2P].buffer);
        shm_buffer[C2P].is_loaded = FALSE;

        printf("[parent] %s = %d\n", expression, result);
    }
}

void *Child(void *arg)
// TO DO: implement this function
//         receive an integer expressions from the parent by message passing
//        compute the result of the expression
//         send the result to the parent process by message passing
{
    SharedBuffer *shm_buffer = (SharedBuffer *)arg;
    // Algorithm)
    //     repeat until the incomming message is "quit"
    //         receieve an expression from the parent through the message queue p2c.
    //             on failure, display an error message.
    //         for debug, display the incoming message, its index, and the return value of msgrcv().
    //         if the message is "quit", break the loop
    //         compute the evaluation in the incoming message
    //         for debug, display the outgoing message and its index.
    //         send the result as a string to the parent through the message queue c2p.
    //             on failure, display an error message.
    //        for debug, display the return value of msgsnd().
    //         increase the index of outgoing message.
    //
    //    display a message indicating that the child is terminating.

    char expression[MAX_LEN] = "";
    int result;
    while (TRUE)
    {
        while (shm_buffer[P2C].is_loaded == FALSE)
        {
            usleep(1);
        }
        strcpy(expression, shm_buffer[P2C].buffer);
        shm_buffer[P2C].is_loaded = FALSE;

        if (strcmp(expression, "quit") == 0)
        {
            printf("[child] received expression \"%s\"\n", expression);
            printf("[child] Terminating Child.\n");
            return NULL;
        }
        result = Evaluate(expression);
        sprintf(shm_buffer[C2P].buffer, "%d", result);
        shm_buffer[C2P].is_loaded = TRUE;
        printf("[child] received expression \"%s\"\n", expression);
        printf("[child] sending result \"%d\"\n", result);
    }
    printf("Terminating Child.\n");
}

int Evaluate(char *expression)
{
    int op1 = 0, op2 = 0;
    char op = 0;
    int result = 0;

    int ret = sscanf(expression, "%d %c %d", &op1, &op, &op2);
    if (ret == 3)
    {
        switch (op)
        {
        case '+':
            result = op1 + op2;
            break;

        case '-':
            result = op1 - op2;
            break;

        case '*':
            result = op1 * op2;
            break;

        case '/':
            if (op2 != 0)
                result = op1 / op2;
            break;
        }
    }

    return result;
}

//////////////////////////////////////////
// origin code
// ork하고 else문에서 wait함수 추가
// parent에서 입력 받았을 때 뒤에 널 값 넣어주면 좋을 것 같아요. 그리고 부모 종료된 거 프린트하면 좋을것같다
//////////////////////////////////////////

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include <unistd.h>
#include <wait.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <sys/ipc.h>
#include <sys/shm.h>

#define _DEBUG // do not disable this macro

#define TRUE 1
#define FALSE 0

#define P2C 0 // parent to child
#define C2P 1 // child to parent

#define MAX_LEN 128

typedef struct
{
    int is_loaded;        // is_loaded == TRUE indicates a data is loaded in buffer. otherwise, buffer is not ready
    char buffer[MAX_LEN]; // buffer to store the data
} SharedBuffer;

/*
    Transferring data through SharedBuffer

    sender:
        wait until is_loaded becomes FALSE
        store data in buffer
        set is_loaded to TRUE

    receiver:
        wait until is_loaded becomes TRUE
        retrieve data from buffer
        set is_loaded to FALSE

*/

void *Parent(void *arg);
void *Child(void *arg);
int Evaluate(char *expression);

int main(int argc, char *argv[])
{

    key_t key = ftok("shmfile", 65);
    int shmid = shmget(key, sizeof(SharedBuffer) * 2, 0666 | IPC_CREAT);

    if (shmid < 0)
    {
        printf("Failed to create shared memory");
        exit(-1);
    }
    printf("shmid = %d\n", shmid);
    SharedBuffer *shm_buffer = (SharedBuffer *)shmat(shmid, (void *)0, 0);
    if (shm_buffer == (void *)-1)
    {
        printf("Failed to attach shared memory");
        shmctl(shmid, IPC_RMID, NULL);
        exit(-1);
    }

    shm_buffer[P2C].is_loaded = FALSE;
    shm_buffer[P2C].buffer[0] = 0;
    shm_buffer[C2P].is_loaded = FALSE;
    shm_buffer[C2P].buffer[0] = 0;

    pid_t pid = fork();

    if (pid < 0)
    {
        printf("Failed to fork");
        shmdt(shm_buffer);
        shmctl(shmid, IPC_RMID, NULL);
        exit(-1);
    }

    if (pid == 0)
    {
        Child(shm_buffer);
        shmdt(shm_buffer);
        exit(0);
    }
    else
    {
        Parent(shm_buffer);
        wait(NULL);
        shmdt(shm_buffer);
        shmctl(shmid, IPC_RMID, NULL);
    }
    system("ipcs");
    printf("Bye!\n");
    return 0;
}

void *Parent(void *arg)
{
    SharedBuffer *shm_buffer = (SharedBuffer *)arg;
    char expression[MAX_LEN] = "";
    char result[MAX_LEN] = "";

    while (1)
    {
        printf("[parent] Input an integer binary expressions(type \"quit\" to finish.): ");
        fgets(expression, MAX_LEN, stdin);
        expression[strlen(expression) - 1] = 0;

        if (strlen(expression) == 0)
        {
            continue;
        }

        while (shm_buffer[P2C].is_loaded)
            ;
        strcpy(shm_buffer[P2C].buffer, expression);
        shm_buffer[P2C].is_loaded = TRUE;

        if (strcmp(expression, "quit") == 0)
        {
            break;
        }

        while (!shm_buffer[C2P].is_loaded)
            ;
        strcpy(result, shm_buffer[C2P].buffer);
        shm_buffer[C2P].is_loaded = FALSE;

        printf("[parent] %s = %s\n", expression, result);
    }
    printf("Terminating Parent.\n");
}

void *Child(void *arg)
{
    SharedBuffer *shm_buffer = (SharedBuffer *)arg;
    char expression[MAX_LEN] = "";
    char result[MAX_LEN] = "";

    while (1)
    {
        while (!shm_buffer[P2C].is_loaded)
            ;
        strcpy(expression, shm_buffer[P2C].buffer);
        shm_buffer[P2C].is_loaded = FALSE;
        if (strcmp(expression, "quit") == 0)
        {
            break;
        }

        printf("[child] received expression \"%s\"\n", expression);

        int eval_result = Evaluate(expression);
        sprintf(result, "%d", eval_result);

        printf("[child] sending result \"%s\"\n", result);

        while (shm_buffer[C2P].is_loaded)
            ;
        strcpy(shm_buffer[C2P].buffer, result);
        shm_buffer[C2P].is_loaded = TRUE;
    }
    printf("Terminating Child.\n");
}

int Evaluate(char *expression)
{
    int op1 = 0, op2 = 0;
    char op = 0;
    int result = 0;

    int ret = sscanf(expression, "%d %c %d", &op1, &op, &op2);
    if (ret == 3)
    {
        switch (op)
        {
        case '+':
            result = op1 + op2;
            break;

        case '-':
            result = op1 - op2;
            break;

        case '*':
            result = op1 * op2;
            break;

        case '/':
            if (op2 != 0)
                result = op1 / op2;
            break;
        }
    }

    return result;
}
