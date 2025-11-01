#include<stdio.h>
#include<stdlib.h>
#define MAX 100

int parent[MAX];

void makeset(int n){
    for(int i=0;i<n;i++){
        parent[i]=i;
    }
    printf("Sets are created");
}

int find(int x){
    if(parent[x]!=x){
        parent[x]=find(parent[x]);
    }
    return parent[x];
}

void unionset(int x, int y){
    int rootx=find(x),rooty=find(y);
    if(rootx != rooty){
        parent[rootx]=rooty;
        printf("Sucessfull union\n");
    }
    else{
        printf("They are already in same set\n");
    }
}

void display(int n){
    for(int i=0;i<n;i++){
        printf("%d : %d\n",find(i),i);
    }

}

int main(void)
{
    int ch,i,n,a,x,b;
    printf("Enter number of disjoint sets:");
    scanf("%d",&n);
    makeset(n);
    while(1){
        printf("\n\n--DISJOINT SET OPERATIONS--\n");
        printf("1.DISPLAY\n2.FIND\n3.UNION\n4.EXIT\n"); 
        printf("Enter your choice:");
        scanf("%d",&ch);   
        switch(ch){
            case 1:
                display(n);
            break;
            case 2:
                printf("Enter the set you want to find:");
                scanf("%d",&x);
                printf("root of %d is %d",x,find(x));
            break;
            case 3:
                printf("Enter the sets you want to union:");
                scanf("%d %d",&a,&b); 
                unionset(a,b);  
            break;
            case 4:
                exit(0);
            break;
            default:
                printf("Invalid choice !");
            break;
        }
    }
    return 0;
}