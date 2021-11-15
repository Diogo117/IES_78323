Lab 3 notebook

3.1 b)
    -A nova instancia da Interface UserRepository no construtor do User Controller, é iniciada vazia mas com os metodos da interface CrudRepository.
    -A interface CrudRepository tem  como metodos (save/ saveAll/ findById/ existsById/ findAll/ findAllById/ count/ deleteById/ delete/ deleteAllById/ deleteAll/ deleteAll), o segundo deleteAll nao tem parametros de entrada, estes metodos estão no ficheiro da interface de CrudRepository.java.
    -A informação esta a ser guardada no controlador no parametro (userRepository).
    -O aviso de sistema sobre o email vazio esta definido na propria class User atraves da linha (@NotBlank(message = "Email is mandatory")).
