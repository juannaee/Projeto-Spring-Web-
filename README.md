
# 🚀 Projeto Spring Web com Spring Boot

Este projeto é uma aplicação web construída com **Spring Boot**, com o objetivo de desenvolver uma API RESTful robusta, limpa e escalável, seguindo boas práticas de arquitetura de software.

---

## 🎯 Objetivos do Projeto

- Aplicar **boas práticas** no desenvolvimento de APIs REST com Java e Spring Boot.
- Estruturar uma aplicação backend moderna, limpa e escalável.
- Demonstrar na prática conceitos como:
  - Arquitetura em camadas.
  - Criação e utilização correta de **DTOs**, incluindo DTOs simplificados para otimizar respostas.
  - Tratamento global de exceções.
  - Segurança com **Spring Security**.
  - Versionamento e deploy contínuo.

---

## 🏗️ Arquitetura e Organização

O projeto segue uma arquitetura em camadas, com os pacotes organizados da seguinte forma:

```
src/main/java/com/SpringWeb/ProjetoSpring
 ┣ config                 → Arquivos de configuração geral e de segurança
 ┣ controllers            → Endpoints da API (antigo resources)
 ┣ dto                    → Objetos de transferência de dados, organizados em subpacotes (user, order)
 ┣ entities               → Entidades que representam as tabelas do banco
 ┣ exceptions             → Tratamento global de exceções
 ┣ repositories           → Acesso e persistência no banco de dados
 ┣ services               → Regra de negócio e operações da aplicação
 ┗ ProjetoSpringApplication.java → Classe principal
```

---

## 🚀 Tecnologias Utilizadas

- ✅ **Spring Boot** — Framework principal
- ✅ **Spring Data JPA** — Persistência de dados
- ✅ **Spring Security** — Segurança da aplicação
- ✅ **Apache Tomcat** — Servidor embutido
- ✅ **Maven** — Gerenciamento de dependências
- ✅ **H2 Database** — Banco em memória para desenvolvimento e testes
- ✅ **MySQL** — Banco relacional usado no desenvolvimento atual (via XAMPP)
- ✅ **PostgreSQL** — Pretendido futuramente para produção
- ✅ **Heroku** — Plataforma para deploy
- ✅ **Postman** — Testes e documentação da API
- ✅ **Java 17+** — Linguagem principal

---

## 🔧 Funcionalidades

- 🔗 **APIs RESTful** completas para manipulação de usuários e pedidos.

> 🚧 Este projeto está em crescimento! Em breve serão adicionados novos recursos como produtos, categorias e muito mais.

- 🔐 **Segurança** com autenticação e proteção dos endpoints.
- 🔄 **DTOs simplificados** para evitar referências circulares e otimizar respostas.
- 🏗️ **Tratamento global de exceções** com mensagens de erro claras e padronizadas.
- 🚀 **Deploy contínuo no Heroku.**
- 🧪 **Testes com Postman.**
- 🌍 **Perfis de ambiente** para desenvolvimento (`dev`), testes (`test`) e produção (`prod`).

---

## 📦 Como Executar Localmente

1. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
```

2. Navegue até a pasta do projeto:
```bash
cd seu-repositorio
```

3. Execute o projeto:
```bash
./mvnw spring-boot:run
```

4. Acesse:
```
http://localhost:8080
```

---

## 🗄️ Banco de Dados


- ✅ **MySQL** no desenvolvimento local (via XAMPP).
- ✅ **PostgreSQL** planejado para uso futuro em produção.

---

## 🌐 Deploy

> 🚧 Ainda não disponivel:
Aplicação disponível no Heroku:  
> 🔗 [Acesse aqui](#)

---

## 📑 Documentação da API

> 🚧 Ainda não disponivel:
Coleção disponível no Postman:  
> 🔗 [Acesse aqui](#)

---

## 🏆 Próximos Passos

- ✅ Implementação de autenticação com JWT.
- ✅ Upload de arquivos.
- ✅ Paginação, ordenação e filtros avançados.
- ✅ Testes unitários e de integração.
- 🚀 Novas entidades como produtos, categorias, etc.
- 🚀 Melhorias na documentação Swagger/OpenAPI.

---

## 🤝 Contribuição

Sinta-se à vontade para abrir issues, propor melhorias ou enviar PRs!  
Vamos evoluir esse projeto juntos.

---

## 💻 Autor

Desenvolvido por **[Juan Guilherme Silva Lemos](https://github.com/juannaee)** — 💙 Vamos conectar no [LinkedIn](https://www.linkedin.com/in/juan-guilherme-silva-lemos-40b516244/).

---

## 📜 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

