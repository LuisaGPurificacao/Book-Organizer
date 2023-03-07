# Book Organizer
:sparkles: Sistema para organizar suas leituras

## Endpoints

- Livros
  - [Adicionar livro](#adicionar-livro)
  - [Listar livro por autor](#listar-livro-por-autor)
  - [Listar livro por categoria](#listar-livro-por-categoria)
  - [Listar livro por id](#listar-livro-por-id)
  - [Atualizar livro](#atualizar-livro)
  - [Excluir livro](#excluir-livro)
- Categorias
  - Adicionar categoria
  - Atualizar categoria
  - Excluir categoria
- Autores
  - Adicionar autor
  - Atualizar autor
  - Excluir autor
- Usuários
  - Cadastrar usuário
  - Exibir usuário
  - Atualizar usuário
  - Excluir usuário

### Adicionar Livro

`POST` /book-organizer/livros

**Campos da requisição**

| Campo            | Tipo   | Obrigatório?| Descrição
|------------------|--------|:-----------:|-
|titulo              |String  |sim          |Texto com o titulo do livro com no máximo 230 caracteres.
|autor         |Autor  |sim          |Texto com o autor do livro com no máximo 230 caracteres.
|quantidade_paginas  |int     |sim          |O valor da quantidade de paginas que o livro possui.
|avaliacao |int     |não          |O valor de 1 a 5 que define a quantidade de estrelas.
|status        |double  |sim          |O valor da porcentagem de paginas lidas.
|categoria        |Long  |não          |Texto com a categoria do livro.
|pagina_atual        |int  |sim          |O valor da quantidade de paginas que o usuario leu.

**Exemplo de corpo de requisição**

```js
{
    titulo: "Clean Code",
    autor: "Luisa Purifica",
    categoria: "tecnologia",
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

### Listar Livro Por Autor

`GET` /book-organizer/livros/autor/{idAutor}

**Exemplo de corpo de requisição**

```js
{
    id: 1,
    titulo: "Clean Code",
    autor: {
      id: 1,
      nome: "Luisa Purifica"
    },
    categoria: {
      id: 1,
      nome: "TECNOLOGIA"
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
| 200 | Livros retornados de acordo com a categoria com sucesso
| 404 | Categoria não existe

---

### Listar Livro Por Categoria

`GET` /book-organizer/livros/{idCategoria}

**Exemplo de corpo de requisição**

```js
{
    id: 1,
    titulo: "Clean Code",
    autor: {
      id: 1,
      nome: "Luisa Purifica"
    },
    categoria: {
      id: 1,
      nome: "TECNOLOGIA"
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
| 200 | Livros retornados de acordo com a categoria com sucesso
| 404 | Categoria não existe

---

### Listar Livro Por ID

`GET` /book-organizer/livros/{id}

**Exemplo de corpo de requisição**

```js
{
    id: 1,
    titulo: "Clean Code",
    autor: {
      id: 1,
      nome: "Luisa Purifica"
    },
    categoria: {
      id: 1,
      nome: "TECNOLOGIA"
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
| 200 | Livro retornado com sucesso
| 404 | Livro com id informado não existe

---

### Atualizar Livro

`PUT` /book-organizer/livros/{id}

**Campos da requisição**

| Campo            | Tipo   | Obrigatório?| Descrição
|------------------|--------|:-----------:|-
|titulo              |String  |não          |Texto com o titulo do livro com no máximo 230 caracteres.
|autor         |Autor  |não          |Texto com o autor do livro com no máximo 230 caracteres.
|quantidade_paginas  |int     |não          |O valor da quantidade de paginas que o livro possui.
|avaliacao |int     |não          |O valor de 1 a 5 que define a quantidade de estrelas.
|status        |double  |não          |O valor da porcentagem de paginas lidas.
|categoria        |Long  |não          |Texto com a categoria do livro.
|pagina_atual        |int  |não          |O valor da quantidade de paginas que o usuario leu.

**Exemplo de corpo de requisição**

```js
{
    titulo: "Clean Code",
    autor: "Luisa Purifica",
    categoria: "tecnologia",
    quantidade_paginas: 550,
    pagina_atual: 110,
    status: 20,
    avaliacao: 4.5
}
```

**Códigos de Resposta**

| Código | Descrição
|-|-
| 200 | Livro atualizado com sucesso
| 400 | Os campos enviados são inválidos
| 404 | Não existe livro com o id informado

---

### Excluir livro

`DELETE` /book-organizer/livros/{id}

**Códigos de Resposta**

| Código | Descrição
|-|-
| 204 | Livro excluido com sucesso
| 404 | Não existe livro com o id informado
