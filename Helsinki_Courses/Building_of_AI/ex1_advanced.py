portnames = ["PAN", "AMS", "CAS", "NYC", "HEL"]
 
def permutations(route, ports):
    if not ports:
        print(' '.join([portnames[i] for i in route]))

    else:
        for index,item in enumerate(ports):
            newports = ports[:index]+ports[index+1:]
            permutations(route + [item], newports)

permutations([0], list(range(1, len(portnames))))
