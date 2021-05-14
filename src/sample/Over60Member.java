package sample;

public class Over60Member extends DefaultMember {
    private int age;

    public Over60Member(String membershipNumber, String memberName, Date startMembershipDate, int age) {
        super(membershipNumber, memberName, startMembershipDate);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return
                "age=" + age +
                '}';
    }
}
