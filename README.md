# Welcome to the ZRA, a Zoo for Robotic Animals!

## Project Description:

This project contains the design of a zoo for robotic animals called the ZRA. It is set in the future, so you
will be visiting the ZRA as a time traveler!

This application will allow you to **visit robotic animals** in various locations and learn interesting facts about 
them. This application will also allow you to **donate robotic 
animal(s) of your own** to the ZRA!

Anyone who wants to take a break from schoolwork or work and explore the world of robotic
animals is welcome to use it! The purpose of this application is to provide user enjoyment and invoke curiosity.

This project is of interest to me because I love thinking creatively and inventing fun
worlds that seem otherworldly or impossible. A zoo for robotic animals is right up my alley!


## User Stories:

*PHASE 1*

As a user, I want to be able to:
- view a list of all of the robotic animals currently in the ZRA and where they are located
- specify the biome I want to visit in the ZRA, and view a list of the animals in that biome
- select an animal in a certain biome, and view the animal in detail
- donate a robotic animal of my own to the ZRA (including their name, the biome they live in, their length, and a 
cool fact about them)


*PHASE 2*

As a user, I want to be given the option to:

- save my ZRA application to file
- load my previous ZRA application from file

# Instructions for Grader

1. You can generate the first required event by clicking the button on the side tab labelled "DONATE". Enter
the robotic animal's name, select the biome it lives in, use the slider to pick a length and enter a cool fact.
Press "Submit!" to submit your robotic animal, and click "Reset" to clear the submission boxes.
2. You can generate the second required event by visiting subsets of the robotic animals in the Cave, 
Grassland, Ocean, or Tropic. Select the appropriate biome on the side tab, and click "Explore the ____!" 
for an updated list of all the robotic animals in that biome.
3. You can locate my visual components (images) by running the application and observing the splash screen, or by 
visiting the "WELCOME" tab or any of the biome tabs.
4. You can save the state of my application by clicking the "Save" button on the "WELCOME" tab.
5. You can reload the state of my application by clicking the "Load" button on the "WELCOME" tab.

## Phase 4: Task 2

Wed Aug 10 18:28:13 GMT-07:00 2022 --- ADDITION: TurboTurtle was added to the ZRA!

Wed Aug 10 18:28:13 GMT-07:00 2022 --- ADDITION: ZeonZebra was added to the ZRA!

Wed Aug 10 18:28:38 GMT-07:00 2022 --- VISITATION: Cave was visited!

Wed Aug 10 18:28:59 GMT-07:00 2022 --- ADDITION: ScarySquid was added to the ZRA!

Wed Aug 10 18:29:02 GMT-07:00 2022 --- VISITATION: Ocean was visited!

Wed Aug 10 18:29:05 GMT-07:00 2022 --- VISITATION: Tropic was visited!

Wed Aug 10 18:29:35 GMT-07:00 2022 --- ADDITION: TomCat was added to the ZRA!

Wed Aug 10 18:29:39 GMT-07:00 2022 --- VISITATION: Cave was visited!

Wed Aug 10 18:29:41 GMT-07:00 2022 --- VISITATION: Grassland was visited!

Wed Aug 10 18:30:30 GMT-07:00 2022 --- ADDITION: PeakyParrot was added to the ZRA!

Wed Aug 10 18:31:40 GMT-07:00 2022 --- ADDITION: LightspeedLion was added to the ZRA!

Wed Aug 10 18:31:42 GMT-07:00 2022 --- VISITATION: Grassland was visited!

Wed Aug 10 18:31:49 GMT-07:00 2022 --- VISITATION: Tropic was visited!

Process finished with exit code 0

## Phase 4: Task 3

If I had more time to work on the project, I would do some refactoring to improve the design. I would do as follows:

- A lot of classes currently rely on the same instance of the ZooForRoboAnimals (they have a field / an association 
with that class). I would use the Singleton design pattern, similar to the one in the EventLog class, that creates a 
single instance of the ZooForRoboAnimals that other classes can call and operate on, to remove some of those 
associations.
- I would create a ZooManager class that contains all the methods that filter through elements of the 
ZooForRoboAnimals (such as the method that gets all the RoboAnimals in a certain biome, or the method that returns a 
list of all the names of the RoboAnimals currently in the ZooForRoboAnimals). This would remove the association 
between the BiomeTab class and the ZooForRoboAnimals class, and create one between BiomeTab and 
ZooManager. This refactoring would improve cohesion.