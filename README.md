## Refactoring Report & Findings

Name: Roben Joseph B Tambayong

NPM: 2406453594

### 1. Identified Code Smells
* **Unit Size:** The `processQuestLogic` method was a "God Method" handling business rules, file formatting, and file I/O simultaneously.
* **Complexity (OCP Violation):** The logic relied on a massive `if - else if` block. Adding a new quest type required modifying core service logic.
* **Persistence & DIP Violation:** The service depended directly on concrete Java I/O classes (`FileWriter`) with a hardcoded filename, violating the Dependency Inversion Principle.
* **Controller SRP Violation:** `QuestController` violated the Single Responsibility Principle by performing domain-specific validation.

### 2. Improvements Applied
* **Test-Driven Correction:** Fixed `QuestServiceTest` to expect the correct 1,000 gold payout for Escort quests.
* **Strategy Pattern:** Fixed the OCP violation by creating a `QuestStrategy` interface with concrete classes for each quest type.
* **Repository Pattern:** Fixed the DIP violation by abstracting the file writing behind a `QuestLogger` interface.
* **Dependency Injection:** Configured the tests and controllers to inject the required strategies and loggers.
* **Controller Cleanup:** Stripped business validation out of `QuestController`, delegating all logic to the service layer.