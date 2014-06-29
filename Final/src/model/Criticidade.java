package model;

public enum Criticidade {
	LOW("LOW", 1),
	MEDIUM("MEDIUM", 2),
	HIGH("HIGH", 3),
	CRITICAL("CRITICAL", 4),
	BLOCKER("BLOCKER", 5);

	private String descricao;
	private int ordem;

	private Criticidade(String descricao, int ordem) {
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
