#48-57  , 65-90 , 97-122
str=input().lower()
res=[]
for i in str:
    if 48<=ord(i)<=57 or 97<=ord(i)<=122:
        res.append(i)
print(res==res[::-1])
