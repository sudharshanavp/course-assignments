import random

def main():

    prob = 0.80
    if random.random() < prob:
        print('dog')
    else:
        print('cat')

main()


