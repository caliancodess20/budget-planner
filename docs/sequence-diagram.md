# Sequence Diagram — Adding an Expense &amp; Budget Alert

This traces what actually happens when a user picks "2. Add Expense" from the menu,
and how the independently-running `BudgetAlertThread` reacts afterward.

```mermaid
sequenceDiagram
    actor U as User
    participant M as Main
    participant BP as BudgetPlanner
    participant E as Expense
    participant AT as BudgetAlertThread
    participant BC as BudgetCalculator

    U->>M: Choose "2. Add Expense", enter description/amount/category
    M->>M: Validate amount (throw InvalidAmountException if <= 0)
    M->>E: new Expense(description, amount, category)
    M->>BP: addTransaction(expense)
    BP-->>M: "Transaction added successfully."

    Note over AT: Running independently on its own thread,<br/>woken every 10 seconds
    loop every 10 seconds
        AT->>BP: getTransactions()
        BP-->>AT: ArrayList<Transaction>
        AT->>BC: calculateExpense(transactions)
        BC-->>AT: totalExpense
        AT->>BP: getBudgetLimit()
        BP-->>AT: budgetLimit
        AT->>AT: percentage = totalExpense / budgetLimit * 100
        alt percentage >= 100
            AT->>U: print "*** BUDGET ALERT: exceeded your budget! ***"
        else percentage >= 80
            AT->>U: print "*** BUDGET WARNING: 80% or more used ***"
        end
    end
```
