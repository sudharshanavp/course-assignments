def main():

    portnames = ["PAN", "AMS", "CAS", "NYC", "HEL"]
    port1 = 0
    for port2 in range(1, 5):
        for port3 in range(1, 5):
            for port4 in range(1, 5):
                for port5 in range(1, 5):
                    
                    route = [port1, port2, port3, port4, port5]
                    if 0 in route:
                        if 1 in route:
                            if 2 in route:
                                if 3 in route:
                                    if 4 in route:
                                        print(' '.join([portnames[i] for i in route]))



main()
