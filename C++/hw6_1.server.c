// /*
// 	socket_server.c: open a port and converts digit strings into the corresponding alphabet string
// 		communicates with the client through SOCKET
// 		e.g., "135246" --> "one three five two four six"

// 		try to make the output as similar to the following example as possible

// 	Example) ./socket_server 1234		// server-port = 1234
// 		port = 1234
// 		creating socket...
// 		Done.
// 		socket binding...
// 		Done.
// 		listening socket...
// 		Done.
// 		Waiting for connect request...
// 		Connected.
// 		input = [1234]					// received "1234" from the client
// 		output = [one two three four]
// 		Sending message...				// sending "one two three four" to the client
// 		Done.
// 		input = [872]
// 		output = [eight seven two]
// 		Sending message...
// 		Done.
// 		input = [1004]
// 		output = [one zero zero four]
// 		Sending message...
// 		Done.
// 		input = [1829401]
// 		output = [one eight two nine four zero one]
// 		Sending message...
// 		Done.
// 		Closing sockets					// received "quit"
// 		Done.

// */

// #include <stdio.h>
// #include <stdlib.h>
// #include <string.h>
// #include <ctype.h>

// #include <unistd.h>
// #include <fcntl.h>
// #include <arpa/inet.h>
// #include <sys/socket.h>

// void Digit2Text(char *digit_string, char *alphabet_str);

// int main(int argc, char *argv[])
// {
// 	if(argc < 2){
// 		printf("Usage: %s <server-port>\n", argv[0]);
// 		return 0;
// 	}

// 	int ret = 0;
// 	int port = atoi(argv[1]);
// 	printf("port = %d\n", port);

// 	printf("creating socket...\n");
// 	// TO DO: create a socket (server socket) using the port number. store the socket in an integer variable
//     int server_socket = socket(AF_INET, SOCK_STREAM, 0);
//         if (server_socket == -1) {
//             perror("Socket creation failed");
//             exit(1);
//         }
// 	printf("Done.\n");

// 	struct sockaddr_in svr_addr = { 0 };
// 	// TO DO: fill svr_addr with appropriate values
//     svr_addr.sin_family = AF_INET;
//     svr_addr.sin_port = htons(port);
//     svr_addr.sin_addr.s_addr = INADDR_ANY;

// 	printf("socket binding...\n");
// 	// TO DO: bind the socket to svr_addr
// 	//	on failure, display an error message and terminate
//     if (bind(server_socket, (struct sockaddr *)&svr_addr, sizeof(svr_addr)) < 0) {
//             perror("Binding failed");
//             exit(1);
//         }
// 	printf("Done.\n");

// 	printf("listening socket...\n");
// 	// TO DO: listen the server socket
// 	//	on failure, display an error message and terminate
//     if (listen(server_socket, 1) < 0) {
//             perror("Listening failed");
//             exit(1);
//         }

// 	printf("Done.\n");

// 	struct sockaddr_in client_addr = { 0 };
// 	memset(&client_addr, 0, sizeof(client_addr));
// 	socklen_t client_addr_len = 0;

// 	printf("Waiting for connect request...\n");
// 	// TO DO: accept a connection request by calling acctp(). keep the client socket in an integer variable
// 	//	on failure, display an error message and terminate

//     int client_socket = accept(server_socket, (struct sockaddr *)&client_addr, &client_addr_len);
//         if (client_socket < 0) {
//             perror("Accepting connection failed");
//             exit(1);
//         }

// 	printf("Connected.\n");

// 	char input[64] = "";
// 	char output[512] = "";

// 	/* TO DO: repeat
// 		read an input string from the socket using read()
// 		if the input is "quit" or an empty string, break
// 		convert the input into the corresponding alphabet string by calling Digit2Text()
// 		write the alphabet string into the socket using write()
// 	*/
//     while (1) {
//         int bytes_read = read(client_socket, input, sizeof(input) - 1);
//             if (bytes_read <= 0) {
//                 if (strcmp(input, "quit") == 0 || strlen(input) == 0) {
//                     printf("Closing sockets\n");
//                     // TO DO: close the two sockets
//                     close(client_socket);
//                     close(server_socket);
//                     printf("Done.\n");
//                     break;
//                 } else {
//                     fprintf(stderr, "Error reading from socket\n");
//                     exit(1);
//                 }
//             }
//             input[bytes_read] = '\0';
//             Digit2Text(input, output);

