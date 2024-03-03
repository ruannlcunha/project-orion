
insert into usuario (email, nome, senha)
values ('admin@gmail.com.br', 'admin',
'$2a$10$VrIbJURwINOR5HOrWFFTNOwSILsioRJSuOGAg8Luvr9qZDSOl5JXG');

INSERT INTO permissao (funcao, usuario_id) VALUES ('ADMIN', 1);
INSERT INTO permissao (funcao, usuario_id) VALUES ('USUARIO', 1);

INSERT INTO biblioteca (titulo) VALUES ('O Legado de Orion');

INSERT INTO campanha (titulo) VALUES ('A Guilda de Orion');
INSERT INTO campanha (titulo) VALUES ('O Segredo de Khaas');
INSERT INTO campanha (titulo) VALUES ('Grande Primavera');
INSERT INTO campanha (titulo) VALUES ('Exterminadores de Circinus');