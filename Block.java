import java.time.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class Block {
    private String transaction;
    private String hash;
    private String previousHash;
    private LocalDateTime date;
    public Block(String transaction, String previousHash) throws NoSuchAlgorithmException {
        this.transaction = transaction;
        this.date = LocalDateTime.now();
        this.previousHash = previousHash;
        this.hash = generateHash();
    }
    private String generateHash() throws NoSuchAlgorithmException {
        String hash = transaction + previousHash + date;
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(hash.getBytes());

        byte[] digest = md.digest();
        StringBuffer sb = new StringBuffer();
        for (byte b : digest) {
            sb.append(String.format("%02x", b & 0xff));
        }

        hash = sb.toString();

        return hash;
    }
    public void printBlock(){
        System.out.println("Hash: " + hash);
        System.out.println("Transaction: " + transaction);
        System.out.println("Date created: " + date);
        System.out.println("Previous hash: " + previousHash);
        System.out.println("");
    }
    public String getHash(){
        return hash;
    }
}