# Relatorio Técnico e README 
observação: Esse markdown está presente no próprio projeto e foi objeto de entrega para um trabalho da pós em arquitetura em Java.

## Tecnologias utilizadas
### Qualidade de código

Fizemos os testes unitários no JUnit com H2 como entendo ser o Padrão dada nossa stack.

Para testes integrados utilizei a ferramenta allure para conseguir testar os end-points. 

Utilizei o JaCoCo para análise de cobertura de código.

AssertJ para facilitar a escrita das asserções dos testes unitários. 

### Stack da Solução

Foi feita com spring-boot, utilizando o Swagger como ferramenta de documentação e pensado para ser implantado com Postgres.

## Utilização do Clean Architecture

Tive o cuidado de separar os objetos na estrutura sugerida pelo clean archtecture. Quando comparado ao TechChallenge 3 que esse trabalho está reponde eu observo dois ponto que evoluí na aplicação dos preceitos.

O primeiro foi conseguir efetivamente abandonar a ideia dos controllers e Services que até então eu insistia em usar por falta de compreensão da arquitetura.

O segundo foi a efetiva separação do Repositório das definições das entidades de sistema. 

Foi um processo trabalhoso que aprecio enquanto conceito e exercício. Um exemplo interessante dessa separação foi a criação dos objetos para Valores dos atendimento e dos Horário de atendimento que dentro das entidades do sistema são objetos próprios com suas regras mas que são persistidos de forma ingênua.

## Qualidade de Software

No Techchallenge que estou repondo aqui meu maior foco havia sido os testes unitários. Dessa vez busquei dar enfâse também aos testes integrados e os testes de carga. 

Conforme sugere o TDD eu criei os testes dos endpoints antes da implementação e achei a experiência bem interessante. Ainda melhor do que o TDD de classes específicas do sistema e acho que se deve ao fato das interfaces da requisição e resposta dos endpoits serem mais desacoplados do códigos uma vez que são JSON e dessa forma facilita a mudança de interfaces do elemento sendo testado. 

## Deploys em outros ambientes

Optei por fazer o deploy via AWS. Subi primeiro pelo Elastic Beanstalk que foi super simples. [link para a instância do beanstalk](http://sistemawellness-env.eba-eqmfjufw.us-east-1.elasticbeanstalk.com/swagger-ui/index.html). Achei bacana mas a forma como eu havia feito foi subindo o arquivo .jar no site da AWS e não achei que bastava para esse trabalho.

Incluí então uma action no github desse trabalho para fazer um deploy automático numa instância do EC2. Deu bem mais trabalho mas o exercício foi interessante. [Link para a intância do EC2](http://3.220.67.224/swagger-ui/index.html).

Observação, não tenho como garantir que ambas as instâncias estarão no ar no momento da correção. Hoje ambos estão disponíveis e funcionando corretamente.

## O que não foi feito

Muitas das funcionalidades esperadas do negócio não foram implementadas e estou ciente disso. Busquei focar nos três temas da unidade: clean archtecture, deploy na nuvem e qualidade de software e estou contente com o que fiz e com o que aprendi enquanto fazia esse trabalho.