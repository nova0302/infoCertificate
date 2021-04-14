TARGETS=helloExec execDemo selfExec forkAndExecDemo
CFLAGS=-Wall -g -std=c99 -werror

all:clean $(TARGETS)

$(TARGETS):
	gcc $@.c -o $@.exe

clean:
	rm -rf $(TARGETS)
