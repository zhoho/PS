// /*

// 	Write a C program that copies a file.
// 	* Read the source and destination pathnames from the command line arguments.
// 	* If the destination path includes directories that do not exist, create the directories.
// 	* After copying the file, run 'ls -al <dest_path>' by calling the system() function.

// 	Make the output as close to the example as possible.

// 	Example)
// 		$ cat test.txt							# display the contenets of a file 'test.txt'.
// 		This is a test file!

// 		$ ./hw2_3 test.txt NewDir/test2.txt		# initially, directory NewDir does not exist.
// 		3 arguments:							# display command line arguments.
// 		argv[0] = ./hw2_3
// 		argv[1] = test.txt
// 		argv[2] = NewDir/test2.txt
// 		Preparing directory...
// 		Directory NewDir was created.			# create NewDir since it does not exist.
// 		result = 1
// 		Copying file test.txt to NewDir/test2.txt
// 		src = 3
// 		dest = 4
// 		read_size = 22, written_size = 22		# read and wrote 22 bytes
// 		read_size = 0, written_size = 22		# zero byte was read. written_size contains the previous value
// 		test.txt was successfully copied to NewDir/test2.txt
// 		-rw-r--r-- 1 user user 22  3월 11 16:46 NewDir/test2.txt

// 		$ .c  # this time, NewDir exists but NewDir/NewDir2 does not.
// 		3 arguments:							# display command line arguments
// 		argv[0] = ./hw2_3
// 		argv[1] = test.txt
// 		argv[2] = NewDir/NewDir2/test3.txt
// 		Preparing directory...
// 		Found directory NewDir.					# NewDir was already created by the previous execution
// 		Directory NewDir/NewDir2 was created.	# create NewDir/NewDir2 since it does not exist.
// 		result = 1
// 		Copying file test.txt to NewDir/NewDir2/test3.txt
// 		src = 3
// 		dest = 4
// 		read_size = 22, written_size = 22		# read and wrote 22 bytes
// 		read_size = 0, written_size = 22		# zero byte was read. written_size contains the previous value
// 		test.txt was successfully copied to NewDir/NewDir2/test3.txt
// 		-rw-r--r-- 1 user user 22  3월 11 16:46 NewDir/NewDir2/test3.txt

// 	To solve this problem, search the Internet for the following functions and learn how to use them.

//     * int open(const char *pathname, int flags, mode_t mode);
// 	* int close(int fd);
// 	* ssize_t read (int fd, void *buf, size_t nbytes);
// 	* ssize_t write (int fd, void *buf, size_t len);
// 	* int access( const char *path, int mode);
// 	* int mkdir(const char *pathname, mode_t mode);

// 	Complete the program by writing two functions CheckAndCreateDirectory() and CopyFile().

// 	Compilation command:
// 		gcc hw2_3.c -o hw2_3

// 	Execution command:
// 		hw2_3 <src_path> <dest_path>

// */

// #include <stdio.h>
// #include <stdlib.h>
// #include <string.h>
// #include <errno.h>
// #include <unistd.h>
// #include <fcntl.h>
// #include <sys/stat.h>
// #include <sys/types.h>

// #define TRUE 1
// #define FALSE 2

// #define MAX_PATH 256			// maximum length of pathnames
// #define BUFFER_SIZE 512			// the size of buffer to copy files

// int CheckAndCreateDirectory(char *file_path);
// int CopyFile(char *src_path, char *dest_path);

// int main(int argc, char *argv[])
// {
// 	printf("%d arguments:\n", argc);
// 	for(int i = 0; i < argc; i++)
// 		printf("argv[%d] = %s\n", i, argv[i]);

// 	if(argc < 3){
// 		printf("Usage: %s <src_path> <dest_path>\n", argv[0]);
// 		return 0;
// 	}

// 	char *src_path = argv[1];
// 	char *dest_path = argv[2];

// 	if(access(src_path, R_OK) != 0){
// 		printf("Error! File %s does not exist or is not readible!\n", src_path);
// 		exit(-1);
// 	}

// 	// check destination directory exists or create the directory
// 	printf("Preparing directory...\n");
// 	int success = CheckAndCreateDirectory(dest_path);
// 	printf("result = %d\n", success);

// 	// copy file
// 	printf("Copying file %s to %s\n", src_path, dest_path);;
// 	if(success)
// 		success = CopyFile(src_path, dest_path);

// 	if(success){
// 		printf("%s was successfully copied to %s\n", src_path, dest_path);

// 		char cmd[MAX_PATH] = "";
// 		sprintf(cmd ,"ls -al %s", dest_path);
// 		system(cmd);
// 	} else {
// 		printf("Failed to copy %s to %s!\n", src_path, dest_path);
// 	}
// 	return 0;
// }

// int CheckAndCreateDirectory(char *file_path) {
//     int len = strlen(file_path);
//     char subdir[MAX_PATH] = "";
//     int i;
//     struct stat st = {0};

//     for (i = 0; i < len; i++) {
//         if (file_path[i] == '/') {
//             strncpy(subdir, file_path, i+1);
//             subdir[i+1] = '\0';

