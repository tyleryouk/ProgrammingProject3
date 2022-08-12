# ProgrammingProject3

Programming Project 3

I. Overview
The purpose of this project is to give you practice designing a class hierarchy. It is important that you spend time designing your class hierarchy before you start coding. If you properly organize your classes, you can achieve the desired program behavior below with significantly less code that with a poorly organized hierarchy.

II. Code Readability (20% of your project grade)
New for this assignment: The comments above the class and above each method must be written in JavaDoc format. You will be introduced to JavaDoc style commenting in the labs. You can also find a description in the Java in a Nutshell text. Be sure to run JavaDoc and view the webpage in order to verify that you have implemented the comments correctly.

To receive the full readability marks, your code must follow the following guideline:

All variables (fields, parameters, local variables) must be given appropriate and descriptive names.
All variable and method names must start with a lowercase letter. All class names must start with an uppercase letter.
The class body should be organized so that all the fields are at the top of the file, the constructors are next, the non-static methods next, and the static methods at the bottom.
There should not be two statements on the same line.
All code must be properly indented (see page 689 of the Lewis book for an example of good style). The amount of indentation is up to you, but it should be at least 2 spaces, and it must be used consistently throughout the code.
You must be consistent in your use of {, }. The closing } must be on its own line and indented the same amount as the line containing the opening {.
There must be an empty line between each method.
There must be a space separating each operator from its operands as well as a space after each comma.
There must be a comment at the top of the file that is in proper JavaDoc format and includes both your name and a description of what the class represents. The comment should include tags for the author.
There must be a comment directly above each method (including constructors) that is in proper JavaDoc format and states what task the method is doing, not how it is doing it. The comment should include tags for any parameters, return values and exceptions, and the tags should include appropriate comments that indicate the purpose of the inputs, the value returned, and the meaning of the exceptions.
There must be a comment directly above each field that, in one line, states what the field is storing.
There must be a comment either above or to the right of each non-field variable indicating what the variable is storing. Any comments placed to the right should be aligned so they start on the same column.
There must be a comment above each loop that indicates the purpose of the loop. Ideally, the comment would consist of any preconditions (if they exist) and the subgoal for the loop iteration.
Any code that is complicated should have a short comment either above it or aligned to the right that explains the logic of the code.
III. Program Testing (20% of your project grade)
New for this assignment: The testing routines should be included in a JUnit test class.

You are to write a test report that indicates the types of tests needed to thoroughly test your project. The tests should demonstrate that all of your methods behave correctly. An conditional statements will need tests that go through each branch of the execution. Any loops will need tests that cover the "test 0, test 1, test many" and "test first, test middle, test last" guidelines. Your testing report should not list the actual tests and results.

You are to have a JUnit test class or classes that implement each of the needed tests. Comments and method names in your JUnit class should connect to your testing report. For example, if your testing report states "method xxx must be tested with string inputs of different lengths", then the reader should be able to go to the JUnit class and easily identify the tests that test that method on inputs of length 0, 1, and more than 1.

The testing report must be separate from the JUnit class. In most companies, the testing document will be written in a style that allows both programmers and non-programmers to read it and recognize whether all the needed test cases were included.

IV. Java Programming (60% of your grade)
Manipulating points, lines, vectors and planes is the bane of many math students. You will make their life easier (and maybe help you in multivariate calculus and physics classes) by writing classes to model these objects. Java already has classes for 2-dimensional points and line segments, but these classes are not as generic as they could be are are really meant for desiging graphical user interfaces. You will create classes for points, lines, vectors, and planes in 2-dimensions and 3-dimensions that you could use for physics or geometry programs.

Design Rules: Your project must contain the following five types and each type must contain the listed methods. The project may use any combination of classes, abstract classes, or interfaces that you feel is appropriate. The project may add additional types to the ones listed. The classes/types may contain additional methods to the ones listed if you feel they are needed. You may use any combination of inheritance, method overriding, and method overloading to achieve the needed behavior. Part of the coding grade will be the quality of the class hierarchy you create.

Point2D
A 2-dimensional point is a location on a plane with two coordinates. To integrate the Point2D class with the other classes below, assume the point lies in the plane with the z-coordinate equal to 0. The Point2D class should have the following constructor:
the constructor takes two double values that represent the x and y coordinates and it creates a point with those coordinates
as well as the following methods:
getX
Takes no input and returns the x coordinate.
getY
Takes no input and returns the y coordinate.
toString
Overrides the toString method of Object. Returns a String representation of the point. The representation should be the x coordinate followed by the y coordinate inside parenthesis. For example, "(3.0,5.0)"
equals
Overrides the equals method of Object. Returns true if the input values is a Point or Point2D with the same coordinates as this Point2D.
distance
A static method that takes two input values and returns a double. The input values that may be type Point or Point2D. Returns the distance from the first input point to the second one. (The Math class contains a function you may find useful.)
Line2D
A line in 2-dimensional space (i.e. in the plane with the equation z=0). The Line2D class should have the following constructor:
the constructor takes two input values that are each type Point2D. The new Line2D is defined by the two points. You can assume the two points are different. Optional challenge: Create a checked exception that you throw if the two points are not different.
In addition, the Line2D class should have the following methods:
toString
Overrides the toString method of Object. Returns a String representation of the Line2D. The String should contain the slope/intercept equation for the line, unless the line is vertical. For example: "y = 5.0x + 3.4", "y = 0.3x - 10.1", and "x = 1.3" are good representations, and the last example is for the case where the slope is vertical.
equals
Overrides the equals method of Object. Return true if input value is a Line2D or a Line that represents the same line.
isParallel
A static method that takes two inputs and returns a boolean. The input values may be type Line2D or type Line. Returns true if the two input lines are parallel.
intersection
A static method that takes two lines as input and returns a point. If both inputs are type Line2D the the ouput should be type Point2D. If either input is type Line then the output should be type Point. The method should return the point where the two input lines intersect, if there is an intersection. If the two lines do not intersect, the method should return null.
Point
A 3-dimensional point. The Point class should have the following constructor:
the constructor takes three double values that represent the x, y, and z coordinates and it creates a point with those coordinates
as well as the following methods:
getX
Takes no input and returns the x coordinate.
getY
Takes no input and returns the y coordinate.
getZ()
Takes no input and returns the z coordinate.
toString
Overrides the toString method of Object. Returns a String representation of the point. The representation should be the x coordinate followed by the y coordinate and z coordinate inside parenthesis. For example, "(3.0,5.0,-1.0)"
equals
Overrides the equals method of Object. Returns true if the input values is a Point or Point2D with the same coordinates as this Point2D.
distance
A static method that takes two input values and returns a double. The input values that may be type Point or Point2D. Returns the distance from the first input point to the second one. (The Math class contains a function you may find useful.)
Line
A line in 3-dimensional space. The Line class should have multiple constructors:
You can define a line by two points where the points may be either type Point2D or type Point. You can assume the two points are different. Optional challenge: Create a checked exception that you throw if the two points are not different.
You can define a line by a point and a Vector where the point may be either type Point2D or Point. The line will run through the point and be parallel to the vector.
In addition, the Line class should have the following methods:
toString
Overrides the toString method of Object. Returns a String representation of the Line. The String should contain the three parametric equations for the line.
equals
Overrides the equals method of Object. Return true if the input value is a Line or a Line2D that represents the same line.
getVector
Takes no input and returns a Vector that is parallel to this line.
isParallel
A static method that takes two inputs and returns a boolean. The input values may be type Line2D or type Line. Returns true if the two input lines are parallel.
intersection
A static method that takes two lines as input and returns a point. If both inputs are type Line2D the the ouput should be type Point2D. If either input is type Line then the output should be type Point. The method should return the point where the two input lines intersect, if there is an intersection. If the two lines do not intersect, the method should return null.
Vector
A vector is a directed line segment that starts at the origin and ends at the x, y, and z coordinates of the point. The Vector should have the following constructors.
A constructor that takes three double values: x, y, and z and creates a Vector with these coordinates.
A constructor that takes a Point values and creates a vector with the same coordinates as the point.
A constructor that takes a Vector and double value and creates a Vector that is the same direction as the input Vector but with length equal to the input double.
And the following methods:
toString
Overrides the toString method of Object. Returns a String representation of the Vector. The representation should be the x coordinate followed by the y coordinate and z coordinate inside angle brackets. For example, "<3.0,5.0,-1.0>".
equals
Overrides the equals method of Object. Returns true if the input value is a Vector with the same coordinates.
magnitude
Takes no input and returns the length of the Vector as a double.
unitVector
Takes no input and returns a new Vector that has the same direction as this Vector but with length 1.
sum
A static method that takes two input Vectors and returns a new Vector that is the sum of the input vectors. <5, 6, 2> + <3, 4, 7> = <5 + 3, 6 + 4, 2 + 7>
scale
A static method that takes a Vector and a double and returns a new Vector that is the result of multiplying each coordinate in the input Vector by the input double.
