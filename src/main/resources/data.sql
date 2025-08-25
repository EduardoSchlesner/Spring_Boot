INSERT INTO USUARIO(nome, email, senha) VALUES('Aluno', 'aluno@email.com', '123456');

INSERT INTO CURSO(nome, categoria) VALUES('Spring Boot', 'Programação');
INSERT INTO CURSO(nome, categoria) VALUES('HTML 5', 'Front-end');

INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida', 'Erro ao criar projeto', '2025-07-02 15:32:43', 'Aguardando', 'Clécio', 'Ecomp');
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 2', 'Projeto não compila', '2025-07-001 17:52:43', 'Aguardando', 'Cleber', 'SI');
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 3', 'Tag HTML', '2024-12-07 08:12:43', 'Respondida', 'Afonso', 'Redes');