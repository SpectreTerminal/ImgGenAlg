DIRECTORY=src
AUX=Crossover.class Driver.class Evolve.class Fitness.class Individual.class IO.class Mutate.class Pixel.class Population.class PPMImage.class
ENCODE=UTF-8
JAR=GenAlg.jar

GenAlg:
	java -jar -Dfile.encoding=$(ENCODE) $(JAR)

# for cleaning purposes
clean:
	cd $(DIRECTORY); rm $(AUX) 
