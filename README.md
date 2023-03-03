# Book Organizer
:sparkles: Sistema para organizar suas leituras

## Endpoints

- Livros
  - [Adicionar livro]('#adicionar-livro')
  - [Listar livro por categoria]('')
  - [Listar livro por id]('')
  - [Atualizar livro]('')
  - [Excluir livro]('')
- Usuários
  - [Cadastrar usuário]('')
  - [Exibir usuário]('')
  - [Atualizar usuário]('')
  - [Excluir usuário]('')

### Adicionar livro

`POST` /api/livro

**Campos da requisição**

| Campo            | Tipo   | Obrigatório?| Descrição
|------------------|--------|:-----------:|-
|titulo              |String  |sim          |Texto com o titulo do livro com no máximo 230 caracteres.
|autor         |String  |sim          |Texto com o autor do livro com no máximo 230 caracteres.
|quantidade_paginas  |int     |sim          |O valor da quantidade de paginas que o livro possui.
|avaliacao |int     |não          |O valor de 1 a 5 que define a quantidade de estrelas.
|status        |String  |sim          |O valor da porcentagem de paginas lidas.
|categoria        |String  |não          |Texto com a categoria do livro.
|pagina_atual        |int  |sim          |O valor da quantidade de paginas que o usuario leu.

**Exemplo de corpo de requisição**

```js
{
    informacoes: {
        titulo: "Clean Code",
        autor: "Luisa Purifica",
        categoria: "Tecnologia"
    },
    quantidade_paginas: 500,
    pagina_atual: 100,
    status: 20,
    avaliacao: 5
}
```

**Códigos de Resposta**

| Código | Descrição
|-|-
| 201 | Livro cadastrado com sucesso
| 400 | Os campos enviados são inválidos

---
