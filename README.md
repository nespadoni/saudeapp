# Saúde App

Saúde App é um aplicativo Java projetado para o gerenciamento de informações relacionadas a pacientes, médicos e consultas. O objetivo é fornecer uma solução simples e eficaz que aplica boas práticas de programação, como arquitetura limpa e princípios SOLID. Este projeto foi desenvolvido como parte de um portfólio pessoal.

---

## Funcionalidades Principais

- **Cadastro de pacientes**: Registre pacientes com dados como nome, CPF e data de nascimento.
- **Cadastro de médicos**: Gerencie informações sobre médicos, incluindo nome, CRM e especialidade.
- **Listagem**:
    - Exiba listas de pacientes cadastrados.
    - Visualize médicos por especialidade.
    - Liste consultas agendadas.
- **Agendamento de consultas**:
    - Permite marcar consultas entre pacientes e médicos.
    - Informações sobre data, horário e status da consulta.
- **Cancelamento de consultas**.

---

## Tecnologias Utilizadas

- **Linguagem**: Java 21
- **Framework: Spring**
- **Paradigma**: Orientação a Objetos
- **Princípios de Design**: SOLID
- **Estrutura de Arquivos**: Seguindo o padrão MVC (Model-View-Controller).

---

## Estrutura do Projeto

O projeto segue uma organização modular, com os seguintes pacotes principais:

```plaintext
src/
├── saude.app.api/
│   ├── controllers/    // Controladores: gestão de regras de negócio
│   ├── dto/            // Data Transfer Objects: transfere dados entre camadas
│   ├── exceptions/     // Exceções personalizadas
│   ├── models/         // Modelos que representam o domínio (Paciente, Médico, Consulta)
│   ├── repositories/   // Repositórios: gerenciam a persistência de dados
│   ├── services/       // Lógica de negócio complexa
│   ├── utils/          // Classes utilitárias (validações, datas, etc.)
│   ├── views/          // Interface do usuário (menu textual por enquanto)
│   └── Main.java       // Ponto de entrada da aplicação
```

---

## Como Executar

1. Certifique-se de ter o Java instalado (versão 21 ou superior).
2. Clone este repositório:
   ```bash
   git clone https://github.com/nespadoni/saudeapp.git
   ```
3. Faça chamada das ações utilizando uma ferramenta de Teste de API (Insomnia e Postman) para explorar as funcionalidades.

---

## Funcionalidades Futuras
- Implementar persistência com banco de dados.
- Criar uma interface gráfica (GUI).
- Melhorar as validações e mensagens ao usuário.
- Adicionar relatórios e visualizações de dados.

---

## Contribuições
Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou criar pull requests para melhorias e novos recursos.

---
