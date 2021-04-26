class ContaCorrente(
    titular: String,
    banco: String,
    numeroAgencia: Int,
    numeroConta: Int,
    digitoConta: Int
) : Conta(titular, banco, numeroAgencia, numeroConta, digitoConta) {

    override fun sacar(valor: Double): Retorno {
        val retorno = super.sacar(valor)
        saldo -= 1
        return retorno
    }

    override fun transferir(contaDestino: Conta, valor: Double): Retorno {
        val retorno = super.transferir(contaDestino, valor)
        saldo -= 0.5
        return retorno
    }
}