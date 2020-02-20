package org.dominisoft.scrumdev.claro2020;

public class VoteRegister {
  private Cedula cedula;
  private String voteDate;

  /**
   * Vote register.
   */
  public VoteRegister() {
  }

  public Cedula getCedula() {
    return cedula;
  }

  public void setCedula(Cedula cedula) {
    this.cedula = cedula;
  }

  public String getVoteDate() {
    return voteDate;
  }

  public void setVoteDate(String voteDate) {
    this.voteDate = voteDate;
  }
}
