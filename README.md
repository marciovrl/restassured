# example-restassured
Example of how to simply use Restassured and test in an API.

Esse repositório tem como objetivo ser meu campo de treinamento e estudo de RestAssured. (ad infinitum em construção... ).

Foi contruidos testes de serviço com `junit` e com `cucumber` para o endpoint `/posts` da API `https://jsonplaceholder.typicode.com`.

# Pré-requisitos
- Java instalado e configurado;
- Maven instalado e configurado.

# Rodar os testes
- Clonar projeto:
```
git clone https://github.com/marciovrl/example-restassured.git
```

- Executar comando para instalação das dependencias:
```
mvn install
```

- Para executar os testes de forma unitária:
```
mvn -DtestSourceDirectory=src/test/java/com/example/steps/test clean test
```

- Para executar os testes com cucumber:
```
mvn clean -Dtest=CucumberTest test
```

# Estrutura do projeto
```
|
| - src
    | - test
        | - features
            | - `Example.feature`
        | - java
            | com
                | - example
                    | - steps
                    | - definitions
                        | - `cucumberStepTest.java`
                    | - test
                        | - `unitTest.java`
                    | - support
                            | - `CucumberTest.java`
| - `.gitignore`
| - `pom.xml`  
| - `README.md`  
```
