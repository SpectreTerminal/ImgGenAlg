# ImgGenAlg
 
## Prelude
This project is based from an assignment in my second-year C programming course. However, a poor understanding of C led to a poor result in that assignment. As a way to hone my programming skills, I took on the task of correctly completing this task, but in a domain I was more familiar with, Java. 

## Background  
A genetic algorithm takes inspiration from natural selection. A population of individuals, containing a set of properties, evolves over time through mutations or crossovers/reproductions. An individual's strength is determined by its _fitness_ value. Depending on the context, a higher or lower fitness value indicates a stronger individual. In each iteration/generation, the stronger individuals reproduce, the weaker individuals "die". This continues for a fixed number of generations, or until the fitness level is satisfactory for the problem at hand.

Taken from [Wikipedia on Genetic Algorithms][1].

## About this Project
The goal is to apply concepts of the genetic algorithm to re-create a provided image. This uses individuals, each holding an array of pixels (the image itself), and the fitness itself. In this context, a lower fitness value indicates a **stronger** individual, that the individual's image has a better resemblance to the original image.

## Running this Project
A JAR file and supporting makefile is available in the root directory of the repository. 
1. Download these files, along with the `data` directory.
2. Ensure that all files are together in the same directory.
3. Run `make GenAlg` where the makefile is located.

[1]: https://en.wikipedia.org/wiki/Genetic_algorithm
