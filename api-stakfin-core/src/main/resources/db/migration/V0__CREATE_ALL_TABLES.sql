--acao_transacao       = ENUM('COMPRA', 'VENDA', 'DIVIDENDO', 'JUROS');
--tipo_transacao       = ENUM('RENDA_FIXA', 'RENDA_VARIAVEL');
--tipo_rendafixa       = ENUM('CDB', 'LCI', 'LCA');
--indexador_rendafixa  = ENUM('PRE', 'POS', 'IPCA', 'CDI');
--status_rendaixa      = ENUM('ATIVO', 'VENDIDO', 'VENCIDO');
--status_rendavariavel = ENUM('ATIVO', 'VENDIDO');

create table usuario
(
    id    bigserial primary key,
    email varchar(255) not null UNIQUE,
    nome  varchar(100) not null
);

CREATE TABLE ticker
(
    id                VARCHAR(10) PRIMARY KEY,
    nome              VARCHAR(100),
    setor             VARCHAR(50),
    segmento          VARCHAR(50),
    ultimo_valor      bigint,
    data_ultimo_valor DATE,
    updated_at        TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE ticker_history
(
    ticker VARCHAR(10),
    data   DATE,
    valor  bigint,
    PRIMARY KEY (ticker, data),
    FOREIGN KEY (ticker) REFERENCES ticker (id)
);

CREATE TABLE transacao
(
    id              bigserial PRIMARY KEY,
    usuario_id      bigint,
    ativo_id        bigint,
    acao            varchar(50),
    tipo            varchar(50),
    quantidade      INT,
    valor_unitario  bigint,
    data_transacao  DATE,
    idempotence_key varchar(255) UNIQUE,
    created_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (usuario_id) REFERENCES usuario (id)
);

CREATE TABLE ativo_rendafixa
(
    id                     bigserial PRIMARY KEY,
    usuario_id             bigint,
    emissor                VARCHAR(100),
    taxa_aa                bigint,
    tipo                   varchar(50),
    indexador              varchar(50),
    data_compra            DATE,
    data_vencimento        DATE,
    data_venda             DATE,
    status                 varchar(50),
    quantidade_compra      INT,
    valor_compra           bigint,
    quantidade_total_venda INT,
    valor_total_venda      bigint,
    idempotence_key        varchar(255) UNIQUE,
    created_at             TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (usuario_id) REFERENCES usuario (id)
);

CREATE TABLE ativo_rendavariavel
(
    id                      bigserial PRIMARY KEY,
    usuario_id              bigint,
    ticker                  VARCHAR(10),
    taxa_total_compra       bigint,
    taxa_total_venda        bigint,
    status                  varchar(50),
    quantidade_total_compra INT,
    quantidade_total_venda  INT,
    valor_total_compra      bigint,
    valor_total_venda       bigint,
    pm                      bigint,
    idempotence_key         varchar(255) UNIQUE,
    created_at              TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (ticker) REFERENCES ticker (id),
    FOREIGN KEY (usuario_id) REFERENCES usuario (id)
);


