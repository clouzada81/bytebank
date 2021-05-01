class ContaPoupanca(
    titular: Funcionario,
    banco: String,
    numeroAgencia: Int,
    numeroConta: Int,
    digitoConta: Int
) : Conta(
    titular = titular,
    banco = banco,
    numeroAgencia = numeroAgencia,
    numeroConta = numeroConta,
    digitoConta = digitoConta
) {

    /**
     * Saques de conta poupança não geram taxa de saque
     */
    override fun doSacar(valor: Double) {
        this.saldo -= valor
    }

    /**
     * Transferências de conta poupança não geram taxa de transferência
     */
    override fun doTransferir(contaDestino: Conta, valor: Double) {
        this.saldo -= valor
        this.saldo -= (valor * 0.01)
    }

    /**
     * Conta poupança rende 0,48% no aniversário
     */
    override fun render(): String {
        val valorRendimento = this.saldo * 0.0048
        this.saldo += valorRendimento
        return "O rendimento da conta de ${this.titular.nome} foi de $valorRendimento."
    }
}