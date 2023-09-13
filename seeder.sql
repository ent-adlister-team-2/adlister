USE tasklister_db;

-- Seed random data into the Households table
INSERT INTO tasklister_db.households (username, email, password)
VALUES
    (SUBSTRING(MD5(RAND()), 1, 10), SUBSTRING(MD5(RAND()), 1, 10), SUBSTRING(MD5(RAND()), 1, 10)),
    (SUBSTRING(MD5(RAND()), 1, 10), SUBSTRING(MD5(RAND()), 1, 10), SUBSTRING(MD5(RAND()), 1, 10)),
    (SUBSTRING(MD5(RAND()), 1, 10), SUBSTRING(MD5(RAND()), 1, 10), SUBSTRING(MD5(RAND()), 1, 10)),
    (SUBSTRING(MD5(RAND()), 1, 10), SUBSTRING(MD5(RAND()), 1, 10), SUBSTRING(MD5(RAND()), 1, 10)),
    (SUBSTRING(MD5(RAND()), 1, 10), SUBSTRING(MD5(RAND()), 1, 10), SUBSTRING(MD5(RAND()), 1, 10)),
    (SUBSTRING(MD5(RAND()), 1, 10), SUBSTRING(MD5(RAND()), 1, 10), SUBSTRING(MD5(RAND()), 1, 10)),
    (SUBSTRING(MD5(RAND()), 1, 10), SUBSTRING(MD5(RAND()), 1, 10), SUBSTRING(MD5(RAND()), 1, 10)),
    (SUBSTRING(MD5(RAND()), 1, 10), SUBSTRING(MD5(RAND()), 1, 10), SUBSTRING(MD5(RAND()), 1, 10)),
    (SUBSTRING(MD5(RAND()), 1, 10), SUBSTRING(MD5(RAND()), 1, 10), SUBSTRING(MD5(RAND()), 1, 10)),
    (SUBSTRING(MD5(RAND()), 1, 10), SUBSTRING(MD5(RAND()), 1, 10), SUBSTRING(MD5(RAND()), 1, 10));

-- Seed random data into the Tasks table
-- Seed random data into the Tasks table with household_id
INSERT INTO Tasks (name, description, household_id)
VALUES
    (SUBSTRING(MD5(RAND()), 1, 10), SUBSTRING(MD5(RAND()), 1, 10), FLOOR(RAND() * 5) + 1), -- Assuming there are 5 households
    (SUBSTRING(MD5(RAND()), 1, 10), SUBSTRING(MD5(RAND()), 1, 10), FLOOR(RAND() * 5) + 1),
    (SUBSTRING(MD5(RAND()), 1, 10), SUBSTRING(MD5(RAND()), 1, 10), FLOOR(RAND() * 5) + 1),
    (SUBSTRING(MD5(RAND()), 1, 10), SUBSTRING(MD5(RAND()), 1, 10), FLOOR(RAND() * 5) + 1),
    (SUBSTRING(MD5(RAND()), 1, 10), SUBSTRING(MD5(RAND()), 1, 10), FLOOR(RAND() * 5) + 1),
    (SUBSTRING(MD5(RAND()), 1, 10), SUBSTRING(MD5(RAND()), 1, 10), FLOOR(RAND() * 5) + 1),
    (SUBSTRING(MD5(RAND()), 1, 10), SUBSTRING(MD5(RAND()), 1, 10), FLOOR(RAND() * 5) + 1),
    (SUBSTRING(MD5(RAND()), 1, 10), SUBSTRING(MD5(RAND()), 1, 10), FLOOR(RAND() * 5) + 1),
    (SUBSTRING(MD5(RAND()), 1, 10), SUBSTRING(MD5(RAND()), 1, 10), FLOOR(RAND() * 5) + 1),
    (SUBSTRING(MD5(RAND()), 1, 10), SUBSTRING(MD5(RAND()), 1, 10), FLOOR(RAND() * 5) + 1);

