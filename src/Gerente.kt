class Gerente(
    nome: String,
    cpf: String,
    salario: Double,
) : Funcionario(
    nome = nome,
    cpf = cpf,
    salario = salario
) {

    override fun bonificacao(): Double {
        return salario * 0.2
    }

    override fun salarioLiquido(): Double {
        return salario + bonificacao()
    }
}