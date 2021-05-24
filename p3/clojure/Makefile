P=p3
ARG=600851475143
TIME_CMD=/usr/bin/time -p

all: build run clean

build: 
		clojure -M -e "(compile '$(P))"

run:
		$(TIME_CMD) clojure -M -m $(P) $(ARG)

clean:
		$(RM) -r classes/*.class classes/clojure/ .cpcache