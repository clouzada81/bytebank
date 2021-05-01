class AreaRestrita {

    fun login(admin: FuncionarioAdmin, senha: String) {
        if (admin.autenticar(senha)) {
            println("Usuário ${admin.nome} autenticado com sucesso!")
        } else {
            println("Acesso do usuario ${admin.nome} negado! Senha incorreta: $senha")
        }
    }
}