import numpy as np



def generate(p1):

    # change this so that it generates 10000 random zeros and ones

    # where the probability of one is p1

    seq = np.random.choice([0,1], p=[1-p1, p1], size=10000)

    return seq



def count(seq):

    count = 0;

    for i in range(0,len(seq)-4):

        if (seq[i] == seq[i+1] == seq[i+2] == seq[i+3] == seq[i+4] == 1):

            count+=1

    # insert code to return the number of occurrences of 11111 in the sequence

    return count



def main(p1):

    seq = generate(p1)

    return count(seq)



print(main(2/3))
