#include <stdio.h>
#include <unistd.h>
int favNum = 84;

int main(int argc, char *argv[])
{
    printf("helloExec.c: vavNum: %d\n", favNum);
    printf("  My PID %d\n", getpid());

    printf("  My arguments: \n");
    for (int i=0; i<argc; ++i) {
	printf("%d: %s\n", i, argv[i]);
    }
    printf("\n");

    return 0;
}

