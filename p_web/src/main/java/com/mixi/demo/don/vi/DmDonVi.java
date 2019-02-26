package com.mixi.demo.don.vi;

import javax.persistence.*;

@Entity
public class DmDonVi {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @SequenceGenerator(allocationSize = 1, name = )
    private Long id;

    @Column(name = "ID_DVI_CHA")
    private Long idDonViCha;
    @Column(name = "MA_DVI")
    private String maDonvi;
    @Column(name = "MA_DVI_CHA")
    private String maDonviCha;
    @Column(name = "MO_HINH_KDOANH")
    private String moHinhKDoanh;
    @Column(name = "LOAI_DVI")
    private String loaiDvi;
    @Column(name = "MA_TINHTP")
    private String maTinhTP;
    @Column(name = "NGUON_TAO_DL")
    private String nguonTaoDL;
    @Column(name = "TEN_GDICH")
    private String tenGDich;
    @Column(name = "TEN_TAT")
    private String tenTat;
    @Column(name = "DIA_CHI")
    private String diaChi;
    @Column(name = "DIEN_THOAI")
    private String dienThoai;
    @Column(name = "SO_FAX")
    private String soFax;
    @Column(name = "WEBSITE")
    private String webSite;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "LOGO")
    private String logo;
    @Column(name = "SO_DKKD")
    private String soDKKD;
    @Column(name = "MA_SO_THUE")
    private String maSoThue;
    @Column(name = "SO_TAI_KHOAN")
    private String soTaiKhoan;
    @Column(name = "TEN_NGAN_HANG")
    private String tenNganHang;
    @Column(name = "MA_HACH_TOAN")
    private String maHachToan;
    @Column(name = "GDOC_TEN")
    private String gdocTen;
    @Column(name = "GDOC_TEL")
    private String gdocTel;
    @Column(name = "GDOC_MOBILE")
    private String gdocMobile;
    @Column(name = "GDOC_FAX")
    private String gdocFax;
    @Column(name = "GDOC_EMAIL")
    private String gdocEmail;
    @Column(name = "KTTRUONG_TEN")
    private String kttruongTen;
    @Column(name = "KTTRUONG_TEL")
    private String kttruongTel;
    @Column(name = "KTTRUONG_MOBILE")
    private String kttruongMobile;
    @Column(name = "KTTRUONG_FAX")
    private String kttruongfax;












