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

	public static Tipo getEnumByDescricao(String value) {
		for(Tipo e: Tipo.values()) {
			if(e.getDescricao().equals(value)) {
				return e;
			}
		}
		return null;
	}

	public static Tipo getEnumById(int id) {
		for(Tipo e: Tipo.values()) {
			if(e.getOrdem() == id) {
				return e;
			}
		}
		return null;
	}
}
