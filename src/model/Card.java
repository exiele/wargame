package model;

// TODO: Auto-generated Javadoc
/**
 * The Enum Card.
 */
public enum Card {

	/** The ac. */
	/* Norte */AC("Quadrado"),

	/** The am. */
	AM("Triângulo"),

	/** The ap. */
	AP("Círculo"),

	/** The pa. */
	PA("Quadrado"),

	/** The ro. */
	RO("Triângulo"),

	/** The rr. */
	RR("Círculo"),

	/** The al. */
	/* Nordeste */AL("Quadrado"),

	/** The ba. */
	BA("Triângulo"),

	/** The ce. */
	CE("Círculo"),

	/** The ma. */
	MA("Quadrado"),

	/** The pe. */
	PE("Triângulo"),

	/** The pb. */
	PB("Círculo"),

	/** The pi. */
	PI("Quadrado"),

	/** The rn. */
	RN("Triângulo"),

	/** The se. */
	SE("Círculo"),

	/** The es. */
	/* Sudeste */ES("Quadrado"),

	/** The mg. */
	MG("Triângulo"),

	/** The rj. */
	RJ("Círculo"),

	/** The sp. */
	SP("Quadrado"),

	/** The go. */
	/* Centro-oeste */GO("Triângulo"),

	/** The mt. */
	MT("Círculo"),

	/** The pr. */
	/* Sul */PR("Quadrado"),

	/** The rs. */
	RS("Triângulo"),

	/** The sc. */
	SC("Círculo"),

	/** The coringa2. */
	CORINGA2("Coringa"),

	/** The coringa1. */
	CORINGA1("Coringa");

	/** The shape. */
	public String shape;

	/**
	 * Instantiates a new card.
	 *
	 * @param shape the shape
	 */
	Card(String shape) {
		this.shape = shape;
	}
}
