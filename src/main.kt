fun main() {
    val funcionarioCris = criarAnalista("Cris Louzada", "000.000.000-00", 3500.0)
    val funcionarioRegis = criarAnalista("Regis Louzada", "333.333.333-33", 2500.0)
    val funcionarioBruna = criarGerente("Bruna Sevilha", "111.111.111-11", 6000.0, "bruna@2021")
    val funcionarioJoana = criarGerente("Joana Louzada", "444.444.444-44", 5000.0, "joaninha")
    val funcionarioBerlim = criarDiretor("Berlim", "222.222.222-22", 11000.0, "ze ruela")
    val funcionarioFulano = criarDiretor("Fulano de Tal", "555.555.555-55", 10000.0, "beltrano")

    val contaCris = criarContaCorrente(funcionarioCris, "Banco Bradesco", 27, 226843, 4)
    val contaRegis = criarContaCorrente(funcionarioRegis, "Banco Bradesco", 28, 101010, 5)
    val contaBruna = criarContaPoupanca(funcionarioBruna, "Banco do Brasil", 10, 102030, 5)
    val contaJoana = criarContaPoupanca(funcionarioJoana, "Caixa Econômica Federal", 11, 102040, 7)
    val contaBerlim = criarContaCorrente(funcionarioBerlim, "Banco Itaú", 29, 101112, 9)
    val contaFulano = criarContaPoupanca(funcionarioFulano, "Banco Santander", 30, 202122, 6)

    movimentarContas(origem = contaCris, destino = contaBruna)
    movimentarContas(origem = contaRegis, destino = contaJoana)
    movimentarContas(origem = contaBerlim, destino = contaFulano)

    val areaRestrita = AreaRestrita()
    areaRestrita.login(admin = funcionarioBruna, senha = "bruna@2021")
    areaRestrita.login(admin = funcionarioJoana, senha = "joaninha")
    areaRestrita.login(admin = funcionarioBerlim, senha = "ze ruela")
    areaRestrita.login(admin = funcionarioFulano, senha = "jaspion")

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
    val funcionario = Analista(nome = nome, cpf = cpf, salario = salario)
    println("Bem vindo novo funcionário: ${funcionario.nome}")
    println("Salário base: ${funcionario.salario}")
    println("Bonificação: ${funcionario.bonificacao()}")
    println("Salario Líquido: ${funcionario.salarioLiquido()}")
    println("----------")
    return funcionario
}

private fun criarGerente(nome: String, cpf: String, salario: Double, senha: String): FuncionarioAdmin {
    val funcionario = Gerente(nome = nome, cpf = cpf, salario = salario, senha = senha)
    println("Bem vindo novo funcionário: ${funcionario.nome}")
    println("Salário base: ${funcionario.salario}")
    println("Bonificação: ${funcionario.bonificacao()}")
    println("Salario Líquido: ${funcionario.salarioLiquido()}")
    println("----------")
    return funcionario
}

private fun criarDiretor(nome: String, cpf: String, salario: Double, senha: String): FuncionarioAdmin {
    val funcionario = Diretor(nome = nome, cpf = cpf, salario = salario, senha = senha, plr = 300.0)
    println("Bem vindo novo funcionário: ${funcionario.nome}")
    println("Salário base: ${funcionario.salario}")
    println("Bonificação: ${funcionario.bonificacao()}")
    println("Salario Líquido: ${funcionario.salarioLiquido()}")
    println("----------")
    return funcionario
}


private fun criarContaCorrente(titular: Funcionario, banco: String, agencia: Int, conta: Int, digito: Int): Conta {
    val contaCorrente = ContaCorrente(titular = titular,
        banco = banco, numeroAgencia = agencia, numeroConta = conta, digitoConta = digito)

    println("Bem vindo ao Bytebank ${contaCorrente.titular.nome}")
    println("Sua conta foi criada: ${contaCorrente.banco} (${contaCorrente.numeroAgencia} / ${contaCorrente.numeroConta}-${contaCorrente.digitoConta})")
    println("Saldo inicial da conta de ${contaCorrente.titular.nome}: ${contaCorrente.saldo}")
    println("----------")
    return contaCorrente
}

private fun criarContaPoupanca(titular: Funcionario, banco: String, agencia: Int, conta: Int, digito: Int): Conta {
    val contaPoupanca = ContaPoupanca(titular = titular,
        banco = banco, numeroAgencia = agencia, numeroConta = conta, digitoConta = digito)
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