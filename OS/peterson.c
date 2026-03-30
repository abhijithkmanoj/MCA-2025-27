#include <stdio.h>
#include <pthread.h>

int flag[2];
int turn;
int shared_counter = 0;

void* process(void* arg) {
    int i = *(int*)arg;
    int j = 1 - i;

    // Entry Section
    flag[i] = 1;
    turn = j;
    while (flag[j] && turn == j); 

    // Critical Section
    printf("Process %d is in the Critical Section.\n", i);
    shared_counter++;
    printf("Counter value: %d\n", shared_counter);

    // Exit Section
    flag[i] = 0;

    printf("Process %d left the Critical Section.\n", i);
    return NULL;
}

int main() {
    pthread_t t1, t2;
    int id0 = 0, id1 = 1;

    pthread_create(&t1, NULL, process, &id0);
    pthread_create(&t2, NULL, process, &id1);

    pthread_join(t1, NULL);
    pthread_join(t2, NULL);

    return 0;
}