Lab 2 Notebook

 Review Questions:
a) O servlet Container é responsavel por isolar um processo da aplicação, para correr processos em paralelo ou mesmo, só para criar uma vista dinamica. Isto é alcançado atraves de como o container responde ao pedido http, que lhe é enviado pela aplicação, onde o container irá chamar o servlet e correr este mesmo. Dado este servllet por terminado o container envia a resposta a aplicação.
b) A maneira como o Spring Boot utiliza o modelo MVC, é atraves do uso de classes estaticas para os Models, nos exercicios anteriores são as classes Greeting e GreetingJSON, usa Controllers normalmente, atraves dos classes GreetingController e GreetingJSONController, mas na parte da View ja é diferente, pois o Spring Boot cria estas dinamicamente, usando os Controllers para gerar as Views.
c) O objetivo das dependencias "starters" é fornecer as ferramentas basicas necessarias, para correr a aplicação como ferramentas Web apra desenvolvimento, como o servidor, nestes exercicios foi o tomcat e por fim forneceu testes para testar a aplicação.
d) As anotações "@EnableAutoConfiguration", "@ComponentScan" e "@SpringBootConfiguration" são as três anotações presentes na anotação "@SpringBootApplication".
e) A meu ver as melhores praticas relativamente a metodologia REST são, a de responder a erros com mensagen explicitas, para que o utilizador identifique o erro com mais facilidade.
      Outro seria o não usar verbos nas ligações pois estas ligações por si têm de fazer sentido so com nomes, caso contratio corre-se o risco de ter varios URL com designações similares e isso pode tornar a API dificil de usar.
      Ter varias versões é outra pratica que a meu ver é bastante importante, pois as APIs que usam a metedologia REST podem ser utilizadas por varias outra aplicações e quando se atualiza uma API isso pode por sua vez influenciar a aplicação do utilizador.
      Apesar de ser boa pratica para qualquer metedologia é sempre boa pratica ter boa documentação para tornar a API acessivel.
      Por fim seria o uso de Json enves de XML, pelo simples facto de ser mais facil de tratar e mais facil de ler.
