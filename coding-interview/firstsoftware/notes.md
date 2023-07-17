## The Single Responsibility Principle
Classes should only do one thing and mean it only has a single reason to change
- Eg. an invoice shouldn't also have the save to file method in the class

## The Open-Closed Principle
Classes should be open to extension, but closed for modification.
We should be able to add new functionality without touching existing code.

## The Liskov Substitution Principle
Subclasses should be substitutable for their base classes.
if b is a subclass of c, then we should be able to pass b to anything that expects c and it should work

## The Interface Segregation Principle
Interfaces should be segregated, better to implement many small than 1 large
- assume an interface exists for a service and includes a pay method, now anything that is free has to implement pay

## The Dependency Inversion Principle
Classes should depend on abstract classes and interfaces, not concrete classes.
