INSERT INTO destination (id, name, country, region, climate, bestSeason, avgBudget, tags)
VALUES
  (1, 'Cancun', 'Mexico', 'Yucatan', 'tropical', 'winter', 1500, 'beach'),
  (2, 'Paris', 'France', 'Europe', 'mild', 'spring', 2000, 'romantic');

INSERT INTO packages (id, title, description, base_price, discountPercent, destination_id)
VALUES
  (1, 'Cancun Trip', '5 nights all-inclusive', 1200, 10, 1),
  (2, 'Paris Weekend', '3 nights in the city', 900, 5, 2);
