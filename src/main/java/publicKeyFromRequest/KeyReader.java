package publicKeyFromRequest;

import org.apache.commons.codec.binary.Base64;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.security.KeyFactory;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;

public class KeyReader {

    public static void main(String[] args) {
        File file = new File(filePath);
        File outputFile = new File(savedCert);
        try {
            String publicKeyString = readPublicKeyStringFromRequest(file);
            saveCertificateFromPublicKeyString(publicKeyString, outputFile);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static final String filePath = "C:\\Users\\Amirzhan\\Documents\\tasks\\getCert230622.txt";//"C:\\Users\\Amirzhan\\Documents\\requestForAwardServiceForReadCert.xml"; //certFromRequestAwardService.xml"; //requestForAwardServiceForReadCert.xml
    public static final String savedCert = "C:\\Users\\Amirzhan\\Documents\\savedCert230622_2.der";
    public static final String beginString = "<wsse:KeyIdentifier EncodingType=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary\" ValueType=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-x509-token-profile-1.0#X509v3\">";
    //public static final String beginString = "<ds:X509Certificate>";
    public static final String endString = "</wsse:KeyIdentifier>";
    //public static final String endString = "</ds:X509Certificate>";

    public static RSAPublicKey readPublicKeyFromPemFile(File file) throws Exception {
        String key = getStringFromFile(file);

        String publicKeyPEM = key
                .replace("-----BEGIN PUBLIC KEY-----", "")
                .replaceAll(System.lineSeparator(), "")
                .replace("-----END PUBLIC KEY-----", "");

        byte[] encoded = Base64.decodeBase64(publicKeyPEM);

        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(encoded);
        return (RSAPublicKey) keyFactory.generatePublic(keySpec);
    }

    public static String readPublicKeyStringFromRequest(File file) throws Exception {
        String request = getStringFromFile(file);
        int beginIndex = request.indexOf(beginString) + beginString.length();
        int endIndex = request.indexOf(endString);
        return request.substring(beginIndex, endIndex).trim();
    }

    private static String getStringFromFile(File file) throws Exception{
        return new String(Files.readAllBytes(file.toPath()), Charset.defaultCharset());
    }

    public static void saveCertificateFromPublicKeyString(String data, File outFile) throws IOException, CertificateException {
        byte[] encoded = Base64.decodeBase64(data);
        //System.out.println(new String(encoded));
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        certificateFactory.generateCertificate(new ByteArrayInputStream(encoded)).getPublicKey();
        FileOutputStream fos = new FileOutputStream(outFile);
        fos.write(encoded);
        fos.close();
    }
}