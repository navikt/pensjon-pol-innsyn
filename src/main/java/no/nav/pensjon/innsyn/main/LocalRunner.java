package no.nav.pensjon.innsyn.main;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import no.nav.pensjon.innsyn.sink.FileOutputStreamCreator;

public class LocalRunner {
    public static void main(String[] args) {
        for (String fnr: args) {
            try {
                WorksheetProducer.produceWorksheet(fnr, new FileOutputStreamCreator());
                if(new File("poi-generated-file.xlsx").renameTo(new File(fnr+"-POPP-"+ LocalDate.now().toString()+".xlsx"))){
                    System.out.println("Generated file for data for "+fnr);
                } else {
                    System.out.println("Could not rename file for "+fnr);
                    return;
                }
            }catch(IOException e){
                System.out.println("Could not extract data for "+fnr);
                e.printStackTrace();
                return;
            }
        }
        System.out.println("Done.");
    }
}