## Programming Assignment 2

In this project, we simulate a marble game, where a marble travels down one chute that leads to 3 different chutes. The first gate picks one of the proceeding 3, and the proceeding 3 each have 2 options. Different input or "marbles" have a different impact on which options the gate points to, and changes the gate after it goes through it.

This is implemented with a Gate object in java, with 2 types that implement a different gate picking scheme for the 2 different types of gates described above.

Compile all 3 files...
```
$ javac Gate.java
```
```
$ javac Simulate.java
```
```
$ javac chen_p2.java
```

Then, run `chen_p2` with the original states and input string as command line arguments in the format...
```
$ java chen_p2 <INITIAL_STATES> <INPUT STRING>
```

For example, to run the tests in the assignment sheet...
```
$ java chen_p2 LLLL 1111
```
```
$ java chen_p2 LLLL 0000
```
```
$ java chen_p2 LLLL 01010101
```
```
$ java chen_p2 LLLL 10101010
```

