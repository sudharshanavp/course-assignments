import random



def main():
    favourite = "bats"
    prob = random.random()
    print(prob)
    if prob < 0.8:
        favourite = "dogs"
    if prob > 0.9:
        favourite = "cats"
    print("I love " + favourite) 

main()