//             if (stat(subdir, &st) == 0) {
//                 printf("Subdirectory exists: %s\n", subdir);
//             }
//             else {
//                 int mkdir_status = mkdir(subdir, 0766);
//                 if (mkdir_status == 0) {
//                     printf(": Directory %s was created.\n", subdir);
//                 }
//                 else {
//                     printf("Error! subdirectory %s: %s\n", subdir, strerror(errno));
//                     return FALSE;
//                 }
//             }
//         }
//     }
//     return TRUE;
// }

// int CopyFile(char *src_path, char *dest_path)
// {
//     int src = open(src_path, O_RDONLY, 0);
//     printf("src = %d\n", src);
//     if (src < 0) {
//         perror("Error! source file");
//         return FALSE;
//     }

//     int dest = open(dest_path, O_WRONLY | O_CREAT, 0644);
//     printf("dest = %d\n", dest);
//     if (dest < 0) {
//         perror("Error! destination file");
//         close(src);
//         return FALSE;
//     }

//     static char buffer[BUFFER_SIZE];
//     ssize_t read_size = 0, written_size = 0;

//     while ((read_size = read(src, buffer, BUFFER_SIZE)) > 0) {
//         written_size = write(dest, buffer, read_size);
//         if (written_size < read_size) {
//             perror("Error! writing destination file");
//             close(src);
//             close(dest);
//             return FALSE;
//         }
//         printf("read_size = %ld, written_size = %ld\n", read_size, written_size);
//     }

//     close(src);
//     close(dest);

//     return TRUE;
// }

// previous code

// changed code
//  if (written_size > read_size) 부분에서 !=으로 판정하는 것이 조금 더 범주도 넓고 판단하기에 용이하다고 생각되어 수정

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <errno.h>
#include <unistd.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <sys/types.h>

#define TRUE 1
#define FALSE 2

#define MAX_PATH 256    // maximum length of pathnames
#define BUFFER_SIZE 512 // the size of buffer to copy files

int CheckAndCreateDirectory(char *file_path);
int CopyFile(char *src_path, char *dest_path);

int main(int argc, char *argv[])
{
    printf("%d arguments:\n", argc);
    for (int i = 0; i < argc; i++)
        printf("argv[%d] = %s\n", i, argv[i]);

    if (argc < 3)
    {
        printf("Usage: %s <src_path> <dest_path>\n", argv[0]);
        return 0;
    }

    char *src_path = argv[1];
    char *dest_path = argv[2];

    if (access(src_path, R_OK) != 0)
    {
        printf("Error! File %s does not exist or is not readible!\n", src_path);
        exit(-1);
    }

    // check destination directory exists or create the directory
    printf("Preparing directory...\n");
    int success = CheckAndCreateDirectory(dest_path);
    printf("result = %d\n", success);

    // copy file
    printf("Copying file %s to %s\n", src_path, dest_path);
    ;
    if (success)
        success = CopyFile(src_path, dest_path);

    if (success)
    {
        printf("%s was successfully copied to %s\n", src_path, dest_path);

        char cmd[MAX_PATH] = "";
        sprintf(cmd, "ls -al %s", dest_path);
        system(cmd);
    }
    else
    {
        printf("Failed to copy %s to %s!\n", src_path, dest_path);
    }
    return 0;
}

int CheckAndCreateDirectory(char *file_path)
{
    int len = strlen(file_path);
    char subdir[MAX_PATH] = "";
    int i;
    struct stat st = {0};

    for (i = 0; i < len; i++)
    {
        if (file_path[i] == '/')
        {
            strncpy(subdir, file_path, i + 1);
            subdir[i + 1] = '\0';

            if (stat(subdir, &st) == 0)
            {
                printf("Subdirectory exists: %s\n", subdir);
            }
            else
            {
                int mkdir_status = mkdir(subdir, 0766);
                if (mkdir_status == 0)
                {
                    printf(": Directory %s was created.\n", subdir);
                }
                else
                {
                    printf("Error! subdirectory %s: %s\n", subdir, strerror(errno));
                    return FALSE;
                }
            }
        }
    }
    return TRUE;
}

int CopyFile(char *src_path, char *dest_path)
{
    int src = open(src_path, O_RDONLY, 0);
    printf("src = %d\n", src);
    if (src < 0)
    {
        perror("Error! source file");
        return FALSE;
    }

    int dest = open(dest_path, O_WRONLY | O_CREAT, 0644);
    printf("dest = %d\n", dest);
    if (dest < 0)
    {
        perror("Error! destination file");
        close(src);
        return FALSE;
    }

    static char buffer[BUFFER_SIZE];
    ssize_t read_size = 0, written_size = 0;

    while ((read_size = read(src, buffer, BUFFER_SIZE)) > 0)
    {
        written_size = write(dest, buffer, read_size);
        if (written_size != read_size)
        {
            perror("Error! writing destination file");
            close(src);
            close(dest);
            return FALSE;
        }
        printf("read_size = %ld, written_size = %ld\n", read_size, written_size);
    }

    close(src);
    close(dest);

    return TRUE;
}
