package FileHelper;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.File;

public class RankingFileHandler {
    
    public static void writeRanking(String playerData) {
        String fileName = "ranking.txt";
        try {
            PrintWriter writer = new PrintWriter(new FileOutputStream(new File(fileName), true));
            writer.println(playerData);
            writer.close();
        } catch (Exception e) {
            System.out.println("Error writing to file");
        }
    }

}
