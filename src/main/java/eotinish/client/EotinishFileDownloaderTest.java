package eotinish.client;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class EotinishFileDownloaderTest {
    private static final String targetUrl = "http://localhost:10505/ws/eotinish";
    private static final String request = "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:q1=\"http://soap.services.api.court.kz/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><SOAP-ENV:Header xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\"></SOAP-ENV:Header><soap:Body xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\" wsu:Id=\"id-C1FF5CB2673218A1D31617704668685251409\"><SendMessage xmlns=\"http://bip.bee.kz/SyncChannel/v10/Types\"><request xmlns=\"\"><requestData><data xsi:type=\"q1:getFileRequest\"><fileId>990442</fileId></data></requestData></request></SendMessage></soap:Body></soap:Envelope>";

    public static final String pathToFileSaveData = "C:\\Users\\Amirzhan\\Downloads\\test\\saveData.docx";
    public static final String pathToLocalFile = "C:\\Users\\Amirzhan\\Downloads\\test\\990442.docx";

    //private static final String pathStrWithoutBug = "C:\\Users\\Amirzhan\\Documents\\torelik\\dev\\eotinish-client-test\\src\\main\\resources\\saveData.docx";

    private static final String pathToTxt1 = "C:\\Users\\Amirzhan\\Downloads\\test\\eotinishTest1.txt";

    public static final String pathToTxt2 = "C:\\Users\\Amirzhan\\Downloads\\test\\eotinishTest2.txt";

    private static final String pathToTxt3 = "C:\\Users\\Amirzhan\\Downloads\\test\\eotinishTest3.txt";

    public static void main(String[] args) throws Exception {
        String fileStr = executePost(targetUrl, null, request);
        int startNumber = fileStr.indexOf("<fileData>") + 10;
        int endNumber = fileStr.indexOf("</fileData>");
        String dataStr = fileStr.substring(startNumber, endNumber);

        byte[] decodedBytes = Base64.getDecoder().decode(dataStr.getBytes());
        InputStream is = new ByteArrayInputStream(decodedBytes);
        XWPFDocument document = new XWPFDocument(is);
        FileOutputStream fos = new FileOutputStream(new File(pathToFileSaveData));
        document.write(fos);
        fos.close();
    }

    private static String readFromInputStream(InputStream inputStream)
            throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }

    private static String executePost(String targetURL, String urlParameters, String request) {
        HttpURLConnection connection = null;

        try {
            //Create connection
            URL url = new URL(targetURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type",
                    "text/xml");

//            connection.setRequestProperty("Content-Length",
//                    Integer.toString(urlParameters.getBytes().length));
            connection.setRequestProperty("Content-Language", "en-US");

            connection.setUseCaches(false);
            connection.setDoOutput(true);

            //Send request
            DataOutputStream wr = new DataOutputStream (
                    connection.getOutputStream());
            wr.writeBytes(request);
            wr.close();

            //Get Response
            InputStream is = connection.getInputStream();
            return readFromInputStream(is);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

}
