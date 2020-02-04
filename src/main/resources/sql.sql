/** Agência **/
CREATE TABLE agencia(
	id bigserial NOT NULL UNIQUE,
	nome varchar(300) NOT NULL,
	apelido varchar(100),
	endereco varchar(300),
	CONSTRAINT PK_agencia PRIMARY KEY (id)
);

/** Cliente **/
CREATE TABLE cliente(
	id bigserial NOT NULL UNIQUE,
	nome varchar(300) NOT NULL,
	cpf varchar(20) NOT NULL,
	endereco varchar(300),
	telefone varchar(20),
	id_agencia bigserial NOT NULL,
	id_conta bigserial NOT NULL,
	CONSTRAINT PK_cliente PRIMARY KEY (id),
    CONSTRAINT FK_cliente_agencia FOREIGN KEY (id_agencia) REFERENCES agencia(id)
);

/** Conta **/
CREATE TABLE conta(
	id bigserial NOT NULL UNIQUE,
	tipo_conta bigint NOT NULL,
	valor decimal(300),
	id_cliente bigserial NOT NULL,
	CONSTRAINT PK_conta PRIMARY KEY (id),
    CONSTRAINT FK_conta_cliente FOREIGN KEY (id_cliente) REFERENCES cliente(id)
);

Alter table cliente add foreign key (id_conta) references conta (id);

/** Deposito **/
CREATE TABLE deposito(
	id bigserial NOT NULL UNIQUE,
	valor decimal(300),
	data_deposito timestamptz,
	id_conta bigserial NOT NULL,
	CONSTRAINT PK_deposito PRIMARY KEY (id),
    CONSTRAINT FK_deposito_conta FOREIGN KEY (id_conta) REFERENCES conta(id)
);

/** Saque **/
CREATE TABLE saque(
	id bigserial NOT NULL UNIQUE,
	valor decimal(300),
	data_saque timestamptz,
	id_conta bigserial NOT NULL,
	CONSTRAINT PK_saque PRIMARY KEY (id),
    CONSTRAINT FK_saque_conta FOREIGN KEY (id_conta) REFERENCES conta(id)
);
   
/** Transferencia **/
CREATE TABLE transferencia(
	id bigserial NOT NULL UNIQUE,
	valor decimal(300),
	data_transferencia timestamptz,
	id_conta bigserial NOT NULL,
	CONSTRAINT PK_transferencia PRIMARY KEY (id),
    CONSTRAINT FK_transferencia_conta FOREIGN KEY (id_conta) REFERENCES conta(id)
);