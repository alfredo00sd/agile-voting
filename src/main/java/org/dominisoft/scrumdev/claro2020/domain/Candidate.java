package org.dominisoft.scrumdev.claro2020.domain;

public class Candidate {
  private String name;
  private String nickName;
  private String partic;

  /** This method creates a candidate.
   * @param name name
   * @param nickName nickname
   * @param partic partic
   */
  public Candidate(String name, String nickName, String partic) {
    this.name = name;
    this.nickName = nickName;
    this.partic = partic;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  public String getPartic() {
    return partic;
  }

  public void setPartic(String partic) {
    this.partic = partic;
  }

  public static Candidate instance(String[] arg) {
    return new Candidate(arg[0], arg[1], arg[2]);
  }

  @Override
  public String toString() {
    return "Candidate [name=" + name + ", nickName=" + nickName + ", partic=" + partic + "]";
  }

}
