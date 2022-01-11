# ant-simulation
Language: Java

Objective: Move an ant from one point and reach to food and take it back home.

Functionality:

A board has been set with values 0 or 1. 0 denotes the wall or 1 is the path. Ant will turn whenever it hits the wall in another direction. Simultaneously it stores the path for an optimal path like an ant does. It will return home if the ant finds food or moved all the possible squares and did not find food. If the ant finds the food, it will take that food and returns to home with the path which is followed(does not count where it took a U-turn). Also according to the food weight(value), it will come multiple times to take the whole food.


I used the backtracking concept to solve this issue. As well as to monitor the U-turns I changed the board value to -3 so ant doesn't check on the old path. Even I maintained an array to store the position of the ant on each step. If it moves ahead but on the new or unknown-block it adds up the position otherwise delete it.
