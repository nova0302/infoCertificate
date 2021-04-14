#include <stdio.h>
#include <unistd.h>
int favNum = 42;

int main(int argc, char *argv[])
{
    printf("execDemo: My pid is %d.\n", getpid());
    char *args[]={"./helloExec", "hello", "world", NULL};
    // with L : comma separated arguemnts
    // with V : Vector (i.e., an array of strings)
    // with P : Include normal search path for executable
    //execvp("./helloExec.exe", args);
    execvp(args[0], args);
    printf("Farewell cruel world!!\n");

    return 0;
}
