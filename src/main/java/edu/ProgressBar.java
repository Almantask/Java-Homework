package edu;

// This class demonstrates encapsulation
// We hid the internal ProgressBar details
// And exposed all the functionality through methods
// This also demonstrates abstraction
// ProgressBar is a concept: can increase progress, can print progress
public class ProgressBar {
    // Assume process can only increase
    private float currentProgress;
    private float max;

    public ProgressBar(float currentProgress, float max) {
        if (currentProgress > max) {
            this.currentProgress = max;
        } else if(currentProgress >= 0){
            this.currentProgress = currentProgress;
        }
        if(max > 0){
            this.max = max;
        } else {
            // default max
            this.max = 100;
        }

    }

    // add negative or zero - does nothing
    // add plus positive - less than max or more tha max
    //

    public void addProgress(float increment){
        if(increment < 0) return;

        currentProgress+=increment;
        if(currentProgress > max){
            currentProgress = max;
        }
    }

    public float getProgress(){
        return currentProgress / max;
    }

    @Override
    public String toString() {
        String progress = "";
        float tenPercent = max * 0.1f;
        int stars = (int)(currentProgress / tenPercent);
        for (int i = 0; i < stars; i++) {
            progress +="#";
        }

        return progress;
    }
}
