def ext (l):
    result = []
    for i in l:
        if isinstance(i, list):
            result.extend(ext(i))
        else:
            result.append(i)
    return result
ls=[1,[2,[3,4]],5]
print(ext(ls))