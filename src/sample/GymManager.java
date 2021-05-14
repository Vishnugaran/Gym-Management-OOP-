package sample;

import java.io.IOException;
import java.util.ArrayList;

public interface GymManager {
    void addMember();
    void deleteMember();
    void printDetails();
    void sort();
    void writeAndSave() throws IOException;
    ArrayList<DefaultMember> members = new ArrayList<>();
}
