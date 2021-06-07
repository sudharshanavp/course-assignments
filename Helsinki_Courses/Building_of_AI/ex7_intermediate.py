def count11(seq):

   # define this function and return the number of occurrences as a number

    count = 0

    for i in range(0,len(seq)-1):

        if (seq[i] == seq[i+1] == 1):

            count+=1

    # insert code to return the number of occurrences of 11111 in the sequence

    return count

    

print(count11([0, 0, 1, 1, 1, 0])) # this should print 2
