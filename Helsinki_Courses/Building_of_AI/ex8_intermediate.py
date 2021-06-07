def main():

    countries = ['Denmark', 'Finland', 'Iceland', 'Norway', 'Sweden']

    populations = [5615000, 5439000, 324000, 5080000, 9609000]

    fishers = [1891, 2652, 3800, 11611, 1757]

    probabilities = []



    total_fishers = sum(fishers)

    total_population = sum(populations)

    

    for i in fishers:

        probabilities.append((i/total_fishers)*100)

    # write your solution here



    for country, probability in zip(countries, probabilities):

        print("%s %.2f%%" % (country, probability)) # modify this to print correct results



main()
