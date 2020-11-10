run: compile
	java FrontEndWisconsinMap

compile:
	javac FrontEndWisconsinMap.java
	javac Cities.java
	javac CitiesBackEnd.java
	javac CityTest.java
	javac CS400Graph.java
	javac GraphADT.java

test: compile
	java CityTest

clean:
	$(RM) FrontEndWisconsinMap.class
	$(RM) Cities.class
	$(RM) CitiesBackEnd.class
	$(RM) CityTest.class
	$(RM) CS400Graph.class
	$(RM) GraphADT.class
