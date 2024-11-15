## Programming Assignment 4

To create a PDA that accepts **{ x#y | x, y in {0,1}* such that x != y and xi = yi for some i s.t. 1 <= i <= min(|x|, |y|)}**, a string is accepted if |x| != |y| and some xi = xy, or if |x| = |y|, if some xi = yi and some x(i+1) != y(i+1).

This PDA is nondeterministic and has two sections, one that checks for xi = yi and x(i+1) != y(i+1) and one for xi = yi and |x| != |y|.

In section 1...
- Loop through x, adding pushing k to the stack regardless of what is read. When we are at an arbitrary i(nondeterministic, so the program will run through all possible options), we push the i's symbol and (i+1)'s symbol onto the stack
- For the remainder of x, do nothing to the stack. This way, we have access to i
- Once we transition to y, we pop off the top of the stack to get xi and x(i+1). There are 4 possible combinations for xix(i+1), which are 00, 01, 10, 11, and we move an appropriate subsection that checks for the specific combination.
- Then, we loop through y and pop off k everytime, thus allowing us to move to the ith character in y
- Each subsection will check if xi = yi and if either x(i+1) != y(i+1) or x(i+1) is empty while y(i+1) has a value, which implies x(i+1) != y(i+1)

In section 2...
- We push the first character of x and push k onto the stack for the rest of the charactes
- When we get to y, we move to an appropriate subsection based on the first character of y
- This loops through k and checks that once we get to the bottom of the stack, the first character of x matches the first character of y, done through the subsections we moved into. This ONLY accepts if the length is not the same