#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <pthread.h>

// Thread function
void* thread_function(void* arg) {
    printf("Thread: ID = %lu\n", pthread_self());
    return NULL;
}

int main() {
    pid_t pid;
    pthread_t tid;

    // Create a new process
    pid = fork();

    if (pid < 0) {
        // Error
        printf("Fork failed\n");
        return 1;
    }
    else if (pid == 0) {
        // Child process
        printf("Child Process: PID = %d\n", getpid());

        // Create a thread inside child process
        pthread_create(&tid, NULL, thread_function, NULL);
        pthread_join(tid, NULL);

        printf("Child Process: Thread finished\n");
    }
    else {
        // Parent process
        printf("Parent Process: PID = %d, Child PID = %d\n", getpid(), pid);

        // Create a thread inside parent process
        pthread_create(&tid, NULL, thread_function, NULL);
        pthread_join(tid, NULL);

        printf("Parent Process: Thread finished\n");
    }

    return 0;
}

// gcc processnthread.c -o processnthread -lpthread
// ./program