//    KTTRUONG_EMAIL
//            TTHAI_BGHI
//    TTHAI_NVU
//            MA_DVI_QLY
//    MA_DVI_TAO
//            NGAY_NHAP
//    NGUOI_NHAP


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdDonViCha() {
        return idDonViCha;
    }

    public void setIdDonViCha(Long idDonViCha) {
        this.idDonViCha = idDonViCha;
    }

    public String getMaDonvi() {
        return maDonvi;
    }

    public void setMaDonvi(String maDonvi) {
        this.maDonvi = maDonvi;
    }

    public String getMaDonviCha() {
        return maDonviCha;
    }

    public void setMaDonviCha(String maDonviCha) {
        this.maDonviCha = maDonviCha;
    }

    public String getMoHinhKDoanh() {
        return moHinhKDoanh;
    }

    public void setMoHinhKDoanh(String moHinhKDoanh) {
        this.moHinhKDoanh = moHinhKDoanh;
    }

    public String getLoaiDvi() {
        return loaiDvi;
    }

    public void setLoaiDvi(String loaiDvi) {
        this.loaiDvi = loaiDvi;
    }

    public String getMaTinhTP() {
        return maTinhTP;
    }

    public void setMaTinhTP(String maTinhTP) {
        this.maTinhTP = maTinhTP;
    }

    public String getNguonTaoDL() {
        return nguonTaoDL;
    }

    public void setNguonTaoDL(String nguonTaoDL) {
        this.nguonTaoDL = nguonTaoDL;
    }

    public String getTenGDich() {
        return tenGDich;
    }

    public void setTenGDich(String tenGDich) {
        this.tenGDich = tenGDich;
    }

    public String getTenTat() {
        return tenTat;
    }

    public void setTenTat(String tenTat) {
        this.tenTat = tenTat;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getSoFax() {
        return soFax;
    }

    public void setSoFax(String soFax) {
        this.soFax = soFax;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getSoDKKD() {
        return soDKKD;
    }

    public void setSoDKKD(String soDKKD) {
        this.soDKKD = soDKKD;
    }

    public String getMaSoThue() {
        return maSoThue;
    }

    public void setMaSoThue(String maSoThue) {
        this.maSoThue = maSoThue;
    }

    public String getSoTaiKhoan() {
        return soTaiKhoan;
    }

    public void setSoTaiKhoan(String soTaiKhoan) {
        this.soTaiKhoan = soTaiKhoan;
    }

    public String getTenNganHang() {
        return tenNganHang;
    }

    public void setTenNganHang(String tenNganHang) {
        this.tenNganHang = tenNganHang;
    }

    public String getMaHachToan() {
        return maHachToan;
    }

    public void setMaHachToan(String maHachToan) {
        this.maHachToan = maHachToan;
    }

    public String getGdocTen() {
        return gdocTen;
    }

    public void setGdocTen(String gdocTen) {
        this.gdocTen = gdocTen;
    }

    public String getGdocTel() {
        return gdocTel;
    }

    public void setGdocTel(String gdocTel) {
        this.gdocTel = gdocTel;
    }

    public String getGdocMobile() {
        return gdocMobile;
    }

    public void setGdocMobile(String gdocMobile) {
        this.gdocMobile = gdocMobile;
    }

    public String getGdocFax() {
        return gdocFax;
    }

    public void setGdocFax(String gdocFax) {
        this.gdocFax = gdocFax;
    }

    public String getGdocEmail() {
        return gdocEmail;
    }

    public void setGdocEmail(String gdocEmail) {
        this.gdocEmail = gdocEmail;
    }

    public String getKttruongTen() {
        return kttruongTen;
    }

    public void setKttruongTen(String kttruongTen) {
        this.kttruongTen = kttruongTen;
    }

    public String getKttruongTel() {
        return kttruongTel;
    }

    public void setKttruongTel(String kttruongTel) {
        this.kttruongTel = kttruongTel;
    }

    public String getKttruongMobile() {
        return kttruongMobile;
    }

    public void setKttruongMobile(String kttruongMobile) {
        this.kttruongMobile = kttruongMobile;
    }

    public String getKttruongfax() {
        return kttruongfax;
    }

    public void setKttruongfax(String kttruongfax) {
        this.kttruongfax = kttruongfax;
    }

    @Override
    public String toString() {
        return "DmDonVi{" +
                "id=" + id +
                ", idDonViCha=" + idDonViCha +
                ", maDonvi='" + maDonvi + '\'' +
                ", maDonviCha='" + maDonviCha + '\'' +
                ", moHinhKDoanh='" + moHinhKDoanh + '\'' +
                ", loaiDvi='" + loaiDvi + '\'' +
                ", maTinhTP='" + maTinhTP + '\'' +
                ", nguonTaoDL='" + nguonTaoDL + '\'' +
                ", tenGDich='" + tenGDich + '\'' +
                ", tenTat='" + tenTat + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", dienThoai='" + dienThoai + '\'' +
                ", soFax='" + soFax + '\'' +
                ", webSite='" + webSite + '\'' +
                ", email='" + email + '\'' +
                ", logo='" + logo + '\'' +
                ", soDKKD='" + soDKKD + '\'' +
                ", maSoThue='" + maSoThue + '\'' +
                ", soTaiKhoan='" + soTaiKhoan + '\'' +
                ", tenNganHang='" + tenNganHang + '\'' +
                ", maHachToan='" + maHachToan + '\'' +
                ", gdocTen='" + gdocTen + '\'' +
                ", gdocTel='" + gdocTel + '\'' +
                ", gdocMobile='" + gdocMobile + '\'' +
                ", gdocFax='" + gdocFax + '\'' +
                ", gdocEmail='" + gdocEmail + '\'' +
                ", kttruongTen='" + kttruongTen + '\'' +
                ", kttruongTel='" + kttruongTel + '\'' +
                ", kttruongMobile='" + kttruongMobile + '\'' +
                ", kttruongfax='" + kttruongfax + '\'' +
                '}';
    }

}
