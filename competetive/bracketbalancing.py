def paramm(s):
  stk=[]
  mapping={")":"(","]":"[","}":"{"}
  for char in s:
    if char in "({[":
      stk.append(char)
    elif char in ")}]":
      if not stk or stk[-1]!=mapping[char]:
        return False
      stk.pop()
  return not stk

s=input()
print(paramm(s))
