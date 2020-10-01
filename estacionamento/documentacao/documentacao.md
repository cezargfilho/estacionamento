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
  "telefone": "71991734603",
  "tipo": "MENSALISTA",
  "endereco": {
    "cep": "40270-240",
    "rua": "Rua XXXXXX",
    "numero": "540",
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
  "placa": "JQYO718",
  "cpfUsuario": "00000000000",
  "nomeFabricante": "FIAT",
  "modelo": "Palio",
  "cor": "Branca" 
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
  "placa": "JQYO718",
  "vaga": 20,
  "cpf": "00000000000"
}
```
- LISTAR
1. Método: /GET
2. URL: /entrada/listar

- DETALHAR
1. Método: /GET
2. URL: /entrada/detalhe/**{id}**

**PAGAMENTO**

- CADASTRAR
1. Método: /POST
2. URL: /pagamento/cadastrar
3. Template JSON:
```
{
  "precoId": "10",
  "qtdHoras": "8",
  "cpfUsuario": "00000000000",
  "vaga": "20"
}
```
- LISTAR
1. Método: /GET
2. URL: /pagamento/listar

- DETALHAR
1. Método: /GET
2. URL: /pagamento/detalhe/**{id}**