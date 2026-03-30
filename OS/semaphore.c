#include <stdio.h>
#include <pthread.h>
#include <semaphore.h>
#include <unistd.h>

sem_t mutex;
int shared_resource = 0;

void* thread_func(void* arg) {
    int id = *(int*)arg;

    // Wait (P operation)
    sem_wait(&mutex); 

    // Critical Section
    printf("Thread %d entered Critical Section.\n", id);
    shared_resource++;
    sleep(1); // Simulating work
    printf("Thread %d updated resource to: %d\n", id, shared_resource);

    // Signal (V operation)
    printf("Thread %d leaving Critical Section.\n", id);
    sem_post(&mutex);

    return NULL;
}

int main() {
    pthread_t t1, t2;
    int id1 = 1, id2 = 2;

    // Initialize semaphore (0 for shared between threads, 1 for initial value)
    sem_init(&mutex, 0, 1);

    pthread_create(&t1, NULL, thread_func, &id1);
    pthread_create(&t2, NULL, thread_func, &id2);

    pthread_join(t1, NULL);
    pthread_join(t2, NULL);

    sem_destroy(&mutex);
    return 0;
}