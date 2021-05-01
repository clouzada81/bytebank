class Cliente(
    val nome: String,
    val login: String,
    val senha: String,
) : Autenticavel {
    override fun autenticar(senha: String): Boolean {
        return this.senha == senha
    }
}