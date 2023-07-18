# Bank Statement

Aqui você encontrará os detalhes sobre o projeto: como instalar, executar, funcionalidades, recursos e tecnologias utilizadas.

## Introdução

O **Bank Statement** é uma API construída em **Spring** para consulta de extrato bancário, onde, além do ID da conta, a requisição pode enviar parâmetros opcionais, tais como o período e o nome do operador da tranasação.

## Instalação e execução

É necessário que você possua a JDK 11
1. Primeiramente, clone este repositório com o comando `git clone git@github.com:stonefullstm/bank-project.git`
2. Na raiz do projeto clonado, execute `mvn install` a fim de instalar as dependências necessárias
3. É possível executar a aplicação usando a IDE de sua preferência ou um dos comandos:
   `./mvnw clean package` para linux ou ` .\mvnw clean package` para windows. 
4. A aplicação estará rodando em `http://localhost:8080/`

## Funcionalidades

A API é constituída do seguinte endpoint:

`http://localhost:8080/transferencias/id`, onde `id` é o ID da conta a ser consultada. Por exemplo, se for feita a requisição `http://localhost:8080/transferencias/1`, o retorno será no formato:

~~~json
{
  "saldoTotal": 33636.19,
  "transferencias": [
    {
      "id": 1,
      "dataTransferencia": "2019-01-01T09:00:00.000+00:00",
      "valor": 30895.46,
      "tipo": "DEPOSITO",
      "nomeOperadorTransacao": null
    },
    {
      "id": 3,
      "dataTransferencia": "2019-05-04T05:12:45.000+00:00",
      "valor": -500.5,
      "tipo": "SAQUE",
      "nomeOperadorTransacao": null
    },
    {
      "id": 5,
      "dataTransferencia": "2020-06-08T07:15:01.000+00:00",
      "valor": 3241.23,
      "tipo": "TRANSFERENCIA",
      "nomeOperadorTransacao": "Beltrano"
    }
  ]
}
~~~

Além disso, é possível informar parâmetros opcionais na URL, tais como no exemplo:

`http://localhost:8080/transferencias/1?operador=Beltrano&datainicial=01/01/2019&datafinal=01/01/2021`

Se informar somente o `operador`, a API retorna apenas as transações deste operador. Se informar apenas as datas, o retorno comtemplará somente o período entre as duas datas. E se forem enviados os três parâmetros, a API irá retornar os lançamentos deste operador no intervalo de datas informado.

## Tecnologias utilizadas

Linguagem de programação [Java](https://www.java.com/pt-BR/), o framework web [Spring Boot](https://spring.io/projects/spring-boot), [Spring Data JPA](https://spring.io/projects/spring-boot) e [Maven](https://maven.apache.org/) para gerenciamento do build do projeto.