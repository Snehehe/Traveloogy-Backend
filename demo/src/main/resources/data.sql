INSERT INTO destination (name, country, region, description) VALUES
('Paris', 'France', 'Europe', 'City of lights and romance'),
('Tokyo', 'Japan', 'Asia', 'Modern meets tradition'),
('New York', 'USA', 'North America', 'The Big Apple');

INSERT INTO packages (title, description, base_price, destination_id) VALUES
('Paris Getaway', '4 nights in Paris', 1299.99, 1),
('Tokyo Explorer', '7 days in Tokyo', 1899.50, 2),
('NYC Weekend', '2 nights in New York', 899.00, 3);

INSERT INTO users (email, first_name, last_name, password, role) VALUES
('admin@travel.com', 'Admin', 'User', 'admin123', 'ADMIN'),
('john@example.com', 'John', 'Doe', 'password', 'USER');

INSERT INTO review (comment, rating, travel_package_id, user_id) VALUES
('Amazing trip!', 5, 1, 2),
('Totally worth it', 4, 2, 2);
('Had a great time!', 5, 3, 2);