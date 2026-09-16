# System Architecture

Budget Planner is a single-process command-line application. `Main` drives the menu
loop and delegates all real work to a small set of supporting classes, each with one
clear responsibility.

```mermaid
graph TD
    Main["Main<br/>(CLI menu loop)"] --> BP["BudgetPlanner<br/>(holds ArrayList&lt;Transaction&gt;,<br/>add/view/search/delete)"]
    Main --> FM["FileManager<br/>(save/load data/budget.txt)"]
    Main --> BC["BudgetCalculator<br/>(totals income/expense/balance)"]
    Main --> AT["BudgetAlertThread<br/>(daemon thread, watches budget %)"]

    BP --> T["Transaction<br/>(base class)"]
    T --> INC["Income"]
    T --> EXP["Expense"]
    EXP --> CAT["Category (enum)"]

    Main -.throws/catches.-> IAE["InvalidAmountException"]

    AT -.reads totals via.-> BC
    FM -.reads/writes.-> BP

    DB[("data/budget.txt<br/>(plain text file)")]
    FM --> DB
```

## Layer Responsibilities
- **Main** — the only class that talks to the user (via `Scanner`/`System.out`);
  reads menu choices and calls into the other classes.
- **BudgetPlanner** — the in-memory model of the current session's transactions.
- **Transaction / Income / Expense / Category** — the data model, using inheritance
  to represent two kinds of transaction and an enum to constrain valid categories.
- **BudgetCalculator** — pure calculation logic (totals, balance), kept separate
  from both the menu and the data so it can be reused or tested independently.
- **FileManager** — the only class that touches the file system, isolating the
  storage format from the rest of the application.
- **BudgetAlertThread** — runs independently of the main thread, periodically
  checking spend against the configured limit without blocking the CLI.
- **InvalidAmountException** — a custom checked exception used to reject
  zero/negative amounts at the point of entry.
