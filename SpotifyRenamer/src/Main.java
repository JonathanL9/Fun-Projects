import java.io.File;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\DELL\\Desktop\\The Wild Robot SoundTrack";
        String remove = "[SPOTDOWNLOADER.COM]";

        File myPlayList = new File(filePath);
        File[] mySongs = myPlayList.listFiles();

        if(mySongs!= null){
            for (File song : mySongs){
              String oldName= song.getName();
              String newName= oldName.replace(remove,"");

              File renamed = new File(filePath + "/" + newName);
              if(song.renameTo(renamed)){
                  System.out.println("Old Name : " + oldName +"\nNew Name : " + newName);
              }
              else System.out.println("Error Renaming the File");
            }
        }

        System.out.println("You did it Jo!!!! You're First Project !!!");
        }
    }
