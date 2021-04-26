class ContaPoupanca(
    titular: String,
    banco: String,
    numeroAgencia: Int,
    numeroConta: Int,
    digitoConta: Int
) : Conta(titular, banco, numeroAgencia, numeroConta, digitoConta) {

    fun render() {
        saldo *= 0.05
    }
}