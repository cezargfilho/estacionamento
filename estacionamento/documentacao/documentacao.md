
# Documentação

Documentação do projeto de estacionamento da matéria de Tópicos Avançados em Banco de Dados, Universidade Católica do Salvador.

## UML - Modelagem Lógica
![Modelo Lógico](uml_logic.png)

## Especificação
Back-end:
- Linguagem Java
- Banco de dados utilizado Postgre SQL

Front-end
- Vue JS

Para buildar a aplicação utilize o Maven, com o comando:
WAR:	```mvn compile war:war```
JAR:	```mvn package```

## Endpoints

**USUÁRIO**
- CADASTRAR
1. Método: /POST
2. URL: /usuarios/cadastrar/mensalista
3. Template JSON:
```
{
  "nome": "Cezar Gonzalez Filho",
  "cpf": "88888888888",
  "dataNascimento": "21/09/1996",
  "telefone": "71990000000",
  "tipo": "MENSALISTA",
  "endereco": {
    "cep": "40270-000",
    "rua": "Rua XXXXXX",
    "numero": "000",
    "cidade": "Salvador",
    "estado": "BA",
    "pais": "Brasil"
  }
}
```
- LISTAR
1. Método: /GET
2. URL: /usuarios/listar

- DETALHAR
1. Método: /GET
2. URL: /usuarios/detalhe/**{id}**  

**VEICULO**

- CADASTRAR
1. Método: /POST
2. URL: /veiculos/cadastrar
3. Template JSON:
```
{
  "placa": "XXXXXXX",
  "cpfUsuario": "88888888888",
  "nomeFabricante": "FIAT",
  "modelo": "Branca"
}
```
- LISTAR
1. Método: /GET
2. URL: /veiculos/listar

- DETALHAR
1. Método: /GET
2. URL: /veiculos/detalhe/**{id}**

**ENTRADA**

- CADASTRAR
1. Método: /POST
2. URL: /entrada/cadastrar
3. Template JSON:
```
{
  "placa": "XXXXXXX",
  "numeroVaga": "20",
  "cpfUsuario": "88888888888"
}
```
- LISTAR
1. Método: /GET
2. URL: /entrada/listar

- DETALHAR
1. Método: /GET
2. URL: /entrada/detalhe/**{id}**