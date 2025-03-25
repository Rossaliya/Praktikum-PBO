
package com.parcel.management;

import java.util.ArrayList;
import java.util.InputMismatchException;
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

    @Override
    public String toString() {
        return "Kode: " + kode + ", Nama: " + nama + ", Harga: " + harga;
    }
}

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
                        System.out.println("Terima kasih telah menggunakan sistem!");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid! Silakan pilih menu yang tersedia.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid! Harap masukkan angka.");
                scanner.nextLine(); // Membersihkan buffer
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
                    System.out.println("Harga tidak boleh negatif! Silakan masukkan ulang.");
                } else {
                    valid = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid! Harap masukkan angka.");
                scanner.nextLine();
            }
        }

        daftarParcel.add(new Parcel(kode, nama, harga));
        System.out.println("Parcel berhasil ditambahkan!");
    }

    public static void lihatParcel() {
        if (daftarParcel.isEmpty()) {
            System.out.println("Tidak ada parcel dalam daftar.");
            return;
        }
        System.out.println("\nDaftar Parcel:");
        for (Parcel parcel : daftarParcel) {
            System.out.println(parcel);
        }
    }

    protected static void editParcel() {
        System.out.print("Masukkan kode parcel yang akan diedit: ");
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
                            System.out.println("Harga tidak boleh negatif! Silakan masukkan ulang.");
                        } else {
                            valid = true;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Input tidak valid! Harap masukkan angka.");
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

    static void hapusParcel() {
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
