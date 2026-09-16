# Use Case Diagram

```mermaid
graph LR
    User((User))
    User --> UC1[Add Income]
    User --> UC2[Add Expense]
    User --> UC3[View All Transactions]
    User --> UC4[View Expenses Only]
    User --> UC5[Search Expense by Keyword]
    User --> UC6[Delete a Transaction]
    User --> UC7[Show Budget Summary]
    User --> UC8[Set Budget Limit]
    User --> UC9[Save Data to File]
    User --> UC10[Load Data from File]
    User --> UC11[Exit]

    UC2 -.->|must choose| UC12[Select Expense Category]
    UC1 -.->|validated by| UC13[Reject Invalid Amount]
    UC2 -.->|validated by| UC13

    Watcher((Background<br/>Alert Thread))
    Watcher --> UC14[Monitor Spend vs Budget Limit]
    UC14 -.->|triggers| UC15[Print Budget Warning]
```

## Actors
- **User** — the person running the CLI; performs all the transaction, budgeting,
  and file operations through the numbered menu.
- **Background Alert Thread** — not a human actor, but a second thread of execution
  that acts autonomously within the system, independent of the user's menu choices.
