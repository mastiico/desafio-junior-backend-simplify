# Sistema de Gerenciamento de Tarefas

Este é um sistema de gerenciamento de tarefas que permite aos usuários criar, visualizar, editar e excluir tarefas.

## Tecnologias Utilizadas

- Linguagem de Programação: Java
- Framework: Spring Boot
- Banco de Dados: MySQL
- Mapeamento de Objeto-Relacional: Dozer
- Hypermedia as the Engine of Application State (HATEOAS)
- DTO (Data Transfer Object)

## Requisitos

- JDK 17 ou superior
- MySQL instalado localmente
- Maven para construir e executar o projeto

## Configuração do Banco de Dados

1. Crie um banco de dados no MySQL chamado `todolist`.
2. Configure as credenciais do banco de dados no arquivo `application.properties`:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/todolist
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   spring.jpa.hibernate.ddl-auto=update

5. Inicie o aplicativo e acesse a URL base localmente:

   [http://localhost:8080](http://localhost:8080)

## Estrutura do Projeto

  - `src/main/java/com/mastico/ToDoList`: Pacote principal do projeto
  - `Controllers`: Controladores REST para manipulação das tarefas
  - `Controllers/Mapper/VO`: Visual Objects (VO) para representação dos dados
  - `Models`: Modelos de entidades para representar as tarefas
  - `Repositories`: Interfaces de repositório para interação com o banco de dados
  - `Services`: Lógica de negócio para manipulação das tarefas
  - `ToDoListApplication.java`: Ponto de entrada da aplicação Spring Boot

## Como Contribuir

1. Faça um fork do repositório.
2. Crie uma branch para a sua feature (`git checkout -b feature/NomeDaFeature`).
3. Faça commit das suas alterações (`git commit -am 'Adicione sua feature'`).
4. Faça push para a branch (`git push origin feature/NomeDaFeature`).
5. Crie um novo Pull Request.

## Autores

- [Mastico]([https://github.com/seu-usuario](https://github.com/mastiico/)) - Desenvolvedor
