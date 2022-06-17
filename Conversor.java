import java.util.HashMap;

public class Conversor {

    String chave;
    private static HashMap<Character, String> valores = new HashMap<>();

    public Conversor(String chave){
        this.chave = chave;
        colocarValores();
    }

    public String criptografar(String texto){
        texto = texto.toUpperCase();
        String cript = "";
        for(int i = 0; i < texto.length(); i++){
            String value1 = valores.get(texto.charAt(i)); // pega o valor do character do texto
            String value2 = valores.get(chave.charAt(i % chave.length())); 
            cript += getKeyFromValue(XOR(value1, value2)); // faz um xor dos dois valores binarios e pega a chave que tem o resultado como o valor
        }
        return cript;
    }

    public String descriptografar(String texto){
        return criptografar(texto); // fazendo um xor do que foi criptografado com a chave denovo retorna o original
    }

    private static String XOR(String value1, String value2){
        if(value1.length() != value2.length()) return null;
        String n = "";
        for(int i = 0; i < value1.length(); i++){
            if(value1.charAt(i) == value2.charAt(i)) n += "0";
            else n += "1";
        }
        return n;
    }

    private static Character getKeyFromValue(String value){
        if(valores.containsValue(value)){
            for(HashMap.Entry<Character, String> entry : valores.entrySet()){
                if(entry.getValue().equals(value)){
                    return entry.getKey();
                }
            }
        }
        return null;
    }

    private static void colocarValores(){
        valores.put('A', "11000");
        valores.put('B', "10011");
        valores.put('C', "01110");
        valores.put('D', "10010");
        valores.put('E', "10000");
        valores.put('F', "10110");
        valores.put('G', "01011");
        valores.put('H', "00101");
        valores.put('I', "01100");
        valores.put('J', "11010");
        valores.put('K', "11110");
        valores.put('L', "01001");
        valores.put('M', "00111");
        valores.put('N', "00110");
        valores.put('O', "00011");
        valores.put('P', "01101");
        valores.put('Q', "11101");
        valores.put('R', "01010");
        valores.put('S', "10100");
        valores.put('T', "00001");
        valores.put('U', "11100");
        valores.put('V', "01111");
        valores.put('W', "11001");
        valores.put('X', "10111");
        valores.put('Y', "10101");
        valores.put('Z', "10001");
        valores.put(' ', "00100");
        valores.put('?', "11111");
        valores.put('.', "11011");
        valores.put('!', "01000");
        valores.put(',', "00010");
        valores.put(';', "00000");
    }
}
