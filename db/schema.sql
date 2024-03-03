DROP TABLE IF EXISTS permissao CASCADE;
DROP TABLE IF EXISTS conteudo_campanha CASCADE;
DROP TABLE IF EXISTS campanha CASCADE;
DROP TABLE IF EXISTS secao CASCADE;
DROP TABLE IF EXISTS conteudo CASCADE;
DROP TABLE IF EXISTS biblioteca CASCADE;
DROP TABLE IF EXISTS usuario CASCADE;

CREATE TABLE usuario (
	id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL UNIQUE,
	email VARCHAR(255) NOT NULL UNIQUE,
	senha VARCHAR(128) NOT NULL,
	ativo BOOLEAN NOT NULL DEFAULT(true)
);

CREATE TABLE permissao (
	id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	funcao VARCHAR(100) NOT NULL,
	usuario_id BIGINT NOT NULL,
    CONSTRAINT fk_permissao_usuario FOREIGN KEY(usuario_id) REFERENCES usuario(id),
    CONSTRAINT uk_permissao UNIQUE(funcao,usuario_id)
);

CREATE TABLE biblioteca (
	id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	ativo BOOLEAN NOT NULL DEFAULT(true),
    titulo VARCHAR(128) NOT NULL
);

CREATE TABLE conteudo (
	id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    titulo VARCHAR(128) NOT NULL,
	biblioteca_id BIGINT NOT NULL,
    categoria VARCHAR(128) NOT NULL,
	ativo BOOLEAN NOT NULL DEFAULT(true),
    CONSTRAINT fk_conteudo_biblioteca FOREIGN KEY (biblioteca_id) REFERENCES biblioteca(id)
);

CREATE TABLE imagem (
	id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    nome VARCHAR(800) NOT NULL DEFAULT(""),
	conteudo_id BIGINT NOT NULL,
    CONSTRAINT fk_imagem_conteudo FOREIGN KEY (conteudo_id) REFERENCES conteudo(id)
);

CREATE TABLE secao (
	id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    titulo VARCHAR(128) NOT NULL,
    descricao VARCHAR(2500) NOT NULL,
	conteudo_id BIGINT NOT NULL,
	ativo BOOLEAN NOT NULL DEFAULT(true),
    CONSTRAINT fk_secao_conteudo FOREIGN KEY (conteudo_id) REFERENCES conteudo(id)
);

CREATE TABLE campanha (
	id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL
);

CREATE TABLE conteudo_campanha (
	id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	conteudo_id BIGINT NOT NULL,
	campanha_id BIGINT NOT NULL,
	ativo BOOLEAN NOT NULL DEFAULT(true),
    CONSTRAINT uk_conteudo_campanha UNIQUE (conteudo_id, campanha_id),
    CONSTRAINT fk_conteudo_campanha_conteudo FOREIGN KEY (conteudo_id) REFERENCES conteudo(id),
	CONSTRAINT fk_conteudo_campanha_campanha FOREIGN KEY (campanha_id) REFERENCES campanha(id)
);
