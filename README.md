# STEP SEM-3 Week 8 — Category C Practice

Solutions are based on `STEP-SEM-3_Week_8_Category_C_Practice.pdf`.

## Coding questions (Java)
1. Payment System Fee Calculation — `src/Problem1PaymentSystemFeeCalculation.java`
2. Library Item Due Date Calculator — `src/Problem2LibraryItemDueDateCalculator.java`
3. Delivery Fee Calculator — `src/Problem3DeliveryFeeCalculator.java`
4. Examination Question Grader — `src/Problem4ExaminationQuestionGrader.java`
5. Public Transport Fare Calculator — `src/Problem5PublicTransportFareCalculator.java`

## Written answers
- `Quiz_Answers.md` — all 10 quiz answers.
- `Concept_Answers.md` — answers to all 10 concept questions.

## Compile and run
Install a Java JDK. From the repository root, compile and run one file at a time. Example:

```bash
javac src/Problem1PaymentSystemFeeCalculation.java
java -cp src Problem1PaymentSystemFeeCalculation
```

Each coding problem is a separate Java program with its own `main` method.

## OOP design
The programs use base classes and subclasses so that each type implements its own calculation. The processing loop calls the shared operation polymorphically.
