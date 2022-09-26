import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {


    public static void main(String[] args) throws IOException {
        System.out.println("Please press x then enter to get list of all latest portfolio value per token in USD");
        System.out.println("Please press 1 then enter followed by token name then x and enter to get the latest portfolio value for that token in USD");
        System.out.println("Please press 2 then enter followed by date then x and enter to get the portfolio value per token in USD on that date");
        System.out.println("Please press 3 then enter followed by token name, enter, date, enter then x and enter to get the portfolio value per token in USD on that date for that particualr token");
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        String token="";
        String date="";
        String line;
        List<String> lineList= new ArrayList<>();

        while (!((line=reader.readLine()).equals("x"))) {

            lineList.add(line);

        }
        if(lineList.size()==0){

            getPortfolioPerToken();
        }else if(lineList.get(0).equals("1")){
            token=lineList.get(1);
            getPortfolioForAToken(token);
        }
        else if(lineList.get(0).equals("2")){
            date=lineList.get(1);
            getPortfolioPerTokenForAGivenDate(date);
        }

        else if(lineList.get(0).equals("3")){
            token=lineList.get(1);
            date=lineList.get(2);

            getPortfolioPerTokenForAGivenDateNToken(date,token);
        }

        lineList.clear();



    }


    private static void getPortfolioPerToken(){

        try{
            BufferedReader br = new BufferedReader(new FileReader("/home/kibe/kibe.com/propine.csv"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if(values.length==4){
                System.out.println(values[2]+" "+  values[3]);}

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    private static void getPortfolioForAToken(String token){


        try {
            BufferedReader br = new BufferedReader(new FileReader("/home/kibe/kibe.com/propine.csv"));

            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if(values.length==4&&values[2].equals(token)){
                    System.out.println(values[2]+" "+  values[3]);
                }


            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static void getPortfolioPerTokenForAGivenDate(String date){
        try {
            BufferedReader br = new BufferedReader(new FileReader("/home/kibe/kibe.com/propine.csv"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if(values.length==4&&values[0].equals(date)){
                    System.out.println(values[2]+" "+  values[3]);
                }


            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    private static void getPortfolioPerTokenForAGivenDateNToken(String date, String token){

        try {
            BufferedReader br = new BufferedReader(new FileReader("/home/kibe/kibe.com/propine.csv"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if(values.length==4&&values[2].equals(token)&&values[0].equals(date)){
                    System.out.println(values[2]+" "+  values[3]);
                }


            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
