CREATE TABLE IF NOT EXISTS client (
    id SERIAL PRIMARY KEY,
    nui VARCHAR(255) UNIQUE,
    fullname VARCHAR(255),
    address VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS product (
    id SERIAL PRIMARY KEY,
    description VARCHAR(255),
    brand VARCHAR(255),
    price DECIMAL(10, 2),
    stock INT
    );

CREATE TABLE IF NOT EXISTS invoice (
    id SERIAL PRIMARY KEY,
    code VARCHAR(255) UNIQUE,
    create_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    total DECIMAL(10, 2),
    client_id INT,
    FOREIGN KEY (client_id) REFERENCES client(id)
);

CREATE TABLE IF NOT EXISTS detail (
    id SERIAL PRIMARY KEY,
    quantity INT,
    price DECIMAL(10, 2),
    invoice_id INT,
    product_id INT,
    FOREIGN KEY (invoice_id) REFERENCES invoice(id),
    FOREIGN KEY (product_id) REFERENCES product(id)
);
