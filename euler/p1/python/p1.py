import sys


def p1(limit):

    multiples = [n for n in range(limit) if n % 3 == 0 or n % 5 == 0]

    return sum(multiples)


if __name__ == "__main__":
    arg = int(sys.argv[1])
    print(p1(arg))
