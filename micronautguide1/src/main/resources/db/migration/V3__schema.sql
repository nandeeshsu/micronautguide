CREATE TABLE IF NOT EXISTS book (
   id BIGINT NOT NULL UNIQUE PRIMARY KEY,
   name VARCHAR(255) NOT NULL UNIQUE
);

ALTER TABLE book ADD CONSTRAINT name_unique UNIQUE (name);
ALTER TABLE book ALTER COLUMN name SET NOT NULL;