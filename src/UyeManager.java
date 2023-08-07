import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UyeManager extends Veritabani {
    static Scanner Consol = new Scanner(System.in);

    public static void uyeMenu() throws InterruptedException {
        String Tercih = "";
        while (!Tercih.equalsIgnoreCase("Q")) {
            System.out.println("=== ÜYE İŞLEMLERİ ===");
            System.out.println("1- Üye Listesi Yazdır");
            System.out.println("2- Soyisimden Üye Bul");
            System.out.println("3- Şehre Göre Üye Bul");
            System.out.println("4- Üye Ekleme");
            System.out.println("5- Kimlik No ile Kayıt Silme");
            System.out.println("6- Kayıt Taleplerini Görüntüle");
            System.out.println("A- Bir Önceki Menü");
            System.out.println("Q- Çıkış");
            System.out.println();
            System.out.print("Lütfen Geçerli Bir Tercih Yapınız: ");
            Tercih = Consol.nextLine();
            switch (Tercih) {
                case "1":
                    uyeListesiYazdir();
                    break;
                case "2":
                    soyisimdenUyeBulma();
                    break;
                case "3":
                    sehreGoreUyeBulma();
                    break;
                case "4":
                    uyeEkleme();
                    break;
                case "5":
                    tcnoIleUyeSil();
                    break;
                case "6":
                    uyeTalepleriYazdir();
                    break;
                case "A":
                    Helper.showAdminMenu();
                    break;
                case "Q":
                    Helper.projeDurdur();
                    break;
                default:
                    System.out.println("Hatalı Tercih!");
            }
        }
    }

    public static void uyeListesiYazdir() throws InterruptedException {
        System.out.println("Üye Listesi Yazdırılıyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }
        System.out.println("=== TECHNO STUDY CONFLUENCE ===");
        System.out.println("========= ÜYE LİSTESİ =========");
        System.out.println("TC NO - İSİM - SOYİSİM - ŞEHİR - D.YILI");
        for (Map.Entry<String, String> X : uyelerMap.entrySet()) {
            System.out.println(X.getKey() + " - " + X.getValue() + " / ");
        }
    }

    public static void soyisimdenUyeBulma() throws InterruptedException {
        boolean anahtar = true;
        System.out.print("Aradığınız üyenin soyisminin tamamını ya da bir kısmını giriniz: ");
        String uyeSoyad = Consol.nextLine();
        System.out.println(
                "\n========== TECHNO STUDY BOOTCAMP ===========\n" +
                        "=========== SOYİSİM İLE ÜYE ARAMA ==========\n" +
                        "TcNo : İsim , Soyisim , Şehir , D.Yılı");
        for (Map.Entry<String, String> uyelerEntrySet : uyelerMap.entrySet()) {
            if (uyelerEntrySet.getValue().contains(uyeSoyad)) {
                System.out.println(uyelerEntrySet.getKey() + " " + uyelerEntrySet.getValue());
                anahtar = false;
            }
        }
        if (anahtar) {
            System.out.println("\nBelirtilen bilgiler ile eşleşen bir üye mevcut değildir.\n");
        }
    }

    public static void sehreGoreUyeBulma() throws InterruptedException {
        boolean anahtar=true;
        System.out.print("Aranan Şehir Adı: ");
        String Sehir = Consol.nextLine();
        System.out.println("Aranıyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }
        System.out.println("=== TECHNO STUDY CONFLUENCE ===");
        System.out.println("======== ARANAN ÜYELER ========");
        System.out.println("TC NO - İSİM - SOYİSİM - ŞEHİR - D.YILI");
        for (Map.Entry<String, String> X : uyelerMap.entrySet()) {
            if (X.getValue().contains(Sehir)) {
                System.out.println(X.getKey() + " - " + X.getValue() + " / ");
                anahtar=false;
            }
        }
        if (anahtar){
            System.out.println("Belirtilen Şehre Ait Üyelik Mevcut Değildir");
        }
    }

    public static void uyeEkleme() throws InterruptedException {
        System.out.println("=== ÜYELİK KAYDI ===");
        String tcNO = "";
        while (true) {
            System.out.print("TC NO: ");
            tcNO = Consol.nextLine();
            System.out.println("Kontrol Ediliyor...");
            for (int i = 0; i < 20; i++) {
                Thread.sleep(100);
                System.out.print(">");
            }
            if (!intControl(tcNO)) {
                System.out.println("TC NO SADECE RAKAMLARDAN OLUŞMALIDIR");
            } else {
                System.out.println("TC NO KABUL EDİLDİ");
                break;
            }
        }
        String isim = "";
        while (true) {
            System.out.print("İSİM: ");
            isim = Consol.nextLine();
            System.out.println("Kontrol Ediliyor...");
            for (int i = 0; i < 20; i++) {
                Thread.sleep(100);
                System.out.print(">");
            }
            if (!strControl(isim)) {
                System.out.println("İSİM RAKAM VEYA UYGUNSUZ KARAKTER İÇEREMEZ");
            } else {
                System.out.println("İSİM KABUL EDİLDİ");
                break;
            }
        }
        String soyisim = "";
        while (true) {
            System.out.print("SOYİSİM: ");
            soyisim = Consol.nextLine();
            System.out.println("Kontrol Ediliyor...");
            for (int i = 0; i < 20; i++) {
                Thread.sleep(100);
                System.out.print(">");
            }
            if (!strControl(soyisim)) {
                System.out.println("SOYİSİM RAKAM VEYA UYGUNSUZ KARAKTER İÇEREMEZ");
            } else {
                System.out.println("SOYİSİM KABUL EDİLDİ");
                break;
            }
        }
        String Sehir = "";
        while (true) {
            System.out.print("ŞEHİR: ");
            Sehir = Consol.nextLine();
            System.out.println("Kontrol Ediliyor...");
            for (int i = 0; i < 20; i++) {
                Thread.sleep(100);
                System.out.print(">");
            }
            if (!strControl(Sehir)) {
                System.out.println("ŞEHİR RAKAM VEYA UYGUNSUZ KARAKTER İÇEREMEZ");
            } else {
                System.out.println("ŞEHİR KABUL EDİLDİ");
                break;
            }
        }
        String dYili = "";
        while (true) {
            System.out.print("DOĞUM YILI: ");
            dYili = Consol.nextLine();
            System.out.println("Kontrol Ediliyor...");
            for (int i = 0; i < 20; i++) {
                Thread.sleep(100);
                System.out.print(">");
            }
            if (!intControl(dYili)) {
                System.out.println("DOĞUM YILI SADECE RAKAMLARDAN OLUŞMALIDIR");
            } else {
                System.out.println("DOĞUM YILI KABUL EDİLDİ");
                break;
            }
        }
        String UyeBilgileri = isim + " , " + soyisim + " , " + Sehir + " , " + dYili;
        uyelerMap.put(tcNO, UyeBilgileri);
        System.out.println("İşleniyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }
        System.out.println("=== ÜYE KAYDI TAMAMLANDI ===");
        uyeMenu();
    }

    public static boolean strControl(String str) {
        String regex = "^[a-zA-ZçÇğĞıİöÖşŞü]+$";
        return Pattern.matches(regex, str);
    }

    public static boolean intControl(String str) {
        String regex = "^[0-9]+$";
        return Pattern.matches(regex, str);
    }

    public static void tcnoIleUyeSil() throws InterruptedException {
        System.out.println("=== TC NO İLE ÜYE KAYDI SİLME ===");
        String tcNo = "";
        boolean HataliGiris = false;
        while (!HataliGiris) {
            try {
                System.out.print("TC NO: ");
                tcNo = Consol.nextLine();
                Long.parseLong(tcNo);
                HataliGiris = true;
            } catch (NumberFormatException e) {
                System.out.println("TC NO SADECE RAKAMLARDAN OLUŞMALIDIR");
            }
        }
        if (uyelerMap.containsKey(tcNo)) {
            String silinecekUyeBilgisi = uyelerMap.get(tcNo);
            uyelerMap.remove(tcNo);
            System.out.println(silinecekUyeBilgisi + " " + "siliniyor...");
            for (int i = 0; i < 20; i++) {
                Thread.sleep(100);
                System.out.print(">");
            }
            System.out.println("ÜYE BAŞARIYLA SİLİNDİ");
        } else {
            System.out.println("ÜYE BULUNAMADI");
        }
        uyeMenu();
    }

    public static void uyeTalepleriYazdir() throws InterruptedException {
        System.out.println("=== ÜYE KAYIT TALEPLERİ ===");
        System.out.print("Talepler Görüntüleniyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }
        System.out.println();
        for (Map.Entry<String, String> X : uyeTalepleri.entrySet()) {
            System.out.println(X.getKey()+" "+X.getValue());
        }
        uyeMenu();
    }

    public static void uyelikTalebiOlustur() throws InterruptedException {
        System.out.println("=== ÜYELİK TALEBİ OLUŞTUR ===");
        String tcNO = "";
        while (true) {
            System.out.print("TC NO: ");
            tcNO = Consol.nextLine();
            System.out.println("Kontrol Ediliyor...");
            for (int i = 0; i < 20; i++) {
                Thread.sleep(100);
                System.out.print(">");
            }
            if (!intControl(tcNO)) {
                System.out.println("TC NO SADECE RAKAMLARDAN OLUŞMALIDIR");
            } else {
                System.out.println("TC NO KABUL EDİLDİ");
                break;
            }
        }
        String isim = "";
        while (true) {
            System.out.print("İSİM: ");
            isim = Consol.nextLine();
            System.out.println("Kontrol Ediliyor...");
            for (int i = 0; i < 20; i++) {
                Thread.sleep(100);
                System.out.print(">");
            }
            if (!strControl(isim)) {
                System.out.println("İSİM RAKAM VEYA UYGUNSUZ KARAKTER İÇEREMEZ");
            } else {
                System.out.println("İSİM KABUL EDİLDİ");
                break;
            }
        }
        String soyisim = "";
        while (true) {
            System.out.print("SOYİSİM: ");
            soyisim = Consol.nextLine();
            System.out.println("Kontrol Ediliyor...");
            for (int i = 0; i < 20; i++) {
                Thread.sleep(100);
                System.out.print(">");
            }
            if (!strControl(soyisim)) {
                System.out.println("SOYİSİM RAKAM VEYA UYGUNSUZ KARAKTER İÇEREMEZ");
            } else {
                System.out.println("SOYİSİM KABUL EDİLDİ");
                break;
            }
        }
        String Sehir = "";
        while (true) {
            System.out.print("ŞEHİR: ");
            Sehir = Consol.nextLine();
            System.out.println("Kontrol Ediliyor...");
            for (int i = 0; i < 20; i++) {
                Thread.sleep(100);
                System.out.print(">");
            }
            if (!strControl(Sehir)) {
                System.out.println("ŞEHİR RAKAM VEYA UYGUNSUZ KARAKTER İÇEREMEZ");
            } else {
                System.out.println("ŞEHİR KABUL EDİLDİ");
                break;
            }
        }
        String dYili = "";
        while (true) {
            System.out.print("DOĞUM YILI: ");
            dYili = Consol.nextLine();
            System.out.println("Kontrol Ediliyor...");
            for (int i = 0; i < 20; i++) {
                Thread.sleep(100);
                System.out.print(">");
            }
            if (!intControl(dYili)) {
                System.out.println("DOĞUM YILI SADECE RAKAMLARDAN OLUŞMALIDIR");
            } else {
                System.out.println("DOĞUM YILI KABUL EDİLDİ");
                break;
            }
        }
        String UyeBilgileri = isim + " , " + soyisim + " , " + Sehir + " , " + dYili;
        uyeTalepleri.put(tcNO, UyeBilgileri);
        System.out.println("İşleniyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }
        System.out.println("=== ÜYE TALEBİ ALINDI ===");
        Helper.showGuestMenu();
    }
}
