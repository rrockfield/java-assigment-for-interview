# ASML Assigment for interview

Given a 2D array

{{1,2,3,4},
{5,6,7,8},
{9,10,11,12},
{13,14,15,16}}

Traverse the array in the pattern below and print the numbers along the path.

Print: 1,2,3,4, 8,12,16, 15,14,13, 9,5, 6,7, 11, 10

Must haves

- Solution written in Java
- Internal logic shall be under unit test
- Documentation in the code

Nice to haves

- Suggestions for improvement

# Not-specified Assumptions

- If matrix is null, throw an exception
- If there is a null row, throw an exception
- If rows are not the same size, throw an exception
- If matrix is empty, it's still valid, and print and empty string
- If rows are empty, it's still a valid matrix, and print and empty string
- Matrix is small enough to fit in memory

# Performance improvement

It's possible to use parallelism to process this task (multithread or distributed) if matrix is large enough and therefore worth it.

Each move could be sent to a thread and collect at the end in the same order as soon as they finish building its String object.

# What to do it Matrix is too large and provided via files

- Read matrix line by line once.
- Build files for each movement. Right and Left movements are easy, because they belong to a single line.
- Up and Down files can be tricky, as you need to append to those files for every line read.
- When printing the result, Left and Down movement files must be read backwards.
- File movements must be indexed

For example, given a 2D array

{{1,2,3,4},
{5,6,7,8},
{9,10,11,12},
{13,14,15,16}}

read line 1 and create file:

file00000000001: 1,2,3,4,

read line 2 and create files:

file00000000002: 8,
file00000000004: 5,
file00000000005: 6,7,

read line 3 and create/modify files:

file00000000002: 8,12
file00000000004: 5,9 (add 9)
file00000000006: 10,11

read line 4 and create/modify files:

file00000000002: 8,12,16 (add 16)
file00000000004: 5,9,13 (add 13)
file00000000003: 13,14,15

Print:

file00000000001,
file00000000002,
file00000000003 backwards,
file00000000004 backwards,
file00000000005,
file00000000006