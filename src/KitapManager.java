import java.util.EnumSet;
import java.util.Map;
import java.util.Scanner;

public class KitapManager extends Veritabani {
    static Scanner Consol = new Scanner(System.in);

    public static void kitapMenu() throws InterruptedException {
        while (true) {
            System.out.println("=== KİTAP İŞLEMLERİ ===");
            System.out.println();
            System.out.println("1- Kitap Listesi");
            System.out.println("2- Yazardan Kitap Bul");
            System.out.println("3- Kitap Türü veya Yayın Tarihinden Kitap Bul");
            System.out.println("4- Kitap Ekle");
            System.out.println("5- Kitap Sil");
            System.out.println("6- Kitap Ödünç Al");
            System.out.println("7- Kitap İade Et");
            System.out.println("A- Bir Önceki Menü");
            System.out.println("Q- Çıkış");
            System.out.print("Seçiminiz: ");
            String Secim = Consol.nextLine();
            switch (Secim) {
                case "1":
                    kitapListesiYazdir();
                    break;
                case "2":
                    yazardanKitapBulma();
                    break;
                case "3":
                    turVeyaYayinTarihiIleKitapBulma();
                    break;
                case "4":
                    if (Helper.loggedInUserRole == UserRole.ADMIN) {
                        kitapEkle();
                        break;
                    } else if (Helper.loggedInUserRole == UserRole.USER) {
                        System.out.println("YETKİSİZ GİRİŞ");
                        break;
                    } else {
                        System.out.println("YETKİSİZ GİRİŞ");
                        break;
                    }
                case "5":
                    if (Helper.loggedInUserRole == UserRole.ADMIN) {
                        isimIleKitapSilme();
                        break;
                    } else if (Helper.loggedInUserRole == UserRole.USER) {
                        System.out.println("YETKİSİZ GİRİŞ");
                        break;
                    } else {
                        System.out.println("YETKİSİZ GİRİŞ");
                        break;
                    }
                case "6":
                    if (Helper.loggedInUserRole == UserRole.ADMIN) {
                        kitapOduncAl();
                        break;
                    } else if (Helper.loggedInUserRole == UserRole.USER) {
                        kitapOduncAl();
                        break;
                    } else {
                        System.out.println("YETKİSİZ GİRİŞ");
                        break;
                    }
                case "7":
                    if (Helper.loggedInUserRole == UserRole.ADMIN) {
                        kitapIadeEt();
                        break;
                    } else if (Helper.loggedInUserRole == UserRole.USER) {
                        kitapIadeEt();
                        break;
                    } else {
                        System.out.println("YETKİSİZ GİRİŞ");
                        break;
                    }
                case "A":
                    if (Helper.loggedInUserRole == UserRole.ADMIN) {
                        Helper.showAdminMenu();
                        break;
                    } else if (Helper.loggedInUserRole == UserRole.USER) {
                        Helper.showUserMenu();
                        break;
                    } else {
                        Helper.showGuestMenu();
                        break;
                    }
                case "Q":
                    Helper.projeDurdur();
                default:
                    System.out.println("Hatalı Seçim!");
            }
        }
    }

