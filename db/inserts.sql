
insert into usuario (email, nome, senha)
values ('admin@gmail.com.br', 'admin',
'$2a$10$VrIbJURwINOR5HOrWFFTNOwSILsioRJSuOGAg8Luvr9qZDSOl5JXG');

INSERT INTO permissao (funcao, usuario_id) VALUES ('ADMIN', 1);
INSERT INTO permissao (funcao, usuario_id) VALUES ('USUARIO', 1);

INSERT INTO campanha (titulo, imagem_fundo, imagem_icone, usuario_id)
VALUES ('A Guilda de Orion', 'Guilda de Orion Fundo.png', 'Guilda de Orion Icone.png', 1);