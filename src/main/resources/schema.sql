CREATE TABLE IF NOT EXISTS Customer (
    id INTEGER IDENTITY PRIMARY KEY,
    name VARCHAR(100),
    age INTEGER not null
    );


CREATE TABLE  IF NOT EXISTS Address (
    customer INTEGER,
    customer_key VARCHAR(100),
    city VARCHAR(100),
    PRIMARY KEY(customer, customer_key)
);

ALTER TABLE Address ADD CONSTRAINT FK_ADDRESS_CUSTOMER FOREIGN KEY (customer) REFERENCES Customer (ID)