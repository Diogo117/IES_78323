Lab1 notebook

No exercicio 1.2 na parte K, tem de haver controlo do codigo de cidade inserido para funcionar corretamente, controlo como verificar se é um Integer, no estado em que esta é funcional e corresponde ao pedido, mas corre o risco de falhar.
No exercicio 1.5 não consegui desvendar o erro que me deparei no tempo disponibilizado, a class WeatherStarterClass não era visivel na interface.

Review Question:
    a) As fases pricipais do ciclo "Default" são a fase de Compilação, onde o Maven compila o codigo, a fase de package, na qual ira criar os ficheiros JAR/WAR ditados no ficheiro POM.xml e por fim a fase de Deploy, que irá replicar o os pacotes finais  no repositorio.
    b) Depende do projeto, pois esta arquitetura de desenvolvimento facilita alguns aspetos de desenvolvimeto de software que usando outras arquiteturas pode demorar mais, por exemplo a implemetação de dependencias, tambem permite uma consistencia entre projetos para uma leitura facilitada dos mesmos.
    c) Para contribuir com uma nova funcionalidade no projeto seria necessario em priemiro lugar puxar o projeto, se o projeto já estava localmente, então fazer pull para atualizar o projeto no caso de este ter sido actualizado por outros membros da equipa, de seguida seria a criação de um Branch no caso de haver outros membros a trabalhar nesse projeto,
        após isso, então desenvolve-se a nova funcionalidade, fazendo Commits pelo caminho para o caso de conflitos mais tarde, e por fim Fazer pull do projeto mais uma vez, resolver os conflitos e fazer Push dos commits.
    d) Após rever algumas das boas praticas de como fazer commits, por experiencia propria, em ambiente profissional, as que mais me marcaram foram as de fazer pequenos mas muitos commits, enves de um enorme, ser direto nas mensagens e informar, consisamente, as alterações e fazer commits só de codigo que esteja a correr.
    e) Uma das razões principais para configurar Volumes manualmente para uma base-de-dados de produção é devido a redundancia, atraves da armazenação em varios locais seguros, permintindo assim com que os dados não se percam.
