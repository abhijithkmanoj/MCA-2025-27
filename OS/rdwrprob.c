// #include <stdio.h>
// #include <pthread.h>
// #include <semaphore.h>
// #include <unistd.h>

// sem_t mutex, wrt;
// int readcount = 0;
// int shared_data = 0;

// // Reader function
// void* reader(void* arg) {
//     int id = *(int*)arg;

//     // Entry section
//     sem_wait(&mutex);
//     readcount++;
//     if (readcount == 1)
//         sem_wait(&wrt); // First reader blocks writers
//     sem_post(&mutex);

//     // Critical Section
//     printf("Reader %d is reading data: %d\n", id, shared_data);
//     sleep(1);

//     // Exit section
//     sem_wait(&mutex);
//     readcount--;
//     if (readcount == 0)
//         sem_post(&wrt); // Last reader allows writers
//     sem_post(&mutex);

//     return NULL;
// }

// // Writer function
// void* writer(void* arg) {
//     int id = *(int*)arg;

//     sem_wait(&wrt); // Writer enters

//     // Critical Section
//     shared_data++;
//     printf("Writer %d is writing data: %d\n", id, shared_data);
//     sleep(1);

//     sem_post(&wrt); // Writer leaves

//     return NULL;
// }

// int main() {
//     pthread_t r1, r2, w1;
//     int id1 = 1, id2 = 2, id3 = 1;

//     // Initialize semaphores
//     sem_init(&mutex, 0, 1);
//     sem_init(&wrt, 0, 1);

//     // Create threads
//     pthread_create(&r1, NULL, reader, &id1);
//     pthread_create(&r2, NULL, reader, &id2);
//     pthread_create(&w1, NULL, writer, &id3);

//     // Join threads
//     pthread_join(r1, NULL);
//     pthread_join(r2, NULL);
//     pthread_join(w1, NULL);

//     // Destroy semaphores
//     sem_destroy(&mutex);
//     sem_destroy(&wrt);

//     return 0;
// }

#include <stdio.h>
#include <pthread.h>
#include <semaphore.h>
#include <unistd.h>

sem_t wrt;
pthread_mutex_t mutex;
int readcount = 0;

// Reader function
void *reader(void *arg) {
    int id = *(int *)arg;

    for(int i = 0; i < 3; i++) {

        pthread_mutex_lock(&mutex);
        readcount++;

        if(readcount == 1)
            sem_wait(&wrt);

        pthread_mutex_unlock(&mutex);

        printf("Reader %d is reading\n", id);
        sleep(1);

        pthread_mutex_lock(&mutex);
        readcount--;

        if(readcount == 0)
            sem_post(&wrt);

        pthread_mutex_unlock(&mutex);

        sleep(1);
    }
}

// Writer function
void *writer(void *arg) {
    int id = *(int *)arg;

    for(int i = 0; i < 3; i++) {

        sem_wait(&wrt);

        printf("Writer %d is writing\n", id);
        sleep(2);

        sem_post(&wrt);

        sleep(1);
    }
}

int main() {
    pthread_t r[3], w[2];
    int id[3];

    sem_init(&wrt, 0, 1);
    pthread_mutex_init(&mutex, NULL);

    for(int i = 0; i < 3; i++) {
        id[i] = i + 1;
        pthread_create(&r[i], NULL, reader, &id[i]);
    }

    for(int i = 0; i < 2; i++) {
        id[i] = i + 1;
        pthread_create(&w[i], NULL, writer, &id[i]);
    }

    for(int i = 0; i < 3; i++)
        pthread_join(r[i], NULL);

    for(int i = 0; i < 2; i++)
        pthread_join(w[i], NULL);

    sem_destroy(&wrt);
    pthread_mutex_destroy(&mutex);

    return 0;
}

