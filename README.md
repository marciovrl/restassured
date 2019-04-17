# example-restassured
Example of how to simply use Restassured and test in an API.

s/Ese repositório tem como objetivo ser meu campo de treinamento e estudo de RestAssured. (ad infinitum em construção... ).

Peguei a API `https://jsonplaceholder.typicode.com` e desenvolvi a automação do endpoint `/posts` testando os verbos/chamadas e o contrato.

# Pre-requisitos
- Java instalado e configurado;
- Maven instalado e configurado.

# Utiliar esse projeto como exemplo
- Clonar projeto:
```
git clone https://github.com/marciovrl/example-restassured.git
```

- Executar comando para instalação das dependencias:
```
mvn install
```

- Para executar os testes:
```
mvn -DtestSourceDirectory=src/test/java/com/exmaple/steps/test clean test
```

# Iniciar projeto do zero
- Gerar estrutura do projeto Maven
```
mvn archetype:generate
```

- Procurar as seguintes depencias em `https://mvnrepository.com` e adicionar no arquivo `pom.xml`.
```
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
</dependency>
```

```
<dependency>
    <groupId>io.rest-assured</groupId>
    <artifactId>rest-assured</artifactId>
</dependency>
```

```
<dependency>
    <groupId>com.jayway.restassured</groupId>
    <artifactId>rest-assured</artifactId>
</dependency>
```

```
<dependency>
    <groupId>org.hamcrest</groupId>
    <artifactId>hamcrest-all</artifactId>
</dependency>
```

- Agora só estruturar e escrever os testes!

# Estrutura do projeto
```
|
| - src
    | - java
        | - com
            | example
                | - steps
                    | - test
                        | - test
                            | - `ArquivoTeste.java`
| - `.gitignore`
| - `pom.xml`  
| - `README.md`  
```
endpoint https://jsonplaceholder.typicode.com/posts

