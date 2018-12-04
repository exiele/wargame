package model;

// TODO: Auto-generated Javadoc
/**
 * The Enum Territory.
 */
public enum Territory {

	/** The ac. */
	/* Norte */AC("AC", "Norte", "Acre", "AM,RO"),

	/** The am. */
	AM("AM", "Norte", "Amazonas", "AC,RO,RR,PA,MT"),

	/** The ap. */
	AP("AP", "Norte", "Amapá", "PA"),

	/** The pa. */
	PA("PA", "Norte", "Pará", "AM,RR,AP,MT,GO,MA"),

	/** The ro. */
	RO("RO", "Norte", "Território de Rondonia", "AC,AM,MT"),

	/** The rr. */
	RR("RR", "Norte", "Território de Roraima", "AM,PA"),

	/** The al. */
	/* Nordeste */AL("AL", "Nordeste", "Alagoas", "SE,BA,PE"),

	/** The ba. */
	BA("BA", "Nordeste", "Bahia", "ES,MG,GO,PI,PE,AL,SE"),

	/** The ce. */
	CE("CE", "Nordeste", "Ceará", "RN,PB,PE,PI"),

	/** The ma. */
	MA("MA", "Nordeste", "Maranhão", "PI,GO,PA"),

	/** The pe. */
	PE("PE", "Nordeste", "Pernambuco", "PB,AL,BA,PI,CE"),

	/** The pb. */
	PB("PB", "Nordeste", "Paraíba", "RN,PE,CE"),

	/** The pi. */
	PI("PI", "Nordeste", "Piauí", "CE,PE,BA,GO,MA"),

	/** The rn. */
	RN("RN", "Nordeste", "Rio Grande do Norte", "PB,CE"),

	/** The se. */
	SE("SE", "Nordeste", "Sergipe", "AL,BA"),

	/** The es. */
	/* Sudeste */ES("ES", "Sudeste", "Espírito Santo", "BA,RJ,MG"),

	/** The mg. */
	MG("MG", "Sudeste", "Minas Gerais", "ES,RJ,SP,MT,GO,BA"),

	/** The rj. */
	RJ("RJ", "Sudeste", "Rio de Janeiro", "ES,SP,MG"),

	/** The sp. */
	SP("SP", "Sudeste", "São Paulo", "RJ,PR,MT,MG"),

	/** The go. */
	/* Centro-oeste */GO("GO", "Centro-oeste", "Goiás", "MA,PI,BA,MG,MT,PA"),

	/** The mt. */
	MT("MT", "Centro-oeste", "Mato Grosso", "RO,AM,PA,GO,MG,SP,PR"),

	/** The pr. */
	/* Sul */PR("PR", "Sul", "Paraná", "MT,SP,SC"),

	/** The rs. */
	RS("RS", "Sul", "Rio Grande do Sul", "SC"),

	/** The sc. */
	SC("SC", "Sul", "Santa Catarina", "PR,RS");

	/** The name. */
	public String name;

	/** The neighbours. */
	public String neighbours;

	/** The region. */
	public String region;

	/** The id. */
	public String id;

	/**
	 * Instantiates a new territory.
	 *
	 * @param id         the id
	 * @param region     the region
	 * @param name       the name
	 * @param neighbours the neighbours
	 */
	private Territory(String id, String region, String name, String neighbours) {
		this.id = id;
		this.name = name;
		this.region = region;
		this.neighbours = neighbours;
	}
}
