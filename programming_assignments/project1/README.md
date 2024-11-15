## Programming Assignment 1

To create a Java program that can create and simulate a Turing machine from states and transitions in a .txt file, we use a hash map to map multiple transitions to individual states.

States are of the form...
```
state <x>    <state_type>
```

Transitions are of the form...
```
transition   <begin state>   <read char> <result state>  <write char>   <direction>
```

The Turing machine is then run on a string from the commandline with a constraint on how many transitions the machine can simulate.

To run...
```
$ javac chen_p1.java
```
```
$ java chen_p1 test.txt <string> <max_transitions>
```

Example strings and outputs...
```
$ java chen_p1 test.txt 0110 100 
$0110# accept
```
```
$ java chen_p1 test.txt 0110 9 
0110# quit
```
```
$ java chen_p1 test.txt 021 20 
21 reject
```
