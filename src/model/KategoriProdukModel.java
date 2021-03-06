package model;

import javax.persistence.*;

@Entity
@Table(name = "kategori_produk", schema = "mysneakersby", catalog = "")
public class KategoriProdukModel {
    private int id;
    private String kategori;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "kategori", nullable = false, length = 50)
    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KategoriProdukModel that = (KategoriProdukModel) o;

        if (id != that.id) return false;
        if (kategori != null ? !kategori.equals(that.kategori) : that.kategori != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (kategori != null ? kategori.hashCode() : 0);
        return result;
    }
}
