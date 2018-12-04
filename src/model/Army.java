package model;

// TODO: Auto-generated Javadoc
/**
 * The Class Army.
 *
 * @author Exiele
 */
public class Army {

	/** The type. */
	private int type;

	/** The type name. */
	private String typeName;

	/** The size. */
	private int size;

	/**
	 * Instantiates a new army.
	 *
	 * @param type the type
	 * @param size the size
	 */
	public Army(int type, int size) {
		this.type = type;
		this.size = size;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * Gets the type name.
	 *
	 * @return the type name
	 */
	public String getTypeName() {
		return typeName;
	}

	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Adds to the army size.
	 *
	 * @param i the delta
	 */
	public void add(int i) {
		size = size + i;
	}

	/**
	 * Reset.
	 */
	public void reset() {
		size = 0;
	}
}
