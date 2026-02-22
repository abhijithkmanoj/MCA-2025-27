a=input()
for i in range(len(a)-1):
    if a[i]==a[i+1]:
        a=a[0:i]+a[i+2::]
print(a)