class Analista(
    nome: String,
    cpf: String,
    salario: Double,
) : Funcionario(
    nome = nome,
    cpf = cpf,
    salario = salario
) {
    override fun bonificacao(): Double {
        return this.salario * 0.1
    }

    override fun salarioLiquido(): Double {
        return salario + bonificacao()
    }
}