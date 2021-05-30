import tech.tablesaw.api.Table;

import java.io.IOException;

public class TableSaw {

    public static void main (String[] args) throws IOException {
        Table tab = Table.read().csv("titanic.csv");
        System.out.println("Structure: "+tab.structure());
        System.out.println("Summary of Data: "+tab.summary());

    }
}
