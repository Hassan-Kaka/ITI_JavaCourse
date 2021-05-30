import joinery.DataFrame;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.*;

public class Joinery {
    public static void main(String[] args) throws IOException {
        //load the Titanic data as CSV file
        DataFrame<Object> dataframe = DataFrame.readCsv("titanic.csv");
        System.out.println(dataframe.describe());
        //Get max value for parch
        System.out.print("Max value for parch: ");
        System.out.println(dataframe.describe().col(4).get(4));
        //Adding new Column
        Joinery join = new Joinery();
        DataFrame newdf = join.addNewColumn(dataframe).describe();
        System.out.println(newdf);

        //select column and get analysis from it
        System.out.println(dataframe.retain(1).describe());
        //Get mean and max from DataFrame
        DataFrame<Object> analysis = DataFrame.readCsv("titanic.csv").retain("survived","age","sibsp");
        System.out.print("Mean is: ");
        analysis.mean().iterrows().forEachRemaining(System.out::println);
        System.out.print("Max is: ");
        analysis.max().iterrows().forEachRemaining(System.out::println);
        //Creating two dataframes and perform (join and merge)
        DataFrame<Object> df11 = dataframe.retain("name" , "age").dropna().unique("name");
        DataFrame<Object> df22 = dataframe.retain("name" , "sex").dropna().unique("name");
        DataFrame<Object> joinResult = df11.join(df22,DataFrame.JoinType.LEFT);
        System.out.println("The Result of left join using two DataFrames");
        System.out.println(joinResult);

        DataFrame<Object> mergeResult = df11.merge(df22, DataFrame.JoinType.INNER);
        System.out.println("The Result of merging two DataFrames");
        System.out.println(mergeResult);
    }


      //Function to add column on data frame
      DataFrame addNewColumn(DataFrame df){
        List<Integer> newCol = new ArrayList<>();
        for (int i = 0 ; i< df.length();i++){
            newCol.add(i+1);
        }
        return df.add("New Column",newCol);
    }
}