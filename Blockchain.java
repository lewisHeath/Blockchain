import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

class Blockchain {
    private Block genesisBlock;
    private ArrayList<Block> blockchain;
    public Blockchain() throws NoSuchAlgorithmException{
        blockchain = new ArrayList<>();
        genesisBlock = new Block("", "0");
        blockchain.add(genesisBlock);        
    }
    public void addBlock(String transaction) throws NoSuchAlgorithmException {
        int lastIndexOfBlock = blockchain.size() -1;
        Block newBlock = new Block(transaction, blockchain.get(lastIndexOfBlock).getHash());
        blockchain.add(newBlock);
    }
    public void printBlockchain(){
        for(int i = 0; i < blockchain.size(); i++){
            blockchain.get(i).printBlock();
        }
    }
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Blockchain myBlockchain = new Blockchain();
        myBlockchain.addBlock("Lewis paid Ben 10 ETH");
        myBlockchain.addBlock("Ben paid Tom 25 BTC");
        myBlockchain.printBlockchain();
    }
}