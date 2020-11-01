# Java-Homework

## Chapter 1: Fundamentals. Your own calculator

It's 1949 and you are tasked to lead programmer's team in order to implement a brand new calculator.
The calculator is very simple though: it can add (+), multiple(x), divide(%) and take(-).
It does not and will not support any brackets or memory.
It will only ever support whole numbers.

Calculator should have only 1 function- `int calculate(string expression)`

### 0- Empty

Empty string "" should return 0.

### 1- Addition & Subtraction

Passing a string "5+5" should return 10.
Passing a string "5-5" should return 0.

### 2 - Multiplication & Division

Implement addition of 2 numbers.
passing a string "5x5" should return 25.
passing a string "5%5" should return 1.

### 3 - Division from 0

Division from zero should not be possible.
If a string "5/0" is passed, result should be -1

### 4 - Floating point numbers

As mentioned, floating point numbers should not be supported.
If string contains not a whole number and not the allowed operations
(+-x%) then it should also return -1.

### 5 - Factorial

Factorial is a number that is being multiplied from 1, till itself and is marked using "!".
For example:
4! = 4 * 3 * 2 * 1= 24
5! = 5 * 4 * 3 * 2 * 1 = 120

Add support for calculating factorial.

### 6 - Mix

Add support for mixing all sorts of operations.
"5x1+2-4!" = 17
