To create a turing machine that RECOGNIZES strings of the form {0^n (01)^m 1^k | n,m,k >= 0 and n > m and m > k}, we only need to accept when the conditions are met. 

To do this, we loop through the input string and cross out a 0(n), an 01(m), and a 1(k). The format of the language, which is in strictly decreasing order makes implementing this easy. n must be at least 2 and m at least 1. 

Thus, we can implement a stage to check for n >= m > k and a stage for n > m.
    - In stage 1...
        - Loop through input and replace a unique 0, 01, and 1
        - This continues until a loop is reached where 0 and 01 are found, but there are no 1s, thus ensuring n >= m > k
        - If a 0 or 01 are not found, there are no transitions and the machine cannot accept this input
            - A 0 not being found implies that n = k
            - A 01 not being found implies that m = k
    - In stage 2..
        - We loop through the input replacing a unique 0 and 01
        - This continues until a loop is reached where there is a 0 but no 01, ensuring n > m, leading to an accept state

Example strings...
    - Accept
        - 00001011
            - n = 3, m = 2, k = 1
        - 000000000101011
            - n = 8, m = 3, k = 1
    - Reject
        - 0
        - 1
        - 0011
            - n = 1, m = 1, k = 1
        - 000011
            - n = 3, m = 2, k = 1
        - 00101111
            - n = 1, m = 2, k = 3

Notes...
    - Detecting 01 is implemented by requiring a 0 to be read and shifting right, a 1 to be read and written over and shifting left, and the previous 0 to be read and written over shifting right, shifting right again(as we are over the previously written over 1), leaving us at the next input character after 01  

