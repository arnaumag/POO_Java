# Example de makefile pour compiler le squelette de code distribué
# Vous pouvez compléter ce makefile, mais étant donnée la taille du projet, 
# il est FORTEMENT recommandé d'utiliser un IDE!

# Organisation:
#  1) Les sources (*.java) se trouvent dans le répertoire src
#     Les classes d'un package toto sont dans src/toto
#     Les classes du package par defaut sont dans src
#
#  2) Les bytecodes (*.class) sont générés dans le répertoire bin
#     La hiérarchie des sources (par package) est conservée.
#
#  3) Une librairie gui.jar est distribuée pour l'interface grapique. 
#     Elle se trouve dans le sous-répertoire lib.
#
# Compilation:
#  Options de javac:
#   -d : répertoire dans lequel sont générés les .class compilés
#   -sourcepath : répertoire dans lequel sont cherchés les .java
#   -classpath : répertoire dans lequel sont cherchées les classes compilées (.class et .jar)

all: runTestInvader 

compileTestInvader:
	javac -d bin -classpath lib/gui.jar src/TestInvader.java

runTestInvader: compileTestInvader
	java -classpath bin:lib/gui.jar TestInvader

compileBalls:
	javac -d bin src/Balls.java

compileTestBalls:
	javac -d bin -classpath src src/TestBalls.java

runTestBalls: compileTestBalls
	java -classpath bin TestBalls

compileBallsSimulator:
	javac -d bin -classpath lib/gui.jar:src src/BallsSimulator.java

compileTestBallsSimulator:
	javac -d bin -classpath lib/gui.jar:src src/TestBallsSimulator.java

runTestBallsSimulator: compileTestBallsSimulator
	java -classpath bin:lib/gui.jar TestBallsSimulator

compileConway:
	javac -d bin src/Conway.java

compileTestConway:
	javac -d bin -classpath src src/TestConway.java

runTestConway: compileTestConway
	java -classpath bin TestConway

compileConwaySimulator:
	javac -d bin -classpath lib/gui.jar:src src/ConwaySimulator.java

compileTestConwaySimulator:
	javac -d bin -classpath lib/gui.jar:src src/TestConwaySimulator.java

runTestConwaySimulator: compileTestConwaySimulator
	java -classpath bin:lib/gui.jar TestConwaySimulator

clean:
	rm -rf bin/

