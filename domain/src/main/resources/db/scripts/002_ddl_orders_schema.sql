CREATE TABLE IF NOT EXISTS orders (
    id SERIAL PRIMARY KEY,
    address TEXT NOT NULL,
    amount FLOAT NOT NULL,
    status TEXT,
    created_at TIMESTAMP
);