# Problem Statement

## Problem
People often lose track of their income and expenses because there is no quick,
frictionless way to log transactions and see where their money is going. Spreadsheets
get abandoned, and mental tracking is unreliable — by the time overspending in a
category is noticed, it has already happened.

## Scope
Budget Planner is a command-line Java application for recording income and expense
transactions, categorizing expenses, setting a monthly budget limit, and viewing a
running summary of income, expenses, and balance. Data is stored in a local text file
(`data/budget.txt`) rather than a database, and the application is single-user —
it does not support multiple accounts, multiple currencies, or networked access.

## Target Users
Individuals who want a simple, no-setup way to track their personal spending directly
from the command line, without installing a database or a full budgeting application.

## High-Level Features
1. **Transaction management** — add income and expense entries, view all transactions
   or only expenses, search expenses by keyword, and delete a transaction.
2. **Categorization** — every expense is tagged with a fixed category (via the
   `Category` enum), enabling category-level analysis.
3. **Budgeting** — set a maximum spending limit; a background thread (`BudgetAlertThread`)
   continuously monitors spend and warns the user as they approach or exceed it.
4. **Reporting** — view a budget summary showing total income, total expense,
   remaining balance, and percentage of budget used.
5. **Persistence** — save all transactions to a text file and reload them in a
   later session via `FileManager`.
