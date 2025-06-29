# Relatorio Técnico
observação: Esse markdown está presente no próprio projeto.

## Tecnologias utilizadas
### Qualidade de código

Fizemos os testes unitários no JUnit com H2 como entendo ser o Padrão dada nossa stack.

Para testes integrados utilizei a ferramenta allure para conseguir testar os end-points. 

Utilizei o JaCoCo para análise de cobertura de código.

AssertJ para facilitar a escrita das asserções dos testes unitários. 

### Stack da Solução

Foi feita com spring-boot, utilizando o Swagger como ferramenta de documentação e pensado para ser implantado com Postgres.

### Deploy na nuvem


## Utilização do Clean Architecture

Tive o cuidado de separar os objetos na estrutura sugerida pelo clean archtecture. Quando comparado ao TechChallenge 3 que esse trabalho está reponde eu observo dois ponto que evoluí na aplicação dos preceitos.

O primeiro foi conseguir efetivamente abandonar a ideia dos controllers e Services que até então eu insistia em usar por falta de compreensão da arquitetura.

O segundo foi a efetiva separação do Repositório das definições das entidades de sistema. 

Foi um processo trabalhoso que aprecio enquanto conceito e exercício. Um exemplo interessante dessa separação foi a criação dos objetos para Valores dos atendimento e dos Horário de atendimento que dentro das entidades do sistema são objetos próprios com suas regras mas que são persistidos de forma ingênua.

## Qualidade de Software

No Techchallenge que estou repondo aqui meu maior foco havia sido os testes unitários. Dessa vez busquei dar enfâse também aos testes integrados e os testes de carga. 

Utilizei conforme o TDD criei os testes dos endpoints antes da implementação dos restpoints e achei a experiência bem interessante.