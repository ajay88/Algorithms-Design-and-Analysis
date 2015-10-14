# -*- coding: utf-8 -*-
"""
Created on Wed Oct 14 18:38:55 2015

@author: dell
"""

def sort_and_count(L,lo,hi):
    if lo >= hi:
        return (0,[L[lo]])
    mid = lo+(hi-lo)/2
    (ra,A) = sort_and_count(L,lo,mid)
    (rb,B) = sort_and_count(L,mid+1,hi)
    (r,L)  = merge_and_count(A,B)  
    return (ra+rb+r,L)

def merge_and_count(A,B):
    L =[]
    count =0
    while len(A) != 0 and len(B) != 0:
        if A[0] <= B[0]:
            L.append(A.pop(0))
        else:
            count = count+len(A)
            L.append(B.pop(0))
    if len(A) == 0:
        L.extend(B)
    if len(B) == 0:
        L.extend(A)
    return (count,L)
    
#L =[2,5,7,8,11,10,0,89,23]
#A = [2,5,7,8,90]
#B = [0,11,23,89]
#print merge_and_count(A,B)
#print sort_and_count(L,0,len(L)-1)
L =[]
f = open('IntegerArray.txt')
for x in f:
    L.append(int(x))
tup =sort_and_count(L,0,len(L)-1)
print tup[0]
        
            
            
            