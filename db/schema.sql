DROP TABLE IF EXISTS permissao CASCADE;
DROP TABLE IF EXISTS usuario_campanha CASCADE;
DROP TABLE IF EXISTS secao CASCADE;
DROP TABLE IF EXISTS imagem CASCADE;
DROP TABLE IF EXISTS conteudo CASCADE;
DROP TABLE IF EXISTS categoria CASCADE;
DROP TABLE IF EXISTS campanha CASCADE;
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

CREATE TABLE campanha (
	id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    imagem_fundo VARCHAR(800) NOT NULL,
	usuario_id BIGINT NOT NULL,
    imagem_icone VARCHAR(800) NOT NULL,
	ativo BOOLEAN NOT NULL DEFAULT(true)
);

CREATE TABLE usuario_campanha (
	id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	usuario_id BIGINT NOT NULL,
	campanha_id BIGINT NOT NULL,
    cargo VARCHAR(24) NOT NULL,
	ativo BOOLEAN NOT NULL DEFAULT(true),
    CONSTRAINT uk_usuario_campanha UNIQUE(usuario_id, campanha_id),
    CONSTRAINT ck_usuario_campanha CHECK (cargo IN('MESTRE','JOGADOR', 'ESPECTADOR')),
    CONSTRAINT fk_usuario_campanha_usuario FOREIGN KEY (usuario_id) REFERENCES usuario(id),
    CONSTRAINT fk_usuario_campanha_campanha FOREIGN KEY (campanha_id) REFERENCES campanha(id)
);

CREATE TABLE categoria (
	id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    nome VARCHAR(128) NOT NULL,
	campanha_id BIGINT NOT NULL,
	ativo BOOLEAN NOT NULL DEFAULT(true),
    CONSTRAINT fk_categoria_campanha FOREIGN KEY (campanha_id) REFERENCES campanha(id)
);

CREATE TABLE conteudo (
	id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    titulo VARCHAR(128) NOT NULL,
	campanha_id BIGINT NOT NULL,
	categoria_id BIGINT NOT NULL,
	ativo BOOLEAN NOT NULL DEFAULT(true),
    CONSTRAINT fk_conteudo_categoria FOREIGN KEY (categoria_id) REFERENCES categoria(id),
    CONSTRAINT fk_conteudo_campanha FOREIGN KEY (campanha_id) REFERENCES campanha(id)
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