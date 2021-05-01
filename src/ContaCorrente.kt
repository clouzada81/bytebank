class ContaCorrente(
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
     * Saques de conta corrente geram 0,5% do valor do saque como taxa de saque
     */
    override fun doSacar(valor: Double) {
        this.saldo -= valor
        this.saldo -= (valor * 0.005)
    }

    /**
     * Transferências de conta corrente geram 1% do valor da transferência como taxa de transferência
     */
    override fun doTransferir(contaDestino: Conta, valor: Double) {
        this.saldo -= valor
        this.saldo -= (valor * 0.01)
        contaDestino.depositar(valor)
    }

    /**
     * Conta corrente não rende
     */
    override fun render(): String {
        return "Sem rendimento"
    }
}