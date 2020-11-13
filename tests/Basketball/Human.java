package Basketball;
//### 0- Human (EASY)
//Every memeber of a team has a name, birthday, age, nationality.

public class Human {
        private String name;
        private String birthday;
        private int age;
        private String nationality;

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getBirthday() {
                return birthday;
        }

        public void setBirthday(String birthday) {
                this.birthday = birthday;
        }

        public int getAge() {
                return age;
        }

        public void setAge(int age) {
                this.age = age;
        }

        public String getNationality() {
                return nationality;
        }

        public void setNationality(String nationality) {
                this.nationality = nationality;
        }

        public Human(String name, String birthday, int age, String nationality) {
                this.name = name;
                this.birthday = birthday;
                this.age = age;
                this.nationality = nationality;
        }

        @Override
        public String toString() {
                return "Human{" +
                        "name='" + name + '\'' +
                        ", birthday=" + birthday +
                        ", age=" + age +
                        ", nationality='" + nationality + '\'' +
                        '}';
        }
}
