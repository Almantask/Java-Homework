package Advent;

public class Day2 {
    public static void main(String[] args) {
        String program = FileUtil.loadFile("src/java/Advent/day2").get(0);
        String[] programList = program.split(",");


        int pc = 0;
        boolean run = true;
        while (run) {

            int opcode = Integer.parseInt(programList[pc]);
            int position1;
            int position2;
            int result;


            switch (opcode) {

                case 1:
                    position1 = Integer.parseInt(programList[pc + 1]);
                    position2 = Integer.parseInt(programList[pc + 2]);
                    result = Integer.parseInt(programList[position1]) + Integer.parseInt(programList[position2]);
                    programList[Integer.parseInt(programList[pc + 3])] = String.valueOf(result);
                    break;
                case 2:
                    position1 = Integer.parseInt(programList[pc + 1]);
                    position2 = Integer.parseInt(programList[pc + 2]);
                    result = Integer.parseInt(programList[position1]) + Integer.parseInt(programList[position2]);
                    programList[Integer.parseInt(programList[pc + 3])] = String.valueOf(result);
                    break;
                default:
                    run = false;
                    break;
            }
            pc += 4;
        }
        System.out.println(programList[0]);
    }
}