//             int bytes_written = write(client_socket, output, strlen(output));
//             if (bytes_written <= 0) {
//                 fprintf(stderr, "Error writing to socket\n");
//                 exit(1);
//             }
//                 printf("input = [%s]\n", input);
//                 printf("output = [%s]\n", output);
//                 printf("Sending message...\n");
//                 printf("Done.\n");
//         }
// 	printf("Closing sockets\n");

// 	// TO DO: close the two sockets

//     close(client_socket);
//     close(server_socket);

// 	printf("Done.\n");
// 	printf("Bye!\n");

// 	return 0;
// }

// void Digit2Text(char *digit_str, char *alphabet_str)
// {
// 	static char digit_name[][16] = {
// 		"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
// 	};

// 	// TO DO: convert a digit string into the corresponding alphabet string
// 	//	e.g., "135246" --> "one three five two four six"
// 	// 	if digit_string is an empty string or contains a non-digit character
// 	//		set alphabet_str to "" and return
//     int digit_length = strlen(digit_str);
//     int alphabet_str_index = 0;
//         for (int i = 0; i < digit_length; i++) {
//             if (!isdigit(digit_str[i])) {
//                 alphabet_str[0] = '\0';
//                 return;
//             }
//         }
//         alphabet_str[0] = '\0';
//         for (int i = 0; i < digit_length; i++) {

//             int digit = digit_str[i] - '0';
//             strcat(alphabet_str, digit_name[digit]);

//             if (i < digit_length - 1) {
//                 strcat(alphabet_str, " ");
//             }
//         }
//     }

///* previous code
///* server에서 close가  중복, 그리고 Digit2Text함수에서 for문을 굳이 2개를 쓸 필요가 없음.
///* client_port 변수가 불필요.

/// updated code

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#include <unistd.h>
#include <fcntl.h>
#include <arpa/inet.h>
#include <sys/socket.h>

void Digit2Text(char *digit_string, char *alphabet_str);

int main(int argc, char *argv[])
{
    if (argc < 2)
    {
        printf("Usage: %s <server-port>\n", argv[0]);
        return 0;
    }

    int ret = 0;
    int port = atoi(argv[1]);
    printf("port = %d\n", port);

    printf("creating socket...\n");
    int server_socket = socket(AF_INET, SOCK_STREAM, 0);
    if (server_socket < 0)
    {
        printf("socket error");
        exit(1);
    }

    printf("Done.\n");

    struct sockaddr_in svr_addr = {0};
    svr_addr.sin_family = AF_INET;
    svr_addr.sin_addr.s_addr = INADDR_ANY;
    svr_addr.sin_port = htons(port);

    printf("socket binding...\n");

    if (bind(server_socket, (struct sockaddr *)&svr_addr, sizeof(svr_addr)) < 0)
    {
        printf("bind error");
        exit(1);
    }
    printf("Done.\n");

    printf("listening socket...\n");

    if (listen(server_socket, 1) < 0)
    {
        printf("listen error");
        exit(1);
    }

    printf("Done.\n");

    struct sockaddr_in client_addr = {0};
    memset(&client_addr, 0, sizeof(client_addr));
    socklen_t client_addr_len = 0;

    printf("Waiting for connect request...\n");

    int client_socket = accept(server_socket, (struct sockaddr *)&client_addr, &client_addr_len);
    if (client_socket < 0)
    {
        printf("accept error");
        exit(1);
    }

    printf("Connected.\n");

    char input[64] = "";
    char output[512] = "";

    while (1)
    {
        memset(input, 0, sizeof(input));
        read(client_socket, input, sizeof(input));
        input[strcspn(input, "\n")] = '\0';
        if (strcmp(input, "quit\n") == 0 || strlen(input) == 0)
        {
            write(client_socket, "", 1);
            break;
        }
        printf("input = [%s]\n", input);
        Digit2Text(input, output);
        printf("output = [%s]\n", output);
        printf("Sending message...\n");

        write(client_socket, output, strlen(output) + 1);
        printf("Done.\n");
    }

    printf("Closing sockets\n");

    close(server_socket);
    close(client_socket);

    printf("Done.\n");

    return 0;
}

void Digit2Text(char *digit_str, char *alphabet_str)
{
    static char digit_name[][16] = {
        "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    int i;
    int len = strlen(digit_str);
    alphabet_str[0] = '\0';

    for (i = 0; i < len; i++)
    {
        if (!isdigit(digit_str[i]))
        {
            strcpy(alphabet_str, "");
            return;
        }

        strcat(alphabet_str, digit_name[digit_str[i] - '0']);
        if (i < len - 1)
            strcat(alphabet_str, " ");
    }
}