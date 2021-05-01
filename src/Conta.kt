abstract class Conta(
    var titular: Funcionario,
    val banco: String,
    val numeroAgencia: Int,
    val numeroConta: Int,
    var digitoConta: Int,
) {
    var saldo = 0.0
        protected set

    fun sacar(valor: Double): String {
        if (valor <= 0) {
            return "Saque não realizado da conta de ${this.titular.nome}. Valor: $valor.\nMotivo: Informe um valor maior do que zero"
        }

        if (this.saldo < valor) {
            return "Saque não realizado da conta de ${this.titular.nome}. Valor: $valor.\nMotivo: Saldo insuficiente"
        }

        doSacar(valor)
        return "Saque realizado com sucesso da conta de ${this.titular.nome}. Valor: $valor"
    }

    fun depositar(valor: Double): String {
        if (valor <= 0) {
            return "Informe um valor maior do que zero"
        }
        this.saldo += valor
        return "Depósito realizado com sucesso na conta de ${this.titular.nome}. Valor: $valor"
    }

    fun transferir(contaDestino: Conta, valor: Double): String {
        if (valor <= 0) {
            return "Transferência não realizada da conta de ${this.titular.nome} para ${contaDestino.titular.nome}. Valor: $valor.\nMotivo: Informe um valor maior do que zero"
        }

        if (this.saldo < valor) {
            return "Transferência não realizada da conta de ${this.titular.nome} para ${contaDestino.titular.nome}. Valor: $valor.\nMotivo: Saldo insuficiente na conta de ${this.titular.nome}"
        }

        doTransferir(contaDestino, valor)
        return "Transferência realizada. De: ${this.titular.nome} para ${contaDestino.titular.nome}. Valor: $valor"
    }

    fun receber(): String {
        this.saldo += this.titular.salarioLiquido()
        return "Pagamento caiu na conta de ${this.titular.nome}. Valor: ${this.titular.salarioLiquido()}"
    }

    abstract fun render(): String
    abstract fun doSacar(valor: Double)
    abstract fun doTransferir(contaDestino: Conta, valor: Double)
}
