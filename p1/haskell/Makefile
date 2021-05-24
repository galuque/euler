P=p1
ARG=1000
TIME_CMD=/usr/bin/time -p

all: build run clean

build:
		stack ghc $(P).hs

run: build
		$(TIME_CMD) ./$(P) $(ARG)

clean:
		$(RM) $(P) *.hi *.o

