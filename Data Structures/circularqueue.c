#include<stdio.h>
#include<stdlib.h>

#define SIZE 5

int rear =-1,front=-1;
int cq[SIZE];
int c=0;

void cqinsert(int value){
    if(front==0 && rear == SIZE-1 || front==rear+1){
        printf("Overflow!\n");
    }
    else if(rear==SIZE-1 && front != SIZE-1){
        rear++;
        cq[rear]=value;
        c++;
    }
    else{
        if(front==-1){
            front++;
        }
        rear++;
        cq[rear]=value;
        c++;
    }
}
void cqdelete(){
    if(rear==-1){
        printf("Underflow\n");
    }
    else if(front==rear || rear==front-1){
        rear=-1;
        front=-1;
        c--;
    }
    else{
        rear--;
        c--;
    }
}
void display(){
     if(rear==-1){
        printf("Underflow\n");
    }
    else if(rear>=front){
        for(int i=front;i<=rear;i++){
            printf("%d \t",cq[i]);
        }
    } 
    else if(rear<front){
        for(int i=front;i<=SIZE-1;i++){
            printf("%d\t",cq[i]);
        }
        for(int i=0;i<=rear;i++){
            printf("%d\t",cq[i]);
        }
    }  
}

int main(){
    int ch,value;
    
    while(1){
        printf("\n--CIRCULAR QUEUE OPERATIONS--\n");
        printf("1.INSERTION\n2.DELETION\n3.DISPLAY\n4.COUNT\n5.EXIT\n");
        printf("Enter your choice:");
        scanf("%d",&ch);
    
    
    switch(ch){
        case 1:
        printf("Enter the value:");
        scanf("%d",&value);
        cqinsert(value);
        break;
        case 2:
        cqdelete();
        break;
        case 3:
        display();
        break;
        case 4:
        printf("Count=%d",c);
        break;
        case 5:
        exit(0);
        break;
        default:
        printf("Invalid choice !");
        break;
    }
   }
}