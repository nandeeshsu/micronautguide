CREATE TABLE IF NOT EXISTS book (
   id BIGINT NOT NULL UNIQUE PRIMARY KEY,
   name VARCHAR(255) NOT NULL UNIQUE
);