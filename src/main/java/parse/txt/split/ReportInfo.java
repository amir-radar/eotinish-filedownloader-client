package parse.txt.split;

public class ReportInfo {
    public int number;
    public int id;
    public String repCode;
    public String repName;
    public String repType;
    public String repFileName;
    public String repFileType;
    public String updated;

    @Override
    public String toString() {
        return "ReportInfo{" +
                "number=" + number +
                ", id=" + id +
                ", repCode='" + repCode + '\'' +
                ", repName='" + repName + '\'' +
                ", repType='" + repType + '\'' +
                ", repFileName='" + repFileName + '\'' +
                ", repFileType='" + repFileType + '\'' +
                ", updated='" + updated + '\'' +
                '}';
    }
}
