import csv
from datetime import datetime

def register_entry():
    now = datetime.now()
    date_time = now.strftime("%m/%d/%Y %H:%M:%S")
    with open('/path/to/csv/file.csv', mode='r') as csv_file:
        csv_reader = csv.reader(csv_file)
        fieldnames = ['id', 'entry_time', 'exit_time']
        with open('/path/to/csv/file.csv', mode='a') as csv_file:
            writer = csv.DictWriter(csv_file, fieldnames=fieldnames)
            for row in csv_reader:
                try:
                    id = int(row[0])
                    writer.writerow({'id': id, 'entry_time': date_time, 'exit_time': ''})
                except ValueError:
                    pass

def register_exit():
    now = datetime.now()
    date_time = now.strftime("%m/%d/%Y %H:%M:%S")
    with open('/path/to/csv/file.csv', mode='r') as csv_file:
        csv_reader = csv.reader(csv_file)
        fieldnames = ['id', 'entry_time', 'exit_time']
        rows = []
        for row in csv_reader:
            try:
                id = int(row[0])
                entry_time = row[1]
                exit_time = row[2]
                if exit_time == '':
                    exit_time = date_time
                rows.append({'id': id, 'entry_time': entry_time, 'exit_time': exit_time})
            except ValueError:
                pass
    with open('/path/to/csv/file.csv', mode='w') as csv_file:
        writer = csv.DictWriter(csv_file, fieldnames=fieldnames)
        writer.writeheader()
        for row in rows:
            writer.writerow(row)
