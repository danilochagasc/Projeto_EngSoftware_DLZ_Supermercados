<h1 align="center">DLZ Supermercados</h1>

## Descrição do Projeto
<p> Nossa proposta é o desenvolvimento de um sistema de supermercado delivery. Tendo como objetivo fornecer a melhor experiência aos nosso usuários por meio da facilidade de compra de produtos em um ambiente inteiramente online e entregue em sua casa. </p>

## Funcionalidades

### Cadastrar
<p> Os usuários podem criar uma conta que contenha informações como nome, e-mail, endereço, telefone e senha.</p>

### Login
<p> Os usuários devem possuir uma conta que contenha informações como nome, e-mail, endereço, telefone e senha para que possam acessar todas as funcionalidades do site.</p>

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
|-- documentacao/ (Conjunto de documentos que contêm as especificações do Software)
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
```

## Regras e Padrões de Uso do Git

### Commits
Os commits devem utilizar um padrão objetivo e direto, deixando a linha do tempo do projeto mais estruturada e de fácil entendimento.

- Padrão utilizado:
   <Mudança feita>...<O que sofreu alteração>

### Branches
- Utilizar as branches "back-end" e "front-end" para códigos de back-end e front-end, respectivamente.
- Realizar merge das branches anteriormente citadas com a branch main somente após a fase de testes e garantia de corretude das funcionalidades criadas.
- Utilizar o padrão de letras minúsculas para a nomeação de branches separas por hífen.

### Organização
- Manter a organização por área de front-end, back-end e as demais para documentação.
  
### Arquivos Ignorados
- Inserir os arquivos e pastas no .gitignore de seu diretório.

## Regras e Boas Práticas de Codificação
- O código deve ser de fácil entendimento:
   - Nomear classes, métodos e variáveis de maneira intuitiva.
   - Identar o código corretamente.
   - Utilizar a convenção de nomenclatura Camel Case em classes, métodos e variáveis.
   - Organizar o código de uma maneira lógica, com funções relacionadas agrupadas e conceitos relacionados próximos uns dos outros.
- O código deve ser direto:
   - Evitar o uso de linguagem rebuscada.
   - Fazer uso de bibliotecas e métodos que otimizem o código.
- O código deve não conter duplicidade:
   - Seguir o planejamento de classes, respeitando a divisão de funcionalidades.
   - Utilizar práticas como sobrecarga de métodos, interfaces e outras técnicas que possam ser suportados pela linguagem para evitar repetição de código.

## Autores
- Danilo Chagas
- José Airton
- Lara Linhares
