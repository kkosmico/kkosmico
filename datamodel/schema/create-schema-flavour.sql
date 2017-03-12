DROP TABLE IF EXISTS flavour.dishes CASCADE;

CREATE TABLE flavour.dishes (
  id uuid NOT NULL,
  name VARCHAR(50) NOT NULL,
  description VARCHAR(255),
  price FLOAT,
  type VARCHAR(50) NOT NULL,
  deleted BOOLEAN DEFAULT false NOT NULL

);

ALTER TABLE flavour.dishes
    ADD CONSTRAINT UQ_dishes_id UNIQUE (id);