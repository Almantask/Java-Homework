package edu;

import edu.protectedkeywordAndEnum.Gender;
import edu.protectedkeywordAndEnum.Teacher;

public class GoodTeacher extends Teacher {
    public GoodTeacher(String name, Gender gender) {
        super(name, gender);
        // Ok
        //this.name = "";
    }
}
