public class GameConfig {

    private final int max_attempts;
    private final int min;
    private final int max;

    public GameConfig(int max_attempts, int min, int max){
        this.max_attempts = max_attempts;
        this.min = min;
        this.max = max;
    }

    public int getMax_attempts(){
        return max_attempts;
    }

    public int getMin(){
        return min;
    }

    public int getMax(){
        return max;
    }
}
