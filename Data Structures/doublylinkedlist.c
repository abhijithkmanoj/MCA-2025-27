#include<stdio.h>
#include<stdlib.h>
struct node{
    struct node *next;
    struct node *prev;
    int data;
};
struct node* start=NULL;
struct node *ptr=NULL;

struct node* createnode(int value){
    struct node *newnode=(struct node*)malloc(sizeof(struct node));
    newnode->prev=NULL;
    newnode->next=NULL;
    newnode->data=value;
    return newnode;
}
void insertatbeg(int value)
{
    struct node* newnode=createnode(value);
    if(start==NULL){
        start = newnode; 
        return;
    }
    struct node *ptr=start;
    newnode->next=ptr;
    ptr->prev=newnode;
    start = newnode; 
}


void insertatend(int value){
    struct node* newnode = createnode(value);
    if(start==NULL){
        start = newnode;
        return;
    }
    struct node *ptr=start;
    while(ptr->next != NULL){
        ptr=ptr->next;
    }
    ptr->next=newnode;
    newnode->prev=ptr;
}


void deletefrombeg(){

    if(start==NULL){
        printf("Underflow");
        return; 
    } else { 
        struct node *temp=start;
        start=start->next;
        if (start != NULL) { 
            start->prev = NULL;
        }
        free(temp);
    }
}
void deletefromend(){
    if(start==NULL){
        printf("Nothing to delete");
        return;
    }
    if (start->next == NULL) { 
        free(start);
        start = NULL;
        return;
    }
    struct node *ptr=start;
    while(ptr->next != NULL){
        ptr=ptr->next;
    }
    struct node *temp=ptr;
    ptr=ptr->prev;
    ptr->next=NULL;
    free(temp);
}

void displaybegtoend(){
    if(start==NULL){
        printf("Nothing to show");
        return;
    }
    struct node *ptr=start;
    while(ptr != NULL){ 
        printf("%d ",ptr->data);
        ptr=ptr->next;
    }
}
void displayendtobeg(){
    if(start==NULL){
        printf("Nothing to show");
        return;
    }
    struct node *ptr=start;
    while(ptr->next != NULL){
        ptr=ptr->next;
    }
    while(ptr != NULL){ 
        printf("%d ",ptr->data); 
        ptr=ptr->prev;
    }
}

int countnodes(){
    int c = 0; 
        if(start==NULL){
        printf("Zero nodes\n");
        return 0;
    }
    struct node *ptr=start;
    while(ptr != NULL){ 
        ptr=ptr->next;
        c++;
    }
    printf("Count=%d\n",c);
    return c;
}
int main(){
    int ch,value;
    while(1){
        printf("\n--MENU--\n");
        printf("\n1.INSERT AT BEGINNING"); 
        printf("\n2.INSERT AT END");
        printf("\n3.DELETE FROM BEGINNING");
        printf("\n4.DELETE FROM END");
        printf("\n5.DISPLAY BEGINNING TO END");
        printf("\n6.DISPLAY END TO BEGINNING");
        printf("\n7.COUNT NODES");
        printf("\n8.EXIT");
    
    printf("\nEnter your choice:");
    scanf("%d",&ch);
    switch(ch)
    {
        case 1:
        printf("Enter your value:");
        scanf("%d",&value);
        insertatbeg(value);
        break;
        case 2:
        printf("Enter your value:");
        scanf("%d",&value);
        insertatend(value);
        break;
        case 3:
        deletefrombeg();
        break;
        case 4:
        deletefromend();
        break;
        case 5:
        displaybegtoend();
        break;
        case 6:
        displayendtobeg();
        break;
        case 7:
        countnodes(); 
        break;
        case 8:
        exit(0);
        break;
        default:
        printf("Invalid choice!");
        break;
    }
    } 
    return 0;
}