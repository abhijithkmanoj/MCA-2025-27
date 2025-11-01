#include<stdio.h>
#include<stdlib.h>
#define SIZE 12
int i;
void display(int set[],int n){
    printf("{");
    for(i=0; i<n ; i++)
    {
        if (set[i]==1){
            printf("%d\t",i);
        } 
    }
    printf("}");
}

void setunion(int a[],int b[], int c[], int n){
    for(i=0;i<n;i++){
        c[i]=a[i]|b[i];
    }
}

void intersection(int a[],int b[], int c[], int n){
    for(i=0;i<n;i++){
        c[i]=a[i]&(b[i]);
    }
}
void difference(int a[],int b[], int c[], int n){
    for(i=0;i<n;i++){
        c[i]=a[i]&(~b[i]);
    }
}
int main(){
    int a[SIZE-1]={},b[SIZE-1]={};
    int result[SIZE];
    int ch,n, e;
    printf("Universal Set U={0,1,2,.....,%d}",SIZE-1);
    printf("Enter number of elements in set A:");
    scanf("%d",&n);
    printf("Enter elements of set A:");
    for(i=0;i<n;i++){
        scanf("%d",&e);
        if(e>=0 && e<SIZE)
        a[e]=1;
    }
    printf("Enter number of elements in set B:");
    scanf("%d",&n);
    printf("Enter elements of set B:");
    for(i=0;i<n;i++){
        scanf("%d",&e);
        if(e>=0 && e<SIZE)
        b[e]=1;
    }
    printf("SET A");
    display(a,SIZE);
    printf("SET B");
    display(b,SIZE);
while(1){
        printf("\n--SET OPERATIONS--\n");
        
        printf("1.UNION\n2.INTERSECTION\n3.DIFFERENCE (A-B)\n4.DIFFERENCE (B-A)\n5.DISPLAY SET\n6.EXIT\n");
        printf("Enter your choice:");
        scanf("%d",&ch);
    
    switch(ch){
        case 1:
        setunion(a,b,result,SIZE);
        printf("A U B:");
        display(result,SIZE);
        break;
        case 2:
        intersection(a,b,result,SIZE);
        display(result,SIZE);
        break;
        case 3:
        difference(a,b,result,SIZE);
        display(result,SIZE);
        break;
        case 4:
        difference(b,a,result,SIZE);
        display(result,SIZE);
        break;
        case 5:
        display(result,SIZE);
        break;
        case 6:
        exit(0);
        break;
        default:
        printf("Invalid choice !");
        break;
        }
    }
    return 0;
}