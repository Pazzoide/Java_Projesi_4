import java.util.Scanner;

public class Helper {
    static Scanner Consol=new Scanner(System.in);
    public static String loggedInUsername;
    public static UserRole loggedInUserRole;
    private static void loginAndShowUserMenu(UserRole role) throws InterruptedException {
        while (true) {
            System.out.print("Kullanici Adi: ");
            String username = Consol.nextLine();
            System.out.print("Sifre: ");
            String password = Consol.nextLine();
            role = authenticateUser(username, password);
            if (role == UserRole.ADMIN) {
                loggedInUserRole=UserRole.ADMIN;
                System.out.println("Admin olarak giriş yapıldı");
                break;
            } else if (role == UserRole.USER) {
                loggedInUserRole=UserRole.USER;
                System.out.println("User olarak giriş yapıldı");
                break;
            } else if (role == UserRole.GUEST) {
                loggedInUserRole=UserRole.GUEST;
                System.out.println("Guest olarak giriş yapıldı");
                break;
            } else {
                System.out.println("Geçersiz kullanıcı adı veya şifre");
            }
        }
        switch (loggedInUserRole){
            case ADMIN: System.out.println("=== ROL ADMIN ===");
                showAdminMenu();
            case USER: System.out.println("=== ROL USER ===");
                showUserMenu();
            case GUEST: System.out.println("=== ROL GUEST ===");
                showGuestMenu();
        }
    }
    private static UserRole authenticateUser(String username, String password) {
        if ("Admin".equals(username) && "Admin123".equals(password)){
            return UserRole.ADMIN;
        } else if ("User".equals(username) && "User123".equals(password)) {
            return UserRole.USER;
        }else if ("Guest".equals(username) && "Guest123".equals(password)){
            return UserRole.GUEST;
        }else {
            return null;
        }
    }
    public static void anaMenu() throws InterruptedException{
        String Tercih="";
        while (!Tercih.equalsIgnoreCase("Q")) {
            System.out.println("=== TECHNO KÜTÜPHANE UYGULAMASINA HOŞGELDİNİZ ===");
            System.out.println("1- Sistem Girişi");
            System.out.println("2- Kütüphane Bilgileri");
            System.out.println("Q- Çıkış");
            System.out.print("Lütfen menüden tercihinizi yapınız: ");
            Tercih=Consol.nextLine();
            switch (Tercih){
                case "1": loginAndShowUserMenu(null); break;
                case "2": kutuphaneBilgileriniYazdir(); break;
                case "Q": projeDurdur();
                default: System.out.println("Hatalı seçim! Tekrar deneyiniz");
            }
        }
    }
    public static void showAdminMenu() throws InterruptedException{
        while (true) {
            System.out.println("=== ADMİN PANELİ ===");
            System.out.println();
            System.out.println("1- Üye İşlemleri");
            System.out.println("2- Kitap İşlemleri");
            System.out.println("3- Kullanıcı Oturumunu Kapat");
            System.out.println("Q- Çıkış");
            System.out.println();
            System.out.print("Lütfen menüden tercihinizi yapınız: ");
            String Tercih = Consol.nextLine().toUpperCase();
            switch (Tercih){
                case "1": UyeManager.uyeMenu(); break;
                case "2": KitapManager.kitapMenu(); break;
                case "3": anaMenu(); break;
                case "Q": projeDurdur();
                default: System.out.println("Hatalı giriş! Tekrar Deneyiniz");
            }
        }
    }
    public static void showUserMenu() throws InterruptedException{
        while (true) {
            System.out.println("=== USER PANELİ ===");
            System.out.println();
            System.out.println("1- Kitap İşlemleri");
            System.out.println("2- Kullanıcı Oturumunu Kapat");
            System.out.println("Q- Çıkış");
            System.out.println();
            System.out.print("Lütfen menüden tercihinizi yapınız: ");
            String Tercih = Consol.nextLine().toUpperCase();
            switch (Tercih){
                case "1": KitapManager.kitapMenu(); break;
                case "2": anaMenu(); break;
                case "Q": projeDurdur();
                default: System.out.println("Hatalı giriş! Tekrar Deneyiniz");
            }
        }
    }
    public static void showGuestMenu() throws InterruptedException{
        while (true) {
            System.out.println("=== GUEST PANELİ ===");
            System.out.println();
            System.out.println("1- Kitap İşlemleri");
            System.out.println("2- Kullanıcı Oturumunu Kapat");
            System.out.println("3- Kayıt Talebi Oluştur");
            System.out.println("Q- Çıkış");
            System.out.println();
            System.out.print("Lütfen menüden tercihinizi yapınız: ");
            String Tercih = Consol.nextLine().toUpperCase();
            switch (Tercih){
                case "1": KitapManager.kitapMenu(); break;
                case "2": anaMenu(); break;
                case "3": UyeManager.uyelikTalebiOlustur(); break;
                case "Q": projeDurdur();
                default: System.out.println("Hatalı giriş! Tekrar Deneyiniz");
            }
        }
    }
    public static void kutuphaneBilgileriniYazdir() throws InterruptedException{
        System.out.print("Kutuphane bilgileri yazdiriliyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }
        System.out.println("\n" +
                "\n============= TECHNO STUDY CONFLUENCE =============\n" +
                "\t\t Kutuphane : " + Kutuphane.kutuphaneIsim +
                "\n\t\t Adres : " + Kutuphane.adres +
                "\n\t\t Telefon : " + Kutuphane.telefon);
    }
    public static void projeDurdur() {
        System.out.println("Kutuphane projesinden ciktiniz");
        System.exit(0);
    }
}
