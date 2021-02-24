import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Podaj nazwe pierwszego pliku: ");
        String f1 = reader.readLine();
        System.out.println("Podaj nazwe drugiego pliku: ");
        String f2 = reader.readLine();

        Path f1_path;
        Path f2_path;
        BufferedReader file1_reader;
        BufferedReader file2_reader;
        ArrayList<Double> x = new ArrayList<>();
        ArrayList<Double> sum_y= new ArrayList<>();

        try
        {
            f1_path = Paths.get(f1);
            f2_path = Paths.get(f2);
            file1_reader = Files.newBufferedReader(f1_path);
            file2_reader = Files.newBufferedReader(f2_path);
            String line1, line2;
            line1 = file1_reader.readLine();
            line2 = file2_reader.readLine();
            while (line1 != null && line2 != null) {

                String x1, x2, y1, y2;
                x1 = line1.split(" ")[0];
                x2 = line2.split(" ")[0];
                y1 = line1.split(" ")[1];
                y2 = line2.split(" ")[1];

                if(!x1.equals(x2))
                {
                    System.out.println("Wartosci x nie sa identyczne dla obu plikow");
                    break;
                }
                else{
                    x.add(Double.parseDouble(x1));
                    sum_y.add(Double.parseDouble(y1)+Double.parseDouble(y2));
                }
                line1 = file1_reader.readLine();
                line2 = file2_reader.readLine();
            }
        }
        catch (Exception e)
        {
            System.out.println("Blad wczytania pliku - konczenie programu");
            System.exit(1);
        }

        System.out.println("Podaj nazwe dla pliku wyjsciowego: ");
        String output = reader.readLine();
        Path path = Paths.get(output);

        BufferedWriter writer = null;

        try{
            writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.WRITE);
            System.out.println("Plik o podanej nazwie już istnieje. Czy chcesz podac inna nazwe? " +
                    "Jezeli nie, plik zosatnie nadpisany (tak/nie)");

            output = reader.readLine();
            while(!output.equals("tak") && !output.equals("nie"))
            {
                System.out.println("Prosze podac odpowiedz 'tak' lub 'nie'");
                output = reader.readLine();
            }
            if(output.equals("tak"))
            {
                System.out.println("Podaj nowa nazwe");
                output = reader.readLine();
                path = Paths.get(output);
                writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.CREATE_NEW);
            }
            for (int i = 0; i < x.size(); i++)
                writer.write(String.format("%f %f\n", x.get(i), sum_y.get(i)));
        }
        catch(NoSuchFileException e)
        {
            writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.CREATE_NEW);
            for (int i = 0; i < x.size(); i++)
                writer.write(String.format("%f %f\n", x.get(i), sum_y.get(i)));
        }




    }


}
