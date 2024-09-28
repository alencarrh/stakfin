Estou montando um aplicativo de controle de investimentos. A ideia é bem simples, somente cadastrar ativos (quantidade, valor, etc) e uma carteira esperada, para, no final, apresentar qual a composição atual e como ela se compara com a carteira esperada.

Preciso de ajuda para modelar as tabelas de banco de dados, o que eu tenho até o momento é o seguinte:

Premissas:
  - renda fixa somente será comprada uma única vez, toda nova compra é um novo ativo.
  - renda fixa pode ser vendida N vezes, até zerar a posição.
  - renda variavel pode ter várias compras, a posição é a soma de todas as compras.
  - renda variavel pode ser vendida N vezes, a posição é a soma de todas as vendas.
  - PM da renda fixa nunca se altera.
  - PM da renda variável sempre é recalculado após cada nova compra.
  - renda variável 


transacao
 - id
 - usuario
 - acao // COMPRA ou VENDA
 - tipo // RENDA_FIXA ou RENDA_VARIAVEL - ou outros futuramente
 - quantidade
 - valor_unitário
 - ativo_id // não é um FK porque pode referenciar a tabela de RENDA_FIXA ou RENDA_VARIAVEL
 - data_transacao
 - created_at


ativo_rendafixa //sempre representa a posição atual (recalculada após qualquer nova transação)
 - id
 - usuario
 - emissor
 - taxa_aa  //taxa anual em long 10,00% = 1000
 - tipo // CDB, LCI, LCA, etc
 - indexador // PRE, POS, IPCA, CDI
 - data_compra //data da primeira compra
 - data_vencimento //data de vencimento do ativo
 - data_venda // data da última venda (ou vencimento do ativo se não vendido)
 - quantidade_compra
 - valor_compra //valor representado em long 100,00 = 10000
 - quantidade_total_venda
 - valor_total_venda //valor representado em long 100,00 = 10000
 - pm  //valor representado em long 100,00 = 10000

ativo_rendavariavel
 - id
 - usuario
 - ticket //código da ação na bolsa - PETR4, VALE5, etc - FK para tabela de TICKER
 - data_compra //data da primeira compra
 - data_venda // data da última venda
 - taxa_total_compra
 - taxa_total_venda
 - quantidade_total_compra
 - quantidade_total_venda
 - valor_total_compra //valor representado em long 100,00 = 10000
 - valor_total_venda //valor representado em long 100,00 = 10000
 - pm  //valor representado em long 100,00 = 10000


ticker
  - id // String PETR4, VALE5, etc
  - nome // PETROBRAS, VALE, etc
  - setor // PETROLEO, MINERACAO, etc
  - segmento // EXPLORACAO, PRODUCAO, etc
  - ultimo_valor
  - data_ultimo_valor // somente data
  - update_at // datetime
  - created_at // datetime

ticker_history
  - id // String PETR4, VALE5, etc
  - data
  - valor




Resposta Gemini

-- Criação das tabelas

CREATE TABLE transacao (
    id SERIAL PRIMARY KEY,
    usuario INT,
    ativo_id INT,
    acao ENUM('COMPRA', 'VENDA', 'DIVIDENDO', 'JUROS'),
    tipo ENUM('RENDA_FIXA', 'RENDA_VARIAVEL'),
    quantidade INT,
    valor_unitario bigint,
    data_transacao DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE ativo_rendafixa (
    id SERIAL PRIMARY KEY,
    usuario INT,
    emissor VARCHAR(100),
    taxa_aa long,
    tipo ENUM('CDB', 'LCI', 'LCA'),
    indexador ENUM('PRE', 'POS', 'IPCA', 'CDI'),
    data_compra DATE,
    data_vencimento DATE,
    data_venda DATE,
    status ENUM('ATIVO', 'VENDIDO', 'VENCIDO'),
    quantidade_compra INT,
    valor_compra bigint,
    quantidade_total_venda INT,
    valor_total_venda bigint
);

CREATE TABLE ativo_rendavariavel (
    id SERIAL PRIMARY KEY,
    usuario INT,
    ticker VARCHAR(10),
    data_compra DATE,
    data_venda DATE,
    taxa_total_compra bigint,
    taxa_total_venda bigint,
    status ENUM('ATIVO', 'VENDIDO'),
    quantidade_total_compra INT,
    quantidade_total_venda INT,
    valor_total_compra bigint,
    valor_total_venda bigint,
    pm bigint

    FOREIGN KEY (ticker) REFERENCES ticker(id)
);

CREATE TABLE ticker (
    id VARCHAR(10) PRIMARY KEY,
    nome VARCHAR(100),
    setor VARCHAR(50),
    segmento VARCHAR(50),
    ultimo_valor bigint,
    data_ultimo_valor DATE,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE ticker_history (
    ticker VARCHAR(10),
    data DATE,
    valor bigint,
    PRIMARY KEY (ticker, data),
    FOREIGN KEY (ticker) REFERENCES ticker(id)
);