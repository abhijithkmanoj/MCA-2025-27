#include<stdio.h>
#include<stdlib.h>
#define SIZE 6
int i;
void setunion(int x[SIZE-1],int y[SIZE-1]){
    int z[SIZE-1];
    for(i=0;i<SIZE;i++){
        if(x[i]==1 || y[i]==1){
            z[i]=1;
        }
    }
    printf("union SET A and SET B:");
    for(i=0;i<SIZE;i++){
        printf("%d",z[i]);
    }
}

int main()
{   
    int ch,e,a[SIZE-1],b[SIZE-1],c[SIZE-1];
    for(i=0;i<SIZE-1;i++){
        a[i]=0;
        b[i]=0;
        c[i]=0;
    }
    printf("Enter elements of Set A from 0 to %d and -1 to stop",SIZE);
        while(i){
            scanf("%d",&e);
            if(e==-1){
                i=0;
            }
            else{
                a[e-1]=1;
            }
        }
    printf("Enter elements of Set B from 0 to %d and -1 to stop",SIZE);
        i=1;
        while(i){
            scanf("%d",&e);
            if(e==-1){
                i=0;
            }
            else 
            {
                b[e-1]=1;
            }
        }
        printf("SET A:");
        for(i=0;i<SIZE;i++){
        printf("%d\t",a[i]);
        }
        printf("SET B:");
        for(i=0;i<SIZE;i++){
        printf("%d\t",b[i]);
        }



    while(1){
        printf("\n--SET OPERATIONS--\n");
        printf("Universal Set U={1,2,.....,%d}",SIZE-1);
        printf("1.UNION\n2.INTERSECTION\n3.DIFFERENCE (A-B)\n4.DIFFERENCE (B-A)\n5.DISPLAY SET\n6.EXIT\n");
        printf("Enter your choice:");
        scanf("%d",&ch);
    
    switch(ch){
        case 1:
        setunion(a,b);
            break;
        case 2:
        intersection(a[],b[]);
        break;
        case 3:
        difference(a[],b[]);
        break;
        case 4:
        difference(b[],a[]);
        break;
        case 5:
        display();
        break;
        case 6:
        exit(0);
        break;
        default:
        printf("Invalid choice !");
        break;
        }
    }
}
