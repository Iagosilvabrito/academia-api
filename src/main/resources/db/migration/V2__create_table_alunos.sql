CREATE TABLE aluno (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    telefone VARCHAR(20),
    users_id INTEGER NOT NULL UNIQUE,
    FOREIGN KEY (users_id) REFERENCES users(id)
);