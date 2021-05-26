P=p5
TIME_CMD=/usr/bin/time -p

all: build run clean

build: 
		clojure -M -e "(compile '$(P))"

run:
		$(TIME_CMD) clojure -M -m $(P)

clean:
		$(RM) -r classes/*.class classes/clojure/ .cpcache