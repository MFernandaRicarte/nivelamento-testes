CREATE TABLE operadoras_ativas (
    registro_ans INTEGER PRIMARY KEY,
    cnpj VARCHAR(20),
    razao_social TEXT,
    nome_fantasia TEXT,
    modalidade TEXT,
    logradouro TEXT,
    numero TEXT,
    complemento TEXT,
    bairro TEXT,
    cidade TEXT,
    uf VARCHAR(2),
    cep VARCHAR(10),
    ddd VARCHAR(3),
    telefone VARCHAR(20),
    fax VARCHAR(20),
    endereco_eletronico TEXT,
    representante TEXT,
    cargo_representante TEXT,
    regiao_de_comercializacao TEXT,
    data_registro_ans DATE
);

CREATE TABLE demonstracoes_contabeis (
    data DATE,
    reg_ans INTEGER,
    cd_conta_contabil TEXT,
    descricao TEXT,
    vl_saldo_inicial NUMERIC,
    vl_saldo_final NUMERIC
);
