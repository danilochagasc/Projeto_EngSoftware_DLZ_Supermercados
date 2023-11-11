<h1 align="center">DLZ Supermercados</h1>

## Descrição do Projeto
<p> Nossa proposta é o desenvolvimento de um sistema de supermercado delivery. Tendo como objetivo fornecer a melhor experiência aos nosso usuários por meio da facilidade de compra de produtos em um ambiente inteiramente online e entregue em sua casa. </p>

## Funcionalidades

### Cadastrar
<p> Os usuários podem criar uma conta que contenha informações como nome, endereço, cidade e CEP.</p>

### Login
<p> Os usuários devem possuir uma conta que contenha informações como nome, endereço, cidade e CEP para que possam acessar todas as funcionalidades do site.</p>

### Catálogo de produtos
<p> Os produtos são apresentados separados por categorias.</p>

### Carrinho
<p> Contém a listagem de produtos selecionados pelo usuário.</p>

### Conclusão de Compra e Pagamento
<p> Confere os produtos selecionados e é processada a opção de pagamento para a conclusão do pedido.</p>

## Tecnologias
- React (JavaScript) --versão 18.2.0 
- Spring Boot (Java) --versão 3.1.5
- PostgreSQL (SQL) --versão 15.4

## Estrutura de Diretórios
<a name="estrutura-diretorio"></a>

```sh
.
|-- documentacao/
|   |-- demais diretórios
|
|-- back-end/
    |-- scr/
        |-- main/
            |-- java/com/dlz/backend/
                |-- controller/* (Pasta dos controllers da aplicação)
                |-- dto/* (Pasta dos dto's - Data Transfer Object - da aplicação)
                |-- model/
                |-- repository/
                |-- service/
                |-- util/* (Pasta com classes auxiliares de cada model)
                |-- BackEndApplication.java (Arquivo principal)
             |-- resouces/
                 |-- application.properties (Arquivo de configurações referentes ao banco de dados)
|
|-- front-end/
    |-- src/
        |-- assets/* (Imagens utilizadas na aplicação)
        |-- components/* (Componentes utilizados para a aplicação)
        |-- pages/* (Páginas da aplicação)
        |-- styles/
    |-- public/
|
|-- padroes-adotados/* (Documento referente as regras de verificação e análise de requisitos)
|-- documentacao/* (Documento que contém todas as especificações do Software)
```

## Autores
- Danilo Chagas
- José Airton
- Lara Linhares
