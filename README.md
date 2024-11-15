## Sistema de Gerenciamento de Tarefas Kanban

## Descrição
Este projeto implementa uma API REST para gerenciar um quadro **Kanban** de tarefas. O sistema permite a criação, edição, movimentação e exclusão de tarefas através de três colunas principais: **A Fazer (To Do)**, **Em Progresso (In Progress)** e **Concluído (Done)**. Cada tarefa pode ser movida entre essas colunas conforme seu progresso.

## Tecnologias Utilizadas
- **Java Spring Boot**
- **Banco de dados H2** (in-memory)
- **Postman** (para testes de API)

## Requisitos Funcionais
1. **Cadastro de Tarefas **:
   - Cada tarefa deve conter:
     - Título 
     - Descrição
     - Data de criação 
     - Status 
     - Prioridade 
     - Data limite 

2. **Gerenciamento de Tarefas **:
   - Criar novas tarefas na coluna "A Fazer".
   - Listar todas as tarefas organizadas por coluna 
   - Mover uma tarefa entre as colunas do Kanban 
   - Editar uma tarefa (alterar título, descrição, prioridade, etc.).
   - Excluir uma tarefa.

3. **Funcionalidades Extras **:
   - Ordenar tarefas dentro de cada coluna por prioridade.
   - Filtrar tarefas por prioridade e data limite.
   - Gerar um relatório que liste as tarefas por coluna e destaque as tarefas atrasadas (com data limite passada e status não "Concluído").

## Regras de Negócio
- As tarefas só podem ser criadas na coluna "A Fazer".
- A tarefa deve ser movida entre as colunas na ordem: A Fazer → Em Progresso → Concluído.
- O título da tarefa é obrigatório; descrição e data limite são opcionais.

## Endpoints da API (0,5 ponto)

### Tarefas
- **POST** `/tasks`: Criar uma nova tarefa na coluna "A Fazer".
- **GET** `/tasks`: Listar todas as tarefas organizadas por coluna.
- **PUT** `/tasks/{id}/move`: Mover uma tarefa para a próxima coluna.
- **PUT** `/tasks/{id}`: Atualizar uma tarefa (título, descrição, prioridade).
- **DELETE** `/tasks/{id}`: Excluir uma tarefa.



