#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

#include <sys/types.h>
#include <sys/wait.h>

int main(int argc, char *argv[])
{
    pid_t forkStatus = fork();
    /* Child... */
    if (forkStatus == 0) {
	printf("Child is running, processing.\n");
	sleep(5);
	printf("Child is done, exiting.\n");
    }else if (forkStatus != -1) {
	printf("Parent is waiting...\n");
	wait(NULL);
	printf("Parent is exiting...\n");
    }else{
	perror("Error while calling the fork function.\n");
    }
    return 0;
}
