fun main() {
    val funcionarioCris = criarAnalista(nome = "Cris Louzada", cpf = "000.000.000-00", salario = 3500.0)
    val funcionarioRegis = criarAnalista(nome = "Regis Louzada", cpf = "333.333.333-33", salario = 2500.0)
    val funcionarioBruna = criarGerente(nome = "Bruna Sevilha", cpf = "111.111.111-11", salario = 6000.0)
    val funcionarioJoana = criarGerente(nome = "Joana Louzada", cpf = "444.444.444-44", salario = 5000.0)
    val funcionarioBerlim = criarDiretor(nome = "Berlim", cpf = "222.222.222-22", salario = 11000.0)
    val funcionarioFulano = criarDiretor(nome = "Fulano de Tal", cpf = "555.555.555-55", salario = 10000.0)

    val contaCris = criarContaCorrente(funcionarioCris, "Banco Bradesco", 27, 226843, 4)
    val contaRegis = criarContaCorrente(funcionarioRegis, "Banco Bradesco", 28, 101010, 5)
    val contaBruna = criarContaPoupanca(funcionarioBruna, "Banco do Brasil", 10, 102030, 5)
    val contaJoana = criarContaPoupanca(funcionarioJoana, "Caixa Econômica Federal", 11, 102040, 7)
    val contaBerlim = criarContaCorrente(funcionarioBerlim, "Banco Itaú", 29, 101112, 9)
    val contaFulano = criarContaPoupanca(funcionarioFulano, "Banco Santander", 30, 202122, 6)

    movimentarContas(contaCris, contaBruna)
    movimentarContas(contaRegis, contaJoana)
    movimentarContas(contaBerlim, contaFulano)
}

private fun movimentarContas(origem: Conta, destino: Conta) {
    println(origem.receber())
    println(origem.depositar(1000.0))
    println(origem.sacar(300.0))
    println(origem.render())
    avaliarConta(origem)

    println(destino.receber())
    println(destino.depositar(1000.0))
    println(destino.sacar(2000.0))
    println(destino.render())
    avaliarConta(destino)

    println(origem.transferir(destino, 500.0))
    avaliarConta(origem)
    avaliarConta(destino)
    println("----------")
}

private fun criarAnalista(nome: String, cpf: String, salario: Double): Funcionario {
    val funcionario = Analista(nome, cpf, salario)
    println("Bem vindo novo funcionário: ${funcionario.nome}")
    println("Salário base: ${funcionario.salario}")
    println("Bonificação: ${funcionario.bonificacao()}")
    println("Salario Líquido: ${funcionario.salarioLiquido()}")
    println("----------")
    return funcionario
}

private fun criarGerente(nome: String, cpf: String, salario: Double): Funcionario {
    val funcionario = Gerente(nome, cpf, salario)
    println("Bem vindo novo funcionário: ${funcionario.nome}")
    println("Salário base: ${funcionario.salario}")
    println("Bonificação: ${funcionario.bonificacao()}")
    println("Salario Líquido: ${funcionario.salarioLiquido()}")
    println("----------")
    return funcionario
}

private fun criarDiretor(nome: String, cpf: String, salario: Double): Funcionario {
    val funcionario = Diretor(nome, cpf, salario, 300.0)
    println("Bem vindo novo funcionário: ${funcionario.nome}")
    println("Salário base: ${funcionario.salario}")
    println("Bonificação: ${funcionario.bonificacao()}")
    println("Salario Líquido: ${funcionario.salarioLiquido()}")
    println("----------")
    return funcionario
}


private fun criarContaCorrente(titular: Funcionario, banco: String, agencia: Int, conta: Int, digito: Int): Conta {
    val contaCorrente = ContaCorrente(titular, banco, agencia, conta, digito)
    println("Bem vindo ao Bytebank ${contaCorrente.titular.nome}")
    println("Sua conta foi criada: ${contaCorrente.banco} (${contaCorrente.numeroAgencia} / ${contaCorrente.numeroConta}-${contaCorrente.digitoConta})")
    println("Saldo inicial da conta de ${contaCorrente.titular.nome}: ${contaCorrente.saldo}")
    println("----------")
    return contaCorrente
}

private fun criarContaPoupanca(titular: Funcionario, banco: String, agencia: Int, conta: Int, digito: Int): Conta {
    val contaPoupanca = ContaPoupanca(titular, banco, agencia, conta, digito)
    println("Bem vindo ao Bytebank ${contaPoupanca.titular.nome}")
    println("Sua conta foi criada: ${contaPoupanca.banco} (${contaPoupanca.numeroAgencia} / ${contaPoupanca.numeroConta}-${contaPoupanca.digitoConta})")
    println("Saldo inicial da conta de ${contaPoupanca.titular.nome}: ${contaPoupanca.saldo}")
    println("----------")
    return contaPoupanca
}

private fun avaliarConta(conta: Conta) {
    println("Saldo da conta de ${conta.titular.nome}: ${conta.saldo}")
    when {
        conta.saldo > 0.0 -> println("conta positiva")
        conta.saldo == 0.0 -> println("conta zerada")
        else -> println("conta negativa")
    }
}