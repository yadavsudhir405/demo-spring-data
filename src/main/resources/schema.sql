CREATE TABLE IF NOT EXISTS Customer (
    customer_id INTEGER IDENTITY PRIMARY KEY,
    name VARCHAR(100),
    age INTEGER not null
    );


CREATE TABLE  IF NOT EXISTS Address (
    customer_id INTEGER,
    city VARCHAR(100)
);

ALTER TABLE Address ADD CONSTRAINT FK_ADDRESS_CUSTOMER FOREIGN KEY (customer_id) REFERENCES Customer (customer_id)