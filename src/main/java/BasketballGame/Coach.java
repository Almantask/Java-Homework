package BasketballGame;

public class Coach {

    private final Human coach;

    public Coach(Human coach) {
        this.coach = coach;
    }

    public String getCoachTitle() {
        return "Coach";
    }

    public Human getCoach() {
        return coach;
    }
}
