public class Main{
    public static void main(String[] args) {
        
        MusicBox mbox = new MusicBox("S34TG65", 'Y', "Raindrops", "Misty", 
        "The path less traveled", "Country", "BZEE Music", "Rhythm Divine");

        System.out.println("Now playing the song");
        mbox.playSong(mbox.getSongID(), mbox.getPremiumSong(), 2);

        MusicBox anotherMusicBox = new MusicBox("NewSongID", 'N', "New Song Title", "New Artist", "New Album", "Pop", "New Producer", "New Label",0);
        System.out.println("Now playing another song");
        
anotherMusicBox.playSong(anotherMusicBox.getSongID(),anotherMusicBox.getPremiumSong(), 1);
        // --- TODO

        /* Repeat the above code to create another object  
         * Pass different parameters to the MusicBox constructor, but initialise premiumSong to N and when calling the
         * playSong method, pass ads parameter as just 1
         * 
         * 
        */
        

    }
}




