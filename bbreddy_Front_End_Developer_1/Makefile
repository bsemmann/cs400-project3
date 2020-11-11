run: compile
	
	java CitiesFrontEnd

compile:
	
	javac CS400Graph.java
	javac Cities.java
	javac CitiesBackEnd.java
	javac CitiesFrontEnd.java
	javac -cp .:junit5.jar CityTest.java
	
test:
	
	java -jar junit5.jar --class-path . --scan-classpath --details tree

clean:
	$(RM) *.class
