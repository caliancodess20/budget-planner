import json
import os

DATA_FILE = 'budget_data.json'

def load_data():
    if os.path.exists(DATA_FILE):
        with open(DATA_FILE, 'r') as f:
            return json.load(f)
    return {'budgets': {}, 'expenses': {}, 'savings': []}

def save_data(data):
    with open(DATA_FILE, 'w') as f:
        json.dump(data, f, indent=4)
    print('Data saved!')

def check_alert(category, limit, spent):
    percentage = (spent / limit) * 100
    if spent > limit:
        print('ALERT: You are over budget in', category, '!')
    elif percentage >= 80:
        print('WARNING: You have used', round(percentage), '% of your', category, 'budget!')

def add_category(data):
    category = input('Enter category name: ').strip().title()
    if category in data['budgets']:
        print('Category already exists.')
        return
    limit = float(input('Enter budget limit in Rs: '))
    data['budgets'][category] = limit
    data['expenses'][category] = []
    save_data(data)
    print('Category added!')

def log_expense(data):
    if not data['budgets']:
        print('No categories found.')
        return
    print('Available categories:', ', '.join(data['budgets'].keys()))
    category = input('Enter category name: ').strip().title()
    if category not in data['budgets']:
        print('Category not found.')
        return
    amount = float(input('Enter expense amount in Rs: '))
    description = input('Enter description: ').strip()
    data['expenses'][category].append({'amount': amount, 'description': description})
    save_data(data)
    print('Expense logged!')
    spent = sum(e['amount'] for e in data['expenses'][category])
    limit = data['budgets'][category]
    check_alert(category, limit, spent)

def view_budget(data):
    if not data['budgets']:
        print('No categories found.')
        return
    print('================================')
    print('        BUDGET SUMMARY')
    print('================================')
    for category, limit in data['budgets'].items():
        spent = sum(e['amount'] for e in data['expenses'].get(category, []))
        remaining = limit - spent
        percentage = round((spent / limit) * 100)
        print('Category  :', category)
        print('Budget    : Rs', limit)
        print('Spent     : Rs', spent)
        print('Remaining : Rs', remaining)
        print('Used      :', percentage, '%')
        if spent > limit:
            print('ALERT     : Over budget!')
        elif percentage >= 80:
            print('WARNING   : Almost at limit!')
        print('--------------------------------')

def track_savings(data):
    if not data['budgets']:
        print('No categories found.')
        return
    total_budget = sum(data['budgets'].values())
    total_spent = sum(
        sum(e['amount'] for e in data['expenses'].get(cat, []))
        for cat in data['budgets']
    )
    total_saved = total_budget - total_spent
    print('================================')
    print('        SAVINGS SUMMARY')
    print('================================')
    print('Total Budget : Rs', total_budget)
    print('Total Spent  : Rs', total_spent)
    print('Total Saved  : Rs', total_saved)
    print('--------------------------------')
    if total_saved > 0:
        print('Great job! You saved Rs', total_saved, 'this month!')
    elif total_saved == 0:
        print('You spent exactly your budget!')
    else:
        print('You overspent by Rs', abs(total_saved), 'this month!')
    month = input('Save this record? (yes/no): ').strip().lower()
    if month == 'yes':
        record = input('Enter month name (e.g. January): ').strip()
        data['savings'].append({
            'month': record,
            'budget': total_budget,
            'spent': total_spent,
            'saved': total_saved
        })
        save_data(data)
        print('Savings record saved!')

def view_savings_history(data):
    if not data['savings']:
        print('No savings records found.')
        return
    print('================================')
    print('       SAVINGS HISTORY')
    print('================================')
    for record in data['savings']:
        print('Month  :', record['month'])
        print('Budget : Rs', record['budget'])
        print('Spent  : Rs', record['spent'])
        print('Saved  : Rs', record['saved'])
        print('--------------------------------')

def main():
    print('Welcome to Budget Planner!')
    data = load_data()
    if 'savings' not in data:
        data['savings'] = []
    while True:
        print('')
        print('1. Add category')
        print('2. Log expense')
        print('3. View budget summary')
        print('4. Track savings')
        print('5. View savings history')
        print('6. Exit')
        choice = input('Enter choice: ')
        if choice == '1':
            add_category(data)
        elif choice == '2':
            log_expense(data)
        elif choice == '3':
            view_budget(data)
        elif choice == '4':
            track_savings(data)
        elif choice == '5':
            view_savings_history(data)
        elif choice == '6':
            print('Goodbye! Keep saving!')
            break
        else:
            print('Invalid choice. Please enter 1 to 6.')

if __name__ == '__main__':
    main()
