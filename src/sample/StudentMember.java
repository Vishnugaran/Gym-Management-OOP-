package sample;

public class StudentMember extends DefaultMember {
    private String schoolName;

    public StudentMember(String membershipNumber, String memberName, Date startMembershipDate, String schoolName) {
        super(membershipNumber, memberName, startMembershipDate);
        this.schoolName = schoolName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Override
    public String toString() {
        return super.toString() +
                "schoolName='" + schoolName + '\'' +
                '}';
    }
}
