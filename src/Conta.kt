class Conta(
    var titular: String,
    val banco: String,
    val numeroAgencia: Int,
    val numeroConta: Int,
    var digitoConta: Int
) {
    var saldo = 0.0
        private set

    fun sacar(valor: Double): Retorno {
        val retorno = Retorno(true, "Saque realizado com sucesso da conta de ${this.titular}. Valor: $valor")

        if (valor <= 0) {
            retorno.setStatus(false)
            retorno.setMensagem("Informe um valor para o saque")
            return retorno
        }

        if (this.saldo < valor) {
            retorno.setStatus(false)
            retorno.setMensagem("Saque não realizado da conta de ${this.titular}. Valor: $valor. Saldo insuficiente")
            return retorno
        }

        this.saldo -= valor
        return retorno
    }

    fun depositar(valor: Double): Retorno {
        val retorno = Retorno(true, "Depósito realizado com sucesso na conta de ${this.titular}. Valor: $valor")
        if (valor <= 0) {
            retorno.setStatus(false)
            retorno.setMensagem("Informe um valor para o depósito")
            return retorno
        }

        this.saldo += valor
        return retorno
    }

    fun transferir(contaDestino: Conta, valor: Double): Retorno {
        val retorno =
            Retorno(true, "Transferência realizada. De: ${this.titular} para ${contaDestino.titular}. Valor: $valor")
        val ret = this.sacar(valor)
        if (!ret.getStatus()) {
            retorno.setStatus(false)
            retorno.setMensagem(
                "Transferência não realizada da conta de ${this.titular} para ${contaDestino.titular}. Valor: $valor. Saldo insuficiente na conta de ${this.titular}"
            )
            return retorno
        }

        contaDestino.depositar(valor)
        return retorno
    }
}