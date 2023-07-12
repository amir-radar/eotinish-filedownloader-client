package compareJsons.entity;

import compareJsons.dto.JsonFileDto;

import java.util.Objects;

public class JsonFile {
    private String ru;
    private String kk;
    private String id;

    public JsonFile(JsonFile fileDto) {
    }

    public String getRu() {
        return ru;
    }

    public void setRu(String ru) {
        this.ru = ru;
    }

    public String getKk() {
        return kk;
    }

    public void setKk(String kk) {
        this.kk = kk;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JsonFile jsonFile = (JsonFile) o;
        return Objects.equals(ru, jsonFile.ru) && Objects.equals(kk, jsonFile.kk) && Objects.equals(id, jsonFile.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ru, kk, id);
    }

    @Override
    public String toString() {
        return "JsonFile{" +
                "ru='" + ru + '\'' +
                ", kk='" + kk + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public JsonFile(){

    }

    public JsonFile(JsonFileDto dto){
        this.ru = dto.ru;
        this.kk = dto.kk;
        this.id = dto.id;
    }
}
