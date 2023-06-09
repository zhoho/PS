/*

    This program reads an integer expression from the user and computes the result using a child process.
    The parent and child processes communicate with each other through message passing.
    Implement this program following the instructions.
    Append "[parent]" and "[child]" to all messages in Parent() and Child respectively.

    Example)
        p2c = 0, c2p = 1				// the ids of the message queues
        [parent] Input an integer binary expressions(type "quit" to finish.): 5 + 1 	// this user typed "5 + 1"
        [parent] msgsnd() returned = 0
        [child] received 0-th message "5 + 3", ret = 136
        [child] sending 0-th message "8"
        [child] msgsnd() returned = 0
        [parent] msgrcv() returned = 136
        [parent] 5 + 3 = 8
        [parent] Input an integer binary expressions(type "quit" to finish.): 7 * 2 	// this user typed "7 * 2"
        [parent] msgsnd() returned = 0
        [child] received 1-th message "7 * 2", ret = 136
        [child] sending 1-th message "14"
        [child] msgsnd() returned = 0
        [parent] msgrcv() returned = 136
        [parent] 7 *2 = 14
        [parent] Input an integer binary expressions(type "quit" to finish.): 9/2 		// this user typed "9/2"
        [parent] msgsnd() returned = 0
        [child] received 2-th message "9/2", ret = 136
        [child] sending 2-th message "4"
        [child] msgsnd() returned = 0
        [parent] msgrcv() returned = 136
        [parent] 9/2 = 4
        [parent] Input an integer binary expressions(type "quit" to finish.): quit 		// this user typed "quit"
        [parent] msgsnd() returned = 0
        [child] received 3-th message "quit", ret = 136
        Terminating Parent.
        Terminating Child.


    You can use the following Linux commands to list or remove message queues
        ipcs				// show infromation on IPC facilities
        ipcrm -q <msgq-id>	// delete a message queue

    After the program terminates, there should be no remaining message queue.
    Example)
        $ ipcs
        ------ Message Queues --------
        key        msqid      owner      perms      used-bytes   messages

        // nothing

*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include <unistd.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/msg.h>

#define _DEBUG // do not disable this macro

#define MAX_LEN 128

void Parent(int p2c, int c2p);
void Child(int p2c, int c2p);
int Evaluate(char *expression);

#define MSG_P2C 1
#define MSG_C2P 2

typedef struct
{
    long type; // the type of the message (in this program, MSG_P2C or MSG_C2P)
               // [IMPORTANT] type should not be zero
    int index; // the index of the message. starting from 0, increase
    char content[MAX_LEN];
    // the content of the message
} Message;

int main(int argc, char *argv[])
{
    // TO DO: create two message queues:
    //         one is for messages from the parent to the child.
    //         the other is for messages from the child to the parent.
    //         on failure, display an error message and quit.
    //         otherwise, display the ids of the two message queues for debug.
    int p2c, c2p;

    p2c = msgget(IPC_PRIVATE, IPC_CREAT | 0666);
    c2p = msgget(IPC_PRIVATE, IPC_CREAT | 0666);

    if (p2c == -1 || c2p == -1)
    {
        perror("Failed to create message queues");
        exit(1);
    }

    printf("[parent] p2c = %d, c2p = %d\n", p2c, c2p);

    // TO DO: create a child process
    // 		on failure, display an error message, destroy the message queues, and terminate.
    // 		In the parent process, call the Parent() function passing the two message queues.
    //		In the child process, call the Child() function passing the two message queues.

    pid_t pid = fork();
    if (pid == -1)
    {
        perror("Failed to fork");
        msgctl(p2c, IPC_RMID, 0); // Remove message queue p2c
        msgctl(c2p, IPC_RMID, 0); // Remove message queue c2p
        exit(1);
    }
    if (pid == 0)
    {
        // Child process
        Child(p2c, c2p);
        exit(0);
    }
    else
    {
        // Parent process
        Parent(p2c, c2p);
    }

    msgctl(p2c, IPC_RMID, 0);
    msgctl(c2p, IPC_RMID, 0);

    return 0;
}

void Parent(int p2c, int c2p)
// TO DO: implement this function
// 		read integer expressions from the user
// 		send the expression to the child process by message passing
//		receive the result from the child by message passing
//		display the expression and result
{
    Message out_msg, in_msg;
    size_t msg_size = sizeof(Message) - sizeof(long);
    out_msg.type = MSG_P2C;
    out_msg.index = 0;

    int index = 0;
    // Algorithm)
    //	repeat until the user types "quit"
    // 		read an integer expression as a string (e.g., "5+3", "7 * 5", etc.) - use fgets()
    // 		if the input is not an empty string,
    // 			send the expression to the child through the message queue p2c.
    // 				on failure, display an error message.
    //			for debug, display the return value of msgsnd().
    // 			if the input string is "quit", break the loop.
    // 			receive the result of the expression from the child through the message queue c2p.
    //				on failure, display an error message.
    //			for debug, display the return value of msgrcv().
    // 			display the expression and the result from the child.
    // 			increase the index of the outgoing message.
    //
    //	destroy the two message queues.
    //	display a message indicating that the parent is terminating.

    while (1)
    {
        printf("Enter an integer binary expression(type or 'quit' to finish: ");
        char input[MAX_LEN];          // Buffer for input expression
        fgets(input, MAX_LEN, stdin); // Read input from user

        // Check if input is empty
        if (strcmp(input, "\n") == 0)
        {
            continue;
        }

        // Check if input is "quit"
        if (strcmp(input, "quit\n") == 0)
        {
            exit(0);
            break;
        }

        // Send input expression to child through p2c message queue
        strncpy(out_msg.content, input, MAX_LEN);
        out_msg.index = index;
        if (msgsnd(p2c, &out_msg, msg_size, 0) == -1)
        {
            perror("[parent] Failed to send message to child");
            continue;
        }
        else
        {
            printf("[parent] msgsnd() returned = 0\n");
        }
        // Receive result from child through c2p message queue
        ssize_t ret;
        if ((ret = msgrcv(c2p, &in_msg, msg_size, index, 0)) == -1)
        {
            perror("[parent] Failed to receive message from child");
            continue;
        }
        else
        {
            printf("[parent] msgrcv() returned = %ld\n", ret);
        }
        printf("[parent] %s = %s \n", input, in_msg.content);
        index++; // Increase index of outgoing message
    }

    // Destroy message queues
    msgctl(p2c, IPC_RMID, 0);
    msgctl(c2p, IPC_RMID, 0);

    printf("Terminating Parent.\n");
}

void Child(int p2c, int c2p)
// TO DO: implement this function
// 		receive an integer expressions from the parent by message passing
//		compute the result of the expression
// 		send the result to the parent process by message passing
{
    Message in_msg, out_msg;
    out_msg.type = MSG_C2P;
    out_msg.index = 0;
    size_t msg_size = sizeof(Message) - sizeof(long);
    int index = 0;
    // Algorithm)
    // 	repeat until the incomming message is "quit"
    // 		receieve an expression from the parent through the message queue p2c.
    // 			on failure, display an error message.
    // 		for debug, display the incoming message, its index, and the return value of msgrcv().
    // 		if the message is "quit", break the loop
    // 		compute the evaluation in the incoming message
    // 		for debug, display the outgoing message and its index.
    // 		send the result as a string to the parent through the message queue c2p.
    // 			on failure, display an error message.
    //		for debug, display the return value of msgsnd().
    // 		increase the index of outgoing message.
    //
    //	display a message indicating that the child is terminating.

    while (1)
    {
        // Receive expression from parent through p2c message queue
        ssize_t ret;
        if ((ret = msgrcv(p2c, &in_msg, msg_size, 0, 0)) == -1)
        {
            perror("[child] Failed to receive message from parent");
            continue;
        }
        printf("[child] Received %d-th message '%s', ret = %ld\n", in_msg.index, in_msg.content, ret);

        // 삭제 printf("[child] Index of incoming message: %d\n", in_msg.index);
        in_msg.index = index;
        if (strcmp(in_msg.content, "quit\n") == 0)
        {
            break;
        }
        // in_msg.index = index;
        //  Evaluate expression and store result in out_msg.text
        int result = Evaluate(in_msg.content); // Replace with your expression evaluation logic
        snprintf(out_msg.content, MAX_LEN, "%d", result);
        // Send result to parent through c2p message queue

        printf("[child] Sending %d-th message '%s'\n", out_msg.index, out_msg.content);

        out_msg.type = in_msg.index;
        if (msgsnd(c2p, &out_msg, msg_size, 0) == -1)
        {
            perror("[child] Failed to send message to parent");
            continue;
        }
        else
        {
            printf("[child] msgsnd() returned = 0\n");
        }
        index++;
    }
    printf("Terminating Child.\n");
}

int Evaluate(char *expression)
// TO DO: return the result of the expression
//		separate the operator and operands from the expression by calling the sscanf() function. (if necessary, search the Internet for sscanf().)
//			(the expression is composed of a left operand, an operator (+, - , *, or /), and a right operand., e.g., "5/2", "10 * 3", "7- 9")
//			for the division operator (/), return zero if the denominator is zero.
//		if the operator and the two operands were retrieved, compute the expression and return the result.
//		otherwise, return zero.
{
    char operator;
    int n1, n2 = 0;
    int result = 0;

    if (sscanf(expression, "%d %c %d", &n1, &operator, & n2) == 3)
    {
        if (operator== '+')
        {
            result = n1 + n2;
        }
        else if (operator== '-')
        {
            result = n1 - n2;
        }
        else if (operator== '*')
        {
            result = n1 * n2;
        }
        else if (operator== '/')
        {
            if (n2 != 0)
            {
                result = n1 / n2;
            }
            else
            {
                printf("[child] Error: Division by zero\n");
            }
        }
        else
        {
            printf("[child] Error: Invalid operator\n");
        }
    }
    else
    {
        printf("[child] Error: Invalid expression\n");
    }
    return result;
}
