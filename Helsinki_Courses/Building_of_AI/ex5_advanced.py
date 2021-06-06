import random, math

def accept_prob(S_old, S_new, T):
    prob = math.exp(-(S_old - S_new)/T)
    if S_new > S_old:
        return 1.0
    else:
        return prob

def accept(S_old, S_new, T):
    if random.random() < accept_prob(S_old, S_new, T):
        print(True)
    else:
        print(False)
