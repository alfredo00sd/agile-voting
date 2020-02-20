package org.dominisoft.scrumdev.claro2020;

public class VoteRegister {
    Cedula cedula;
    String voteDate;

    public VoteRegister() {
    }

    public VoteRegister(Cedula cedula, String voteDate) {
        this.cedula = cedula;
        this.voteDate = voteDate;
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
