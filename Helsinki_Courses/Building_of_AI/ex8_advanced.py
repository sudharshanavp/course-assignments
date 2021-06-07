

import math

import random

import numpy as np

import io

from io import StringIO

countries = ['Denmark', 'Finland', 'Iceland', 'Norway', 'Sweden']

populations = [5615000, 5439000, 324000, 5080000, 9609000]

male_fishers = [1822, 2575, 3400, 11291, 1731]

female_fishers = [69, 77, 400, 320, 26] 



def guess(winner_gender):

    guess = None

    biggest = 0.0

    fishersTotalM = 0

    fishersTotalF = 0

    popTotal = 0

    for i in populations:

        popTotal += i

    for i in male_fishers:

        fishersTotalM += i

    for i in female_fishers:

        fishersTotalF += i

    if winner_gender == 'female':

        fishers = female_fishers

        fishersTotal = fishersTotalF

    else:

        fishers = male_fishers

        fishersTotal = fishersTotalM

    prob_fisher = []

    # write your solution here

    for i in fishers:

        prob_fisher.append(round((i/fishersTotal)*100, 7))

    count = 0

    #print(prob_fisher)

    for i in prob_fisher:

        if i > biggest:

            biggest = i

            guess = countries[count]

        count+=1

    return (guess, biggest)  



def main():

    country, fraction = guess("male")

    print("if the winner is male, my guess is he's from %s; probability %.2f%%" % (country, fraction))

    country, fraction = guess("female")

    print("if the winner is female, my guess is she's from %s; probability %.2f%%" % (country, fraction))



main()



  
