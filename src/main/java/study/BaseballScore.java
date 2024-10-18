package study;

public class BaseballScore {
    private int strikeCnt;
    private int ballCnt;
    private int nothingCnt;


    public BaseballScore() {
        this.strikeCnt = 0;
        this.ballCnt = 0;
        this.nothingCnt = 0;
    }

    public BaseballScore(int strikeCnt, int ballCnt, int nothingCnt) {
        this.strikeCnt = strikeCnt;
        this.ballCnt = ballCnt;
        this.nothingCnt = nothingCnt;
    }


    public void addScore(int index, int i){
        if (index == -1){
            nothingCnt++;
        } else if (index == i){
            strikeCnt++;
        } else if(index != i){
            ballCnt++;
        }
    }

    public boolean isThreeStrike(){
        return strikeCnt == 3;
    }

    public String printScore(){
        if(nothingCnt == 3) {
            return "낫싱";
        } else if (ballCnt != 0 && strikeCnt != 0){
            return ballCnt + "볼 " + strikeCnt + "스트라이크";
        } else if (ballCnt == 0 && strikeCnt != 0){
            return strikeCnt + "스트라이크";
        } else if(ballCnt != 0){
            return ballCnt + "볼";
        }

        return "";
    }

    public int getStrikeCnt() {
        return strikeCnt;
    }

    public int getBallCnt() {
        return ballCnt;
    }

    public int getNothingCnt() {
        return nothingCnt;
    }
}
