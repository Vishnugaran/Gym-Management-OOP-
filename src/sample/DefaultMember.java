package sample;

import java.util.Objects;

public class DefaultMember {
    private String membershipNumber;
    private String memberName;
    private sample.Date startMembershipDate;
    private String type;

    public DefaultMember(String membershipNumber, String memberName, Date startMembershipDate) {
        this.membershipNumber = membershipNumber;
        this.memberName = memberName;
        this.startMembershipDate = startMembershipDate;
    }


    public DefaultMember(String membershipNumber, String memberName, Date startMembershipDate, String type) {
        this.membershipNumber = membershipNumber;
        this.memberName = memberName;
        this.startMembershipDate = startMembershipDate;
        this.type = type;
    }
    //Getter and Setter Creation
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMembershipNumber() {
        return membershipNumber;
    }

    public void setMembershipNumber(String membershipNumber) {
        this.membershipNumber = membershipNumber;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public Date getStartMembershipDate() {
        return startMembershipDate;
    }

    public void setStartMembershipDate(Date startMembershipDate) {
        this.startMembershipDate = startMembershipDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultMember that = (DefaultMember) o;
        return Objects.equals(membershipNumber, that.membershipNumber) &&
                Objects.equals(memberName, that.memberName) &&
                Objects.equals(startMembershipDate, that.startMembershipDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(membershipNumber, memberName, startMembershipDate);
    }

    @Override
    public String toString() {
        return "{" +
                "membershipNumber='" + membershipNumber + '\'' +
                ", memberName='" + memberName + '\'' +
                ", startMembershipDate=" + startMembershipDate +
                '}';
    }
}
