# Concept Answers — Pages 8–9

## 1. Inheritance and specialized behavior
Inheritance lets a specialized class reuse common fields and methods from a base class, then override or add behavior where needed. For example, `Employee` can define common data such as name and an abstract `calculateSalary()` method. `FullTimeEmployee` calculates a fixed monthly salary, while `HourlyEmployee` calculates hours multiplied by an hourly rate. Shared employee information is reused, but salary calculation is specialized.

## 2. The “is-a” relationship
An “is-a” relationship means an instance of the derived class is also a valid instance of the base class. For example, a `Car` is a `Vehicle`. This matters because inheritance should represent a genuine subtype relationship; otherwise, code may become tightly coupled and misleading, and substituting one class for another may not make logical sense.

## 3. Method overriding
Method overriding occurs when a subclass provides its own implementation of an inherited instance method with the same signature. For example, a base `Employee` class may define `calculateSalary()`. `SalariedEmployee` returns a fixed salary, while `CommissionEmployee` returns base pay plus sales commission. Calling the method through an `Employee` reference invokes the appropriate subclass implementation at runtime.

## 4. Runtime polymorphism (dynamic dispatch)
Runtime polymorphism means a base-type reference can point to a derived object, and an overridden instance method call is resolved according to the object's actual runtime class. For example, `Vehicle v = new Car(); v.startEngine();` executes `Car`'s overridden `startEngine()` method, not the base implementation.

## 5. Polymorphic collections
A polymorphic collection stores objects of different derived classes using one common base type. For example, `List<Animal> animals = List.of(new Dog(), new Cat());` can be traversed with one loop calling `makeSound()` on each animal. Each object runs its own implementation, which simplifies processing and reduces repeated type checks.

## 6. Polymorphism versus type-based conditionals
With repeated `if/else` or `switch` checks, central code must know every concrete type and must be edited whenever a new type is introduced. With polymorphism, each subtype implements the shared operation, and the common loop simply calls that operation. This reduces coupling, keeps responsibilities in the appropriate classes, and makes extension easier.

## 7. Adding a new derived type with minimal changes
A base class defines the common contract, while each derived class implements specialized behavior. In a payment system, `Payment` can declare `calculateFee()`, implemented by `CardPayment` and `BankTransferPayment`. Adding `WalletPayment` requires creating the new subtype, but the processor can keep iterating through `Payment` references and calling `calculateFee()` without changing its processing loop.

## 8. Inherited versus overridden behavior
Inherited behavior is a method used from the base class without replacing its implementation; this is appropriate when the shared behavior is correct for the subtype. Overridden behavior is a subclass's replacement implementation for a method; use it when the subtype needs a specialized version. For example, a `Vehicle` may provide a common `displayManufacturer()` method inherited by `Car`, while `Car` overrides `startEngine()` to provide car-specific behavior.

## 9. Why inheritance solely for code reuse can be inappropriate
Inheritance should express a genuine “is-a” relationship, not merely provide access to convenient code. Using it between unrelated classes creates tight coupling, exposes irrelevant methods, makes changes risky, and can violate expectations about what a subtype can do. Composition is often more suitable when one object merely uses or contains another.

## 10. VehicleRental: common and specialized behavior
A common `VehicleRental` base class can hold shared data such as customer name, rental duration, and base-rate calculation. `CarRental` and `TruckRental` can inherit the shared booking and billing behavior while specializing their calculations—for example, a car may add a per-day rate, while a truck may add a load-capacity charge. A common collection of `VehicleRental` references can then be processed uniformly, with each subtype calculating its own final cost.
