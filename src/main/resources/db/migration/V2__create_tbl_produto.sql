create table tbl_produto (
        preco_unitario float(53) not null,
        unidade_de_medida tinyint check (unidade_de_medida between 0 and 4),
        id bigint not null auto_increment,
        nome varchar(255),
        primary key (id)
    ) engine=InnoDB