# Airport-Traffic-Simulator
## Introduction
This Java based software was developed for the simulation of airtraffic of five seleced airports in United states. A object oriented coding strategy have been applied, so all aiports and airplane are treated as objects of the corresponding class. For airport objects, the related events are: TAKEOFF, ARRIVES, LANDED and DEPARTS. Airplane objects take care of passenger number, airplane speed and destination and original airport. All events for airport and airplanes are handled by an EventHandler class by using a comman Descrete Event Simulation (DES) method. The details of the software structure can be found in the *Report.pdf*.
## Run the Experiment
In *AirportSim.java* file, you can specify the number of airplanes you want to run the whole simulation. The larger this number is, the more time it takes to run. Just kindly change this number and compile the program with

__javac AirportSim.java__ and use __java AirportSim__ to run the whole simulation.
