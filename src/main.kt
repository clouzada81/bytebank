fun main() {
    val funcionarioCris = criarFuncionario(nome = "Cris Louzada", cpf = "000.000.000-00", salario = 2500.0);
    val funcionarioBruna = criarFuncionario(nome = "Bruna Sevilha", cpf = "111.111.111-11", salario = 5000.0)

    val contaCris = criarContaCorrente("Cris Louzada", "Banco Bradesco", 27, 226843, 4)
    val contaBruna = criarContaPoupanca("Bruna Sevilha", "Banco do Brasil", 10, 102030, 5)
    movimentarContas(contaCris, contaBruna)
}

private fun movimentarContas(contaCris: Conta, contaBruna: Conta) {
    println((contaCris.depositar(1000.0)).getMensagem())
    println((contaCris.sacar(300.0)).getMensagem())
    avaliarConta(contaCris)

    println((contaBruna.depositar(1000.0)).getMensagem())
    println((contaBruna.sacar(2000.0)).getMensagem())
    avaliarConta(contaBruna)

    println((contaCris.transferir(contaBruna, 500.0)).getMensagem())
    avaliarConta(contaCris)
    avaliarConta(contaBruna)
}

private fun criarFuncionario(nome: String, cpf: String, salario: Double): Funcionario {
    val funcionario = Funcionario(nome = nome, cpf = cpf, salario = salario)
    println("Bem vindo novo funcionário: ${funcionario.nome}")
    println("Salário base: ${funcionario.salario}")
    println("Bonificação: ${funcionario.bonificacao()}")
    println("----------")
    return funcionario
}

private fun criarContaCorrente(titular: String, banco: String, agencia: Int, conta: Int, digito: Int): Conta {
    val conta =
        ContaCorrente(titular = titular, banco = banco, numeroAgencia = agencia, numeroConta = conta, digitoConta = digito)
    println("Bem vindo ao Bytebank ${conta.titular}")
    println("Sua conta foi criada: ${conta.banco} (${conta.numeroAgencia} / ${conta.numeroConta}-${conta.digitoConta})")
    println("Saldo inicial da conta de ${conta.titular}: ${conta.saldo}")
    println("----------")
    return conta
}

private fun criarContaPoupanca(titular: String, banco: String, agencia: Int, conta: Int, digito: Int): Conta {
    val conta =
        ContaPoupanca(titular = titular, banco = banco, numeroAgencia = agencia, numeroConta = conta, digitoConta = digito)
    println("Bem vindo ao Bytebank ${conta.titular}")
    println("Sua conta foi criada: ${conta.banco} (${conta.numeroAgencia} / ${conta.numeroConta}-${conta.digitoConta})")
    println("Saldo inicial da conta de ${conta.titular}: ${conta.saldo}")
    println("----------")
    return conta
}

private fun avaliarConta(conta: Conta) {
    println("Saldo da conta de ${conta.titular}: ${conta.saldo}")
    when {
        conta.saldo > 0.0 -> println("conta positiva")
        conta.saldo == 0.0 -> println("conta zerada")
        else -> println("conta negativa")
    }
}