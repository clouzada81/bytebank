class AreaRestrita {

    fun login(admin: Autenticavel, senha: String) {
        if (admin.autenticar(senha)) {
            println("Usuário autenticado com sucesso!")
        } else {
            println("Acesso do usuário negado! Senha incorreta: $senha")
        }
    }
}