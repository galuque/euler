P=p1
ARG= 1000
TIME_CMD=/usr/bin/time -p
OBJECTS= $(P).o
CFLAGS = -g3 -Wall -O3 -std=c11 -Wpedantic -fsanitize=undefined
LDLIBS = -Wall -fsanitize=undefined
CC     = gcc

all: build run clean

build: $(OBJECTS)
		$(CC) $(CFLAGS) $(OBJECTS) -o $(P)

run: build
		$(TIME_CMD) ./$(P) $(ARG)

clean:
		$(RM) $(P) *.o
