

all: build/wektor.o

build/wektor.o: src/wektor.cpp
	g++ -std=c++11 -c src/wektor.cpp -o build/wektor.o

tests: unit
	./unit -r junit
	./unit -s

unit: build/unit_wektor.o build/units.o build/wektor.o
	g++ build/unit_wektor.o build/units.o build/wektor.o -o unit


build/units.o: src/tests/units.cpp
	g++ -std=c++11 -Isrc -Ithirdparty -c src/tests/units.cpp -o build/units.o

build/unit_wektor.o: src/tests/unit_wektor.cpp
	g++ -std=c++11 -Isrc -Ithirdparty  -c src/tests/unit_wektor.cpp -o build/unit_wektor.o

clean:
	rm -f build/*.o unit

