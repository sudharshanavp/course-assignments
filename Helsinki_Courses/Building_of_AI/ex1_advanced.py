import random

portnames = ["PAN", "AMS", "CAS", "NYC", "HEL"]
def permutations(route, ports):
    if route == [0]:
        i = random.choice(ports)
        route.append(i)
        if i in ports:
            ports.remove(i)
        permutations(route, ports)



    if not ports:

        print(' '.join([portnames[i] for i in route]))





permutations([0], list(range(1, len(portnames))))
