package expertise.downloadcfes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "d_expertise_cfe")
public class Cfe{
    private String id;
    private String regionCode;
    private String nameRu;
    private String nameKz;
    private boolean removed;
    private Date removeDate;

    @Id
    @Column(name = "code_")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "region_code_")
    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    @Column(name = "name_ru_")
    public String getNameRu() {
        return nameRu;
    }

    public void setNameRu(String nameRu) {
        this.nameRu = nameRu;
    }

    @Column(name = "name_kz_")
    public String getNameKz() {
        return nameKz;
    }

    public void setNameKz(String nameKz) {
        this.nameKz = nameKz;
    }

    @Column(name = "removed_")
    public boolean isRemoved() {
        return removed;
    }

    public void setRemoved(boolean removed) {
        this.removed = removed;
    }

    @Column(name = "remove_date_")
    public Date getRemoveDate() {
        return removeDate;
    }

    public void setRemoveDate(Date removeDate) {
        this.removeDate = removeDate;
    }
}