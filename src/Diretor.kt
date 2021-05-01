class Diretor(
    nome: String,
    cpf: String,
    salario: Double,
    var plr: Double
) : Funcionario(
    nome = nome,
    cpf = cpf,
    salario = salario
) {

    override fun bonificacao(): Double {
        return salario * 0.3
    }

    override fun salarioLiquido(): Double {
        return salario + bonificacao() + plr
    }
}