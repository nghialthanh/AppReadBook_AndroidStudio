package com.example.appdoan.entiti;

import java.util.ArrayList;

public class Addbook {
    public static ArrayList<Book> getListData() {
        ArrayList<Book> list = new ArrayList<Book>();
        //catagory =1 : Van hoc Viet Nam
        Book v1 = new Book(1, 1, "Dế mèn phiêu lưu ký", "de_men_phieu_luu_ky__to_hoai",1200);
        Book v2 = new Book(2, 1, "Chuyện cổ tích dành cho người lớn", "chuyen_co_tich_danh_chon_guoi_lon",500);
        Book v3 = new Book(3, 1, "Đất rừng phương nam", "dat_rung_phuong_nam",786);
        Book v4 = new Book(4, 1, "Tắt đèn", "tat_den",2200);
        Book v5 = new Book(5, 1, "Trúng số độc đắc", "trung_so_doc_dac",345);
        Book v6 = new Book(6, 1, "Truyện ngắn Nguyễn Công Hoan", "tuyen_tap_truyen_ngan_nguyen_cong_hoan",1400);
        Book v7 = new Book(7, 1, "Bước đường cùng", "buoc_duong_cung",800);
        Book v8 = new Book(8, 1, "Chí Phèo", "chi_pheo",925);
        Book v9 = new Book(9, 1, "Ngày Vui", "ngay_vui",45);
        Book v10 = new Book(10, 1, "Thương nhau để đó", "thuong_nhau_de_do",45);
        //catagory =2 : Tiếu thuyết nước ngoài

        Book v11 = new Book(11, 2, "Ai đó dõi theo em", "ai_do_doi_theo_em",1078);
        Book v12 = new Book(12, 2, "Kẻ phá đám", "ke_pha_dam",1027);
        Book v13 = new Book(13, 2, "Làng thiên nga đen", "lang_thien_nga_den",1046);
        Book v14 = new Book(14, 2, "Người chồng vĩnh cửu", "nguoi_chong_vinh_cuu",1014);
        Book v15 = new Book(15, 2, "Người mẹ", "nguoi_me",2002);
        Book v16 = new Book(16, 2, "Nhẫn Thạch", "nhan_thach",1542);
        Book v17 = new Book(17, 2, "Nữ sinh", "nu_sinh",1301);
        Book v18 = new Book(18, 2, "Pie đẹ nhất", "pie_de_nhat",210);
        Book v19 = new Book(19, 2, "Sau đêm vũ hội", "sau_dem_vu_hoi",423);
        Book v20 = new Book(20, 2, "Xác thịt về đâu", "xac_thit_ve_dau",457);
        //catagory =3 : kỹ năng sống
        Book v21 = new Book(21, 3, "Cẩm nang chọn nghề", "cam_nang_chon_nghe",785);
        Book v22 = new Book(22, 3, "Đắc nhân tâm", "dac_nhan_tam",1125);
        Book v23 = new Book(23, 3, "Luật hấp dẫn", "luat_hap_dan",1111);
        Book v24 = new Book(24, 3, "The book of Joy", "the_book_of_joy",1128);
        //catagory =4: tuvi
        Book v25 = new Book(25, 4, "Kinh dịch", "kinh_dich_tron_bo",789);
        Book v26 = new Book(26, 4, "Ma Y thần tướng", "ma_y_than_tuong",1555);
        Book v27 = new Book(27, 4, "Nhân tướng học", "nhan_tuong_hoc",1178);

        list.add(v1);list.add(v4);list.add(v5);list.add(v7);list.add(v8);list.add(v9);
        list.add(v10);list.add(v2);list.add(v3);list.add(v6);
        list.add(v11);list.add(v14);list.add(v15);list.add(v17);list.add(v18);list.add(v19);
        list.add(v20);list.add(v11);list.add(v14);list.add(v16);
        list.add(v21);list.add(v24);list.add(v22);list.add(v23);
        list.add(v25);list.add(v26);list.add(v27);
        return list;
    }
}
