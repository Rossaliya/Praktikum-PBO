import java.util.ArrayList;
import java.util.Scanner;

class Parcel {
    private String kode;
    private String nama;
    private double harga;

    public Parcel(String kode, String nama, double harga) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
    }

    public String getKode() {
        return kode;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    @Override
    public String toString() {
        return "Kode: " + kode + ", Nama: " + nama + ", Harga: " + harga;
    }
}

public class ManajemenParcel {
    private static ArrayList<Parcel> daftarParcel = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;
        do {
            System.out.println("\n=== SISTEM MANAJEMEN PENJUALAN PARCEL ===");
            System.out.println("1. Tambah Parcel");
            System.out.println("2. Lihat Parcel");
            System.out.println("3. Edit Parcel");
            System.out.println("4. Hapus Parcel");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    tambahParcel();
                    break;
                case 2:
                    lihatParcel();
                    break;
                case 3:
                    editParcel();
                    break;
                case 4:
                    hapusParcel();
                    break;
                case 5:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 5);
    }

    private static void tambahParcel() {
        System.out.print("Masukkan kode parcel: ");
        String kode = scanner.nextLine();
        System.out.print("Masukkan nama parcel: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan harga parcel: ");
        double harga = scanner.nextDouble();
        scanner.nextLine();

        daftarParcel.add(new Parcel(kode, nama, harga));
        System.out.println("Parcel berhasil ditambahkan!");
    }

    private static void lihatParcel() {
        if (daftarParcel.isEmpty()) {
            System.out.println("Tidak ada parcel dalam daftar.");
            return;
        }
        System.out.println("\nDaftar Parcel:");
        for (Parcel parcel : daftarParcel) {
            System.out.println(parcel);
        }
    }

    private static void editParcel() {
        System.out.print("Masukkan kode parcel yang akan diedit: ");
        String kode = scanner.nextLine();
        for (Parcel parcel : daftarParcel) {
            if (parcel.getKode().equals(kode)) {
                System.out.print("Masukkan nama baru: ");
                parcel.setNama(scanner.nextLine());
                System.out.print("Masukkan harga baru: ");
                parcel.setHarga(scanner.nextDouble());
                scanner.nextLine();
                System.out.println("Parcel berhasil diperbarui!");
                return;
            }
        }
        System.out.println("Parcel tidak ditemukan!");
    }

    private static void hapusParcel() {
        System.out.print("Masukkan kode parcel yang akan dihapus: ");
        String kode = scanner.nextLine();
        for (Parcel parcel : daftarParcel) {
            if (parcel.getKode().equals(kode)) {
                daftarParcel.remove(parcel);
                System.out.println("Parcel berhasil dihapus!");
                return;
            }
        }
        System.out.println("Parcel tidak ditemukan!");
    }
}
