#include <stdio.h>
#include <pthread.h>
#include <semaphore.h>
#include <unistd.h>

#define BUFFER_SIZE 5

int buffer[BUFFER_SIZE];
int in = 0, out = 0;

// Semaphores
sem_t mutex, empty, full;

// Producer function
void* producer(void* arg) {
    int item;
    for(int i = 0; i < 5; i++) {
        item = i + 1;

        sem_wait(&empty);   // Wait if buffer is full
        sem_wait(&mutex);   // Enter critical section

        // Critical Section
        buffer[in] = item;
        printf("Produced: %d\n", item);
        in = (in + 1) % BUFFER_SIZE;

        sem_post(&mutex);   // Exit critical section
        sem_post(&full);    // Signal item added

        sleep(1);
    }
    return NULL;
}

// Consumer function
void* consumer(void* arg) {
    int item;
    for(int i = 0; i < 5; i++) {

        sem_wait(&full);    // Wait if buffer is empty
        sem_wait(&mutex);   // Enter critical section

        // Critical Section
        item = buffer[out];
        printf("Consumed: %d\n", item);
        out = (out + 1) % BUFFER_SIZE;

        sem_post(&mutex);   // Exit critical section
        sem_post(&empty);   // Signal space available

        sleep(1);
    }
    return NULL;
}

int main() {
    pthread_t p, c;

    // Initialize semaphores
    sem_init(&mutex, 0, 1);          // Mutual exclusion
    sem_init(&empty, 0, BUFFER_SIZE); // Empty slots
    sem_init(&full, 0, 0);            // Filled slots

    pthread_create(&p, NULL, producer, NULL);
    pthread_create(&c, NULL, consumer, NULL);

    pthread_join(p, NULL);
    pthread_join(c, NULL);

    // Destroy semaphores
    sem_destroy(&mutex);
    sem_destroy(&empty);
    sem_destroy(&full);

    return 0;
}