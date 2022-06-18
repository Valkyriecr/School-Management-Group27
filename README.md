# School-Management-Group27

Problem Statement: 
In the quest for seamless and effective organisational processes in a college, the technology department of the college has been given the task to digitize and automate its academic-facing processes. The technology department has decided to use Domain Driven Design to actualize this. A section of the technology team was given the responsibility to solicit requirements based on the as-is processes. Thus, after many analysis meetings, they have come up with a domain model.

Improvements: 
As far as improvements go. The packaging layout might need to be organized a bit differently to ensure readability and understanding of where each one leads and does. Another improvement that could be added is more comments to add clarity where needed. Naming conventions should’ve been agreed on beforehand to make sure it was a smooth transition.

Flaws in UML and implementation: 
In the UML, country and address entities has the composition symbol. This is saying that country can’t be listed in more than one location. This in turn should sport an aggregation symbol because country can be listed in multiple cities. The UML is also saying that a country can’t exist without city which is an improper use of the composition symbol. 
