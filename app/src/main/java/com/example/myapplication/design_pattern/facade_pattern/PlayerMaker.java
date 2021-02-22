package com.example.myapplication.design_pattern.facade_pattern;


/**
 *
 * PlayerMaker 外观模式
 */
public class PlayerMaker {
    private PicturePlayer picturePlayer;
    private VideoPlayer videoPlayer;

    public PlayerMaker() {
        picturePlayer = new PicturePlayer();
        videoPlayer = new VideoPlayer();
    }

    public void playPicture() {
        picturePlayer.play();
    }

    public void playVideo() {
        videoPlayer.play();
    }

    private static void main(String[] args){
        PlayerMaker maker = new PlayerMaker();
        maker.playVideo();
        maker.playPicture();
    }

}
