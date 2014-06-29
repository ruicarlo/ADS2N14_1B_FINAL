package model;

public enum Tipo {
	BUG("BUG", 1),
	ENHANCEMENT("ENHANCEMENT", 2);

	private String descricao;
	private int ordem;

	private Tipo(String descricao, int ordem) {
		this.descricao = descricao;
		this.ordem = ordem;
	}
	public String getDescricao() {
		return descricao;
	}

	public int getOrdem() {
		return ordem;
	}
}
