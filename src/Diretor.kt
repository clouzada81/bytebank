class Diretor(
    nome: String,
    cpf: String,
    salario: Double,
    senha: String,
    private var plr: Double
) : FuncionarioAdmin(
    nome = nome,
    cpf = cpf,
    salario = salario,
    senha = senha
) {

    override fun bonificacao(): Double {
        return salario * 0.3
    }

    override fun salarioLiquido(): Double {
        return salario + bonificacao() + plr
    }
}