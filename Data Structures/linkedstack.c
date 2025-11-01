#include<stdio.h>
#include<stdlib.h>

typedef struct node {
    int data;
    struct node* next;
} node;

node* top = NULL;

node* createnode(int value) {   
    node* newnode = (node*)malloc(sizeof(node));
    if (newnode == NULL) {
        printf("Memory allocation failed\n");
        exit(1);
    }
    newnode->data = value;
    newnode->next = NULL;
    return newnode;
}

void push(int value) {   
    node* newnode = createnode(value);
    newnode->next = top;
    top = newnode;
}

void pop() {
    if (top == NULL) {
        printf("Stack underflow!\n");
        return;
    } else {
        node* temp = top;
        top = top->next;
        free(temp);
    }
}

void display() {
    node* temp = top;
    if (temp == NULL) {
        printf("Stack is empty!\n");
        return;
    }
    printf("Stack elements: ");
    while (temp != NULL) {
        printf("%d ", temp->data);
        temp = temp->next;
    }
    printf("\n");
}

int count() {   
    int c = 0;
    node* temp = top;
    while (temp != NULL) {   
        c++;
        temp = temp->next;
    }
    return c;
}

int main(void) {
    int ch, value; 
    
    do {
        printf("\n---MENU---\n");
        printf("1. PUSH\n");
        printf("2. POP\n");
        printf("3. DISPLAY\n");
        printf("4. COUNT\n");
        printf("5. EXIT\n");
        printf("Enter your choice: ");
        scanf("%d", &ch);

        switch (ch) {
            case 1:
                printf("Enter value to insert: ");
                scanf("%d", &value);
                push(value);
                break;
            case 2:
                pop();
                break;
            case 3:
                display();
                break;
            case 4:
                printf("Count = %d\n", count());
                break;
            case 5:
                exit(0);
                break;
            default:
                printf("Invalid choice!\n");
                break;
        }
    } while (ch != 5);

    return 0;
}