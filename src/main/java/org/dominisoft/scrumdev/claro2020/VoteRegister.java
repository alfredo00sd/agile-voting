package org.dominisoft.scrumdev.claro2020;

import org.dominisoft.scrumdev.claro2020.domain.Candidate;

public class VoteRegister {
    public Cedula cedula;
    private Candidate candidate;
    private String date;

    /**
     * Vote register.
     */
    public VoteRegister() {
    }

  /**
   * Vote Register
   * @param cedula
   * @param candidate
   * @param date
   */
    public VoteRegister(Cedula cedula, Candidate candidate, String date) {
        this.cedula = cedula;
        this.candidate = candidate;
        this.date = date;
    }

    public Cedula getCedula() {
        return cedula;
    }

    public void setCedula(Cedula cedula) {
        this.cedula = cedula;
    }

    public Candidate getCandidate() { return candidate; }

    public void setCandidate(Candidate candidate) { this.candidate = candidate; }

    public String getDate() { return date; }

    public void setDate(String date) { this.date = date; }

    @Override
    public String toString() {
        return "VoteRegister{" +
                "cedula=" + cedula +
                ", candidate=" + candidate +
                ", date='" + date + '\'' +
                '}';
    }
}
