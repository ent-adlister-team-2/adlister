USE tasklister_db;

DROP TABLE IF EXISTS tasks;
DROP TABLE IF EXISTS household;

CREATE TABLE household (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    name VARCHAR(150),
    PRIMARY KEY (id)
);

CREATE TABLE tasks (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    status BOOLEAN,
    repeatable BOOLEAN,
    category VARCHAR(100),
    household_id INT UNSIGNED NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (household_id) REFERENCES household(id)
);
