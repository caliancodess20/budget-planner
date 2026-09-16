# Storage / Schema Design

This project stores data in a flat text file (`data/budget.txt`) rather than a
relational database, so a traditional ER diagram does not apply. The file format
is documented here instead, serving the same purpose: a clear record of how data
is structured and persisted.

## File: `data/budget.txt`
One transaction per line, comma-separated. The first field is a type tag that
determines how the rest of the line is parsed.

| Type | Format | Example |
|------|--------|---------|
| Income | `INCOME,<description>,<amount>` | `INCOME,Scholarship,5000.0` |
| Expense | `EXPENSE,<description>,<amount>,<category>` | `EXPENSE,Groceries,500.0,FOOD` |

`category` is always one of the fixed `Category` enum values (`FOOD`, `TRAVEL`,
`EDUCATION`, `SHOPPING`, `BILLS`, `ENTERTAINMENT`, `HEALTH`, `OTHER`).

## Known constraint
Since commas are used as the field delimiter, a transaction description containing
a comma would break parsing on load. This is a documented limitation rather than
a bug — see the Limitations section of the project report.
