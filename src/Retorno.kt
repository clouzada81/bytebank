data class Retorno(private var status: Boolean, private var mensagem: String) {
    fun getStatus(): Boolean {
        return this.status
    }

    fun getMensagem(): String {
        return this.mensagem
    }

    fun setStatus(status: Boolean) {
        this.status = status
    }

    fun setMensagem(mensagem: String) {
        this.mensagem = mensagem
    }
}