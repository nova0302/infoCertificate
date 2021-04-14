#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(int argc, char *argv[])
{
    pid_t pid = fork();
    if (pid < 0) {
	perror("fork failed.");
	exit(1);
    }else if (pid == 0) {
	printf("Child process!!.");
	char* args[]={"./helloExec.exe", "Hello", "World", NULL};
    }
    printf("I'm the parent..\n");
    return 0;
}
