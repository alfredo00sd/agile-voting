package org.dominisoft.scrumdev.claro2020;

public class Cedula {

  private String cedula;
  private boolean hasVote;


  public Cedula() {

  }

  public Cedula(String cedula) {
    this.cedula = cedula;
  }

  public boolean validateLength() {
    return cedula.length() == 11;
  }

  public boolean validateHasVote(){
    return hasVote;
  }

  /**
   * Validates the gov id.
   * @return boolean
   */
  public boolean validateCedula() {

    int suma = 0;
    String cedula = getCedula();

    final char[] peso = { '1', '2', '1', '2', '1', '2', '1', '2', '1', '2' };

    // Comprobaciones iniciales
    if (cedula == null || cedula.length() != 11) {
      return false;
    }

    // Si no es un nº => la descartamos
    try {
      Long.parseLong(cedula);
    } catch (Exception e) {
      return false;
    }

    for (int i = 0; i < 10; i++) {

      int a = Character.getNumericValue(cedula.charAt(i));

      int b = Character.getNumericValue(peso[i]);

      char[] mult = Integer.toString(a * b).toCharArray();

      if (mult.length > 1) {
        a = Character.getNumericValue(mult[0]);
        b = Character.getNumericValue(mult[1]);
      } else {
        a = 0;
        b = Character.getNumericValue(mult[0]);
      }
      suma = suma + a + b;
    }

    int digito = (10 - (suma % 10)) % 10;

    // Comprobamos que el dígito de control coincide
    if (digito != Character.getNumericValue(cedula.charAt(10))) {
      return false;
    }
    return true;
  }

  public void setHasVote(boolean hasVote) {
    this.hasVote = hasVote;
  }

  public String getCedula() {
    return cedula;
  }

  public void setCedula(String cedula) {
    this.cedula = cedula;
  }

}
