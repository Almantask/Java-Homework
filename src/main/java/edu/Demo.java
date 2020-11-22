package edu;

import edu.errors.InvalidTransferException;
import edu.protectedkeywordAndEnum.Gender;
import edu.protectedkeywordAndEnum.Human;
import edu.protectedkeywordAndEnum.Teacher;

import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException, InvalidTransferException {
        //edu.errors.Demo.run();
        edu.generics.Demo.run();
        //edu.protectedkeywordAndEnum.Demo.run();
        //edu.workingWithFiles.jsonxml.Demo.run();
        //edu.workingWithFiles.newio.Demo.run();
        //edu.workingWithFiles.oldio.Demo.run();
        //edu.workingWithFiles.jsonxml.Demo.run();

        //Human human = new Teacher("ka", Gender.FEMALE);
        // not ok
        // human.name = "";
    }
}