    public static void kitapListesiYazdir() throws InterruptedException {
        System.out.println("Kitap Listesi Yazdırılıyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }
        System.out.println("=== TECHNO STUDY CONFLUENCE ===");
        System.out.println("======== KİTAP LİSTESİ ========");
        System.out.println("KİTAP ADI - YAZAR - TÜR - YAYIN YILI");
        for (Map.Entry<String, String> X : kitaplarMap.entrySet()) {
            System.out.println(X.getKey() + " - " + X.getValue() + " / ");
        }
    }

    public static void yazardanKitapBulma() throws InterruptedException {
        boolean anahtar=true;
        System.out.print("Yazar Adı: ");
        String Yazar = Consol.nextLine();
        System.out.println("Aranıyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }
        System.out.println("=== TECHNO STUDY CONFLUENCE ===");
        System.out.println("======== ARANAN YAZAR ========");
        System.out.println("KİTAP ADI - YAZAR - TÜR - YAYIN YILI");
        for (Map.Entry<String, String> X : kitaplarMap.entrySet()) {
            if (X.getValue().contains(Yazar)) {
                System.out.println(X.getKey() + " - " + X.getValue() + " / ");
                anahtar=false;
            }
        }
        if (anahtar){
            System.out.println("Belirtilen Yazara Ait Kitap Mevcut Değildir");
        }
    }

    public static void turVeyaYayinTarihiIleKitapBulma() throws InterruptedException {
        System.out.println("\033[1;32m" + "(Tarih, Polisiye, Kurgu, Roman, Destan)" + "\033[0m");
        System.out.print("Istediginiz kitabin turunu yaziniz: ");
        String KitapTuru = Consol.nextLine();
        System.out.print("Istediginiz kitabin yayın tarihi: ");
        String YayinTarihi = Consol.nextLine();
        System.out.println(
                "\n============ TECHNO STUDY CONFLUENCE ==========\n" +
                        "================= KITAP LISTESI ===============\n" +
                        "Kitap Ismi    :   Yazar Ismi , Kitap Turu , Yayin Yili");
        boolean anahtar = true;
        for (Map.Entry<String, String> K : kitaplarMap.entrySet()) {
            String[] eachValuarr = K.getValue().split(", ");
            if (KitapTuru.equalsIgnoreCase(eachValuarr[1]) || YayinTarihi.equalsIgnoreCase(eachValuarr[2])) {
                if (OduncMap.containsKey(K.getKey())) {
                    System.out.print("\033[1;31m" + "\n ÖDÜNÇ VERİLDİ " + "\033[0m");
                } else {
                    System.out.print("\033[1;32m" + "\n        MEVCUT " + "\033[0m");
                }
                System.out.print(K.getKey() + " " + K.getValue());
                anahtar = false;
            }
        }
        if (anahtar) {
            System.out.println("\033[1;31m" + "\nBelirtilen bilgiler ile eşleşen bir kitap mevcut değildir." + "\033[0m");
        }
        System.out.println();
    }

    public static void kitapEkle() throws InterruptedException {
        System.out.print("Kitap Adı: ");
        String kitapAdi = Consol.nextLine();
        System.out.print("Yazar Adı: ");
        String yazarAdi = Consol.nextLine();
        KitapTuru kitapTuru = null;
        while (kitapTuru == null) {
            try {
                System.out.print("Kitap Türü: " + EnumSet.allOf(KitapTuru.class) + ": ");
                String kTur = Consol.nextLine().toUpperCase();
                kitapTuru = KitapTuru.valueOf(kTur);
            } catch (IllegalArgumentException e) {
                System.out.println("Hatalı Giriş! Lütfen Kitap Türünü Tekrar Giriniz");
            }
        }
        System.out.print("Yayın Tarihi: ");
        int yayinYili = 0;
        boolean GecersizGiris = false;
        while (!GecersizGiris) {
            try {
                yayinYili = Integer.parseInt(Consol.nextLine());
                GecersizGiris = true;
            } catch (NumberFormatException e) {
                System.out.println("Hatalı Giriş! Lütfen Sayı Giriniz");
            }
        }
        String kitapBilgileri = yazarAdi + ", " + kitapTuru + ", " + yayinYili;
        kitaplarMap.put(kitapAdi, kitapBilgileri);

        System.out.println("Kitap Başarıyla Eklendi!");
    }

    public static void isimIleKitapSilme() throws InterruptedException {
        System.out.println("Silinecek kitabin ismini giriniz");
        String silinecekKitap = Consol.nextLine();
        String silinecekValue = kitaplarMap.get(silinecekKitap);
        String sonucValue = kitaplarMap.remove(silinecekKitap);
        System.out.print(silinecekKitap + " Siliniyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }
        try {
            boolean sonuc = sonucValue.equals(silinecekValue);
        } catch (Exception e) {
            System.out.println("Istediginiz kitap ismi bulunamadi");
        }
    }

    public static void kitapIadeEt() throws InterruptedException {
        System.out.println("Ödünç almak istediğiniz kitabın ismini giriniz: ");
        String kitapAdi = Consol.nextLine();
        if (kitaplarMap.containsKey(kitapAdi) || !OduncMap.containsKey(kitapAdi)) {
            System.out.println("\033[1;32m\n" + kitapAdi + " adlı kitap ödünç olarak verilmiştir." + "\033[0m\n");
            OduncMap.put(kitapAdi, "");
        } else {
            System.out.println("\033[1;31m\n" + "Belirtilen isim ile bir kitap mevcut değildir" + "\033[0m\n");
        }
    }

    public static void kitapOduncAl() throws InterruptedException {
        System.out.println("İade etmek istediğiniz kitabın ismini giriniz: ");
        String kitapAdi = Consol.nextLine();
        if (kitaplarMap.containsKey(kitapAdi) && OduncMap.containsKey(kitapAdi)) {
            System.out.println("\033[1;32m\n" + kitapAdi + " adlı kitap iade alınmıştır." + "\033[0m\n");
            OduncMap.remove(kitapAdi, "");
        } else {
            System.out.println("\033[1;31m\n" + "Belirtilen isim ile bir kitap mevcut değildir" + "\033[0m\n");
        }
    }
}
