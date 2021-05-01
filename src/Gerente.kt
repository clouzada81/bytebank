class Gerente(
    nome: String,
    cpf: String,
    salario: Double,
    senha: String
) : FuncionarioAdmin(
    nome = nome,
    cpf = cpf,
    salario = salario,
    senha = senha
) {

    override fun bonificacao(): Double {
        return salario * 0.2
    }

    override fun salarioLiquido(): Double {
        return salario + bonificacao()
    }
}