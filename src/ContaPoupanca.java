
public class ContaPoupanca extends Conta {
    private double taxaDeJuros;

    public ContaPoupanca(Cliente cliente, double taxaDeJuros) {
        super(cliente);
        this.taxaDeJuros = taxaDeJuros;
    }

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Poupan�a ===");
		super.imprimirInfosComuns();
        System.out.println(String.format("Taxa de Juros: %.2f", this.taxaDeJuros)); // imprimir a taxa de juros}

        public double getTaxaDeJuros() { // novo método
            return taxaDeJuros;
        }

        public void setTaxaDeJuros(double taxaDeJuros) { // novo método
            this.taxaDeJuros = taxaDeJuros;
        }
    }
