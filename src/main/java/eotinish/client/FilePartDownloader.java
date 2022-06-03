package eotinish.client;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class FilePartDownloader {

    private static final String eotinishUrl = "http://localhost:10505/ws/eotinish";
    private static final String pathToSaveFile = "C:\\Users\\Amirzhan\\Downloads\\test";
    private static final int fileId = 990442;
    private static final int partNo = 2;
    private static final String strForRequestStartPart = "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:q1=\"http://soap.services.api.court.kz/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><SOAP-ENV:Header xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\"></SOAP-ENV:Header><soap:Body xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\" wsu:Id=\"id-C1FF5CB2673218A1D31617704668685251409\"><SendMessage xmlns=\"http://bip.bee.kz/SyncChannel/v10/Types\"><request xmlns=\"\"><requestData><data xsi:type=\"q1:getFileRequest\">";
    private static final String strForRequestEndPart = "</data></requestData></request></SendMessage></soap:Body></soap:Envelope>";

    private static final String PATHFILE1 = "C:\\Users\\Amirzhan\\Downloads\\test\\990442_1";
    private static final String PATHFILE2 = "C:\\Users\\Amirzhan\\Downloads\\test\\990442_2";
    private static final String PATHFILE = "C:\\Users\\Amirzhan\\Downloads\\test\\990442";
    private static final String PATHTOSAVEDATA = "C:\\Users\\Amirzhan\\Downloads\\test\\concatenatedFile.docx";

    public static void main(String[] args) throws IOException {

        List<Integer> parts = new ArrayList<>();
        //parts.add(1);
        //parts.add(2);
        parts.add(3);

        StringBuilder stringBuilder = new StringBuilder();

        for (int i : parts){
            FilePartDownloader fileDownloader = new FilePartDownloader();
            String responseFromEotinish = fileDownloader.requestForFile(eotinishUrl, fileId, i);
            String fileData = fileDownloader.splitFileData(responseFromEotinish);
            System.out.println("fileData.getBytes(StandardCharsets.UTF_8).length: " + fileData.getBytes(StandardCharsets.UTF_8).length);
            //System.out.println("fileData-" + i + ": " + fileData);
            stringBuilder.append(fileData);
        }
        String allData = stringBuilder.toString();
        //System.out.println(allData);
        System.out.println("allData.length(): " + allData.length());

        byte[] allBytes = java.util.Base64.getDecoder().decode(allData.getBytes(StandardCharsets.UTF_8));
        InputStream is = new ByteArrayInputStream(allBytes);
        XWPFDocument document = new XWPFDocument(is);
        FileOutputStream fos = new FileOutputStream(new File(PATHTOSAVEDATA));
        document.write(fos);
        fos.close();

    }

    private String allPartCount(String responseStr){
        int startNumber = responseStr.indexOf("<totalParts>") + 12;
        int endNumber = responseStr.indexOf("</totalParts>");
        return responseStr.substring(startNumber, endNumber);
    }

    private String requestForFile(String connectionUrl, int id, int part){
        HttpURLConnection connection = null;
        try{
            URL url = new URL(connectionUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-type", "text/xml");
            connection.setDoOutput(true);

            DataOutputStream output = new DataOutputStream(connection.getOutputStream());
            String request = createRequestString(id, part);
            output.writeBytes(request);

            InputStream input = connection.getInputStream();
            return readFromInputStream(input);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        } finally {
            if (connection != null){
                connection.disconnect();
            }
        }
    }

    private String createRequestString(int id, int part){
        String str = null;
        str = strForRequestStartPart;
        if (id != 0){
            str = str + "<fileId>" + id + "</fileId>";
        }
        if (part != 0){
            str = str + "<partNo>" + part + "</partNo>";
        }
        str = str + strForRequestEndPart;
        //System.out.println(str);
        return str;
    }

    private String readFromInputStream(InputStream input) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new InputStreamReader(input))){
            String line = null;
            while((line = br.readLine()) != null){
                stringBuilder.append(line).append("\n");
            }
            return stringBuilder.toString();
        }
    }

    private String splitFileData(String responseStr){
        int startNumber = responseStr.indexOf("<fileData>") + 10;
        int endNumber = responseStr.indexOf("</fileData>");
        String dataStr = responseStr.substring(startNumber, endNumber);
        return dataStr;
    }

    private byte[] decodeFromBase64(String str){
        byte[] bytesInBase64 = str.getBytes(StandardCharsets.UTF_8);
        byte[] decodedBytes = Base64.getDecoder().decode(bytesInBase64);
        return decodedBytes;
    }

    private String saveAsFile(byte[] bytes, String path, int id, int part) throws IOException {
        String fileName = "" + id + "_" + part;
        System.out.println(fileName);
        String pathToFileDataSave = path + "\\" + fileName;
        File file = new File(pathToFileDataSave);
        try(FileOutputStream output = new FileOutputStream(file)){
            output.write(bytes);
            return fileName;
        }
    }

}
