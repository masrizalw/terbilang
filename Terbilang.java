/**
 * Terbilang untuk mengucapkan angka bilangan bulat ke
 * bahasa indonesia
 *
 * @author Mr. W
 * @version 1.0
 * @since 2022-11-07
 */
public class Terbilang {

    public static String terbilang(BigInteger angka) {
        StringBuilder result = new StringBuilder("");
        int jmlDigitDalamRibu = divider(angka);
        while(jmlDigitDalamRibu>=0){

            BigInteger bilanganPembagi = new BigInteger("1000").pow(jmlDigitDalamRibu);
            int bilanganPengurang = angka.divide(bilanganPembagi).intValue();
            if(bilanganPengurang==0){
                jmlDigitDalamRibu--;
                continue;
            }
            int digitAngka = bilanganPengurang;
            int ratus = 0;
            int puluh = 0;

            switch((int)Math.floor(Math.log10(digitAngka)+1)){
                case 3 :
                    ratus = digitAngka/100;
                    if(ratus>0){
                        result.append(switcherSatuan(ratus)+"ratus ");
                        digitAngka = digitAngka-((ratus)*100);
                    }
                case 2 :
                    puluh = (digitAngka/10);
                    if(puluh>0 && puluh!=1){
                        result.append(switcherSatuan(puluh)+"puluh ");
                        digitAngka = digitAngka-((puluh)*10);
                    } else if(puluh==1){
                        result.append(switcherBelasan(digitAngka));
                        break;
                    }
                default:
                    if(digitAngka==1 && (jmlDigitDalamRibu!=1 || ratus!=0 || puluh!=0)){
                        result.append("satu ");
                    } else {
                        result.append(switcherSatuan(digitAngka));
                    }
            }

            result.append(switcherBilangan(jmlDigitDalamRibu));

            angka = angka.subtract(BigInteger.valueOf(bilanganPengurang).multiply(bilanganPembagi));
            jmlDigitDalamRibu--;

        }
        if(result.toString().isEmpty()) result.append("nol");
        return result.toString();
    }

    private static int divider(BigInteger angka){
        int count = 0;
        while(angka.compareTo(BigInteger.ZERO)!=0){
            angka = angka.divide(new BigInteger("1000"));
            if(angka.compareTo(BigInteger.ZERO)==1)count++;
        }
        return count;
    }

    //tinggal menambah angka ke atas utk pengucapan setelah vigintilion
    private static String switcherBilangan(int angka){
        return switch (angka) {
            case 21 -> "vigintilion ";
            case 20 -> "novemdesiliun ";
            case 19 -> "oktodesiliun ";
            case 18 -> "septendesiliun ";
            case 17 -> "sexdesiliun ";
            case 16 -> "quindesiliun ";
            case 15 -> "quatuordesiliun ";
            case 14 -> "tredesiliun ";
            case 13 -> "duodesiliun ";
            case 12 -> "undesiliun ";
            case 11 -> "desiliun ";
            case 10 -> "noniliun ";
            case 9 -> "oktiliun ";
            case 8 -> "septiliun ";
            case 7 -> "sekstiliun ";
            case 6 -> "kuintiliun ";
            case 5 -> "kuadriliun ";
            case 4 -> "triliun ";
            case 3 -> "miliar ";
            case 2 -> "juta ";
            case 1 -> "ribu ";
            default -> "";
        };
    }

    private static String switcherSatuan(int angka){
        return switch (angka) {
            case 9 -> "sembilan ";
            case 8 -> "delapan ";
            case 7 -> "tujuh ";
            case 6 -> "enam ";
            case 5 -> "lima ";
            case 4 -> "empat ";
            case 3 -> "tiga ";
            case 2 -> "dua ";
            case 1 -> "se";
            default -> "";
        };
    }

    private static String switcherBelasan(int angka){
        return switch (angka) {
            case 19 -> "sembilan belas ";
            case 18 -> "delapan belas ";
            case 17 -> "tujuh belas ";
            case 16 -> "enam belas ";
            case 15 -> "lima belas ";
            case 14 -> "empat belas ";
            case 13 -> "tiga belas ";
            case 12 -> "dua belas ";
            case 11 -> "sebelas ";
            default -> "sepuluh ";
        };
    }

}