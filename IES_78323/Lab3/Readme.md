Lab 3 notebook

3.1 b)
    -A nova instancia da Interface UserRepository no construtor do User Controller, é iniciada vazia mas com os metodos da interface CrudRepository.
    -A interface CrudRepository tem  como metodos (save/ saveAll/ findById/ existsById/ findAll/ findAllById/ count/ deleteById/ delete/ deleteAllById/ deleteAll/ deleteAll), o segundo deleteAll nao tem parametros de entrada, estes metodos estão no ficheiro da interface de CrudRepository.java.
    -A informação esta a ser guardada no controlador no parametro (userRepository).
    -O aviso de sistema sobre o email vazio esta definido na propria class User atraves da linha (@NotBlank(message = "Email is mandatory")).

Review Questions
a) A grande diferença entre os RESTControllers e os Controllers é na maneira como tratam os dados que enviam, o RESTController devolve JSON/XML escrito no corpo da resposta, enquanto o Controller necessita de uma View para mostrar o conteudo.
b)
c) As anotações @Table, @Colum, @Id nas entidades, são informações para o compilador a informar que a informação que se segue é para transpor para SQL.
d) A anotação @AutoWired ajuda o compilador a criar entidades sem necessitar da palavra chave "new".
