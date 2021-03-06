package model;

public enum Estado {
	NOVO("NOVO", 1),
	ABERTO("ABERTO", 2),
	ATRIBUIDO("ATRIBUIDO", 3),
	EM_DEV("EM DESENVOLVIMENTO", 4),
	DUPLICADO("DUPLICADO", 5),
	WONT_FIX("WONT FIX", 6),
	CLOSED("CLOSED", 7);

	private String descricao;
	private int ordem;

	private Estado(String descricao, int ordem) {
		this.descricao = descricao;
		this.ordem = ordem;
	}
	public String getDescricao() {
		return descricao;
	}

	public int getOrdem() {
		return ordem;
	}

	public static Estado getEnumByDescricao(String value) {
		for(Estado e: Estado.values()) {
			if(e.getDescricao().equals(value)) {
				return e;
			}
		}
		return null;
	}

	public static Estado getEnumById(int id) {
		for(Estado e: Estado.values()) {
			if(e.getOrdem() == id) {
				return e;
			}
		}
		return null;
	}
}
