import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ManajemenParcel {
    protected static ArrayList<Parcel> daftarParcel = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

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

            try {
                pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1 -> tambahParcel();
                    case 2 -> lihatParcel();
                    case 3 -> editParcel();
                    case 4 -> hapusParcel();
                    case 5 -> System.out.println("Terima kasih telah menggunakan sistem!");
                    default -> System.out.println("Pilihan tidak valid!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid! Harap masukkan angka.");
                scanner.nextLine(); // bersihkan buffer
                pilihan = 0;
            }
        } while (pilihan != 5);
    }

    private static void tambahParcel() {
        System.out.print("Masukkan kode parcel: ");
        String kode = scanner.nextLine();
        System.out.print("Masukkan nama parcel: ");
        String nama = scanner.nextLine();

        double harga = 0;
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print("Masukkan harga parcel: ");
                harga = scanner.nextDouble();
                scanner.nextLine();
                if (harga < 0) {
                    System.out.println("Harga tidak boleh negatif!");
                } else {
                    valid = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid! Masukkan angka.");
                scanner.nextLine();
            }
        }

        Parcel parcel = new Parcel(kode, nama, harga);
        daftarParcel.add(parcel);
        System.out.println("Parcel berhasil ditambahkan!");
    }

    private static void lihatParcel() {
        if (daftarParcel.isEmpty()) {
            System.out.println("Belum ada parcel.");
            return;
        }
        System.out.println("\nDaftar Parcel:");
        for (Parcel parcel : daftarParcel) {
            System.out.println(parcel);
        }
    }

    private static void editParcel() {
        System.out.print("Masukkan kode parcel yang ingin diedit: ");
        String kode = scanner.nextLine();

        for (Parcel parcel : daftarParcel) {
            if (parcel.getKode().equals(kode)) {
                System.out.print("Masukkan nama baru: ");
                parcel.setNama(scanner.nextLine());

                double harga = 0;
                boolean valid = false;
                while (!valid) {
                    try {
                        System.out.print("Masukkan harga baru: ");
                        harga = scanner.nextDouble();
                        scanner.nextLine();
                        if (harga < 0) {
                            System.out.println("Harga tidak boleh negatif!");
                        } else {
                            valid = true;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Input salah, masukkan angka.");
                        scanner.nextLine();
                    }
                }

                parcel.setHarga(harga);
                System.out.println("Parcel berhasil diperbarui!");
                return;
            }
        }
        System.out.println("Parcel tidak ditemukan!");
    }

    private static void hapusParcel() {
        System.out.print("Masukkan kode parcel yang ingin dihapus: ");
        String kode = scanner.nextLine();

        for (int i = 0; i < daftarParcel.size(); i++) {
            if (daftarParcel.get(i).getKode().equals(kode)) {
                daftarParcel.remove(i);
                System.out.println("Parcel berhasil dihapus!");
                return;
            }
        }

        System.out.println("Parcel tidak ditemukan!");
    }
}

// Class Parcel disatukan dalam file ini
class Parcel {
    private String kode;         // private
    private String nama;         // private
    protected double harga;      // protected
    String kategori = "Umum";    // default (package-private)

    public Parcel(String kode, String nama, double harga) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    @Override
    public String toString() {
        return "Kode: " + kode + ", Nama: " + nama + ", Harga: " + harga + ", Kategori: " + kategori;
    }
}
