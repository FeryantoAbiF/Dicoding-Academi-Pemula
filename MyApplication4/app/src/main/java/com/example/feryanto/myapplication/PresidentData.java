package com.example.feryanto.myapplication;

import java.util.ArrayList;

public class PresidentData {
    public static String[][] data = new String[][]{
            {
                    "Megawati Soekarnoputri",
                    "President Indonesia Ke-5",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/8/88/President_Megawati_Sukarnoputri_-_Indonesia.jpg/220px-President_Megawati_Sukarnoputri_-_Indonesia.jpg",
                    " Megawati Soekarnoputri adalah anak kedua Presiden Soekarno yang telah memproklamasikan kemerdekaan Indonesia pada 17 Agustus 1945.",
                    "23 Januari 1947 (umur 71)",
                    "-"
            },
            {
                    "Sri Mulyani",
                    "Menteri Keuangan (2016)",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/3/39/Finance_Ministry_Sri_Mulyani_Indrawati_2016.jpg/200px-Finance_Ministry_Sri_Mulyani_Indrawati_2016.jpg",
                    "Dia adalah anak ketujuh dari seorang dosen universitas, Prof. Satmoko dan Retno Sriningsih. Namanya bercorak bahasa Jawa dan berhuruf Sansekerta.[5] Sri berarti sinar atau cahaya yang bersinar, yang merupakan nama yang umum bagi perempuan Jawa. Mulyani berasal dari kata mulya, juga berarti berharga.[7] Indrawati berasal dari kata Indra and akhiran feminin -wati",
                    "26 Agustus 1962 (umur 56)","-"},
            {"Ani Yudhoyono","Ibu Negara Indonesia Ke-6", "https://upload.wikimedia.org/wikipedia/id/f/fb/Ani_Yudhoyono.jpg","anak ketiga dari tujuh bersaudara pasangan Letnan Jenderal (Purn) Sarwo Edhie Wibowo dan Hj. Sunarti Sri Hadiyah. Menikah dengan SBY pada tanggal 30 Juli 1976, ketika SBY baru saja dilantik menjadi Perwira TNI dan menjadi lulusan terbaik.",
                    "Yogyakarta, 6 Juli 1952 (umur 66)", "-"},
            {"Miranda Goeltom", "Gubernur Bank Indonesia", "https://upload.wikimedia.org/wikipedia/id/6/65/Miranda_goeltom.jpg",
                    "dalah deputi senior gubernur Bank Indonesia dan guru besar Fakultas Ekonomi Universitas Indonesia. Sebelumnya dia menjabat sebagai deputi gubernur BI.\n" +
                            "\n" +
                            "Dia juga ikut dalam pemilihan gubernur BI pada tahun 2003 namun dikalahkan Burhanuddin Abdullah dan akhirnya harus puas dengan posisi deputi senior.", "59 Juni 1949 (umur 69)","-"}
    };

    public static ArrayList<President> getListData(){
        President president = null;
        ArrayList<President> list = new ArrayList<>();
        for (int i = 0; i <data.length; i++) {
            president = new President();
            president.setName(data[i][0]);
            president.setRemarks(data[i][1]);
            president.setPhoto(data[i][2]);
            president.setDeskripsi(data[i][3]);
            president.setLahir(data[i][4]);
            president.setWafat(data[i][5]);

            list.add(president);
        }

        return list;
    }

}
