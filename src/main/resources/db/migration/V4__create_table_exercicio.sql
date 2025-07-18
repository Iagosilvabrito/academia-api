CREATE TABLE exercicio (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    repeticoes INT,
    series INT,
    treino_id BIGINT NOT NULL,
    FOREIGN KEY (treino_id) REFERENCES treino(id)
);