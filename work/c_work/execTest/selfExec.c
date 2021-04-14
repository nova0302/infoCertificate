#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(int argc, char *argv[])
{
    printf("selfExec: My pid is %d.\n", getpid());

    //if (argc != 2) {
    //	printf("Pass 1 argument as an integer\n");
    //	exit(1);
    //}
    //int n = atoi(argv[1]);
    //printf("%d...\n", n);

    
    char *args[]={"./selfExec.exe", "hello", "world", NULL};

    execvp(args[0], args);
    printf("Farewell cruel world!!\n");

    return 0;
}
