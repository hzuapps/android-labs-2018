package edu.hzuapps.androidlabs.soft1614080902221;

//保存一个玩家的信息和游戏记录
public class PlayerData {
    private String playerName;
    private String sex;
    private String gameCharacters;
    private int time;

    public PlayerData(String playerName, String sex, String gameCharacters, int time) {
        this.playerName = playerName;
        this.sex = sex;
        this.gameCharacters = gameCharacters;
        this.time = time;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getGameCharacters() {
        return gameCharacters;
    }

    public void setGameCharacters(String gameCharacters) {
        this.gameCharacters = gameCharacters;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}