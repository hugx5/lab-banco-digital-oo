
public abstract class Conta implements IConta {
    private static final double LIMITE_ALERTA = 100.0; // limite para emitir alerta

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    //O motivo pelo qual ele é privado é que ele é um detalhe de implementação interno da classe Conta que não precisa ser exposto para outras classes.
    // Ele é chamado automaticamente sempre que um saque é feito, para verificar se o saldo da conta caiu abaixo do limite de alerta.
    private void emitirAlertaSaldoBaixo() {
        if (this.saldo < LIMITE_ALERTA) {
            System.out.println(String.format("Atenção: o saldo da conta %d está abaixo do limite de alerta: %.2f", this.numero, this.saldo));
        }
    }

    @Override
    public void sacar(double valor) {
        if (valor > 0 && valor <= this.saldo) {
            this.saldo -= valor;
            emitirAlertaSaldoBaixo(); // verificar o saldo após o saque
        }
    }

    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
        }
    }


    @Override
    public void transferir(double valor, IConta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }
}
