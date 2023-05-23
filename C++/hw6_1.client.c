// /*
// 	socket_client.c: reads digit strings from the user
// 		and converts it into the corresponding alphabet string using socket_server.
// 		communicate with socket_client through SOCKET
// 		e.g., "135246" --> "one three five two four six"

// 		try to make the output as similar to the following example as possible

// 	Example) ./socket_client 127.0.0.1 1234 4321
// 		Connecting to 127.0.0.1:1234
// 		Done.
// 		Input a number: 1234
// 		1234 ==> one two three four
// 		Input a number: 872
// 		872 ==> eight seven two
// 		Input a number: 1004
// 		1004 ==> one zero zero four
// 		Input a number: 1829401
// 		1829401 ==> one eight two nine four zero one
// 		Input a number: quit
// 		quit ==>
// 		Closing sockets
// 		Done.

// */

// #include <stdio.h>
// #include <stdlib.h>
// #include <string.h>

// #include <unistd.h>
// #include <fcntl.h>
// #include <arpa/inet.h>
// #include <sys/socket.h>

// #define BUFFER_SIZE 256

// int main(int argc, char *argv[])
// {
// 	if(argc < 2){
// 		printf("Usage: %s <server-ip> <server-port> <client-port>\n", argv[0]);
// 		return -1;
// 	}

// 	char *server_ip = argv[1];
// 	int server_port = atoi(argv[2]);

// 	// TO DO: create a socket
// 	//  on failure, display an error message and terminate
//     int client_port = atoi(argv[3]);

//         // Create a socket
//         int socket_fd = socket(AF_INET, SOCK_STREAM, 0);
//         if (socket_fd == -1) {
//             perror("Socket creation failed");
//             exit(1);
//         }

//     printf("Connecting to %s:%d\n", server_ip, server_port);

// 	struct sockaddr_in svr_addr = {0};
// 	// TO DO: set svr_addr with appropriate values
//     svr_addr.sin_family = AF_INET;
//         svr_addr.sin_port = htons(server_port);
//         if (inet_pton(AF_INET, server_ip, &(svr_addr.sin_addr)) <= 0) {
//             perror("Invalid address/ Address not supported");
//             exit(1);
//         }

// 	// TO DO: connect to svr_addr using the socket
// 	//  on failure, display an error message and terminate
//     if (connect(socket_fd, (struct sockaddr *)&svr_addr, sizeof(svr_addr)) < 0) {
//             perror("Connection failed");
//             exit(1);
//         }

// 	printf("Done.\n");

// 	/* TO DO: repeat
// 		read a string from the user
// 		write the input string to the socket using write()
// 		read the conversion result from the socket using read()
// 		display the input string and the conversion result
// 		if the conversion result is an empty string, break
// 	*/
//         char input[BUFFER_SIZE];
//         char output[BUFFER_SIZE];

//         while (1) {
//             printf("Input a number: ");
//             fgets(input, BUFFER_SIZE, stdin);

//             int len = strlen(input);
//             if (len > 0 && input[len - 1] == '\n') {
//                 input[len - 1] = '\0';
//             }
//             if (strcmp(input, "quit") == 0) {
//                 break;
//             }
//             write(socket_fd, input, strlen(input));
//             read(socket_fd, output, BUFFER_SIZE);
//             printf("%s ==> %s\n", input, output);
//             if (strlen(output) == 0) {
//                 break;
//             }
//         }

// 	printf("Closing socket\n");

// 	// TO DO: close the socket
//     close(socket_fd);

// 	printf("Done.\n");

// 	printf("Bye!\n");

// 	return 0;
// }

///* previous code
///* server에서 close가  중복, 그리고 Digit2Text함수에서 for문을 굳이 2개를 쓸 필요가 없음.
///* client_port 변수가 불필요.

/// updated code

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include <unistd.h>
#include <fcntl.h>
#include <arpa/inet.h>
#include <sys/socket.h>

#define BUFFER_SIZE 256

int main(int argc, char *argv[])
{
    if (argc < 2)
    {
        printf("Usage: %s <server-ip> <server-port> <client-port>\n", argv[0]);
        return -1;
    }

    char *server_ip = argv[1];
    int server_port = atoi(argv[2]);

    // TO DO: create a socket
    //  on failure, display an error message and terminate

    int sock = socket(AF_INET, SOCK_STREAM, 0);
    if (sock < 0)
    {
        printf("socket");
        exit(1);
    }

    printf("Connecting to %s:%d\n", server_ip, server_port);

    struct sockaddr_in svr_addr = {0};
    svr_addr.sin_family = AF_INET;
    svr_addr.sin_addr.s_addr = inet_addr(server_ip);
    svr_addr.sin_port = htons(server_port);

    if (connect(sock, (struct sockaddr *)&svr_addr, sizeof(svr_addr)) < 0)
    {
        printf("connect");
        exit(1);
    }
    printf("Done.\n");

    char input[BUFFER_SIZE], result[BUFFER_SIZE];
    while (1)
    {
        printf("Input a number: ");
        fgets(input, BUFFER_SIZE, stdin);
        input[strcspn(input, "\n")] = '\0';

        write(sock, input, strlen(input) + 1);
        read(sock, result, BUFFER_SIZE);

        if (strlen(result) == 0)
            break;

        printf("%s ==> %s\n", input, result);
    }
    printf("Closing socket\n");

    close(sock);

    printf("Done.\n");

    return 0;
}
