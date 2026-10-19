# Quiz Answers — Page 7–8

1. **C — Polymorphism.** The common `render()` operation can be called through a base type, and the actual document implementation runs at runtime.
2. **A, B, C.** A Car is a Vehicle, a Rectangle is a Shape, and a DatabaseConnection can be modeled as a NetworkResource. A HelperUtility that contains a Calculator is a “has-a” relationship, not “is-a”.
3. **C — Runtime method dispatch.**
4. **C — Inheritance-based polymorphism.**
5. **A, C, D.** Book extends/overrides behavior; LibraryItem defines common behavior; a DVD can be referenced as a LibraryItem. Option B is not necessarily shared behavior because DVD's fixed loan period is its own implementation.
6. **A, C.** A Dog referred to by an Animal reference executes Dog's overridden method; Dog's method is overridden behavior.
7. **C.** A new WalletPayment can be added without changing the PaymentProcessor iteration logic.
8. **A.** It creates tight coupling and an incorrect “is-a” relationship, making design rigid.
9. **A, C.** Generic sender logic can process different notification types, and new channels can be added with minimal changes.
10. **A, B, C.** Polymorphic collections simplify iteration, allow uniform processing with specialized behavior, and reduce explicit casts.
