import java.util.*;

class Pemain {
    int tinggi;
    int berat;

    Pemain(int tinggi, int berat) {
        this.tinggi = tinggi;
        this.berat = berat;
    }

    @Override
    public String toString() {
        return "Tinggi: " + tinggi + " cm, Berat: " + berat + " kg";
    }
}

public class SortingSearchingFutsal {
    public static void main(String[] args) {
        List<Pemain> timA = new ArrayList<>(Arrays.asList(
            new Pemain(168, 50), new Pemain(170, 60), new Pemain(165, 56),
            new Pemain(168, 55), new Pemain(172, 60), new Pemain(170, 70),
            new Pemain(169, 66), new Pemain(165, 56), new Pemain(171, 72),
            new Pemain(166, 56)
        ));

        List<Pemain> timB = new ArrayList<>(Arrays.asList(
            new Pemain(170, 66), new Pemain(167, 60), new Pemain(165, 59),
            new Pemain(166, 58), new Pemain(168, 58), new Pemain(175, 71),
            new Pemain(172, 68), new Pemain(171, 68), new Pemain(168, 65),
            new Pemain(169, 60)
        ));

        // 1a. Sorting berdasarkan tinggi badan ascending dan descending
        sortDanTampilkan(timA, "Tim A", Comparator.comparingInt(p -> p.tinggi), "Tinggi ASC");
        sortDanTampilkan(timA, "Tim A", Comparator.comparingInt((Pemain p) -> p.tinggi).reversed(), "Tinggi DESC");

        // 1b. Sorting berdasarkan berat badan ascending dan descending
        sortDanTampilkan(timB, "Tim B", Comparator.comparingInt(p -> p.berat), "Berat ASC");
        sortDanTampilkan(timB, "Tim B", Comparator.comparingInt((Pemain p) -> p.berat).reversed(), "Berat DESC");

        // 1c. Cari nilai maksimum dan minimum
        cariMinMax(timA, "Tim A");
        cariMinMax(timB, "Tim B");

        // 1d. Copy semua anggota tim B ke tim C
        List<Pemain> timC = new ArrayList<>(timB);
        System.out.println("Tim C hasil salinan Tim B:");
        timC.forEach(System.out::println);

        // 2a. Implementasi ArrayList sudah dilakukan

        // 2b. Jumlah pemain dengan tinggi 168 atau 160
        long count = timB.stream().filter(p -> p.tinggi == 168 || p.tinggi == 160).count();
        System.out.println("Jumlah pemain Tim B dengan tinggi 168 cm / 160 cm: " + count);

        // 2c. Pemain Tim A dengan berat 56 kg atau 53 kg
        long countBerat = timA.stream().filter(p -> p.berat == 56 || p.berat == 53).count();
        System.out.println("Jumlah pemain Tim A dengan berat 56 kg / 53 kg: " + countBerat);

        // 2d. Apakah ada pemain Tim A dengan tinggi atau berat sama dengan Tim B
        boolean adaSama = timA.stream().anyMatch(pa ->
            timB.stream().anyMatch(pb -> pa.tinggi == pb.tinggi || pa.berat == pb.berat));
        System.out.println("Apakah ada pemain Tim A dengan tinggi/berat sama dengan Tim B? " + (adaSama ? "Ya" : "Tidak"));
    }

    static void sortDanTampilkan(List<Pemain> tim, String namaTim, Comparator<Pemain> comparator, String mode) {
        List<Pemain> sorted = new ArrayList<>(tim);
        sorted.sort(comparator);
        System.out.println("=== " + namaTim + " Sorted by " + mode + " ===");
        sorted.forEach(System.out::println);
    }

    static void cariMinMax(List<Pemain> tim, String namaTim) {
        int minTinggi = tim.stream().mapToInt(p -> p.tinggi).min().orElse(0);
        int maxTinggi = tim.stream().mapToInt(p -> p.tinggi).max().orElse(0);
        int minBerat = tim.stream().mapToInt(p -> p.berat).min().orElse(0);
        int maxBerat = tim.stream().mapToInt(p -> p.berat).max().orElse(0);
        System.out.printf("=> %s: MinTinggi=%d, MaxTinggi=%d, MinBerat=%d, MaxBerat=%d%n",
                namaTim, minTinggi, maxTinggi, minBerat, maxBerat);
    }
}
