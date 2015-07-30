package models;

public enum DiaDaSemana {
	SEGUNDA(2, "Segunda"), TERCA(3, "Terça"),QUARTA(4, "Quarta"), 
	QUINTA(5, "Quinta"), SEXTA(6, "Sexta");

	private final Integer tipo;

	private final String descricao;

	private DiaDaSemana(Integer tipo, String descricao) {
		this.tipo = tipo;
		this.descricao = descricao;
	}

	public Integer getTipo() {
		return tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	@Override
	public String toString() {
		return descricao;
	}
	
	
}
