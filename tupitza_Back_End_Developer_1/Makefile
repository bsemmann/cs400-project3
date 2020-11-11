run: compile
	java CitiesFrontEnd

compile:
	javac CS400Graph.java
	javac Cities.java
	javac CitiesBackEnd.java
	javac CitiesFrontEnd.java

test: CityTest.class
	java -jar junit5.jar -cp . --scan-classpath -n CityTest

CityTest.class:
	javac -cp .:junit5.jar CityTest.java

clean:
	$(RM) *.class
