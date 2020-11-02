# Chapter 1. Homework: Cooking and Conversions

## Introduction

There are 2 main measurement systems to this day: Imperial and Metric.
This is especially apparent comparing amount and quantity measurements in America and Europe.

https://www.thecookierookie.com/cooking-measurements-kitchen-conversion-chart/

Trying to make sense reading amounts in a recipe might be really tricky:

- 1/5 TSP = 1 ML
- 1 TSP = 5 ML
- 1 TBSP = 15 ML
- 1 FL OUNCE = 30 ML
- 1 CUP = 237 ML
- 1 PINT (2 CUPS) = 473 ML
- 1 QUART (4 CUPS) = .95 LITER
- 1 GALLON (16 CUPS) = 3.8 LITERS
- 1 OZ = 28 GRAMS
- 1 POUND = 454 GRAMS

You need to implement a function which does the conversions for cooking amounts.

## Cooking Measurement

Create a class called `CookingMeasurement`. Publicly, it should only have 2 methods: `float getAmount()`, `String getUnit()`.
It should be created using a public constructor that takes amount and unit.

## Units and Amounts

Create a class Cooking.

### Units

Inside a cooking class, create a static class called `Units`.
Define all the measurement units inside this class.
Have metrics for: OZ, POUND, GALLON, QUART, PINT, CUP, FL_OUNCE, TBSP, TSP.
Use `public static final String` for every declaration.

### Amounts

Inside a cooking class, add one more static class called `Amounts`.
Each amount should translate to ML (including ML itself = 1).
Use the same constant syntax.
For example:
```
public static final float TSP = 5;
public static final float ML = 1;
```

## Get ready for conversions

Create a class CookingMeasurementConverter, which has a static method `CookingMeasurement convert(CookingMeasurement originalMeasurement, String unit)`

## Basic conversion (EASY)

For now, `convert` just supports TSP to ML conversion.

## More conversions (EASY)

Add the remaining conversions to ML: OZ, POUND, GALLON, QUART, PINT, CUP, FL_OUNCE, TBSP, TSP.

Hint: create a function which uses a switch statement for checking for unit and then returning the right amount for it.

## Console conversion (EASY)

Create a class called `ReceipePrompt`, with a public method `void run()`, which calls two private methods: 
`void promptAmount()` and `void promptUnit()` that reads both the amount and the unit for cooking measurement.
A user should see a prompt to enter those and in case invalid (not existing unit, negative amount) is entered, 
a retry to enter it should be asked again.

## Two-way conversion (HARD)

In `convert` function, add support for converting from/to every known unit described previously. 

Hint: use the function from *More Conversions* step (with a switch statement) to getAmount
amount of original measurement and measurement you need to convert it to, take their ration and multiple it original amount from that ratio. 

## Menu (MEDIUM)

Update `ReceipePrompt` class `Run()` method. It no longer does the two prompts.
Instead, it prints a menu first:

```
1 - basic conversion of a measurement
2 - receipe processing
```

User is prompted to select either option 1 or 2. Selecting option 1 does the same as before (basic conversion).
Selecting option 2 prints "to be implemented" in the console (in red).

Hint: don't forget to reset the console color after it prints text in red.

## Recipe conversion (VERY HARD)

Implement the option 2 in menu selection.
User pastes a recipe in the console and it should convert that to have all measurements in ML.

Algorithm:
1. Split input recipe by " " (space).
2. Run a for loop for every word split
3. If a word is a number...
4. ..Check what is the next word...
5. ..If the word that follows a number is a known measurement (using the function that you already made)...
6. ..Go back to the number and convert it to ML...
7. ..And change the word after number to ML.

## Future- refactor using enum

TBD