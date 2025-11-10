#include <stdio.h>
#include <stdlib.h>
#define MAX 100

int stack[MAX];
int top = -1;

void push(int value) {
    if (top == MAX - 1) {
        printf("Stack overflow\n");
        return;
    }
    stack[++top] = value;
}

int pop() {
    if (top == -1)
        return -1;
    return stack[top--];
}

int isEmpty() {
    return (top == -1);
}

void DFS(int adj[MAX][MAX], int visited[MAX], int start, int n) {
    push(start);

    printf("DFS Traversal: ");

    while (!isEmpty()) {
        int node = pop();

        if (!visited[node]) {
            printf(" -> %d", node);
            visited[node] = 1;
        }

        for (int i = n - 1; i >= 0; i--) {  
            if (adj[node][i] == 1 && !visited[i]) {
                push(i);
            }
        }
    }
    printf("\n");
}

int main() {
    int n;
    printf("Enter number of vertices: ");
    scanf("%d", &n);

    int adj[MAX][MAX];
    printf("Enter adjacency matrix (%d x %d):\n", n, n);
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            scanf("%d", &adj[i][j]);
            if (adj[i][j] != 0 && adj[i][j] != 1) {
                printf("Invalid input, enter 0 or 1\n");
                i--;
                break;
            }
        }
    }

    int visited[MAX] = {0};
    int start;
    printf("Enter starting vertex (0 to %d): ", n - 1);
    scanf("%d", &start);

    DFS(adj, visited, start, n);

    return 0;
}
