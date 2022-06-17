public class App {
    public static void main(String[] args) throws Exception {
        Conversor conversor = new Conversor("KROM");
        String criptografado = conversor.criptografar("rafaela");
        System.out.println(criptografado);
        criptografado = conversor.descriptografar(criptografado);
        System.out.println(criptografado);
    }
}
