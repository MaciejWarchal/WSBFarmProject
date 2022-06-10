package system;

public class TextSearching {

    public static String findText(String text,String findAfter,char stopMark){


           /* String text = ("User{id=1, name='ewe', isSuperUser=true, isManager=false, isEmployee=false, password='grg'}");
            String findAfter = ("name=");   // po tym nastapi czytanie                           //parametry
            char stopMark = (',');           // przed tym zostanie zakonczone czytanie
           */
        char[] findAfterTab= new char[findAfter.length()];           // tablice robocze
        char[] textTab= new char[text.length()];


        for (int j = 0; j < findAfter.length(); j++) {             //wypelnienie tablic
            findAfterTab[j] = findAfter.charAt(j);
        }
        for (int k=0;k<text.length();k++){
            textTab[k]=text.charAt(k);
        }


        int startReading=0;                                     //miejsca w których czytamy dane
        int stopReading=0;
        String readValue;

        for (int y=0;y<textTab.length;y++) {                // petle szukajace find after
            if(textTab[y]==findAfterTab[0]) {
                boolean flag = false;
                int zz = 0;
                int q = y + 1;
                for (int v = 1; v < findAfterTab.length; v++) {
                    if (textTab[q] == findAfterTab[v]) {
                        flag = true;
                        q++;
                    } else {
                        flag = false;
                        break;
                    }
                }
                zz = y;
                if (flag == true) {
                    startReading=zz+(findAfter.length());
                }
            }
        }
        for (int l=startReading;l<text.length();l++){     // stop reading point
            if (textTab[l]==stopMark){
                stopReading=l;
                break;
            }
        }

        char[]readValueTab=new char[stopReading-startReading];
        for (int i=startReading;i<stopReading;i++){
            readValueTab[i-startReading]=text.charAt(i);         //tu jest tablica z odczytana wartoscia
        }
        readValue=String.copyValueOf(readValueTab);
        //System.out.println(readValue);
        return readValue;

    }
}
