def dupli(n):
    seen = set()
    dup=set()
    for i in n:
        if i not in seen:
            seen.add(i)
        else:
            dup.add(i)
    return list(dup)
ls=[1,2,3,2,4,3]
print(dupli(ls))
