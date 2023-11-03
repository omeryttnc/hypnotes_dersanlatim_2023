package grup1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class Task3 {
    class DoctorMuayeneUcretleri {
        private DOCTOR doctorAdi;
        private HASTALIK hastalik;
        private int ucret;
        private boolean hastaneyeYatmasiGerekir;
        static int totalUcret;

        public DoctorMuayeneUcretleri(DOCTOR doctorAdi, HASTALIK hastalik, int ucret, boolean hastaneyeYatmasiGerekir) {
            this.doctorAdi = doctorAdi;
            this.hastalik = hastalik;
            this.ucret = ucret;
            this.hastaneyeYatmasiGerekir = hastaneyeYatmasiGerekir;
        }

        public DOCTOR getDoctorAdi() {
            return doctorAdi;
        }

        public HASTALIK getHastalik() {
            return hastalik;
        }

        public int getUcret() {
            return ucret;
        }

        public boolean isHastaneyeYatmasiGerekir() {
            return hastaneyeYatmasiGerekir;
        }

        public void calculateTotal() {
            totalUcret += this.ucret;
        }
    }

    enum DOCTOR {
        POLAT,
        ELIF,
        MEMATI,
        CAKIR
    }

    enum HASTALIK {
        BAS_AGRISI,
        DIS_CEKIMI,
        ORTOPEDI,
        KBB,
        KIRIK_CIKIK,
        PSIKOLOJI
    }

    Map<String, Integer> map = new HashMap<>();
    List<DoctorMuayeneUcretleri> doctorMuayeneUcretlerisList = new ArrayList<>();

    @Test
    public void map_array_doctorMuayeneUcreti() {
        // way 1  doctorMuayeneUcretlerisList.add(new DoctorMuayeneUcretleri("Polat","Bas Agrisi", 30, false));
        // way 2 doctorMuayeneUcretlerisList.add(new DoctorMuayeneUcretleri(DOCTOR.POLAT, HASTALIK.BAS_AGRISI, 30, false));
        // way 1 mi way 2 mi daha temiz okumasi ve kullanmasi
        doctorMuayeneUcretlerisList.add(new DoctorMuayeneUcretleri(DOCTOR.POLAT, HASTALIK.BAS_AGRISI, 30, false));
        doctorMuayeneUcretlerisList.add(new DoctorMuayeneUcretleri(DOCTOR.POLAT, HASTALIK.DIS_CEKIMI, 40, false));
        doctorMuayeneUcretlerisList.add(new DoctorMuayeneUcretleri(DOCTOR.CAKIR, HASTALIK.ORTOPEDI, 1000, false));
        doctorMuayeneUcretlerisList.add(new DoctorMuayeneUcretleri(DOCTOR.CAKIR, HASTALIK.KBB, 10, false));
        doctorMuayeneUcretlerisList.add(new DoctorMuayeneUcretleri(DOCTOR.ELIF, HASTALIK.KIRIK_CIKIK, 30, true));
        doctorMuayeneUcretlerisList.add(new DoctorMuayeneUcretleri(DOCTOR.ELIF, HASTALIK.KBB, 20, false));
        doctorMuayeneUcretlerisList.add(new DoctorMuayeneUcretleri(DOCTOR.ELIF, HASTALIK.PSIKOLOJI, 300, true));
        doctorMuayeneUcretlerisList.add(new DoctorMuayeneUcretleri(DOCTOR.MEMATI, HASTALIK.BAS_AGRISI, 0, false));

        // polat beyin discekimi ucreti ne kadar
        //Structural
        for (int i = 0; i < doctorMuayeneUcretlerisList.size(); i++) {
            if (doctorMuayeneUcretlerisList.get(i).doctorAdi.equals(DOCTOR.POLAT) && doctorMuayeneUcretlerisList.get(i).hastalik.equals(HASTALIK.DIS_CEKIMI)) {
                System.out.println("doctorMuayeneUcretlerisList.get(i).getUcret() = " + doctorMuayeneUcretlerisList.get(i).getUcret());
            }
        }

        //Functional
        doctorMuayeneUcretlerisList.stream().filter(t -> t.doctorAdi.equals(DOCTOR.POLAT) && t.hastalik.equals(HASTALIK.DIS_CEKIMI)).forEach(t -> System.out.println("t.getUcret() = " + t.getUcret()));


        // hastaneye yatmasi gereken hastaliklar nelerdir
        //Structural
        for (int i = 0; i < doctorMuayeneUcretlerisList.size(); i++) {
            if (doctorMuayeneUcretlerisList.get(i).isHastaneyeYatmasiGerekir()) {
                System.out.println(doctorMuayeneUcretlerisList.get(i).getHastalik());
            }
        }

        //Functional
        doctorMuayeneUcretlerisList.stream().filter(t -> t.isHastaneyeYatmasiGerekir()).forEach(t -> System.out.println("t.getHastalik() = " + t.getHastalik()));
        doctorMuayeneUcretlerisList.stream().filter(DoctorMuayeneUcretleri::isHastaneyeYatmasiGerekir).forEach(t -> System.out.println("t.getHastalik() = " + t.getHastalik()));


        // bonus
        // bir hasta polat beyden dis cekimi yaptirdiktan sonra bozulan psikolajisini duzeltmek icin elif hanimdan 2 seans psikolojik destek almistir.
        // toplamda odemesi gereken miktar ne kadardir
//Structural
        int toplamUcret = 0;
        for (int i = 0; i < doctorMuayeneUcretlerisList.size(); i++) {
            if (doctorMuayeneUcretlerisList.get(i).getDoctorAdi().equals(DOCTOR.POLAT) && doctorMuayeneUcretlerisList.get(i).getHastalik().equals(HASTALIK.DIS_CEKIMI)) {
                toplamUcret += doctorMuayeneUcretlerisList.get(i).getUcret();
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < doctorMuayeneUcretlerisList.size(); j++) {
                if (doctorMuayeneUcretlerisList.get(j).getDoctorAdi().equals(DOCTOR.ELIF) && doctorMuayeneUcretlerisList.get(j).getHastalik().equals(HASTALIK.PSIKOLOJI)) {
                    toplamUcret += doctorMuayeneUcretlerisList.get(j).getUcret();
                }
            }
        }
        System.out.println("toplamUcret = " + toplamUcret);


        //Functional
        doctorMuayeneUcretlerisList.stream().filter(t -> t.doctorAdi.equals(DOCTOR.POLAT) && t.hastalik.equals(HASTALIK.DIS_CEKIMI)).forEach(DoctorMuayeneUcretleri::calculateTotal);
        doctorMuayeneUcretlerisList.stream().filter(t -> t.doctorAdi.equals(DOCTOR.ELIF) && t.hastalik.equals(HASTALIK.PSIKOLOJI)).forEach(DoctorMuayeneUcretleri::calculateTotal);
        doctorMuayeneUcretlerisList.stream().filter(t -> t.doctorAdi.equals(DOCTOR.ELIF) && t.hastalik.equals(HASTALIK.PSIKOLOJI)).forEach(DoctorMuayeneUcretleri::calculateTotal);
        int totalUcret = ders.DoctorMuayeneUcretleri.totalUcret;
        System.out.println("totalUcret = " + totalUcret);
    }

    @Test
    public void map_array_urun() {
        map.put("elma", 24);
        map.put("armut", 12);
        map.put("ayva", 36);
        map.put("kiraz", 60);
        map.put("muz", 5);
        map.put("cilek", 2);

        //------------------------Map datalarının içine girebilmek ve tek tek datayı işleyebilmek için "entrySet" kullanırız.

        // 4 harfli olan urunlerin fiyatlarini console a yazdir
        //Structural
        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            if (pair.getKey().length() == 4) {
                System.out.println("pair.getValue() = " + pair.getValue());
                System.out.println("pair.getKey() = " + pair.getKey());
            }
        }

            //Functional
            map.entrySet().stream().filter(t -> t.getKey().length() == 4).forEach(t -> System.out.println("t.getValue() = " + t.getValue()));


            // fiyati 30 liradan ucuz olan urunlerin isimlerini yazdir
            //Structural
            for (Map.Entry<String, Integer> pair1 : map.entrySet()) {
                if (pair1.getValue() < 30) {
                    System.out.println("pair1.getKey() = " + pair1.getKey());
                }
            }

            //Function

            map.entrySet().stream().filter(t -> t.getValue() < 30).forEach(t -> System.out.println("t.getKey() = " + t.getKey()));

            // fiyati 30 dan fazla ve 4 harfli olan urunleri yazdir
            //Structural
            for (Map.Entry<String, Integer> pair2 : map.entrySet()) {
                if (pair2.getValue() > 30 && pair2.getKey().length() == 4) {
                    System.out.println("pair2.getKey() = " + pair2.getKey());
                }
            }

            //Functional
            map.entrySet().stream().filter(t -> t.getValue() > 30 && t.getKey().length() == 4).forEach(t -> System.out.println("t.getKey() son = " + t.getKey()));
    }
}
