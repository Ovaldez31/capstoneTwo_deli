# capstoneTwo_deli

## Object-Oriented Programming (OOP) Pillars

Our application is built upon the four fundamental pillars of Object-Oriented Programming: Encapsulation, Abstraction, Inheritance, and Polymorphism.

### 1. Encapsulation

* **Concept:** Encapsulation is the practice of bundling data (fields) and the methods that operate on that data within a single unit (a class). It also involves restricting direct access to an object's internal state, exposing only what is necessary through public methods (getters/setters).

![image](https://github.com/user-attachments/assets/dc528380-2f17-4524-83a7-d14ddddbd1be)

* **Implementation in DELI-cious:**
    * **`Sandwich` Class:** All attributes of a sandwich, such as `currentSandwichBreadType`, `currentSandwichMeat`, `currentSandwichToasted`, `regularToppings`, `sauces`, and various price components (e.g., `breadPrice`, `meatPrice`), are declared as `private final` fields. This ensures that the internal state of a `Sandwich` object can only be accessed or modified through its public methods (e.g., getters), maintaining data integrity.
    * **`Chip` and `Drink` Classes:** Similarly, `Chip` has `private final String flavor` and `private final double price`, and `Drink` has `private final String size`, `private final String flavor`, and `private final double price`. These are encapsulated within their respective classes.


### 2. Inheritance

* **Concept:** Inheritance allows a new class (subclass/child class) to derive properties (fields) and behaviors (methods) from an existing class (superclass/parent class). This promotes code reusability and establishes an "is-a" relationship between classes.
* **Implementation in DELI-cious:**
    * **`Sandwich` as a Base Class:** The `Sandwich` class is implemented as a concrete class that directly implements the `Product` interface. This concrete `Sandwich` class serves as the base class for all sandwich types.
    * **Signature Sandwich Classes (Conceptual):** As per project requirements, more specific sandwich types. These signature sandwiches inherit all the common characteristics and methods of a general `Sandwich` and can then override or add their own specific features or default ingredients.

### 3. Polymorphism

* **Concept:** Polymorphism, meaning "many forms," allows objects of different classes to be treated as objects of a common superclass or interface type. This enables a single method call to behave differently based on the actual type of the object it's invoked on at runtime.
* **Implementation in DELI-cious:**
    * **`Order` Class and `List<Product>`:** The `Order` class maintains a single `List<Product>` to store all items in a customer's order. This list can hold `Sandwich`, `Chip`, and `Drink` objects interchangeably because they all `implement` the `Product` interface.
    * **Dynamic Method Dispatch:** When the `Order.getTotalPrice()` method is called, it iterates through this `List<Product>`. For each `Product` in the list, it calls `product.calcPrice()`. Even though the method call is generic (`product.calcPrice()`), the *correct* `calcPrice()` implementation (from `Sandwich`, `Chip`, or `Drink`) is automatically executed at runtime, demonstrating polymorphism. The same principle applies to `getReceiptDescription()`.

## Enumerations (Enums)

Enums provide a type-safe and highly readable way to represent a finite collection of related constants. Instead of relying on error-prone strings or arbitrary numbers, enums ensure that only predefined, valid options can be used, catching errors at compile time rather than runtime. They also allow associating data and behavior directly with each constant, promoting strong encapsulation.

**Enums Implemented in DELI-cious:**

![image](https://github.com/user-attachments/assets/e61f8eb2-bd39-410c-8534-68970fc538e0)

By leveraging these enums, the DELI-cious application not only meets its functional requirements but also demonstrates a robust and error-resistant design for managing user choices and product configurations.
