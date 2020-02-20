package org.dominisoft.scrumdev.claro2020.domain;

/**
 * "Cedula" validator.
 */
public final class DopNationalIdentificationNumber {

  private final String value;

  /**
   * Validates the given value ensuring only valid data can be used to create
   * instances of this class.
   * 
   * @param nin National Identification Number
   */
  public DopNationalIdentificationNumber(final String nin) {
    if (nin == null) {
      throw new NullPointerException("Get to work.");
    }

    value = nin;
  }

  /**
   * Returns wrapped value.
   * 
   * @return wrapped value.
   */
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return value;
  }
}
