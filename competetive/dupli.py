ls=input().split(",")
ls.sort()
res=[]
for i in ls:
    if(ls[i+1]==ls[i+1] and ls[i] not in res):
        res.append(i) 
print(res)