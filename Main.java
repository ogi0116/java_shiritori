package practice4;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Siritori12{
  public static main(String[] args){
    boolean flag = true;
    String word = new String();
    System.out.println("言葉を入力してください");
    System.out.println("シリトリ");
    String data = "シリトリ";
    List<String> used = new ArrayList<>();

    int i = 0;
    while(i<5){
      String inputstr;
      inputstr = new java.util.Scanner(System.in).nextLine();

      if(Katakana(inputstr)==false){
        continue;
      }

      if(!(data.charAt(data.length()-1) == inputstr.charAt(0))){
        System.out.println("やり直し");
        flag = false;
      }

      if(used.contains(inputstr)){
        System.out.println("その言葉は既に使用しています")
        flag = false;
      }

      used.add(inputstr);
      inputstr = toUpper(inputstr);
      inputstr = remove(inputstr);
      if(flag){
        System.out.println((i+1)+"回目");
        System.out.println("自分:"+ inputstr);

        try{
          File file = new File("C:\\辞書\\sakura.txt");
          if (!file.exists()){
            System.out.println("ファイルなし")
            return;
          }

          FileReader fileReader = new FileReader(file);
          BufferedReader bufferedReader = new BufferedReader(fileReader);

          while((data = bufferedReader.readLine()) != null){
            word = data;
            data = toUppeer(data);
            data = remove(data);
            if(inputstr.charAt(inputstr.length() - 1) == data.charAt(0)){
              if(!used.contains(word)){
                System.out.println("com:" + data);
                break
              }
            }
          }

        }
      }
    }
  }
}