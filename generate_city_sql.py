import csv

STATE_TABLE = """
CREATE TABLE states (
  state_id INT PRIMARY KEY,
  state_name VARCHAR(100) NOT NULL
);
"""

CITY_TABLE = """
CREATE TABLE cities (
  city_id INT PRIMARY KEY,
  city_name VARCHAR(100) NOT NULL,
  state_id INT NOT NULL,
  type VARCHAR(50),
  population INT,
  population_class VARCHAR(20),
  FOREIGN KEY (state_id) REFERENCES states(state_id)
);
"""

state_name_to_id = {
    'Andhra Pradesh': 1,
    'Arunachal Pradesh': 2,
    'Assam': 3,
    'Bihar': 4,
    'Chhattisgarh': 5,
    'Goa': 6,
    'Gujarat': 7,
    'Haryana': 8,
    'Himachal Pradesh': 9,
    'Jharkhand': 10,
    'Karnataka': 11,
    'Kerala': 12,
    'Madhya Pradesh': 13,
    'Maharashtra': 14,
    'Manipur': 15,
    'Meghalaya': 16,
    'Mizoram': 17,
    'Nagaland': 18,
    'Odisha': 19,
    'Punjab': 20,
    'Rajasthan': 21,
    'Sikkim': 22,
    'Tamil Nadu': 23,
    'Telangana': 24,
    'Tripura': 25,
    'Uttar Pradesh': 26,
    'Uttarakhand': 27,
    'West Bengal': 28,
    'Delhi': 29,
    'Chandigarh': 30,
    'Jammu and Kashmir': 31,
    'Ladakh': 32,
    'Puducherry': 33,
    'Andaman and Nicobar Islands': 34,
    'Dadra and Nagar Haveli and Daman and Diu': 35,
    'Lakshadweep': 36
}

def generate_sql(csv_path, output_path):
    cities_sql = []
    state_inserts = []

    # Generate INSERTs for states
    for name, sid in state_name_to_id.items():
        state_inserts.append(
            f"INSERT INTO states (id,name) VALUES ({id},'{name}');"
        )

    with open(csv_path, 'r', encoding='utf-8') as f:
        reader = csv.DictReader(f)
        for row in reader:
            try:
                city_name = row['city_name'].replace("'", "''").strip()
                state_name = row['state_name'].strip()
                state_id = state_name_to_id.get(state_name)

                if not state_id:
                    print(f"⚠️ Skipping city '{city_name}' due to unknown state: '{state_name}'")
                    continue

                type_ = row.get('type', '').replace("'", "''").strip()
                raw_pop = row.get('population', '0').replace(',', '').strip()
                population = int(raw_pop) if raw_pop.isdigit() else 0
                pop_class = row.get('population_class', '').replace("'", "''").strip()

                cities_sql.append(
                    f"INSERT INTO cities ( name, state_name ,state_id, type, population, population_class) VALUES "
                    f"( '{city_name}', '{state_name}', {state_id}, '{type_}', {population}, '{pop_class}');"
                )
            except Exception as e:
                print(f"❌ Error processing row: {row}\n{e}")

    with open(output_path, 'w', encoding='utf-8') as out:
        out.write(STATE_TABLE + '\n')
        out.write(CITY_TABLE + '\n\n')
        out.write('\n'.join(state_inserts) + '\n\n')
        out.write('\n'.join(cities_sql))

    print(f"✅ SQL script generated: {output_path}")

# Example usage
generate_sql('cities.csv', 'insert_cities.sql')
