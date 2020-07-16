package test;

import com.company.SWERC2019K2;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Test {
    private static int n = 1;


    private static String input = ".in";
    private static String output = ".ans";
    private static String problem = "birdwatching";
    private static String name = "/Users/alejandro/Downloads/swerc-testcases/"+problem+"/secret/";

    String toStr(int n){
        if(n == n%10)
            return "test0" + n;
        return "test" + n;
    }


    @org.junit.jupiter.api.BeforeEach
    void setUp() throws FileNotFoundException {
        //outputFile = new File("temp.txt");
        //System.setOut(new PrintStream(new FileOutputStream(outputFile)));
        //System.setIn(new FileInputStream(file));
    }


    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        // Not required
        //System.setOut(System.out);
        //outputFile.delete();
    }

    @org.junit.jupiter.api.Test
    void testProblem() throws FileNotFoundException, IOException {

        String nombreTest= "/Users/alejandro/Downloads/swerc-testcases/birdwatching/data/secret/";

        File file = new File(nombreTest);
        BufferedReader brIn, brAns;
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                String name = pathname.getName();
                return name.contains(".in") && !name.contains("01");
            }
        };

        for(File f: file.listFiles(fileFilter)){
            System.err.println("Test:\t" + f.getName());
            File fileOut = new File("temp.txt");
            System.setIn(new FileInputStream(f));
            System.setOut(new PrintStream(new FileOutputStream(fileOut)));
            File answerFile = new File(f.getName().replace(".in",".ans"));

            brAns = new BufferedReader(new InputStreamReader(new FileInputStream(nombreTest+answerFile)));
            brIn = new BufferedReader(new InputStreamReader(new FileInputStream("temp.txt")));

            long TInicio, TFin, tiempo; //Variables para determinar el tiempo de ejecución
            TInicio = System.currentTimeMillis();

            SWERC2019K2.main(new String[1]);

            TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
            tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
            System.err.println("Tiempo de ejecución en segundos: " + (double) tiempo/1000);

            String lineAns, lineProblem;

            while(((lineProblem = brIn.readLine()) != null) && ((lineAns = brAns.readLine()) != null)){
                assertEquals(lineProblem, lineAns);
            }

            brIn.close();
            brAns.close();

            System.setIn(System.in);
            System.setOut(System.out);
            fileOut.delete();
        }

    }
}
