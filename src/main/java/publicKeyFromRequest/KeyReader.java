package publicKeyFromRequest;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.asn1.cms.SignedData;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.CMSSignedData;
import org.bouncycastle.cms.SignerInformation;
import org.bouncycastle.cms.SignerInformationStore;
import org.bouncycastle.util.Store;

import java.awt.*;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class KeyReader {

    public static void main(String[] args) {
        File file = new File(filePath);
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyymmdd_hhmmss");
        String strDate = dateFormat.format(date);
        String savedCertFile = pathToSaveCert + "savedCert_" +  strDate + ".der";
        File outputFile = new File(savedCertFile);
        try {
            String publicKeyString = readPublicKeyStringFromRequest(file);
            //saveCertificateFromPublicKeyString(publicKeyString, outputFile);
            getSignerInfoFromSignature(publicKeyString, outputFile);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static final String filePath = "C:\\Users\\Amirzhan\\Documents\\tasks\\новый 10.xml";//"C:\\Users\\Amirzhan\\Documents\\requestForAwardServiceForReadCert.xml"; //certFromRequestAwardService.xml"; //requestForAwardServiceForReadCert.xml
    public static final String pathToSaveCert = "C:\\Users\\Amirzhan\\Documents\\";
    public static final String beginString = "<wsse:KeyIdentifier EncodingType=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary\" ValueType=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-x509-token-profile-1.0#X509v3\">";
    public static final String beginString2 = "<ds:X509Certificate>";
    public static final String beginString3 = "<secondSignData>";
    public static final String endString = "</wsse:KeyIdentifier>";
    public static final String endString2 = "</ds:X509Certificate>";
    public static final String endString3 = "</secondSignData>";

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
        int beginIndex = 0;
        int endIndex = 0;
        String otherBeginStr = "<wsse:KeyIdentifier EncodingType=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary\" ValueType=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-x509-token-profile-1.0#X509v3\">";
        String otherEndStr = "</wsse:KeyIdentifier>";
        if (request.contains(beginString2) && request.contains(endString2)){
            beginIndex = request.indexOf(beginString2) + beginString2.length();
            endIndex = request.indexOf(endString2);
        } else if (request.contains(beginString) && request.contains(endString)) {
            beginIndex = request.indexOf(beginString) + beginString.length();
            endIndex = request.indexOf(endString);
        } else if (request.contains(beginString3) && request.contains(endString3)) {
            beginIndex = request.indexOf(beginString3) + beginString3.length();
            endIndex = request.indexOf(endString3);
        } else if (request.contains(otherBeginStr) && request.contains(otherEndStr)){
            beginIndex = request.indexOf(otherBeginStr) + otherBeginStr.length();
            endIndex = request.indexOf(otherEndStr);
        } else {
            throw new Exception("No public key found in request");
        }
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

    public static void getSignerInfoFromSignature(String data, File outFile) throws CMSException, IOException {
        byte[] encoded = Base64.decodeBase64(data);
        CMSSignedData cmsSignedData = new CMSSignedData(encoded);

        Store<X509CertificateHolder> store = cmsSignedData.getCertificates();

        FileOutputStream fos = new FileOutputStream(outFile);

        Collection<X509CertificateHolder> allCerts = store.getMatches(null);
        for (X509CertificateHolder allCert : allCerts) {
            System.out.println(allCert.getSubject());
            System.out.println(allCert.getNotAfter());
            System.out.println(allCert.getNotBefore());
            System.out.println(allCert.getIssuer());
            System.out.println();
            allCert.getSubjectPublicKeyInfo().parsePublicKey().toASN1Primitive().encodeTo(fos);
        }

        fos.write(encoded);
        fos.close();
    }
}