package Exception;

interface Intercafeexc {

    boolean VerifyDell(String Nome, String senha, String UserD);

    boolean VerifyAdd(String New_user, String Senha, String Senha_rep);

    boolean VerifyUpdate(String Nome, String user, String senha, String adm, String auth, String pass);

    boolean VerifyUpdateEvent(String evento, String tell, String local, String bairro, int[] data);
}
