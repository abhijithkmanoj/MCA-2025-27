#2.	 Accept a list of single digit numbers as input string. Concatenate the elements of the list as a single number.

def combine(s):
    if(len(s)==1): return int(s[0])
    else:
        for i in s:
            int(s[0])
            return s[0]*10 + combine(s[0:])
            

s=list(map(int,input("Enter number of the list comma seperated:").split(",")))
print(combine(s))