INSERT INTO user (id, created_at, updated_at, email, username)
SELECT 1, '2023-01-01 00:00:00', '2013-01-01 00:00:00', 'ogu@platypus.com', 'ogu'
WHERE NOT EXISTS (SELECT * FROM user WHERE id = 1);

INSERT INTO product (id, created_at, updated_at, description, name, price, stock)
SELECT 1, '2023-01-01 00:00:00', '2013-01-01 00:00:00', 'Ogu Platypus', 'Ogu T', 50000, 59
WHERE NOT EXISTS (SELECT * FROM product WHERE id = 1);