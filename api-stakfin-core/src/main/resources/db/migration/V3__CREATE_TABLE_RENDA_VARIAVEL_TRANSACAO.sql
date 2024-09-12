create table transacao_renda_variavel
(
    id             bigserial primary key,
    acao           varchar(10)  not null,
    ticker         varchar(100) not null,
    data           date         not null,
    quantidade     bigint       not null,
    valor_unitario bigint       not null
);

GRANT ALL ON SEQUENCE transacao_renda_variavel_id_seq TO stakfin_user;
